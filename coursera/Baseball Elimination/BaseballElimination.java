import edu.princeton.cs.algs4.In;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import edu.princeton.cs.algs4.FordFulkerson;

public class BaseballElimination {

    private final HashMap<String, HashMap<String, Integer>> records;
    private final int num;

    public BaseballElimination(String filename) {
        In file = new In(filename);
        num = Integer.parseInt(file.readLine());
        
        records = new HashMap<>();
        
        String[] content = file.readAllLines();

        ArrayList<String> teamNames = new ArrayList<>();
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

            int[] current = parseIntArray(summary.get(idx));
            for (int i = 0; i < tags.length; i++) {
                records.get(host).put(tags[i], current[i]);
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

    public int wins(String team) {
        return records.get(team).get("wins");
    }

    public int losses(String team) {
        return records.get(team).get("losses");
    }

    public int remaining(String team) {
        return records.get(team).get("remains");
    }

    public int against(String team1, String team2) {
        return records.get(team1).get(team2);
    }

    public boolean isEliminated(String team) {
        return false;
    }

    public Iterable<String> certificateOfElimination(String team) {
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
