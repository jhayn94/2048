package game.model;

import java.util.Random;

/**
 * This class represents all the underlying data for a 2048 board.
 */
public class BoardModel {

    public static final int DEFAULT_SIZE = 4;

    private int[][] cells;

    private final int size;

    public BoardModel() {
        this(DEFAULT_SIZE);
    }

    public BoardModel(int size) {
        this.size = size;
        this.cells = new int[size][size];
        this.reset(this.size);
    }

    public void reset(final int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; i < size; i++) {
                cells[j][i] = 0;
            }
        }

        final Random rng = new Random();
        final int startRow1 = rng.nextInt(2);
        final int startRow2 = rng.nextInt(2) + 2;
        final int startCol1 = rng.nextInt(4);
        final int startCol2 = rng.nextInt(4);
        cells[startCol1][startRow1] = 2;
        cells[startCol2][startRow2] = 2;
    }

    public void setCell(int row, int col, int value) {
        this.cells[col][row] = value;
    }

    public int getCell(int row, int col) {
        return this.cells[col][row];
    }

    public BoardModel createCopy() {
        final BoardModel other = new BoardModel(this.size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; i < size; i++) {
                other.cells[j][i] = this.cells[j][i];
            }
        }
        return other;
    }

    public int getSize() {
        return size;
    }
}
