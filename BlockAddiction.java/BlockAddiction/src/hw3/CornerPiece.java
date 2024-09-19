package hw3;

import api.Cell;
import api.Icon;
import api.Position;

/**
 * Creates the "corner" piece for the game BlockAddiction
 *
 * @author Jon Beltzhoover
 */
public class CornerPiece extends AbstractPiece {
    /**
     * Static position array that holds every possible position the piece can rotate to
     */
    private static final Position[] sequence = {
            new Position(0, 0),
            new Position(0, 1),
            new Position(1, 1),
            new Position(1, 0)
    };

    /**
     * Counter that rotates the first block of the corner piece
     */
    private int firstIndex;
    /**
     * Counter that rotates the second block of the corner piece
     */
    private int secondIndex;
    /**
     * Counter that rotates the third block of the corner piece
     */
    private int thirdIndex;

    /**
     * Constructs a "Corner" piece at the given position
     */
    public CornerPiece (Position startingPos, Icon[] icons) throws IllegalArgumentException {
        super(startingPos, icons);
        this.firstIndex = 1;
        this.secondIndex = 0;
        this.thirdIndex = 3;
    }

    /**
     * Creates a new piece's unique cells and stores them in the "cells" instance variable
     *
     * @param icons - the colors of each block in a piece
     * @return cells of new piece
     */
    @Override
    protected Cell[] createNewPiece(Icon[] icons) {
        Cell[] newPiece = new Cell[icons.length];
        newPiece[0] = new Cell(icons[0], new Position(0, 0));
        newPiece[1] = new Cell(icons[1], new Position(1, 0));
        newPiece[2] = new Cell(icons[2], new Position(1, 1));

        return newPiece;
    }

    /**
     * Transforms this piece without altering its position according to the rules of the game to be implemented. Typical operations would be rotation or reflection. No bounds checking is done.
     */
    @Override
    public void transform() {
        Cell[] cells = getCells();

        cells[0] = new Cell(cells[0].getIcon(), sequence[firstIndex]);
        firstIndex++;
        if (firstIndex > 3)
            firstIndex = 0;
        cells[1] = new Cell(cells[1].getIcon(), sequence[secondIndex]);
        secondIndex++;
        if (secondIndex > 3)
            secondIndex = 0;
        cells[2] = new Cell(cells[2].getIcon(), sequence[thirdIndex]);
        thirdIndex++;
        if (thirdIndex > 3)
            thirdIndex = 0;

        setCells(cells);
    }

}
