package com.clientmaster.clientmaster.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Dashboard {

    @FXML
    private StackPane stackPane;


    @FXML
    private MenuItem verClientesMenuItem;

    @FXML
    private MenuItem verFacturasMenuItem;

    @FXML
    private MenuItem agregarFacturaMenuItem;

    @FXML
    private MenuItem facturacionMenuItem;

    //MODULOS DE CLIENTES

    @FXML
    private void initialize() {
        verClientesMenuItem.setOnAction(event -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/clientmaster/clientmaster/views/clientes.fxml"));
                Parent clientesRoot = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(clientesRoot));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @FXML
    private void mostrarClientes() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/clientmaster/clientmaster/views/clientes.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Lista de Clientes");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void agregarClientes() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/clientmaster/clientmaster/views/addCliente.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Agregar Clientes");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //MODULOS DE FACTURACION

    @FXML
    private void verFacturas() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/clientmaster/clientmaster/views/facturas.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Ver Facturas");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void agregarFacturas() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/clientmaster/clientmaster/views/addFactura.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Agregar Factura");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void verFacturacion() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/clientmaster/clientmaster/views/facturacion.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Ver Facturación");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
