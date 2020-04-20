package game.state.model;

import game.controller.ApplicationStateContext;
import game.factory.ModelFactory;
import game.model.BoardHistory;
import game.model.BoardModel;
import game.state.GameState;

/**
 * This class updates the state of the application when the user starts a new game, either with
 * CTRL + N, or via the context menu.
 */
public class NewGameState extends GameState {

    private final int size;

    public NewGameState() {
        super();
        this.size = 4;
    }

    @Override
    public void onEnter() {
        this.resetBoard();
        this.clearHighlightedCells();

        final BoardModel board = ModelFactory.getInstance().createBoard();
        this.context.setBoard(board);
        this.updateUndoRedoComponents();
        this.resetAppToMatchBoard();
    }

    private void updateUndoRedoComponents() {
        final BoardHistory history = this.context.getHistory();
        history.clearRedoStack();
        history.clearUndoStack();
        this.updateUndoRedoButtons();
    }

}
