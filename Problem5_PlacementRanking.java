import java.util.Arrays;

public class Problem5_PlacementRanking
        implements Comparable<Problem5_PlacementRanking> {

    String name;
    double cgpa;
    int codingScore;

    public Problem5_PlacementRanking(String name, double cgpa,
                                     int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    double compositeScore() {
        return cgpa * 10 + codingScore * 0.5;
    }

    public int compareTo(Problem5_PlacementRanking other) {
        return Double.compare(other.compositeScore(),
                              this.compositeScore());
    }

    static String shortlistAndRank(Problem5_PlacementRanking[] candidates) {

        Problem5_PlacementRanking[] shortlisted =
                new Problem5_PlacementRanking[candidates.length];

        int count = 0;

        for (Problem5_PlacementRanking c : candidates) {

            if (isEligible(c.cgpa) ||
                isEligible(c.cgpa, c.codingScore)) {

                shortlisted[count] = c;
                count++;
            }
        }

        shortlisted = Arrays.copyOf(shortlisted, count);

        Arrays.sort(shortlisted);

        String result = "";

        for (int i = 0; i < shortlisted.length; i++) {

            result += (i + 1) + ". "
                    + shortlisted[i].name
                    + " (" + shortlisted[i].compositeScore() + ")";

            if (i < shortlisted.length - 1)
                result += " | ";
        }

        return result;
    }

    public static void main(String[] args) {

        Problem5_PlacementRanking[] candidates = {

            new Problem5_PlacementRanking("Aisha", 8.2, 40),
            new Problem5_PlacementRanking("Rohit", 6.8, 65),
            new Problem5_PlacementRanking("Meena", 6.0, 90),
            new Problem5_PlacementRanking("Karan", 7.5, 20)
        };

        System.out.println(shortlistAndRank(candidates));
    }
}