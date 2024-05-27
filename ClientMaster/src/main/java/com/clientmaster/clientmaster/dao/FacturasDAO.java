package com.clientmaster.clientmaster.dao;

import com.clientmaster.clientmaster.model.Facturas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacturasDAO {

    private Connection getConnection() {
        try {
            String URL = "jdbc:mysql://127.0.0.1:3306/ClientMasterDB";
            String USER = "root";
            String PASSWORD = "bgomez015";

            Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos");
            return conexion;
        } catch (SQLException e) {
            // Manejar errores al establecer la conexión
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            return null;
        }


    }

    public List<Facturas> getAllFacturas() {
        List<Facturas> facturas = new ArrayList<>();

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT f.id_factura, c.id_cliente, c.nombre_cliente, t.nombre_tipo_servicio, f.precio, f.concepto, f.dia, f.id_mes, f.ano\n" +
                     "FROM facturas f\n" +
                     "JOIN clientes c ON f.id_cliente = c.id_cliente\n" +
                     "JOIN meses m ON f.id_mes = m.id_mes\n" +
                     "JOIN tipo_servicio t ON c.id_tipo_servicio = t.id_tipo_servicio\n")) {

            while (rs.next()) {
                Facturas factura = new Facturas(
                        rs.getInt("id_factura"),
                        rs.getInt("id_cliente"),
                        rs.getString("nombre_cliente"),
                        rs.getString("nombre_tipo_servicio"),
                        rs.getDouble("precio"),
                        rs.getString("concepto"),
                        rs.getInt("dia"),
                        rs.getInt("id_mes"),
                        rs.getInt("ano")
                );
                facturas.add(factura);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    return facturas;
    }

    public void insertFactura(Facturas factura) {
        String sql = "INSERT INTO facturas (id_cliente, id_tipo_servicio, precio, concepto, dia, id_mes, ano) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Obtener el ID del cliente y del tipo de servicio
            int idCliente = obtenerIdCliente(factura.getNombreCliente());
            int idTipoServicio = obtenerIdTipoServicio(factura.getTipoServicio());

            stmt.setInt(1, idCliente);
            stmt.setInt(2, idTipoServicio);
            stmt.setDouble(3, factura.getPrecio());
            stmt.setString(4, factura.getConcepto());
            stmt.setInt(5, factura.getDia());
            stmt.setInt(6, factura.getMes());
            stmt.setInt(7, factura.getAno());

            stmt.executeUpdate();
            System.out.println("Factura insertada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar la factura: " + e.getMessage());
        }
    }

    private int obtenerIdCliente(String nombreCliente) {
        int idCliente = -1; // Valor por defecto si no se encuentra ningún cliente

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT id_cliente FROM clientes WHERE nombre_cliente = ?")) {

            stmt.setString(1, nombreCliente);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                idCliente = rs.getInt("id_cliente");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el ID del cliente: " + e.getMessage());
        }

        return idCliente;
    }

    private int obtenerIdTipoServicio(String tipoServicio) {
        int idTipoServicio = -1; // Valor por defecto si no se encuentra ningún tipo de servicio

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT id_tipo_servicio FROM tipo_servicio WHERE nombre_tipo_servicio = ?")) {

            stmt.setString(1, tipoServicio);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                idTipoServicio = rs.getInt("id_tipo_servicio");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el ID del tipo de servicio: " + e.getMessage());
        }

        return idTipoServicio;
    }

    public int obtenerIdMes(String nombreMes) {
        int idMes = -1; // Valor predeterminado en caso de que no se encuentre el mes
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT id_mes FROM meses WHERE nombre_mes = ?")) {
            stmt.setString(1, nombreMes);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    idMes = rs.getInt("id_mes");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idMes;
    }


}
