import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BaseballElimination {

    private HashMap<String, HashMap<String, Integer>> records;
    private int num;

    public BaseballElimination(String filename) {
        In file = new In(filename);
        num = Integer.parseInt(file.readLine());
        
        records = new HashMap<>();
        
        String[] content = file.readAllLines();

        ArrayList<String> teamNames = new ArrayList<>();
        ArrayList<String[]> summary = new ArrayList<>();
        ArrayList<String[]> detail = new ArrayList<>();

        for (String s : content) {
            String[] line = s.trim().replaceAll("\\s+", " ").split(" ");
            teamNames.add(line[0]);
            records.put(line[0], new HashMap<>());
            summary.add(Arrays.copyOfRange(line, 1, 4));
            detail.add(Arrays.copyOfRange(line,4, line.length));
        }

        for (int idx = 0; idx < teamNames.size(); idx++) {
            String host = teamNames.get(idx);
            int[] current = parseIntArray(summary.get(idx));
            records.get(host).put("wins", current[0]);
            records.get(host).put("losses", current[1]);
            records.get(host).put("remains", current[2]);

            current = parseIntArray(detail.get(idx));
            for (int i = 0; i < current.length; i++) {
                String against = teamNames.get(i);
                if (!host.equals(against)) {
                    records.get(host).put(against, current[i]);
                }
            }
        }
    }

    private static int[] parseIntArray(String[] arr) {
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
        String filename = args[0];
        BaseballElimination be = new BaseballElimination(filename);

        StdOut.printf("There are %d teams.\n", be.numberOfTeams());

        StdOut.println(be.teams());

        StdOut.println(be.wins("Atlanta"));
        StdOut.println(be.losses("New_York"));
        StdOut.println(be.remaining("Montreal"));

        StdOut.println(be.against("Atlanta", "Philadelphia"));
    }

}