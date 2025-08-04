package org.example;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UsuarioDAO {

    public static boolean crearUsuario(Usuario usuario) {
        String sql = """
            INSERT INTO usuario 
            (primer_nombre, segundo_nombre, apellidos, direccion, correo, tipo_documento, numero_documento, telefono, ciudad_residencia)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getPrimerNombre());
            stmt.setString(2, usuario.getSegundoNombre());
            stmt.setString(3, usuario.getApellidos());
            stmt.setString(4, usuario.getDireccion());
            stmt.setString(5, usuario.getCorreo());
            stmt.setString(6, usuario.getTipoDocumento());
            stmt.setString(7, usuario.getNumeroDocumento());
            stmt.setString(8, usuario.getTelefono());
            stmt.setString(9, usuario.getCiudadResidencia());

            int filas = stmt.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) { // MySQL: clave única duplicada
                System.err.println("El correo o número de documento ya existe.");
            } else {
                System.err.println("Error SQL: " + e.getMessage());
            }
            return false;
        }
    }
}
