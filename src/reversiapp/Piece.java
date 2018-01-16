package reversiapp;


public class Piece {
    private int row;
    private int col;
    private char disk;

    /**
     * C'tor. sets the disk to empty.
     *
     * @param newRow
     *            - row value.
     * @param newCol
     *            - column value.
     */
    public Piece(int newRow, int newCol) {
        this.row = newRow;
        this.col = newCol;
        this.disk = Sign.kEmpty;
    }

    /**
     *
     * @return - row value of cell.
     */
    public int getRow() {
        return this.row;
    }

    /**
     *
     * @return - column value of cell.
     */
    public int getCol() {
        return this.col;
    }
    /**
     *
     * @return - disk value of the cell.
     */
    public char getDisk() {
        return this.disk;
    }
    /**
     * Setter for disk.
     *
     * @param newDisk
     *            - new disk value.
     */
    public void setDisk(char newDisk) {
        this.disk = newDisk;
    }

    @Override
    /**
     * Represents the cell as the disk value.
     */
    public String toString() {
        return Character.toString(this.disk);
    }

    public boolean equals(Piece other) {
        return this.row == other.getRow() && this.col == other.getCol();
    }

    /**
     *
     * @return - String representation of the coordinate of the cell.
     */
    public String toCoordinate() {
        String rowStr = String.valueOf(this.row + 1);
        String colStr = String.valueOf(this.col + 1);
        return "(" + rowStr + "," + colStr + ")";
    }
}
