package com.clientmaster.clientmaster.controllers;

import com.clientmaster.clientmaster.dao.ClientsDAO;
import com.clientmaster.clientmaster.model.Clientes;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AddClienteController {

    @FXML
    private TextField txtNombreCliente;

    @FXML
    private TextField txtMunicipio;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtCp;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtContacto;

    @FXML
    private TextField txtPrecio;

    @FXML
    private TextField txtRazonSocial;

    @FXML
    private TextField txtCuentaBancaria;

    @FXML
    private ComboBox<String> cmbProvincia;

    @FXML
    private ComboBox<String> cmbTipoServicio;

    @FXML
    private Button btnAgregarCliente;

    @FXML
    private void initialize() {
        // Llenar el ComboBox de provincias
        cmbProvincia.getItems().addAll("Araba", "Bizkaia", "Gipuzkoa");

        // Llenar el ComboBox de tipos de servicio
        cmbTipoServicio.getItems().addAll("Web Premium", "Ficha asociado");

        // Evento para agregar cliente
        btnAgregarCliente.setOnAction(event -> agregarCliente());
    }


    public void agregarCliente() {
        // Obtener los valores de los campos
        String nombreCliente = txtNombreCliente.getText();
        String municipio = txtMunicipio.getText();
        String direccion = txtDireccion.getText();
        int cp = Integer.parseInt(txtCp.getText());
        int telefono = Integer.parseInt(txtTelefono.getText());
        String contacto = txtContacto.getText();
        int precio = Integer.parseInt(txtPrecio.getText());
        String razonSocial = txtRazonSocial.getText();
        String cuentaBancaria = txtCuentaBancaria.getText();
        String provincia = cmbProvincia.getValue();
        String tipoServicio = cmbTipoServicio.getValue();

        // Crear un objeto Cliente
        Clientes cliente = new Clientes(
                0,
                nombreCliente,
                municipio,
                direccion,
                cp,
                telefono,
                contacto,
                precio,
                razonSocial,
                cuentaBancaria,
                provincia,
                tipoServicio
        );

        // Guardar el cliente en la base de datos
        ClientsDAO clienteDAO = new ClientsDAO();
        clienteDAO.insertCliente(cliente);

        // Mostrar mensaje de éxito
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Éxito");
        alert.setHeaderText(null);
        alert.setContentText("Cliente agregado correctamente.");
        alert.showAndWait();

        // Limpiar los campos después de agregar el cliente
        limpiarCampos();
    }

    private void limpiarCampos() {
        txtNombreCliente.clear();
        txtMunicipio.clear();
        txtDireccion.clear();
        txtCp.clear();
        txtTelefono.clear();
        txtContacto.clear();
        txtPrecio.clear();
        txtRazonSocial.clear();
        txtCuentaBancaria.clear();
        cmbProvincia.getSelectionModel().clearSelection();
        cmbTipoServicio.getSelectionModel().clearSelection();
    }
}
