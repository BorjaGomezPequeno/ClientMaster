package com.clientmaster.clientmaster.model;

public class MesFacturacion {

    private String mes;
    private double baseImponible;
    private double iva;
    private double facturacionTotal;

    public MesFacturacion(String mes, double baseImponible) {
        this.mes = mes;
        this.baseImponible = baseImponible;
    }

    public void calcularIva() {
        this.iva = this.baseImponible * 0.21;
    }

    public void calcularFacturacionTotal() {
        this.facturacionTotal = this.baseImponible + this.iva;
    }

    public String getMes() {
        return mes;
    }

    public double getBaseImponible() {
        return baseImponible;
    }

    public double getIva() {
        return iva;
    }

    public double getFacturacionTotal() {
        return facturacionTotal;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public void setBaseImponible(double baseImponible) {
        this.baseImponible = baseImponible;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public void setFacturacionTotal(double facturacionTotal) {
        this.facturacionTotal = facturacionTotal;
    }
}
