package com.lubaszak.config;

import com.lubaszak.utils.FxmlView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Will load the FXML hierarchy as specified in the load method and register
 * Spring as the FXML MaiController Factory. Allows Spring and Java FX to coexist
 * once the Spring Application context has been bootstrapped.
 */
@Component
public class SpringFXMLLoader {
    private final ResourceBundle resourceBundle;
    private final ApplicationContext context;


    public SpringFXMLLoader(ApplicationContext context, ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
        this.context = context;
    }

    public FXMLLoader load(String fxmlPath) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setControllerFactory(context::getBean); //Spring now FXML MaiController Factory
        loader.setResources(resourceBundle);

        loader.setLocation(getClass().getResource(fxmlPath));
        return loader;
    }

    public FXMLLoader getController(FxmlView fxmlView) {
        FXMLLoader loader = new FXMLLoader();
        try {


            loader.load(getClass().getResource(fxmlView.getFxmlFile()).openStream());
            return loader;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return loader.getController();
    }




}
