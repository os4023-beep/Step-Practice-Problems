class Scorecard {
    private boolean[] results;
    private int count;

    Scorecard(int questions) {
        results = new boolean[questions];
    }

    void recordAnswer(boolean correct) {
        if (count < results.length)
            results[count++] = correct;
    }

    int getScore() {
        int score = 0;

        for (boolean x : results)
            if (x)
                score++;

        return score;
    }
}

public class ScorecardMain {
    public static void main(String[] args) {

        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score: " + sc.getScore());
    }
}