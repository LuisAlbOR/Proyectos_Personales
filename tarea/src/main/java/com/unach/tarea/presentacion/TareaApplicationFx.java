package com.unach.tarea.presentacion;

import com.unach.tarea.TareaApplication;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

public class TareaApplicationFx extends Application {

    private ConfigurableApplicationContext applicationContext;
    /*public static void main(String[] args) {
        launch(args);
    }*/

    @Override
    public void init(){
        this.applicationContext = new SpringApplicationBuilder(TareaApplication.class).run();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(TareaApplication.class.getResource("/templates/index.fxml"));
        loader.setControllerFactory(applicationContext::getBean);
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop(){
        applicationContext.stop();
        Platform.exit();
    }
}