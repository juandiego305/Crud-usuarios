package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mariadb://localhost:3306/crud_usuarios";
    private static final String USER = "root"; // Usuario de MariaDB
    private static final String PASSWORD = ""; // Contraseña de MariaDB

    public static Connection conectar() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println(" Conexion exitosa a MariaDB");
            return conn;
        } catch (SQLException e) {
            System.err.println(" Error de conexion: " + e.getMessage());
            return null;
        }
    }
}
