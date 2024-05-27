package com.clientmaster.clientmaster.controllers;

import com.clientmaster.clientmaster.dao.ClientsDAO;
import com.clientmaster.clientmaster.dao.FacturasDAO;
import com.clientmaster.clientmaster.model.Clientes;
import com.clientmaster.clientmaster.model.Facturas;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class AddFacturaController {

    @FXML
    private ComboBox<String> cmbNombreCliente;

    @FXML
    private ComboBox<String> cmbTipoServicio;

    @FXML
    private TextField txtPrecio;

    @FXML
    private TextField txtConcepto;

    @FXML
    private TextField txtDia;

    @FXML
    private ComboBox<String> cmbMes;

    @FXML
    private TextField txtAno;

    @FXML
    private void initialize() {
        cargarClientes();
        cargarTipoServicio();
        cargarMeses();
    }

    private void cargarClientes() {
        ClientsDAO clientsDAO = new ClientsDAO();
        List<Clientes> clientes = clientsDAO.getAllClientes();

        for (Clientes cliente : clientes) {
            cmbNombreCliente.getItems().add(cliente.getNombre_cliente());
        }
    }
    private void cargarTipoServicio() {
        cmbTipoServicio.getItems().add("Web Premium");
        cmbTipoServicio.getItems().add("Ficha Asociado");
    }


    private void cargarMeses() {
        cmbMes.getItems().add("Enero");
        cmbMes.getItems().add("Febrero");
        cmbMes.getItems().add("Marzo");
        cmbMes.getItems().add("Abril");
        cmbMes.getItems().add("Mayo");
        cmbMes.getItems().add("Junio");
        cmbMes.getItems().add("Julio");
        cmbMes.getItems().add("Agosto");
        cmbMes.getItems().add("Septiembre");
        cmbMes.getItems().add("Octubre");
        cmbMes.getItems().add("Noviembre");
        cmbMes.getItems().add("Diciembre");

    }

    public void agregarFactura() {
        String nombreCliente = cmbNombreCliente.getValue();
        String tipoServicio = cmbTipoServicio.getValue();
        double precio = Double.parseDouble(txtPrecio.getText());
        String concepto = txtConcepto.getText();
        int dia = Integer.parseInt(txtDia.getText());
        String nombreMes = cmbMes.getValue();
        int idMes = obtenerIdMes(nombreMes); // Obtener el ID del mes como un entero
        int ano = Integer.parseInt(txtAno.getText());

        Facturas factura = new Facturas(
                0,
                0,
                nombreCliente,
                tipoServicio,
                precio,
                concepto,
                dia,
                idMes,
                ano
        );
        FacturasDAO facturaDAO = new FacturasDAO();
        facturaDAO.insertFactura(factura);
    }


    private int obtenerIdMes(String nombreMes) {
        FacturasDAO facturaDAO = new FacturasDAO();
        return facturaDAO.obtenerIdMes(nombreMes);
    }
}
