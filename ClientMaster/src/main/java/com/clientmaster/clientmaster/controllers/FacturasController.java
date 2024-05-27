package com.clientmaster.clientmaster.controllers;

import com.clientmaster.clientmaster.dao.FacturasDAO;
import com.clientmaster.clientmaster.model.Facturas;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class FacturasController {

    @FXML
    private TableView<Facturas> tablaFacturas;

    @FXML
    private TableColumn<Facturas, Integer> idFactura;

    @FXML
    private TableColumn<Facturas, Integer> dia;

    @FXML
    private TableColumn<Facturas, Integer> mes;

    @FXML
    private TableColumn<Facturas, Integer> ano;

    @FXML
    private TableColumn<Facturas, Integer> id_cliente;

    @FXML
    private TableColumn<Facturas, String> nombreCliente;

    @FXML
    private TableColumn<Facturas, String> tipoServicio;

    @FXML
    private TableColumn<Facturas, Double> precio;

    @FXML
    private TableColumn<Facturas, String> concepto;

    @FXML
    private void initialize() {

        idFactura.setCellValueFactory(cellData -> cellData.getValue().idFacturaProperty().asObject());
        dia.setCellValueFactory(cellData -> cellData.getValue().diaProperty().asObject());
        mes.setCellValueFactory(cellData -> cellData.getValue().mesProperty().asObject());
        ano.setCellValueFactory(cellData -> cellData.getValue().anoProperty().asObject());
        id_cliente.setCellValueFactory(cellData -> cellData.getValue().idClienteProperty().asObject());
        nombreCliente.setCellValueFactory(cellData -> cellData.getValue().nombreClienteProperty());
        tipoServicio.setCellValueFactory(cellData -> cellData.getValue().tipoServicioProperty());
        precio.setCellValueFactory(cellData -> cellData.getValue().precioProperty().asObject());
        concepto.setCellValueFactory(cellData -> cellData.getValue().conceptoProperty());

        //Cargar datos del cliente en la tabla
        FacturasDAO facturasDAO = new FacturasDAO();
        tablaFacturas.getItems().addAll(facturasDAO.getAllFacturas());


    }

}
