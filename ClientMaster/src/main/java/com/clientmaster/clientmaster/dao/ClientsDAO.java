package com.clientmaster.clientmaster.dao;

import com.clientmaster.clientmaster.model.Clientes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientsDAO {

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

    public List<Clientes> getAllClientes() {
        List<Clientes> clientes = new ArrayList<>();

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT c.*, p.nombre_provincia, t.nombre_tipo_servicio " +
                     "FROM clientes c " +
                     "JOIN provincias p ON c.id_provincia = p.id_provincia " +
                     "JOIN tipo_servicio t ON c.id_tipo_servicio = t.id_tipo_servicio")) {

            while (rs.next()) {
                Clientes cliente = new Clientes(
                        rs.getInt("id_cliente"),
                        rs.getString("nombre_cliente"),
                        rs.getString("municipio"),
                        rs.getString("direccion"),
                        rs.getInt("cp"),
                        rs.getInt("telefono"),
                        rs.getString("contacto"),
                        rs.getInt("precio"),
                        rs.getString("razon_social"),
                        rs.getString("cuenta_bancaria"),
                        rs.getString("nombre_provincia"),
                        rs.getString("nombre_tipo_servicio") // Aquí se corrigió el nombre de la columna
                );
                clientes.add(cliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return clientes;
    }

    public void insertCliente(Clientes cliente) {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO clientes (nombre_cliente, municipio, direccion, cp, telefono, contacto, precio, razon_social, cuenta_bancaria, id_provincia, id_tipo_servicio) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

            // Setear los parámetros en la consulta preparada
            stmt.setString(1, cliente.getNombre_cliente());
            stmt.setString(2, cliente.getMunicipio());
            stmt.setString(3, cliente.getDireccion());
            stmt.setInt(4, cliente.getCp());
            stmt.setInt(5, cliente.getTelefono());
            stmt.setString(6, cliente.getContacto());
            stmt.setInt(7, cliente.getPrecio());
            stmt.setString(8, cliente.getRazon_social());
            stmt.setString(9, cliente.getCuenta_bancaria());
            // Obtener el ID de provincia y de tipo de servicio
            int idProvincia = obtenerIdProvincia(cliente.getProvinciaNombre());
            int idTipoServicio = obtenerIdTipoServicio(cliente.getTipoServicio());
            // Setear los IDs en la consulta preparada
            stmt.setInt(10, idProvincia);
            stmt.setInt(11, idTipoServicio);

            // Ejecutar la consulta
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        private int obtenerIdProvincia(String nombreProvincia) {
            int idProvincia = -1; // Valor por defecto si no se encuentra la provincia

            try (Connection conn = getConnection();
                 PreparedStatement stmt = conn.prepareStatement("SELECT id_provincia FROM provincias WHERE nombre_provincia = ?")) {
                stmt.setString(1, nombreProvincia);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        idProvincia = rs.getInt("id_provincia");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return idProvincia;
        }

        // Método para obtener el ID de tipo de servicio basado en el nombre del tipo de servicio
        private int obtenerIdTipoServicio(String nombreTipoServicio) {
            int idTipoServicio = -1; // Valor por defecto si no se encuentra el tipo de servicio

            try (Connection conn = getConnection();
                 PreparedStatement stmt = conn.prepareStatement("SELECT id_tipo_servicio FROM tipo_servicio WHERE nombre_tipo_servicio = ?")) {
                stmt.setString(1, nombreTipoServicio);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        idTipoServicio = rs.getInt("id_tipo_servicio");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return idTipoServicio;
        }

    public int getIdClientePorNombre(String nombreCliente) {
        String sql = "SELECT id_cliente FROM clientes WHERE nombre_cliente = ?";
        int idCliente = 0;

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombreCliente);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    idCliente = rs.getInt("id_cliente");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el id_cliente: " + e.getMessage());
        }

        return idCliente;
    }
}