package hw3;

import api.Position;
import api.Icon;
import api.Cell;
import java.awt.*;

/**
 * Test cases for each subclass of AbstractPiece
 *
 * @author Jon Beltzhoover
 */
public class PieceTest {

    public static void main(String[] args) {
        Icon[] fourBlocks = new Icon[]{new Icon(Color.RED), new Icon(Color.YELLOW), new Icon(Color.BLUE), new Icon(Color.GREEN)};
        Icon[] threeBlocks = new Icon[]{new Icon(Color.RED), new Icon(Color.YELLOW), new Icon(Color.BLUE)};
        Icon[] twoBlocks = new Icon[]{new Icon(Color.RED), new Icon(Color.YELLOW)};

        LPiece newPiece1 = new LPiece(new Position(0, 0), fourBlocks);
        IPiece newPiece2 = new IPiece(new Position(0, 0), threeBlocks);
        DiagonalPiece newPiece3 = new DiagonalPiece(new Position(0, 0), twoBlocks);
        CornerPiece newPiece4 = new CornerPiece(new Position(0, 0), threeBlocks);
        SnakePiece newPiece5 = new SnakePiece(new Position(0, 0), fourBlocks);

        System.out.println();

        Position temp1 = newPiece1.getPosition();
        System.out.println(temp1);
        System.out.println("Expected: (0,0)");
        System.out.println();

        Position temp2 = newPiece2.getPosition();
        System.out.println(temp2);
        System.out.println("Expected: (0,0)");
        System.out.println();

        Position temp3 = newPiece3.getPosition();
        System.out.println(temp3);
        System.out.println("Expected: (0,0)");
        System.out.println();

        Position temp4 = newPiece4.getPosition();
        System.out.println(temp4);
        System.out.println("Expected: (0,0)");
        System.out.println();

        Position temp5 = newPiece5.getPosition();
        System.out.println(temp5);
        System.out.println("Expected: (0,0)");
        System.out.println();

        Cell[] lpiece = newPiece1.getCells();
        for (Cell cell : lpiece) {
            System.out.print(cell + " ");
        }
        System.out.println();
        System.out.println("Expected: R(0, 0) Y(0, 1) B(1, 1) G(2, 1)");
        System.out.println();

        Cell[] ipiece = newPiece2.getCells();
        for (Cell cell : ipiece) {
            System.out.print(cell + " ");
        }
        System.out.println();
        System.out.println("Expected: R(0, 1) Y(1, 1) B(2, 1)");
        System.out.println();

        Cell[] diapiece = newPiece3.getCells();
        for (Cell cell : diapiece) {
            System.out.print(cell + " ");
        }
        System.out.println();
        System.out.println("Expected: R(0, 0) Y(1, 1)");
        System.out.println();

        Cell[] corpiece = newPiece4.getCells();
        for (Cell cell : corpiece) {
            System.out.print(cell + " ");
        }
        System.out.println();
        System.out.println("Expected: R(0, 0) Y(1, 0) B(1, 1)");
        System.out.println();

        Cell[] spiece = newPiece5.getCells();
        for (Cell cell : spiece) {
            System.out.print(cell + " ");
        }
        System.out.println();
        System.out.println("Expected: R(0, 0) Y(1, 0) B(1, 1) G(1, 2)");
        System.out.println();

        System.out.println();
        newPiece1.cycle();
        newPiece2.cycle();
        newPiece3.cycle();
        newPiece4.cycle();
        newPiece5.cycle();
        System.out.println();

        Cell[] lpiece1 = newPiece1.getCells();
        for (Cell cell : lpiece1) {
            System.out.print(cell + " ");
        }
        System.out.println();
        System.out.println("Expected: Y(0, 0) B(0, 1) G(1, 1) R(2, 1)");
        System.out.println();

        Cell[] ipiece1 = newPiece2.getCells();
        for (Cell cell : ipiece1) {
            System.out.print(cell + " ");
        }
        System.out.println();
        System.out.println("Expected: Y(0, 1) B(1, 1) R(2, 1)");
        System.out.println();

        Cell[] diapiece1 = newPiece3.getCells();
        for (Cell cell : diapiece1) {
            System.out.print(cell + " ");
        }
        System.out.println();
        System.out.println("Expected: Y(0, 0) R(1, 1)");
        System.out.println();

        Cell[] corpiece1 = newPiece4.getCells();
        for (Cell cell : corpiece1) {
            System.out.print(cell + " ");
        }
        System.out.println();
        System.out.println("Expected: Y(0, 0) B(1, 0) R(1, 1)");
        System.out.println();

        Cell[] spiece1 = newPiece5.getCells();
        for (Cell cell : spiece1) {
            System.out.print(cell + " ");
        }
        System.out.println();
        System.out.println("Expected: Y(0, 0) B(1, 0) G(1, 1) R(1, 2)");
        System.out.println();

        System.out.println();
        newPiece1.transform();
        newPiece2.transform();
        newPiece3.transform();
        newPiece4.transform();
        newPiece5.transform();
        System.out.println();

        Cell[] lpiece2 = newPiece1.getCells();
        for (Cell cell : lpiece2) {
            System.out.print(cell + " ");
        }
        System.out.println();
        System.out.println("Expected: Y(0, 2) B(0, 1) G(1, 1) R(2, 1)");
        System.out.println();

        Cell[] ipiece2 = newPiece2.getCells();
        for (Cell cell : ipiece2) {
            System.out.print(cell + " ");
        }
        System.out.println();
        System.out.println("Expected: Y(0, 1) B(1, 1) R(2, 1)");
        System.out.println();

        Cell[] diapiece2 = newPiece3.getCells();
        for (Cell cell : diapiece2) {
            System.out.print(cell + " ");
        }
        System.out.println();
        System.out.println("Expected: Y(0, 1) R(1, 0)");
        System.out.println();

        Cell[] corpiece2 = newPiece4.getCells();
        for (Cell cell : corpiece2) {
            System.out.print(cell + " ");
        }
        System.out.println();
        System.out.println("Expected: Y(0, 1) B(0, 0) R(1, 0)");
        System.out.println();

        Cell[] spiece2 = newPiece5.getCells();
        for (Cell cell : spiece2) {
            System.out.print(cell + " ");
        }
        System.out.println();
        System.out.println("Expected: Y(0, 1) B(0, 0) G(1, 0) R(1, 1)");
        System.out.println();

        System.out.println();
        newPiece1.shiftDown();
        newPiece2.shiftDown();
        newPiece3.shiftDown();
        newPiece4.shiftDown();
        newPiece5.shiftDown();
        System.out.println();

        Cell[] lpiece3 = newPiece1.getCellsAbsolute();
        for (Cell cell : lpiece3) {
            System.out.print(cell + " ");
        }
        System.out.println();
        System.out.println("Expected: Y(1, 2) B(1, 1) G(2, 1) R(3, 1)");
        System.out.println();

        Cell[] ipiece3 = newPiece2.getCellsAbsolute();
        for (Cell cell : ipiece3) {
            System.out.print(cell + " ");
        }
        System.out.println();
        System.out.println("Expected: Y(1, 1) B(2, 1) R(3, 1)");
        System.out.println();

        Cell[] diapiece3 = newPiece3.getCellsAbsolute();
        for (Cell cell : diapiece3) {
            System.out.print(cell + " ");
        }
        System.out.println();
        System.out.println("Expected: Y(1, 1) R(2, 0)");
        System.out.println();

        Cell[] corpiece3 = newPiece4.getCellsAbsolute();
        for (Cell cell : corpiece3) {
            System.out.print(cell + " ");
        }
        System.out.println();
        System.out.println("Expected: Y(1, 1) B(1, 0) R(2, 0)");
        System.out.println();

        Cell[] spiece3 = newPiece5.getCellsAbsolute();
        for (Cell cell : spiece3) {
            System.out.print(cell + " ");
        }
        System.out.println();
        System.out.println("Expected: Y(1, 1) B(1, 0) G(2, 0) R(2, 1)");
        System.out.println();

        System.out.println();
        newPiece1.shiftRight();
        newPiece2.shiftRight();
        newPiece3.shiftRight();
        newPiece4.shiftRight();
        newPiece5.shiftRight();
        System.out.println();

        Cell[] lpiece4 = newPiece1.getCellsAbsolute();
        for (Cell cell : lpiece4) {
            System.out.print(cell + " ");
        }
        System.out.println();
        System.out.println("Expected: Y(1, 3) B(1, 2) G(2, 2) R(3, 2)");
        System.out.println();

        Cell[] ipiece4 = newPiece2.getCellsAbsolute();
        for (Cell cell : ipiece4) {
            System.out.print(cell + " ");
        }
        System.out.println();
        System.out.println("Expected: Y(1, 2) B(2, 2) R(3, 2)");
        System.out.println();

        Cell[] diapiece4 = newPiece3.getCellsAbsolute();
        for (Cell cell : diapiece4) {
            System.out.print(cell + " ");
        }
        System.out.println();
        System.out.println("Expected: Y(1, 2) R(2, 1)");
        System.out.println();

        Cell[] corpiece4 = newPiece4.getCellsAbsolute();
        for (Cell cell : corpiece4) {
            System.out.print(cell + " ");
        }
        System.out.println();
        System.out.println("Expected: Y(1, 2) B(1, 1) R(2, 1)");
        System.out.println();

        Cell[] spiece4 = newPiece5.getCellsAbsolute();
        for (Cell cell : spiece4) {
            System.out.print(cell + " ");
        }
        System.out.println();
        System.out.println("Expected: Y(1, 2) B(1, 1) G(2, 1) R(2, 2)");
        System.out.println();

        System.out.println();
        newPiece1.shiftLeft();
        newPiece2.shiftLeft();
        newPiece3.shiftLeft();
        newPiece4.shiftLeft();
        newPiece5.shiftLeft();
        System.out.println();

        Cell[] lpiece5 = newPiece1.getCellsAbsolute();
        for (Cell cell : lpiece5) {
            System.out.print(cell + " ");
        }
        System.out.println();
        System.out.println("Expected: Y(1, 2) B(1, 1) G(2, 1) R(3, 1)");
        System.out.println();

        Cell[] ipiece5 = newPiece2.getCellsAbsolute();
        for (Cell cell : ipiece5) {
            System.out.print(cell + " ");
        }
        System.out.println();
        System.out.println("Expected: Y(1, 1) B(2, 1) R(3, 1)");
        System.out.println();

        Cell[] diapiece5 = newPiece3.getCellsAbsolute();
        for (Cell cell : diapiece5) {
            System.out.print(cell + " ");
        }
        System.out.println();
        System.out.println("Expected: Y(1, 1) R(2, 0)");
        System.out.println();

        Cell[] corpiece5 = newPiece4.getCellsAbsolute();
        for (Cell cell : corpiece5) {
            System.out.print(cell + " ");
        }
        System.out.println();
        System.out.println("Expected: Y(1, 1) B(1, 0) R(2, 0)");
        System.out.println();

        Cell[] spiece5 = newPiece5.getCellsAbsolute();
        for (Cell cell : spiece5) {
            System.out.print(cell + " ");
        }
        System.out.println();
        System.out.println("Expected: Y(1, 1) B(1, 0) G(2, 0) R(2, 1)");
        System.out.println();

    }

}
