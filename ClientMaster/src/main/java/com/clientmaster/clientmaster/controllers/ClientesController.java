package com.clientmaster.clientmaster.controllers;

import com.clientmaster.clientmaster.dao.ClientsDAO;
import com.clientmaster.clientmaster.model.Clientes;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import jdk.incubator.foreign.CLinker;

public class ClientesController {

    @FXML
    private TableView<Clientes> tablaClientes;

    @FXML
    private TableColumn<Clientes, Integer> colId;

    @FXML
    private TableColumn<Clientes, String> colNombre;

    @FXML
    private TableColumn<Clientes, String> colMunicipio;

    @FXML
    private TableColumn<Clientes, String> colDireccion;

    @FXML
    private TableColumn<Clientes, Integer> colCp;

    @FXML
    private TableColumn<Clientes, Integer> colTelefono;

    @FXML
    private TableColumn<Clientes, String> colContacto;


    @FXML
    private TableColumn<Clientes, Integer> colPrecio;

    @FXML
    private TableColumn<Clientes, String> colRazonSocial;

    @FXML
    private TableColumn<Clientes, String> colCuentaBancaria;

    @FXML
    private TableColumn<Clientes, String> colProvincia;

    @FXML
    private TableColumn<Clientes, String> colTipoServicio;

    @FXML
    private void initialize() {

        colId.setCellValueFactory(cellData -> cellData.getValue().id_clienteProperty().asObject());
        colNombre.setCellValueFactory(cellData -> cellData.getValue().nombre_clienteProperty());
        colMunicipio.setCellValueFactory(cellData -> cellData.getValue().municipioProperty());
        colDireccion.setCellValueFactory(cellData -> cellData.getValue().direccionProperty());
        colCp.setCellValueFactory(cellData -> cellData.getValue().cpProperty().asObject());
        colTelefono.setCellValueFactory(cellData -> cellData.getValue().telefonoProperty().asObject());
        colContacto.setCellValueFactory(cellData -> cellData.getValue().contactoProperty());
        colPrecio.setCellValueFactory(cellData -> cellData.getValue().precioProperty().asObject());
        colRazonSocial.setCellValueFactory(cellData -> cellData.getValue().razon_socialProperty());
        colCuentaBancaria.setCellValueFactory(cellData -> cellData.getValue().cuenta_bancariaProperty());
        colProvincia.setCellValueFactory(cellData -> cellData.getValue().provinciaNombreProperty());
        colTipoServicio.setCellValueFactory(cellData -> cellData.getValue().tipoServicioProperty());


        //Carga los datos de los clientes en la tabla
        ClientsDAO clienteDAO = new ClientsDAO();
        tablaClientes.getItems().addAll(clienteDAO.getAllClientes());
    }
}
