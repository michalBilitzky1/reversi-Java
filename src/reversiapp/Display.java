package reversiapp;

import java.util.List;

public interface Display {
    public void displayBoard(Board board);
    public void displayHumanPlayerChoiceMessage(Player player,
                                                List<Piece> moves);
    public void displayNoMoves(Player player);
    public void displayEndScreen(Player player1, Player player2, Board board,
                                 int player1Score, int player2Score);
}