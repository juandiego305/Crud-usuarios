package org.example;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = ConexionBD.conectar()) {
            if (conn != null) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT id, primer_nombre, apellidos, correo FROM usuario");

                while (rs.next()) {
                    System.out.println(
                            rs.getInt("id") + " | " +
                                    rs.getString("primer_nombre") + " " +
                                    rs.getString("apellidos") + " | " +
                                    rs.getString("correo")
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
