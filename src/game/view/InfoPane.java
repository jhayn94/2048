package game.view;

import game.controller.ApplicationStateContext;
import game.state.model.NewGameState;
import game.state.model.RedoActionState;
import game.state.model.UndoActionState;
import game.view.util.LabelConstants;
import game.view.util.TooltipConstants;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;

/**
 * Info banner on the top the view.
 */
public class InfoPane extends HBox {

    private static final int PADDING_FOR_PANE = 15;

    private static final int DEFAULT_WIDTH = 320;

    private static final int MIN_BUTTON_HEIGHT = 75;

    private static final int MIN_BUTTON_WIDTH = 75;

    private Button undoButton;

    private Button redoButton;

    private Button resetButton;

    private TextArea scoreTextArea;

    private TextArea bestScoreTextArea;

    public InfoPane() {
        this.configure();
    }

    public Button getResetButton() {
        return this.resetButton;
    }

    public Button getUndoButton() {
        return this.undoButton;
    }

    public Button getRedoButton() {
        return this.redoButton;
    }

    private void configure() {
        this.setPadding(new Insets(PADDING_FOR_PANE));
        this.setSpacing(PADDING_FOR_PANE);
        this.setMinWidth(DEFAULT_WIDTH);
        this.setMaxWidth(DEFAULT_WIDTH);
        this.createChildElements();
    }

    private void createChildElements() {
        this.createUndoButton();
        this.createRedoButton();
        this.createResetButton();
    }

    private void createUndoButton() {
        this.undoButton = new Button();
        this.undoButton.setFocusTraversable(false);
        this.undoButton.setText(LabelConstants.UNDO);
        this.undoButton.setTooltip(new Tooltip(TooltipConstants.UNDO));
        this.undoButton.setMinHeight(MIN_BUTTON_HEIGHT);
        this.undoButton.setMinWidth(MIN_BUTTON_WIDTH);
        this.undoButton.setOnAction(event -> ApplicationStateContext.getInstance().changeState(new UndoActionState()));
        this.getChildren().add(this.undoButton);
    }

    private void createRedoButton() {
        this.redoButton = new Button();
        this.redoButton.setFocusTraversable(false);
        this.redoButton.setText(LabelConstants.REDO);
        this.redoButton.setTooltip(new Tooltip(TooltipConstants.REDO));
        this.redoButton.setMinHeight(MIN_BUTTON_HEIGHT);
        this.redoButton.setMinWidth(MIN_BUTTON_WIDTH);
        this.redoButton.setOnAction(event -> ApplicationStateContext.getInstance().changeState(new RedoActionState()));
        this.getChildren().add(this.redoButton);
    }

    private void createResetButton() {
        this.resetButton = new Button();
        this.resetButton.setFocusTraversable(false);
        this.resetButton.setText(LabelConstants.RESET);
        this.resetButton.setTooltip(new Tooltip(TooltipConstants.RESET));
        this.resetButton.setMinHeight(MIN_BUTTON_HEIGHT);
        this.resetButton.setMinWidth(MIN_BUTTON_WIDTH);
        this.resetButton.setOnAction(event -> ApplicationStateContext.getInstance().changeState(new NewGameState()));
        this.getChildren().add(this.resetButton);
    }
}
