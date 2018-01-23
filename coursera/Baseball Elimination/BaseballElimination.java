import edu.princeton.cs.algs4.In;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BaseballElimination {

    private final HashMap<String, HashMap<String, Integer>> records;
    private final int num;
    private int maxWin;
    private ArrayList<String> teamNames;

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

    private Iterable<String> getOtherTeams(String team) {
        ArrayList<String> other = new ArrayList<>();
        for (String t: records.keySet()) {
            if (!t.equals(team)) {
                other.add(t);
            }
        }
        return other;
    }

    public boolean isEliminated(String team) {
        checkTeam(team);
        // trivial elimination
        if ((wins(team) + remaining(team)) < maxWin) {
            return true;
        } else {
            // nontrivial elimination
            ArrayList<String> otherTeams = (ArrayList<String>) getOtherTeams(team);
        }
    }

    public Iterable<String> certificateOfElimination(String team) {
        checkTeam(team);
        return null;
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
