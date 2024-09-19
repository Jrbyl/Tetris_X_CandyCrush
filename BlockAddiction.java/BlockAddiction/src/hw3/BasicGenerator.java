
package hw3;

import java.util.Random;

import api.Generator;
import api.Icon;
import api.Piece;
import api.Position;
import examples.SamplePiece;

/**
 * Generator for Piece objects in BlockAddiction. Icons are always selected uniformly at random, and the Piece types are generated with the following probabilities:
 * <ul>
 * <li>LPiece - 10%
 * <li>DiagonalPiece - 25%
 * <li>CornerPiece - 15%
 * <li>SnakePiece - 10%
 * <li>IPiece - 40%
 * </ul>
 * The initial position of each piece is based on its vertical size as well as the width of the grid (given as an argument to getNext). The initial column is always width/2 - 1. The initial row is: *
 * <ul>
 * <li>LPiece - row = -2
 * <li>DiagonalPiece - row = -1
 * <li>CornerPiece - row = -1
 * <li>SnakePiece - row = -1
 * <li>IPiece - row = -2
 * </ul>
 *
 */
public class BasicGenerator implements Generator
{
	private Random rand;

	/**
	 * Constructs a BasicGenerator that will use the given Random object as its source of randomness.
	 *
	 * @param givenRandom instance of Random to use
	 */
	public BasicGenerator(Random givenRandom)
	{
		rand = givenRandom;
	}



	@Override
	public Piece getNext(int width)
	{
		int col = width / 2 - 1;

		// TODO: change this to return LPiece, IPiece, etc, with the given
		// probabilities
		return new SamplePiece(new Position(-1, col));

// UNCOMMENT WHEN YOU HAVE YOUR OWN CODE FOR THE PIECES
//		int col = width / 2 - 1;
//
//		int p = rand.nextInt(100);
//		if (p < 10)
//		{
//			return new LPiece(new Position(-2, col), getBlocks(4));
//		}
//		else if (p < 35)
//		{
//			return new DiagonalPiece(new Position(-1, col), getBlocks(2));
//		}
//		else if (p < 50)
//		{
//			return new CornerPiece(new Position(-1, col), getBlocks(3));
//		}
//		else if (p < 60)
//		{
//			return new SnakePiece(new Position(-1, col), getBlocks(4));
//		}
//		else
//		{
//			return new IPiece(new Position(-2, col), getBlocks(3));
//		}
	}

	@Override
	public Icon randomIcon()
	{

		return new Icon(Icon.COLORS[rand.nextInt(Icon.COLORS.length)]);

	}

	private Icon[] getBlocks(int num)
	{
		Icon[] icons = new Icon[num];
		for (int i = 0; i < icons.length; i++)
		{
			icons[i] = randomIcon();
		}

		return icons;
	}
}
