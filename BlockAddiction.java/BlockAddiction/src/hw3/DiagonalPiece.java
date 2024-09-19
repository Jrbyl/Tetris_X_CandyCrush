package hw3;

import api.Cell;
import api.Icon;
import api.Position;

/**
 * Creates the "diagonal" piece for the game BlockAddiction
 *
 * @author Jon Beltzhoover
 */
public class DiagonalPiece extends AbstractPiece {
    /**
     * Counter variable that determines what rotation the piece is at
     */
    private int transformCounter;

    /**
     * Constructs a "Diagonal" piece at the given position
     */
    public DiagonalPiece (Position startingPos, Icon[] icons) throws IllegalArgumentException {
        super(startingPos, icons);
        this.transformCounter = 0;
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
        newPiece[1] = new Cell(icons[1], new Position(1, 1));

        return newPiece;
    }

    /**
     * Transforms this piece without altering its position according to the rules of the game to be implemented. Typical operations would be rotation or reflection. No bounds checking is done.
     */
    @Override
    public void transform() {
        Cell[] cells = getCells();

        if (transformCounter == 0) {
            cells[0] = new Cell(cells[0].getIcon(), new Position(0, 1));
            cells[1] = new Cell(cells[1].getIcon(), new Position(1, 0));
            transformCounter = 1;
        }
        else if (transformCounter == 1) {
            cells[0] = new Cell(cells[0].getIcon(), new Position(0, 0));
            cells[1] = new Cell(cells[1].getIcon(), new Position(1, 1));
            transformCounter = 0;
        }

        setCells(cells);
    }

}
