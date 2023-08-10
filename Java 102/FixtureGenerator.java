import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<String> teams = new ArrayList<>(Arrays.asList(
                "Galatasaray", "Fenerbahçe", "Trabzonspor", "Beşiktaş",
                "Başakşehir", "Bursaspor", "Boluspor"));

        generateFixture(teams);
    }

    public static void generateFixture(List<String> teams) {

        if(teams.size() % 2 != 0)
            teams.add("Bay");

        int totalTeams = teams.size();
        int totalRounds = (totalTeams - 1) * 2;

        List<List<String>> fixture = new ArrayList<>();

        for (int round = 0; round < totalRounds; round++) {
            List<String> tempTeams = new ArrayList<>(teams);
            List<String> roundMatches = new ArrayList<>();

            for (int i = 0; i < totalTeams / 2; i++) {
                String home = tempTeams.get(i);
                String away = tempTeams.get(totalTeams - 1 - i);

                String match = home + " vs " + away;
                roundMatches.add(match);
            }

            fixture.add(new ArrayList<>(roundMatches));
            rotateTeams(teams);
        }

        printFixture(fixture);
    }

    public static void rotateTeams(List<String> teams) {
        String lastTeam = teams.remove(teams.size() - 1);
        teams.add(1, lastTeam);
    }

    public static void printFixture(List<List<String>> fixture) {
        int round = 1;

        for (List<String> matches : fixture) {
            System.out.println("Round " + round);
            for (String match : matches) {
                System.out.println(match);
            }
            System.out.println();
            round++;
        }
    }

}

