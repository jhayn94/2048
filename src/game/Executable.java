package game;

import game.controller.ApplicationStateContext;
import game.factory.LayoutFactory;
import game.view.MainApplicationView;
import game.view.util.ResourceConstants;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** Entry point for the execution of the project. */
public class Executable extends Application {

	private static final double DEFAULT_STAGE_WIDTH = 600;

	private static final int DEFAULT_STAGE_HEIGHT = 750;

	private static final Logger LOG = LogManager.getLogger(Executable.class);

	@Override
	public void start(final Stage stage) {
		final MainApplicationView mainAppView = LayoutFactory.getInstance().createMainApplicationView();
		final Scene scene = this.createScene(mainAppView);
		this.configureStage(stage, scene);

		// Initializes the state context with default states + behaviors.
		ApplicationStateContext.getInstance().initialize();

		// These messages are just to separate executions if a log file gets re-used.
		LOG.info("==============================================");
		LOG.info("Application started successfully.");
	}

	/**
	 * Creates and returns a Scene, using the given Parent object as a root element.
	 */
	private Scene createScene(final Region root) {
		final Scene scene = new Scene(root);
		scene.getStylesheets().add(ResourceConstants.APPLICATION_CSS);
		return scene;
	}

	private void configureStage(final Stage stage, final Scene scene) {
		stage.getIcons().add(new Image(this.getClass().getResourceAsStream(ResourceConstants.APPLICATION_ICON)));
		stage.setScene(scene);
		stage.setMinHeight(DEFAULT_STAGE_HEIGHT);
		stage.setHeight(DEFAULT_STAGE_HEIGHT);
		stage.setMinWidth(DEFAULT_STAGE_WIDTH);
		stage.setWidth(DEFAULT_STAGE_WIDTH);
		stage.setMaximized(false);
		stage.show();
	}

	public static void main(final String[] args) {
		Application.launch(args);
	}

}
