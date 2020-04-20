package game.view;

import game.controller.ApplicationStateContext;
import game.state.model.NewGameState;
import game.state.model.RedoActionState;
import game.state.model.UndoActionState;
import game.view.util.LabelConstants;
import game.view.util.TooltipConstants;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;

/**
 * Info banner on the top the view.
 */
public class InfoPane extends HBox {

    private static final int PADDING_FOR_PANE = 15;

    private static final int CHILD_ELEMENT_SPACING = PADDING_FOR_PANE + 10;

    private static final int DEFAULT_WIDTH = 320;

    private static final int ELEMENT_SIZE = 100;

    private Button undoButton;

    private Button redoButton;

    private Button resetButton;

    // Just so styling the same is easy, button doesn't do anything.
    private Button scoreButton;

    public InfoPane() {
        this.configure();
    }

    public Button getScoreButton() {
        return this.scoreButton;
    }

    public Button getUndoButton() {
        return this.undoButton;
    }

    public Button getRedoButton() {
        return this.redoButton;
    }

    private void configure() {
        this.setPadding(new Insets(PADDING_FOR_PANE, PADDING_FOR_PANE, PADDING_FOR_PANE, 1));
        this.setMinWidth(DEFAULT_WIDTH);
        this.setMaxWidth(DEFAULT_WIDTH);
        this.createChildElements();
    }

    private void createChildElements() {
        this.createUndoButton();
        this.createRedoButton();
        this.createResetButton();
        this.createScoreButton();
    }

    private void createUndoButton() {
        this.undoButton = new Button();
        this.undoButton.setFocusTraversable(false);
        this.undoButton.setText(LabelConstants.UNDO);
        this.undoButton.setTooltip(new Tooltip(TooltipConstants.UNDO));
        this.undoButton.setMinHeight(ELEMENT_SIZE);
        this.undoButton.setMinWidth(ELEMENT_SIZE);
        this.undoButton.setOnAction(event -> ApplicationStateContext.getInstance().changeState(new UndoActionState()));
        HBox.setMargin(this.undoButton, new Insets(0, CHILD_ELEMENT_SPACING, 0, 0));
        this.getChildren().add(this.undoButton);
    }

    private void createRedoButton() {
        this.redoButton = new Button();
        this.redoButton.setFocusTraversable(false);
        this.redoButton.setText(LabelConstants.REDO);
        this.redoButton.setTooltip(new Tooltip(TooltipConstants.REDO));
        this.redoButton.setMinHeight(ELEMENT_SIZE);
        this.redoButton.setMinWidth(ELEMENT_SIZE);
        this.redoButton.setOnAction(event -> ApplicationStateContext.getInstance().changeState(new RedoActionState()));
        HBox.setMargin(this.redoButton, new Insets(0, CHILD_ELEMENT_SPACING, 0, 0));
        this.getChildren().add(this.redoButton);
    }

    private void createResetButton() {
        this.resetButton = new Button();
        this.resetButton.setFocusTraversable(false);
        this.resetButton.setText(LabelConstants.RESET);
        this.resetButton.setTooltip(new Tooltip(TooltipConstants.RESET));
        this.resetButton.setMinHeight(ELEMENT_SIZE);
        this.resetButton.setMinWidth(ELEMENT_SIZE);
        this.resetButton.setOnAction(event -> ApplicationStateContext.getInstance().changeState(new NewGameState()));
        HBox.setMargin(this.resetButton, new Insets(0, CHILD_ELEMENT_SPACING, 0, 0));
        this.getChildren().add(this.resetButton);
    }

    private void createScoreButton() {
        this.scoreButton = new Button();
        this.scoreButton.setFocusTraversable(false);
        this.scoreButton.setText(String.valueOf(0));
        this.scoreButton.setTooltip(new Tooltip(TooltipConstants.RESET));
        this.scoreButton.setMinHeight(ELEMENT_SIZE);
        this.scoreButton.setMinWidth(ELEMENT_SIZE * 2);
        this.getChildren().add(this.scoreButton);
    }
}
