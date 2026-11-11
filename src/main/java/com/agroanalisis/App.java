
package com.agroanalisis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class App {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("\n===== AGROANALISIS =====");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Consultar usuarios");
            System.out.println("3. Actualizar usuario");
            System.out.println("4. Eliminar usuario");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    registrarUsuario();
                    break;
                case 2:
                    consultarUsuarios();
                    break;
                case 3:
                    actualizarUsuario();
                    break;
                case 4:
                    eliminarUsuario();
                    break;
                case 5:
                    System.out.println("Hasta pronto.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 5);
    }

    public static void registrarUsuario() {

        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();

        System.out.print("Correo: ");
        String correo = teclado.nextLine();

        System.out.print("Contrasena: ");
        String contrasena = teclado.nextLine();

        System.out.print("Rol: ");
        String rol = teclado.nextLine();

        String sql = "INSERT INTO usuario "
                + "(nombre, correo, contrasena, rol) VALUES (?, ?, ?, ?)";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement consulta = conexion.prepareStatement(sql)) {

            consulta.setString(1, nombre);
            consulta.setString(2, correo);
            consulta.setString(3, contrasena);
            consulta.setString(4, rol);

            consulta.executeUpdate();

            System.out.println("Usuario registrado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al registrar: " + e.getMessage());
        }
    }

    public static void consultarUsuarios() {

        String sql = "SELECT id_usuario, nombre, correo, rol FROM usuario";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement consulta = conexion.prepareStatement(sql);
             ResultSet resultado = consulta.executeQuery()) {

            System.out.println("\n===== LISTA DE USUARIOS =====");

            while (resultado.next()) {
                System.out.println(
                    "ID: " + resultado.getInt("id_usuario")
                    + " | Nombre: " + resultado.getString("nombre")
                    + " | Correo: " + resultado.getString("correo")
                    + " | Rol: " + resultado.getString("rol")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar: " + e.getMessage());
        }
    }

    public static void actualizarUsuario() {

        System.out.print("ID del usuario que desea actualizar: ");
        int id = teclado.nextInt();
        teclado.nextLine();

        System.out.print("Nuevo nombre: ");
        String nombre = teclado.nextLine();

        System.out.print("Nuevo correo: ");
        String correo = teclado.nextLine();

        System.out.print("Nueva contrasena: ");
        String contrasena = teclado.nextLine();

        System.out.print("Nuevo rol: ");
        String rol = teclado.nextLine();

        String sql = "UPDATE usuario SET nombre=?, correo=?, "
                + "contrasena=?, rol=? WHERE id_usuario=?";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement consulta = conexion.prepareStatement(sql)) {

            consulta.setString(1, nombre);
            consulta.setString(2, correo);
            consulta.setString(3, contrasena);
            consulta.setString(4, rol);
            consulta.setInt(5, id);

            int filas = consulta.executeUpdate();

            if (filas > 0) {
                System.out.println("Usuario actualizado correctamente.");
            } else {
                System.out.println("No se encontro ese usuario.");
            }

        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }

    public static void eliminarUsuario() {

        System.out.print("ID del usuario que desea eliminar: ");
        int id = teclado.nextInt();
        teclado.nextLine();

        String sql = "DELETE FROM usuario WHERE id_usuario=?";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement consulta = conexion.prepareStatement(sql)) {

            consulta.setInt(1, id);

            int filas = consulta.executeUpdate();

            if (filas > 0) {
                System.out.println("Usuario eliminado correctamente.");
            } else {
                System.out.println("No se encontro ese usuario.");
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }
}
