package hw3;

import api.Cell;
import api.Icon;
import api.Position;

/**
 * Creates the "I" piece as a shape for the game BlockAddiction
 *
 * @author Jon Beltzhoover
 */
public class IPiece extends AbstractPiece {

    /**
     * Constructs an "I" piece at the given position
     */
    public IPiece (Position startingPos, Icon[] icons) throws IllegalArgumentException {
        super(startingPos, icons);
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
        newPiece[0] = new Cell(icons[0], new Position(0, 1));
        newPiece[1] = new Cell(icons[1], new Position(1, 1));
        newPiece[2] = new Cell(icons[2], new Position(2, 1));

        return newPiece;
    }

    /**
     * Transforms this piece without altering its position according to the rules of the game to be implemented. Typical operations would be rotation or reflection. No bounds checking is done.
     */
    @Override
    public void transform() {
        //This does nothing for the "I" piece
    }

}
