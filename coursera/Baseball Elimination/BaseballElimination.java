import edu.princeton.cs.algs4.FlowEdge;
import edu.princeton.cs.algs4.FlowNetwork;
import edu.princeton.cs.algs4.FordFulkerson;
import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BaseballElimination {

    private final HashMap<String, HashMap<String, Integer>> records;
    private final int num;
    private int maxWin;
    private String maxTeam;
    private final ArrayList<String> teamNames;

    private FlowNetwork flow;
    private FordFulkerson solver;

    public BaseballElimination(String filename) {
        In file = new In(filename);
        num = Integer.parseInt(file.readLine());
        records = new HashMap<>();
        maxWin = 0;
        
        String[] content = file.readAllLines();

        teamNames = new ArrayList<>();
        ArrayList<String[]> summary = new ArrayList<>();
        ArrayList<String[]> detail = new ArrayList<>();

        final int split = 4;
        for (String s : content) {
            String[] line = s.trim().replaceAll("\\s+", " ").split(" ");
            teamNames.add(line[0]);
            records.put(line[0], new HashMap<>());
            summary.add(Arrays.copyOfRange(line, 1, split));
            detail.add(Arrays.copyOfRange(line, split, line.length));
        }

        String[] tags = new String[]{"wins", "losses", "remains"};

        for (int idx = 0; idx < teamNames.size(); idx++) {
            String host = teamNames.get(idx);
            records.get(host).put("id", idx);
            int[] current = parseIntArray(summary.get(idx));
            for (int i = 0; i < tags.length; i++) {
                records.get(host).put(tags[i], current[i]);
                if (tags[i].equals("wins")) {
                    if (current[i] > maxWin) {
                        maxWin = current[i];
                        maxTeam = teamNames.get(idx);
                    }
                }
            }

            current = parseIntArray(detail.get(idx));
            for (int i = 0; i < current.length; i++) {
                String against = teamNames.get(i);
                if (!host.equals(against)) {
                    records.get(host).put(against, current[i]);
                }
            }
        }
    }

    private static int[] parseIntArray(final String[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = Integer.parseInt(arr[i]);
        }
        return res;
    }

    public int numberOfTeams() {
        return num;
    }

    public Iterable<String> teams() {
        return records.keySet();
    }

    private void checkTeam(final String team) {
        if (!teamNames.contains(team)) {
            throw new IllegalArgumentException("Given team is illegal.");
        }
    }

    public int wins(String team) {
        checkTeam(team);
        return records.get(team).get("wins");
    }

    public int losses(String team) {
        checkTeam(team);
        return records.get(team).get("losses");
    }

    public int remaining(String team) {
        checkTeam(team);
        return records.get(team).get("remains");
    }

    public int against(String team1, String team2) {
        checkTeam(team1);
        checkTeam(team2);
        return records.get(team1).get(team2);
    }

    private int getID(String team) {
        return records.get(team).get("id");
    }

    private ArrayList<String> getOtherTeams(String team) {
        ArrayList<String> other = new ArrayList<>();
        for (String t: teams()) {
            if (!t.equals(team)) {
                other.add(t);
            }
        }
        return other;
    }

    private HashMap<Integer, int[]> generateGameId(ArrayList<String> others) {
        HashMap<Integer, int[]> res = new HashMap<>();
        int gameId = numberOfTeams() + 1;
        for (int i = 0; i < others.size(); i++) {
            String host = others.get(i);
            for (int j = i + 1; j < others.size(); j++) {
                String guest = others.get(j);
                int[] pair = new int[]{getID(host), getID(guest), against(host, guest)};
                res.put(gameId++, pair);
            }
        }
        return res;
    }

    private FlowNetwork buildFlowNetwork(final String team) {
        ArrayList<String> others = getOtherTeams(team);
        int numOfNode = 2 + others.size() + others.size() * (others.size() - 1) / 2;

        int source = getID(team);
        int target = numberOfTeams();

        HashMap<Integer, int[]> gameIds = generateGameId(others);
        FlowNetwork res = new FlowNetwork(numOfNode);

        for (Map.Entry<Integer, int[]> entry : gameIds.entrySet()) {
            int key = entry.getKey();
            int[] value = entry.getValue();
            int host = value[0];
            int against = value[1];
            int between = value[2];

            if (between != 0) {
                res.addEdge(new FlowEdge(source, key, between));
                res.addEdge(new FlowEdge(key, host, Double.POSITIVE_INFINITY));
                res.addEdge(new FlowEdge(key, against, Double.POSITIVE_INFINITY));
            }
        }

        for (String other: others) {
            double capacity = wins(team) + remaining(team) - wins(other);
            res.addEdge(new FlowEdge(getID(other), target, capacity));
        }

        return res;
    }

    private int getOutput(String team) {
        int output = 0;
        ArrayList<String> other = getOtherTeams(team);
        for (int i = 0; i < other.size(); i++) {
            for (int j = i + 1; j < other.size(); j++) {
                output += against(other.get(i), other.get(j));
            }
        }
        return output;
    }

    public boolean isEliminated(String team) {
        checkTeam(team);
        // trivial elimination
        if ((wins(team) + remaining(team)) < maxWin) {
            return true;
        } else {
            int source = getID(team);
            int target = numberOfTeams();

            flow = buildFlowNetwork(team);
            solver = new FordFulkerson(flow, source, target);

            return Double.compare(solver.value(), getOutput(team)) != 0;
        }
    }

    public Iterable<String> certificateOfElimination(String team) {
        checkTeam(team);
        if (!isEliminated(team)) {
            return null;
        } else if ((wins(team) + remaining(team) < maxWin)) {
            ArrayList<String> res = new ArrayList<>();
            res.add(maxTeam);
            return res;
        } else {
            ArrayList<String> res = new ArrayList<>();
            ArrayList<String> others = getOtherTeams(team);

            for (int i = 0; i < others.size(); i++) {
                if (solver.inCut(getID(others.get(i)))) {
                    res.add(others.get(i));
                }
            }

            return res;
        }
    }
    public static void main(String[] args) {
        BaseballElimination division = new BaseballElimination(args[0]);
        for (String team : division.teams()) {
            if (division.isEliminated(team)) {
                StdOut.print(team + " is eliminated by the subset R = { ");
                for (String t : division.certificateOfElimination(team)) {
                    StdOut.print(t + " ");
                }
                StdOut.println("}");
            } else {
                StdOut.println(team + " is not eliminated");
            }
        }
    }
}
