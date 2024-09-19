package examples;

import java.awt.Color;

import api.Icon;
import api.Cell;
import api.Position;
import api.Piece;
import api.Icon;

/**
 * Partial implementation of the Piece interface for experimentation.
 */
public class SamplePiece implements Piece
{
	private Position position;
	private Cell[] cells;
	private static final Position[] sequence = {
			new Position(0, 0),
			new Position(0, 1),
			new Position(1, 1),
			new Position(1, 0)
	};

	private int firstIndex;
	private int secondIndex;
	private int thirdIndex;

	/**
	 * Constructs a SamplePiece at the given position.
	 *
	 * @param givenPosition position of upper left corner
	 */
	public SamplePiece(Position givenPosition)
	{
		position = givenPosition;
		cells = new Cell[3];
		cells[0] = new Cell(new Icon(Color.RED), new Position(0, 0));
		cells[1] = new Cell(new Icon(Color.GREEN), new Position(1, 0));
		cells[2] = new Cell(new Icon(Color.YELLOW), new Position(1, 1));

		this.firstIndex = 1;
		this.secondIndex = 0;
		this.thirdIndex = 3;
	}

	@Override
	public Position getPosition()
	{
		return position;
	}

	@Override
	public void setCells(Cell[] givenCells)
	{
		int i;
		cells = new Cell[givenCells.length];

		for (i = 0; i < givenCells.length; i++) {
			cells[i] = new Cell(givenCells[i]);
		}
	}

	@Override
	public Cell[] getCells()
	{
		int i;
		Cell[] cellsCopy = new Cell[cells.length];
		for (i = 0; i < cells.length; i++) {
			cellsCopy[i] = new Cell(cells[i]);
		}
		return cellsCopy;
	}

	@Override
	public Cell[] getCellsAbsolute()
	{
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

	@Override
	public void shiftDown()
	{
		position = new Position(position.row() + 1, position.col());
	}

	@Override
	public void shiftLeft()
	{
		position = new Position(position.row(), position.col() - 1);
	}

	@Override
	public void shiftRight()
	{
		position = new Position(position.row(), position.col() + 1);
	}

	@Override
	public void transform()
	{
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

	}

	@Override
	public void cycle()
	{
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

	@Override
	public Piece clone()
	{
		try
		{
			// call the Object clone() method to create a shallow copy
			SamplePiece s = (SamplePiece) super.clone();

			// then make it into a deep copy (note there is no need to copy the position,
			// since Position is immutable, but we have to deep-copy the cell array
			// by making new Cell objects
			s.cells = new Cell[3];
			for (int i = 0; i < cells.length; ++i)
			{
				s.cells[i] = new Cell(cells[i]);
			}
			return s;
		}
		catch (CloneNotSupportedException e)
		{
			// can't happen, since we know the superclass is cloneable
			return null;
		}
	}
}

