package hw3;

import api.Cell;
import api.Position;
import api.Icon;

/**
 * Creates the "snake" piece for the game BlockAddiction
 *
 * @author Jon Beltzhoover
 */
public class SnakePiece extends AbstractPiece {
    /**
     * Static position array that holds every possible position the piece can rotate to
     */
    private static final Position[] sequence = {
            new Position(0, 0),
            new Position(0, 1),
            new Position(0, 2),
            new Position(1, 2),
            new Position(1, 1),
            new Position(1, 0),
            new Position(2, 0),
            new Position(2, 1),
            new Position(2, 2),
            new Position(1, 2),
            new Position(1, 1),
            new Position(1, 0)
    };

    /**
     * Counter that rotates the first block of the snake piece
     */
    private int firstIndex;
    /**
     * Counter that rotates the second block of the snake piece
     */
    private int secondIndex;
    /**
     * Counter that rotates the third block of the snake piece
     */
    private int thirdIndex;
    /**
     * Counter that rotates the fourth block of the snake piece
     */
    private int fourthIndex;

    /**
     * Constructs a "Snake" piece at a given position
     */
    public SnakePiece (Position startingPos, Icon[] icons) throws IllegalArgumentException {
        super(startingPos, icons);
        this.firstIndex = 1;
        this.secondIndex = 0;
        this.thirdIndex = 11;
        this.fourthIndex = 10;
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
        newPiece[3] = new Cell(icons[3], new Position(1, 2));

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
        if (firstIndex > 11)
            firstIndex = 0;
        cells[1] = new Cell(cells[1].getIcon(), sequence[secondIndex]);
        secondIndex++;
        if (secondIndex > 11)
            secondIndex = 0;
        cells[2] = new Cell(cells[2].getIcon(), sequence[thirdIndex]);
        thirdIndex++;
        if (thirdIndex > 11)
            thirdIndex = 0;
        cells[3] = new Cell(cells[3].getIcon(), sequence[fourthIndex]);
        fourthIndex++;
        if (fourthIndex > 11)
            fourthIndex = 0;

        setCells(cells);
    }

}
