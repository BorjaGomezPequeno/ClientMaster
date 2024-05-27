package com.clientmaster.clientmaster.controllers;

import com.clientmaster.clientmaster.auth.DBUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Button;


public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label messageLabel;

    @FXML
    private Button loginButton; // Agrega esta línea

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM userlogin WHERE username = ? AND password = ?")) {

            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Autenticación exitosa
                System.out.println("Inicio de sesión exitoso para el usuario: " + username);
                // Redirigir al usuario a la página principal (dashboard.fxml)
                messageLabel.setText("Inicio de sesión exitoso.");
                redirectToDashboard();
            } else {
                // Autenticación fallida
                System.out.println("Credenciales inválidas para el usuario: " + username);
                messageLabel.setText("Usuario o contraseña incorrectos. Por favor, inténtelo de nuevo.");
            }
        } catch (SQLException | IOException e) {
            // Maneja cualquier error de SQL o IO
            e.printStackTrace();
        }
    }

    private void redirectToDashboard() throws IOException {
        Stage stage = (Stage) loginButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/clientmaster/clientmaster/views/dashboard.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Dashboard");
        stage.show();
    }
}
