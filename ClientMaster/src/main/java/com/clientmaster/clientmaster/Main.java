package com.clientmaster.clientmaster;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Cargar el archivo FXML
        Parent root = FXMLLoader.load(getClass().getResource("/com/clientmaster/clientmaster/views/login.fxml"));
        // Configurar la escena
        Scene scene = new Scene(root);

        // Configurar el escenario principal (ventana)
        primaryStage.setScene(scene);
        primaryStage.setTitle("Iniciar Sesión");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}