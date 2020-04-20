package game.state.model;

import game.model.BoardHistory;
import game.model.BoardModel;
import game.state.GameState;

/**
 * This class updates the state of the application when the user invokes a
 * "redo", either through the keyboard or a button press in the UI.
 */
public class RedoActionState extends GameState {

    public RedoActionState() {
        super();
    }

    @Override
    public void onEnter() {
        final BoardHistory history = this.context.getHistory();
        if (!history.isRedoStackEmpty()) {
            this.clearHighlightedCells();
            final BoardModel board = history.getBoardForRedo();
            history.addToUndoStack(this.context.getBoard());
            this.context.setBoard(board);
            this.resetAppToMatchBoard();
            this.updateUndoRedoButtons();
        }

    }

}
