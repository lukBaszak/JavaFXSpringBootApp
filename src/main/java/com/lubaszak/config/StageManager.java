package com.lubaszak.config;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.Objects;

import com.lubaszak.controller.FoodSearchController;
import com.lubaszak.controller.LoginController;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import org.slf4j.Logger;

import com.lubaszak.utils.FxmlView;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Manages switching Scenes on the Primary Stage
 */

public class StageManager {

    private static final Logger LOG = getLogger(StageManager.class);
    private final Stage primaryStage;

    private final SpringFXMLLoader springFXMLLoader;

    public StageManager(SpringFXMLLoader springFXMLLoader, Stage stage ) {
        this.springFXMLLoader = springFXMLLoader;
        this.primaryStage = stage;

    }

    public void switchScene(final FxmlView view) {
        Parent viewRootNodeHierarchy = loadViewNodeHierarchy(view.getFxmlFile());


        show(viewRootNodeHierarchy, view.getTitle(), primaryStage);
    }

    public void openNewStage(final FxmlView view) {
        Parent viewRootNodeHierarchy = loadViewNodeHierarchy(view.getFxmlFile());

        Stage stage = new Stage();

        stage.initModality(Modality.APPLICATION_MODAL);
        show(viewRootNodeHierarchy, view.getTitle(), stage);
    }

    private void show(final Parent rootnode, String title, Stage stage) {
        Scene scene = prepareScene(rootnode, stage);

        //scene.getStylesheets().add("/styles/Styles.css");
        stage.setResizable(false);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.centerOnScreen();

        
        try {
            stage.show();
        } catch (Exception exception) {
            logAndExit ("Unable to show scene for title" + title,  exception);
        }
    }
    
    private Scene prepareScene(Parent rootnode, Stage stage){
        Scene scene = stage.getScene();

        if (scene == null) {
            scene = new Scene(rootnode);
        }
        scene.setRoot(rootnode);

        return scene;
    }

    /**
     * Loads the object hierarchy from a FXML document and returns to root node
     * of that hierarchy.
     *
     * @return Parent root node of the FXML document hierarchy
     */
    private Parent loadViewNodeHierarchy(String fxmlFilePath) {
        Parent rootNode = null;
        try {
            rootNode = springFXMLLoader.load(fxmlFilePath).load();
            Objects.requireNonNull(rootNode, "A Root FXML node must not be null");
        } catch (Exception exception) {
            logAndExit("Unable to load FXML view" + fxmlFilePath, exception);
        }
        return rootNode;
    }
    
    
    private void logAndExit(String errorMsg, Exception exception) {
        LOG.error(errorMsg, exception, exception.getCause());
        Platform.exit();
    }

}
