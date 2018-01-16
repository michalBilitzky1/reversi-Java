package reversiapp;


import java.util.List;

public class DisplayScreen implements Display {
    private final char kColSep = '|';

    /**
     * displays the board in console.
     *
     * @param board
     *            - a board.
     */
    @Override
    public void displayBoard(Board board) {
        System.out.println();
        int size = board.getSize();
        String row = "----------------------------------";
        System.out.print(" " + kColSep + " ");
        for (int x = 1; x <= size; x++) {
            System.out.print(x + " " + kColSep + " ");
        }
        System.out.println("\n" + row);
        for (int j = 0; j < size; j++) {
            for (int i = -1; i < size; i++) {
                if (i == -1) {
                    int col = j + 1;
                    System.out.print(col + "|" + " ");
                    continue;
                }
                System.out.print(board.getCell(j, i).toString()
                        + " " + kColSep + " ");
            }
            System.out.println("\n" + row);
        }
    }

    /**
     * displays the list of moves for the player in console.
     *
     * @param player
     *            - a player.
     * @param moves
     *            - list of moves for the player.
     */
    @Override
    public void displayHumanPlayerChoiceMessage(Player player,
                                                List<Piece> moves) {
        System.out.println(player.getColor() + ": " + "Your Turn.");
        System.out.print("Your possible moves are: ");
        for (Piece cell : moves) {
            System.out.print(cell.toCoordinate() + " ");
        }
        System.out.println();
        System.out.println(
                "Please enter your move. Excpected input for (x,y) is x y");
    }

    /**
     * displays a no moves message for the player in console.
     *
     * @param player
     *            - a player.
     */
    @Override
    public void displayNoMoves(Player player) {
        System.out.println(player.getColor()
                + ": You have no availiable moves, turn is passed to the other player.");
    }

    /**
     * displays the scores of the players.
     *
     * @param player1
     * @param player2
     * @param board
     * @param player1Score
     * @param player2Score
     */
    @Override
    public void displayEndScreen(Player player1, Player player2, Board board,
                                 int player1Score, int player2Score) {
        if (player1Score + player2Score == board.getSize() * board.getSize()) {
            // board is full.
            System.out.println("No more possible moves.");
        }
        if (player1Score > player2Score) {
            System.out.println(player1.getColor() + ": You Won!");
        } else {
            System.out.println(player2.getColor() + ": You Won!");
        }
    }
}