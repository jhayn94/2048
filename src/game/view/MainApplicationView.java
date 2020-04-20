package game.view;

import game.factory.LayoutFactory;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;

/**
 * This class represents the main content view of the application.
 */
public class MainApplicationView extends SplitPane {

	private static final String CSS_CLASS = "main-app-view";

	public MainApplicationView() {
		super();
		this.configure();
	}

	private void configure() {
		this.getStyleClass().add(CSS_CLASS);
		this.setOrientation(Orientation.VERTICAL);
		this.createChildElements();
	}

	private void createChildElements() {
		final InfoPane infoPane = LayoutFactory.getInstance().createInfoPane();
		final BoardViewWrapper boardViewWrapper = LayoutFactory.getInstance().createBoardViewWrapper();
		this.getItems().addAll(infoPane, boardViewWrapper);
	}

}
