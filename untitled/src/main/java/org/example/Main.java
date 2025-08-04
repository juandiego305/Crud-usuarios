package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== CREAR USUARIO ===");

        // --- Primer nombre (solo letras) ---
        String primerNombre;
        while (true) {
            System.out.print("Primer nombre: ");
            primerNombre = sc.nextLine();
            if (primerNombre.matches("^[A-Za-zÁÉÍÓÚáéíóúñÑ ]+$")) {
                break;
            } else {
                System.out.println(" El primer nombre solo puede contener letras y espacios, sin numeros ni simbolos.");
            }
        }

        // --- Segundo nombre (solo letras o vacío) ---
        String segundoNombre;
        while (true) {
            System.out.print("Segundo nombre: ");
            segundoNombre = sc.nextLine();
            if (segundoNombre.isEmpty() || segundoNombre.matches("^[A-Za-zÁÉÍÓÚáéíóúñÑ ]+$")) {
                break;
            } else {
                System.out.println(" El segundo nombre solo puede contener letras y espacios.");
            }
        }

        // --- Apellidos (solo letras) ---
        String apellidos;
        while (true) {
            System.out.print("Apellidos: ");
            apellidos = sc.nextLine();
            if (apellidos.matches("^[A-Za-zÁÉÍÓÚáéíóúñÑ ]+$")) {
                break;
            } else {
                System.out.println(" Los apellidos solo pueden contener letras y espacios, sin numeros ni simbolos.");
            }
        }

        // --- Dirección ---
        System.out.print("Direccion: ");
        String direccion = sc.nextLine();

        // --- Correo (formato válido) ---
        String correo;
        while (true) {
            System.out.print("Correo: ");
            correo = sc.nextLine();
            if (correo.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                break;
            } else {
                System.out.println(" El correo no tiene un formato valido (ejemplo: usuario@dominio.com).");
            }
        }

        // --- Tipo de documento ---
        String tipoDocumento;
        while (true) {
            System.out.print("Tipo de documento (CC, TI, CE, PAS): ");
            tipoDocumento = sc.nextLine().toUpperCase();
            if (tipoDocumento.matches("^(CC|TI|CE|PAS)$")) {
                break;
            } else {
                System.out.println(" Tipo de documento inválido. Debe ser CC, TI, CE o PAS.");
            }
        }

        // --- Número de documento (solo números) ---
        String numeroDocumento;
        while (true) {
            System.out.print("Numero de documento: ");
            numeroDocumento = sc.nextLine();
            if (numeroDocumento.matches("^[0-9]+$")) {
                break;
            } else {
                System.out.println(" El numero de documento solo puede contener numeros, sin letras ni simbolos.");
            }
        }

        // --- Teléfono (solo números y máx 10) ---
        String telefono;
        while (true) {
            System.out.print("Telefono: ");
            telefono = sc.nextLine();
            if (telefono.matches("^[0-9]{10}$")) {
                break;
            } else {
                System.out.println(" El teléfono debe contener exactamente 10 dígitos numéricos.");
            }
        }

        // --- Ciudad de residencia ---
        System.out.print("Ciudad de residencia: ");
        String ciudadResidencia = sc.nextLine();

        // Crear el usuario
        Usuario usuario = new Usuario(
                primerNombre, segundoNombre, apellidos,
                direccion, correo, tipoDocumento,
                numeroDocumento, telefono, ciudadResidencia
        );

        // Guardar en la base de datos
        boolean exito = UsuarioDAO.crearUsuario(usuario);

        if (exito) {
            System.out.println(" Usuario creado con exito.");
        } else {
            System.out.println(" No se pudo crear el usuario (correo o documento ya existente en la base de datos).");
        }

        sc.close();
    }
}
