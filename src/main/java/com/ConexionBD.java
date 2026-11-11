
package com.agroanalisis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3306/agroanalisis";
    private static final String USUARIO = "agro_app";
private static final String CONTRASENA = "Agro2026*App";

    public static Connection conectar() {
        Connection conexion = null;

        try {
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println("Conexion exitosa con la base de datos Agroanalisis.");

        } catch (SQLException e) {
            System.out.println("Error al conectar con MySQL: " + e.getMessage());
        }

        return conexion;
    }
}
