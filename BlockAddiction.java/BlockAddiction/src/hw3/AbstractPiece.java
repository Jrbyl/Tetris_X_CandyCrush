package hw3;

import api.Cell;
import api.Icon;
import api.Piece;
import api.Position;

/**
 * Abstract class that contains all the shared data between the unique pieces of BlockAddiction
 *
 * @author Jon Beltzhoover
 */
public abstract class AbstractPiece implements Piece {
    /**
     * Stores the starting position of the piece
     */
    private Position position;
    /**
     * Stores every block of a piece at a given location with a given color
     */
    private Cell[] cells;

    /**
     * The constructor creates a new piece given a starting position and an array of icons (colors)
     *
     * @param startingPos the starting position of the piece
     * @param icons holds the icon (color) of each block in the piece
     */
    protected AbstractPiece (Position startingPos, Icon[] icons) {
        this.position = startingPos;
        this.cells = createNewPiece(icons);
    }

    /**
     * Creates a new piece's unique cells and stores them in the "cells" instance variable
     *
     * @param icons - the colors of each block in a piece
     * @return cells of new piece
     */
    protected abstract Cell[] createNewPiece(Icon[] icons);

    /**
     * Transforms this piece without altering its position according to the rules of the game to be implemented. Typical operations would be rotation or reflection. No bounds checking is done.
     */
    public abstract void transform();

    /**
     * Returns the position of this piece (upper-left corner of its bounding box).
     *
     * @return position of this shape
     */
    @Override
    public Position getPosition() {
        return position;
    }

    /**
     * Returns a deep copy of the Cell objects in this piece. The cell positions are relative to the upper-left corner of its bounding box.
     *
     * @return copy of the cells in this piece
     */
    @Override
    public Cell[] getCells() {
        int i;
        Cell[] cellsCopy = new Cell[cells.length];
        for (i = 0; i < cells.length; i++) {
            cellsCopy[i] = new Cell(cells[i]);
        }
        return cellsCopy;
    }

    /**
     * Returns a new array of Cell objects representing the icons in this piece with their absolute positions (relative positions plus position of bounding box).
     *
     * @return copy of the cells in this piece, with absolute positions
     */
    @Override
    public Cell[] getCellsAbsolute() {
        int i;
        Cell[] cellsAbsolute = new Cell[cells.length];
        int[] rows = new int[cells.length];
        int[] colm = new int[cells.length];
        Icon[] icons = new Icon[cells.length];

        for (i = 0; i < cells.length; i++) {
            rows[i] = cells[i].getRow() + position.row();
            colm[i] = cells[i].getCol() + position.col();
            icons[i] = cells[i].getIcon();
            cellsAbsolute[i] = new Cell(icons[i], new Position(rows[i], colm[i]));
        }
        return cellsAbsolute;
    }

    /**
     * Sets the cells in this piece, making a deep copy of the given array.
     *
     * @param givenCells new cells for this piece
     */
    @Override
    public void setCells(Cell[] givenCells) {
        int i;
        cells = new Cell[givenCells.length];

        for (i = 0; i < givenCells.length; i++) {
            cells[i] = new Cell(givenCells[i]);
        }
    }

    /**
     * Shifts the position of this piece down (increasing the row) by one. No bounds checking is done.
     */
    @Override
    public void shiftDown() {
        position = new Position(position.row() + 1, position.col());
    }

    /**
     * Shifts the position of this piece left (decreasing the column) by one. No bounds checking is done.
     */
    @Override
    public void shiftLeft() {
        position = new Position(position.row(), position.col() - 1);
    }

    /**
     * Shifts the position of this piece right (increasing the column) by one. No bounds checking is done.
     */
    @Override
    public void shiftRight() {
        position = new Position(position.row(), position.col() + 1);
    }

    /**
     * Cycles the icons within the cells of this piece. Each icon is shifted forward to the next cell (in the original ordering of the cells). The last icon wraps around to the first cell.
     */
    @Override
    public void cycle() {
        int i;
        Cell cellCopy = new Cell(cells[0]);

        for (i = 0; i < cells.length; i++) {
            if (i == (cells.length - 1)) {
                cells[i].setIcon(cellCopy.getIcon());
            }
            else {
                cells[i].setIcon(cells[i + 1].getIcon());
            }
        }
    }

    /**
     * Returns a deep copy of this object having the correct runtime type.
     *
     * @return a deep copy of this object
     */
    @Override
    public Piece clone() {
        try {
            AbstractPiece uniquePiece = (AbstractPiece) super.clone();
            uniquePiece.cells = new Cell[cells.length];

            for (int i = 0; i < cells.length; ++i) {
                uniquePiece.cells[i] = new Cell(cells[i]);
            }
            return uniquePiece;
        }
        catch (CloneNotSupportedException exception) {
            return null;
        }
    }

}
