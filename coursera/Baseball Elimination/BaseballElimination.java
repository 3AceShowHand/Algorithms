import edu.princeton.cs.algs4.In;

import java.util.ArrayList;

public class BaseballElimination {

    private int num;

    public BaseballElimination(String filename) {
        In file = new In(filename);
        num = file.readInt();

    }

    public int numberOfTeams() {
        return num;
    }

    public Iterable<String> teams() {
        return null;
    }

    public int wins(String team) {
        return 0;
    }

    public int losses(String team) {
        return 0;
    }

    public int remaining(String team) {
        return 0;
    }

    public int against(String team1, String team2) {
        return 0;
    }

    public boolean isEliminated(String team) {
        return false;
    }

    public Iterable<String> certificateOfElimination(String team) {
        return null;
    }

}