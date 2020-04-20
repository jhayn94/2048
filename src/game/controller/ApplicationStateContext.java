package game.controller;

import game.factory.ModelFactory;
import game.model.BoardHistory;
import game.model.BoardModel;
import game.state.GameState;
import game.state.model.NewGameState;
import game.view.BoardView;
import game.view.InfoPane;
import javafx.stage.Stage;

public class ApplicationStateContext {

    private GameState currentState;

    // View components.
    private Stage primaryStage;

    private InfoPane infoPane;

    private BoardView boardView;

    // Model Components.

    private BoardModel board;

    private BoardHistory history;

    public ApplicationStateContext() {
    }

    public void initialize() {
        this.board = ModelFactory.getInstance().createBoard();
        this.history = ModelFactory.getInstance().createBoardHistory();
        this.currentState = new NewGameState();
        this.currentState.onEnter();
    }

    public void changeState(final GameState newState) {
        this.currentState = newState;
        this.currentState.onEnter();
    }

    public void setPrimaryStage(final Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Stage getPrimaryStage() {
        return this.primaryStage;
    }

    public BoardModel getBoard() {
        return board;
    }

    public void setBoard(final BoardModel board) {
        this.board = board;
    }

    public BoardHistory getHistory() {
        return this.history;
    }

    public void setHistory(final BoardHistory history) {
        this.history = history;
    }

    public InfoPane getInfoPane() {
        return infoPane;
    }

    public void setInfoPane(final InfoPane infoPane) {
        this.infoPane = infoPane;
    }

    public BoardView getBoardView() {
        return boardView;
    }

    public void setBoardView(final BoardView boardView) {
        this.boardView = boardView;
    }

    private static ApplicationStateContext instance;

    public static ApplicationStateContext getInstance() {
        if (instance == null) {
            instance = new ApplicationStateContext();
        }
        return instance;
    }

}
