package com.clientmaster.clientmaster.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Facturas {

//    private int idFactura;
//    private String nombreCliente;
//    private int idCliente;
//    private String tipoServicio;
//    private double precio;
//    private String concepto;
//    private int dia;
//    private int mes;
//    private int ano;

    private final SimpleIntegerProperty idFactura;
    private final SimpleStringProperty nombreCliente;
    private final SimpleIntegerProperty idCliente;
    private final SimpleStringProperty tipoServicio;
    private final SimpleDoubleProperty precio;
    private final SimpleStringProperty concepto;
    private final SimpleIntegerProperty dia;
    private final SimpleIntegerProperty mes;
    private final SimpleIntegerProperty ano;

    //Constructor
    public Facturas() {
        this.idFactura = new SimpleIntegerProperty(0);
        this.idCliente = new SimpleIntegerProperty(0);
        this.nombreCliente = new SimpleStringProperty("");
        this.tipoServicio = new SimpleStringProperty("");
        this.precio = new SimpleDoubleProperty(0.0);
        this.concepto = new SimpleStringProperty("");
        this.dia = new SimpleIntegerProperty(0);
        this.mes = new SimpleIntegerProperty(0);
        this.ano = new SimpleIntegerProperty(0);
    }

    public Facturas(
            int idFactura,
            int idCliente,
            String nombreCliente,
            String tipoServicio,
            double precio,
            String concepto,
            int dia,
            int mes,
            int ano
    )
    {
        this.idFactura = new SimpleIntegerProperty(idFactura);
        this.nombreCliente = new SimpleStringProperty(nombreCliente);
        this.idCliente = new SimpleIntegerProperty(idCliente);
        this.tipoServicio = new SimpleStringProperty(tipoServicio);
        this.precio = new SimpleDoubleProperty(precio);
        this.concepto = new SimpleStringProperty(concepto);
        this.dia = new SimpleIntegerProperty(dia);
        this.mes = new SimpleIntegerProperty(mes);
        this.ano = new SimpleIntegerProperty(ano);
//        this.idFactura = idFactura;
//        this.nombreCliente = nombreCliente;
//        this.tipoServicio = tipoServicio;
//        this.precio = precio;
//        this.concepto = concepto;
//        this.dia = dia;
//        this.mes = mes;
//        this.ano = ano;
    }

    public int getIdFactura() {
        return idFactura.get();
    }

    public SimpleIntegerProperty idFacturaProperty() {
        return idFactura;
    }

    public String getNombreCliente() {
        return nombreCliente.get();
    }

    public SimpleStringProperty nombreClienteProperty() {
        return nombreCliente;
    }

    public int getIdCliente() {
        return idCliente.get();
    }

    public SimpleIntegerProperty idClienteProperty() {
        return idCliente;
    }

    public String getTipoServicio() {
        return tipoServicio.get();
    }

    public SimpleStringProperty tipoServicioProperty() {
        return tipoServicio;
    }

    public double getPrecio() {
        return precio.get();
    }

    public SimpleDoubleProperty precioProperty() {
        return precio;
    }

    public String getConcepto() {
        return concepto.get();
    }

    public SimpleStringProperty conceptoProperty() {
        return concepto;
    }

    public int getDia() {
        return dia.get();
    }

    public SimpleIntegerProperty diaProperty() {
        return dia;
    }

    public int getMes() {
        return mes.get();
    }

    public SimpleIntegerProperty mesProperty() {
        return mes;
    }

    public int getAno() {
        return ano.get();
    }

    public SimpleIntegerProperty anoProperty() {
        return ano;
    }



    //    public int getIdFactura() {
//        return idFactura;
//    }
//
//    public void setIdFactura(int idFactura) {
//        this.idFactura = idFactura;
//    }
//
//    public String getNombreCliente() {
//        return nombreCliente;
//    }
//
//    public void setNombreCliente(String nombreCliente) {
//        this.nombreCliente = nombreCliente;
//    }
//
//    public int getIdCliente() {
//        return idCliente;
//    }
//
//    public void setIdCliente(int idCliente) {
//        this.idCliente = idCliente;
//    }
//
//    public String getTipoServicio() {
//        return tipoServicio;
//    }
//
//    public void setTipoServicio(String tipoServicio) {
//        this.tipoServicio = tipoServicio;
//    }
//
//    public double getPrecio() {
//        return precio;
//    }
//
//    public void setPrecio(double precio) {
//        this.precio = precio;
//    }
//
//    public String getConcepto() {
//        return concepto;
//    }
//
//    public void setConcepto(String concepto) {
//        this.concepto = concepto;
//    }
//
//    public int getDia() {
//        return dia;
//    }
//
//    public void setDia(int dia) {
//        this.dia = dia;
//    }
//
//    public int getMes() {
//        return mes;
//    }
//
//    public void setMes(int mes) {
//        this.mes = mes;
//    }
//
//    public int getAno() {
//        return ano;
//    }
//
//    public void setAno(int ano) {
//        this.ano = ano;
//    }
}
