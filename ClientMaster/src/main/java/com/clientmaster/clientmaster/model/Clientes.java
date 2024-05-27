package com.clientmaster.clientmaster.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Clientes {

    private final SimpleIntegerProperty id_cliente;
    private final SimpleStringProperty nombre_cliente;
    private final SimpleStringProperty municipio;
    private final SimpleStringProperty direccion;
    private final SimpleIntegerProperty cp;
    private final SimpleIntegerProperty telefono;
    private final SimpleStringProperty contacto;
    private final SimpleIntegerProperty precio;
    private final SimpleStringProperty razon_social;
    private final SimpleStringProperty cuenta_bancaria;
    private final SimpleStringProperty provinciaNombre;
    private final SimpleStringProperty tipoServicio;

    // Constructor sin argumentos
    public Clientes() {
        this.id_cliente = new SimpleIntegerProperty(0); // Inicialización predeterminada
        this.nombre_cliente = new SimpleStringProperty("");
        this.municipio = new SimpleStringProperty("");
        this.direccion = new SimpleStringProperty("");
        this.cp = new SimpleIntegerProperty(0);
        this.telefono = new SimpleIntegerProperty(0);
        this.contacto = new SimpleStringProperty("");
        this.precio = new SimpleIntegerProperty(0);
        this.razon_social = new SimpleStringProperty("");
        this.cuenta_bancaria = new SimpleStringProperty("");
        this.provinciaNombre = new SimpleStringProperty("");
        this.tipoServicio = new SimpleStringProperty("");
    }

    public Clientes(
            int id_cliente,
            String nombre_cliente,
            String municipio,
            String direccion,
            int cp,
            int telefono,
            String contacto,
            int precio,
            String razon_social,
            String cuenta_bancaria,
            String provinciaNombre,
            String tipoServicio
            )
    {
        this.id_cliente = new SimpleIntegerProperty(id_cliente);
        this.nombre_cliente = new SimpleStringProperty(nombre_cliente);
        this.municipio = new SimpleStringProperty(municipio);
        this.direccion = new SimpleStringProperty(direccion);
        this.cp = new SimpleIntegerProperty(cp);
        this.telefono = new SimpleIntegerProperty(telefono);
        this.contacto = new SimpleStringProperty(contacto);
        this.precio = new SimpleIntegerProperty(precio);
        this.razon_social = new SimpleStringProperty(razon_social);
        this.cuenta_bancaria = new SimpleStringProperty(cuenta_bancaria);
        this.provinciaNombre = new SimpleStringProperty(provinciaNombre);
        this.tipoServicio = new SimpleStringProperty(tipoServicio);
    }



//    private int id_cliente;
//    private String nombre_cliente;
//    private String municipio;
//    private String direccion;


    public int getId_cliente() {
        return id_cliente.get();
    }

    public SimpleIntegerProperty id_clienteProperty() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente.set(id_cliente);
    }

    public String getNombre_cliente() {
        return nombre_cliente.get();
    }

    public SimpleStringProperty nombre_clienteProperty() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente.set(nombre_cliente);
    }

    public String getMunicipio() {
        return municipio.get();
    }

    public SimpleStringProperty municipioProperty() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio.set(municipio);
    }

    public String getDireccion() {
        return direccion.get();
    }

    public SimpleStringProperty direccionProperty() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion.set(direccion);
    }

    public int getCp() {
        return cp.get();
    }

    public SimpleIntegerProperty cpProperty() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp.set(cp);
    }

    public int getTelefono() {
        return telefono.get();
    }

    public SimpleIntegerProperty telefonoProperty() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono.set(telefono);
    }

    public String getContacto() {
        return contacto.get();
    }

    public SimpleStringProperty contactoProperty() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto.set(contacto);
    }

    public int getPrecio() {
        return precio.get();
    }

    public SimpleIntegerProperty precioProperty() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio.set(precio);
    }

    public String getCuenta_bancaria() {
        return cuenta_bancaria.get();
    }

    public SimpleStringProperty cuenta_bancariaProperty() {
        return cuenta_bancaria;
    }

    public void setCuenta_bancaria(String cuenta_bancaria) {
        this.cuenta_bancaria.set(cuenta_bancaria);
    }

    public String getRazon_social() {
        return razon_social.get();
    }

    public SimpleStringProperty razon_socialProperty() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social.set(razon_social);
    }

    public String getProvinciaNombre() {
        return provinciaNombre.get();
    }

    public SimpleStringProperty provinciaNombreProperty() {
        return provinciaNombre;
    }

    public void setProvinciaNombre(String provinciaNombre) {
        this.provinciaNombre.set(provinciaNombre);
    }

    public String getTipoServicio() {
        return tipoServicio.get();
    }

    public SimpleStringProperty tipoServicioProperty() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio.set(tipoServicio);
    }
}
