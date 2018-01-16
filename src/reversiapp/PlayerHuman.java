package reversiapp;

import java.util.List;
import java.util.Scanner;

public class PlayerHuman implements Player {
    private char color;

    /**
     *
     * @param newColor - a color for the player.
     */
    public PlayerHuman(char newColor) {
        this.color = newColor;
    }

    @Override
    public Piece pickMove(List<Piece> moves) {
        if(moves.size() == 0) {
            return null;
        }
        int row = 0, col = 0;
        Piece piece;
        Piece invalid = new Piece(-1, -1);
        // ----------------------- REMOVE THIS
        Scanner in = new Scanner(System.in);
        do {
            try {
                row = in.nextInt();
                col = in.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid Input. Try Again.");
                piece = invalid;
                in.nextLine();
                continue;
            }
            row -= 1;
            col -= 1;
            piece = new Piece(row, col);
        } while(!cellValidity(piece, moves));
        // ------------------
        return piece;
    }

    @Override
    public char getColor() {
        return this.color;
    }

    /**
     *
     * @param piece - a chosen piece.
     * @param moves - a list of possible moves.
     * @return - true if the chosen piece is valid.
     */
    private boolean cellValidity(Piece piece, List<Piece> moves) {
        for(Piece move : moves) {
            if(piece.equals(move)) {
                return true;
            }
        }
        return false;
    }
    public String playerName() {
        if(this.color == Sign.kBlacks) {
            return "First Player";
        } else {
            return "Second Player";
        }
    }
}