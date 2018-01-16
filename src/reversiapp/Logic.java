package reversiapp;

import java.util.List;

public interface Logic {
    /**
     *
     * @param player
     *            - a player to find the possible moves for.
     * @param board
     *            - a board.
     * @return - a List of possible moves.
     */
    public List<Piece> getPossibleMoves(Player player, Board board);

    /**
     *
     * @param player
     *            - a player to flip the pieces for.
     * @param piece
     *            - a piece to flip the cells around.
     * @param board
     *            - a board.
     */
    public void flip(Player player, Piece piece, Board board);
}