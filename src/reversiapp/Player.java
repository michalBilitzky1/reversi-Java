package reversiapp;

import java.util.List;

public interface Player {
    /**
     *
     * @param moves
     *            - a list of possible moves.
     * @return - a picked cell to place the disk.
     */
    public Piece pickMove(List<Piece> moves);

    /**
     *
     * @return - the color of the player.
     */
    public char getColor();

    /**
     *
     * @return
     */
    public String playerName();
}