package reversiapp;


public class ScoreTracker {
    private int player1Score;
    private int player2Score;

    public ScoreTracker() {
        player1Score = 2; // initial disks
        player2Score = 2;
    }

    public void updateScore(char color, int cellsFlipped) {
        if (color == Sign.kBlacks) {
            player1Score += cellsFlipped + 1;
            player2Score -= cellsFlipped;
        } else if (color == Sign.kWhites) {
            player2Score += cellsFlipped + 1;
            player1Score -= cellsFlipped;
        }
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public int getPlayer2Score() {
        return player2Score;
    }
}