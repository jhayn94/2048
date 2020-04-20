package game.state.action;

import game.model.BoardModel;
import game.state.GameState;
import javafx.scene.input.KeyCode;

/**
 * This class contains methods to show or hide the application context menu.
 */
public class ArrowKeyPressedState extends GameState {

    private final KeyCode keyCode;

    public ArrowKeyPressedState(final KeyCode keyCode) {
        super();
        this.keyCode = keyCode;
    }

    @Override
    public void onEnter() {
        if (KeyCode.UP == this.keyCode || KeyCode.W == this.keyCode) {
            this.handleUpPressed();
        } else if (KeyCode.DOWN == this.keyCode || KeyCode.S == this.keyCode) {
            this.handleDownPressed();
        } else if (KeyCode.LEFT == this.keyCode || KeyCode.A == this.keyCode) {
            this.handleLeftPressed();
        } else if (KeyCode.RIGHT == this.keyCode || KeyCode.D == this.keyCode) {
            this.handleRightPressed();
        }

        this.resetAppToMatchBoard();

        this.printBoard();

    }

    private void handleUpPressed() {
        this.clearGapsMovingUp();
        this.mergeCellsMovingUp();
        this.clearGapsMovingUp();
    }

    private void clearGapsMovingUp() {
        final BoardModel board = this.context.getBoard();
        for (int col = 0; col < BoardModel.DEFAULT_SIZE; col++) {
            for (int row = 1; row < BoardModel.DEFAULT_SIZE; row++) {
                final int value = board.getCell(row, col);
                if (value > 0) {
                    int newRow = row - 1;
                    while (newRow > 0 && board.getCell(newRow, col) == 0) {
                        newRow--;
                    }

                    if (newRow != row) {
                        board.setCell(newRow, col, value);
                        board.setCell(row, col, 0);
                    }
                }
            }
        }
    }

    private void mergeCellsMovingUp() {
        final BoardModel board = this.context.getBoard();
        for (int col = 0; col < BoardModel.DEFAULT_SIZE; col++) {
            for (int row = 0; row < BoardModel.DEFAULT_SIZE - 1; row++) {
                final int cell = board.getCell(row, col);
                final int cell2 = board.getCell(row + 1, col);
                if (cell == cell2) {
                    board.setCell(row, col, cell * 2);
                    board.setCell(row + 1, col, 0);
                }
            }
        }
    }

    private void handleDownPressed() {
        this.clearGapsMovingDown();
        this.mergeCellsMovingDown();
        this.clearGapsMovingDown();
    }

    private void clearGapsMovingDown() {
        final BoardModel board = this.context.getBoard();
        for (int col = 0; col < BoardModel.DEFAULT_SIZE; col++) {
            for (int row = BoardModel.DEFAULT_SIZE - 2; row >= 0; row--) {
                final int value = board.getCell(row, col);
                if (value > 0) {
                    int newRow = row + 1;
                    while (newRow < BoardModel.DEFAULT_SIZE - 1 && board.getCell(newRow, col) == 0) {
                        newRow++;
                    }

                    if (newRow != row) {
                        board.setCell(newRow, col, value);
                        board.setCell(row, col, 0);
                    }
                }
            }
        }
    }

    private void mergeCellsMovingDown() {
        final BoardModel board = this.context.getBoard();
        for (int col = 0; col < BoardModel.DEFAULT_SIZE; col++) {
            for (int row = BoardModel.DEFAULT_SIZE - 1; row > 0; row--) {
                final int cell = board.getCell(row, col);
                final int cell2 = board.getCell(row - 1, col);
                if (cell == cell2) {
                    board.setCell(row, col, cell * 2);
                    board.setCell(row - 1, col, 0);
                }
            }
        }
    }

    private void handleLeftPressed() {
        this.clearGapsMovingLeft();
        this.mergeCellsMovingLeft();
        this.clearGapsMovingLeft();
    }

    private void clearGapsMovingLeft() {
        final BoardModel board = this.context.getBoard();
        for (int row = 0; row < BoardModel.DEFAULT_SIZE; row++) {
            for (int col = 1; col < BoardModel.DEFAULT_SIZE; col++) {
                final int value = board.getCell(row, col);
                if (value > 0) {
                    int newCol = col ;
                    while (newCol > 0 && board.getCell(row, newCol - 1) == 0) {
                        newCol--;
                    }

                    if (newCol != col) {
                        board.setCell(row, newCol , value);
                        board.setCell(row, col, 0);
                    }
                }
            }
        }
    }

    private void mergeCellsMovingLeft() {
        final BoardModel board = this.context.getBoard();
        for (int row = 0; row < BoardModel.DEFAULT_SIZE; row++) {
            for (int col = 0; col < BoardModel.DEFAULT_SIZE - 1; col++) {
                final int cell = board.getCell(row, col);
                final int cell2 = board.getCell(row, col + 1);
                if (cell == cell2) {
                    board.setCell(row, col, cell * 2);
                    board.setCell(row, col + 1, 0);
                }
            }
        }
    }

    private void handleRightPressed() {
        this.printBoard();
        this.clearGapsMovingRight();
        this.printBoard();
        this.mergeCellsMovingRight();
        this.printBoard();
        this.clearGapsMovingRight();
        this.printBoard();
    }

    private void clearGapsMovingRight() {
        final BoardModel board = this.context.getBoard();
        for (int row = 0; row < BoardModel.DEFAULT_SIZE; row++) {
            for (int col = BoardModel.DEFAULT_SIZE - 2; col >= 0; col--) {
                final int value = board.getCell(row, col);
                if (value > 0) {
                    int newCol = col + 1;
                    while (newCol < BoardModel.DEFAULT_SIZE - 1 && board.getCell(row, newCol) == 0) {
                        newCol++;
                    }

                    if (newCol != col) {
                        board.setCell(row, newCol - 1, value);
                        board.setCell(row, col, 0);
                    }
                }
            }
        }
    }

    private void mergeCellsMovingRight() {
        final BoardModel board = this.context.getBoard();
        for (int row = 0; row < BoardModel.DEFAULT_SIZE; row++) {
            for (int col = BoardModel.DEFAULT_SIZE - 1; col > 0; col--) {
                final int cell = board.getCell(row, col);
                final int cell2 = board.getCell(row, col - 1);
                if (cell == cell2) {
                    board.setCell(row, col, cell * 2);
                    board.setCell(row, col - 1, 0);
                }
            }
        }
    }

    private void printBoard() {
        for (int row = 0; row < BoardModel.DEFAULT_SIZE; row++) {
            for (int col = 0; col < BoardModel.DEFAULT_SIZE; col++) {
                System.out.print(this.context.getBoard().getCell(row, col) + " ");
            }
            System.out.println();
        }
        System.out.println("------------");
    }

}
