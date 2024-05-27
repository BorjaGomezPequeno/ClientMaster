package com.clientmaster.clientmaster.controllers;

import com.clientmaster.clientmaster.dao.FacturacionDAO;
import com.clientmaster.clientmaster.model.MesFacturacion;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.List;

public class FacturacionController {

    @FXML
    private TableView<MesFacturacion> tablaFacturacion;

    @FXML
    private TableColumn<MesFacturacion, String> columnaMes;

    @FXML
    private TableColumn<MesFacturacion, Double> columnaBaseImponible;

    @FXML
    private TableColumn<MesFacturacion, Double> columnaIVA;

    @FXML
    private TableColumn<MesFacturacion, Double> columnaFacturacionTotal;

    private FacturacionDAO facturacionDAO;

    public void initialize() {
        facturacionDAO = new FacturacionDAO();

        // Configurar las columnas
        columnaMes.setCellValueFactory(new PropertyValueFactory<>("mes"));
        columnaBaseImponible.setCellValueFactory(new PropertyValueFactory<>("baseImponible"));
        columnaIVA.setCellValueFactory(new PropertyValueFactory<>("iva"));
        columnaFacturacionTotal.setCellValueFactory(new PropertyValueFactory<>("facturacionTotal"));

        // Obtener los datos de la base de datos
        List<MesFacturacion> datosFacturacion = facturacionDAO.obtenerDatosFacturacion();

        // Calcular la base imponible, el IVA y la facturación total
        for (MesFacturacion mes : datosFacturacion) {
            mes.calcularIva();
            mes.calcularFacturacionTotal();
        }

        // Agregar los datos a la tabla
        tablaFacturacion.getItems().addAll(datosFacturacion);
    }
}

