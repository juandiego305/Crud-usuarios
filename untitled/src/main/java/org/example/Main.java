package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== CREAR USUARIO ===");

        System.out.print("Primer nombre: ");
        String primerNombre = sc.nextLine();

        System.out.print("Segundo nombre: ");
        String segundoNombre = sc.nextLine();

        System.out.print("Apellidos: ");
        String apellidos = sc.nextLine();

        System.out.print("Direccion: ");
        String direccion = sc.nextLine();

        System.out.print("Correo: ");
        String correo = sc.nextLine();

        System.out.print("Tipo de documento (CC, TI, CE, PAS): ");
        String tipoDocumento = sc.nextLine();

        System.out.print("Numero de documento: ");
        String numeroDocumento = sc.nextLine();

        System.out.print("Telefono: ");
        String telefono = sc.nextLine();

        System.out.print("Ciudad de residencia: ");
        String ciudadResidencia = sc.nextLine();

        // Crear el usuario usando tu constructor
        Usuario usuario = new Usuario(
                primerNombre, segundoNombre, apellidos,
                direccion, correo, tipoDocumento,
                numeroDocumento, telefono, ciudadResidencia
        );

        // Insertar en la base de datos
        boolean exito = UsuarioDAO.crearUsuario(usuario);

        if (exito) {
            System.out.println("✅ Usuario creado con exito.");
        } else {
            System.out.println("❌ No se pudo crear el usuario.");
        }

        sc.close();
    }
}

