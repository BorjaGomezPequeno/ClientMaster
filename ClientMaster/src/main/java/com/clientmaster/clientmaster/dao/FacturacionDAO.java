package com.clientmaster.clientmaster.dao;

import com.clientmaster.clientmaster.model.MesFacturacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacturacionDAO {

    private final String URL = "jdbc:mysql://127.0.0.1:3306/ClientMasterDB";
    private final String USER = "root";
    private final String PASSWORD = "bgomez015";

    public List<MesFacturacion> obtenerDatosFacturacion() {
        List<MesFacturacion> datosFacturacion = new ArrayList<>();
        String sql = "SELECT m.nombre_mes, SUM(f.precio) AS total " +
                "FROM facturas f " +
                "INNER JOIN meses m ON f.id_mes = m.id_mes " +
                "GROUP BY f.id_mes";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String mes = rs.getString("nombre_mes");
                double total = rs.getDouble("total");
                datosFacturacion.add(new MesFacturacion(mes, total));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones, por ejemplo, lanzar una excepción personalizada o loggear el error.
        }

        return datosFacturacion;
    }
}
