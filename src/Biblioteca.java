import models.Bibliotecario;
import models.Libro;
import models.Prestamo;
import models.Usuario;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<Usuario> usuariosRegistrados = new ArrayList<>();
        ArrayList<Libro> agregarLibro = new ArrayList<>();
        ArrayList<Prestamo> solicitarLibro = new ArrayList<>();
        ArrayList<Prestamo> devolverLibros = new ArrayList<>();

        boolean salida = true;
        do {
            System.out.println();
            // Menú principal
            System.out.println("--------------Bienvenido a la Biblioteca---------------");
            System.out.println();
            System.out.println("Seleccione una opción:");
            System.out.println("1. Iniciar sesión como usuario");
            System.out.println("2. Iniciar sesión como bibliotecario");
            System.out.println("3. Salir");

            int opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    // Opciones para los usuarios
                    boolean salida2 = true;
                    do {
                        System.out.println("----------Bienvenido usuario----------");
                        System.out.println("1. Registrarse");
                        System.out.println("2. Iniciar sesión");
                        System.out.println("3. Volver");
                        System.out.println("Seleccione");

                        int seleccion = entrada.nextInt();
                        entrada.nextLine();

                        switch (seleccion) {
                            case 1:
                                System.out.println();
                                System.out.println("------------------------------------------------");
                                System.out.println("Agregue nombre de usuario: ");
                                String nameUser = entrada.nextLine();
                                System.out.println("Agregue contraseña: ");
                                String contra = entrada.nextLine();
                                Usuario newUser = new Usuario(nameUser, contra);
                                usuariosRegistrados.add(newUser);
                                System.out.println("Usuario añadido correctamente.");
                                System.out.println("------------------------------------------------");
                                break;
                            case 2:
                                System.out.println("-------------------------------------------------");
                                System.out.println("Ingrese nombre de usuario: ");
                                String usuario = entrada.nextLine();
                                System.out.println("Ingrese contraseña: ");
                                String password = entrada.nextLine();
                                boolean usuarioValido = false;
                                for (Usuario usuario1 : usuariosRegistrados) {
                                    if (usuario1.getUserName().equals(usuario) && usuario1.getPasswordUser().equals(password)) {
                                        usuarioValido = true;
                                        System.out.println("¡Bienvenido " + usuario+"!");
                                        System.out.println("El día de hoy le presentamos los siguientes libros: ");
                                        int t=0;
                                        for (Libro recorrerLibros : agregarLibro) {
                                            System.out.println((t+1)+recorrerLibros.titulos());
                                            t++;
                                        }
                                    }
                                }
                                if (!usuarioValido) {
                                    System.out.println("Usuario no válido o no existente.");
                                }
                                break;
                            case 3:
                                // Volver al menú principal
                                System.out.println("Volviendo al menú principal.....");
                                salida2 = false;
                                break;
                        }
                    } while (salida2);
                    break;
                case 2:
                    System.out.println("-----------------------------------------------");
                    // Iniciar sesión como bibliotecario
                    Bibliotecario administrador = new Bibliotecario();
                    System.out.println("Inicie sesión como administrador:");
                    System.out.println("Ingrese su usuario: ");
                    String nameAdmin = entrada.nextLine();
                    System.out.println("Ingrese su contraseña: ");
                    String passwordAdmin = entrada.nextLine();
                    boolean bibliotecarioValido = false;
                    if (administrador.getNameAdmin().equals(nameAdmin) && administrador.getPasswordAdmin().equals(passwordAdmin)) {
                        bibliotecarioValido = true;

                        boolean salida3 = true;
                        System.out.println("------Bienvenido------");
                        do {
                            // Opciones para el bibliotecario
                            System.out.println("¿Qué desea hacer hoy?");
                            System.out.println("1. Agregar libros/dar de alta.");
                            System.out.println("2. Imprimir inventario de libros.");
                            System.out.println("3. Registrar préstamo de libros.");
                            System.out.println("4. Imprimir lista de libros prestados.");
                            System.out.println("5. Registrar devolución de libros.");
                            System.out.println("6. Imprimir lista de libros devueltos.");
                            System.out.println("7. Volver al menú principal.");

                            int seleccion = entrada.nextInt();
                            entrada.nextLine();

                            switch (seleccion) {
                                case 1:
                                    // Agregar libros al inventario
                                    boolean salida4 = true;
                                    do {
                                        System.out.println("Ingrese los datos del libro: ");
                                        System.out.println("Ingrese el título: ");
                                        String title = entrada.nextLine();
                                        System.out.println("Ingrese la editorial: ");
                                        String editorial = entrada.nextLine();
                                        System.out.println("Ingrese el autor: ");
                                        String autor = entrada.nextLine();
                                        System.out.println("Ingrese la fecha de publicación: ");
                                        int fechaPub = entrada.nextInt();
                                        entrada.nextLine();

                                        Libro nuevoLibro = new Libro(title, editorial, autor, fechaPub);
                                        agregarLibro.add(nuevoLibro);
                                        System.out.println("¡El libro se ha agregado exitosamente!");
                                        System.out.println("¿Desea agregar otro libro? s/n");
                                        String respuesta = entrada.nextLine();
                                        if (respuesta.equalsIgnoreCase("n")) {
                                            System.out.println("Volviendo al menú del bibliotecario....");
                                            salida4 = false;
                                            System.out.println();
                                        }
                                    } while (salida4);
                                    break;
                                case 2:
                                    // Imprimir inventario de libros
                                    int i = 0;
                                    System.out.println("Los libros del inventario son: ");
                                    for (Libro totalLibros : agregarLibro) {
                                        System.out.println((i + 1) + ". " + totalLibros.getTitle());
                                        i++;
                                    }
                                    System.out.println();
                                    System.out.println();
                                    break;
                                case 3:
                                    // Registrar préstamo de libros
                                    boolean salida5 = true;
                                    System.out.println("Ingrese el nombre del prestatario: ");
                                    String nameUser = entrada.nextLine();
                                    do {
                                        System.out.println("Ingrese el título del libro a solicitar: ");
                                        String nameBook = entrada.nextLine();

                                        Usuario usuarioPrestamo = null;
                                        for (Usuario usuario : usuariosRegistrados) {
                                            if (usuario.getUserName().equals(nameUser)) {
                                                usuarioPrestamo = usuario;
                                            }
                                        }
                                        Libro libroPrestamo = null;
                                        for (Libro libro : agregarLibro) {
                                            if (libro.getTitle().equals(nameBook)) {
                                                libroPrestamo = libro;
                                                break;
                                            }
                                        }
                                        if (usuarioPrestamo != null && libroPrestamo != null) {
                                            Prestamo libroPrestado = new Prestamo(nameUser, nameBook);
                                            solicitarLibro.add(libroPrestado);
                                            agregarLibro.remove(libroPrestamo); // Eliminar el libro del inventario
                                            System.out.println("¡Préstamo registrado con éxito!");
                                        } else {
                                            System.out.println("No hay libros disponibles");
                                        }
                                        System.out.println("¿Desea solicitar otro libro? s/n");
                                        String respuesta = entrada.nextLine();
                                        if (respuesta.equalsIgnoreCase("n")) {
                                            System.out.println("¡Gracias por su preferencia!");
                                            salida5 = false;
                                        }
                                    } while (salida5);
                                    break;
                                case 4:
                                    // Imprimir lista de libros prestados
                                    int k = 0;
                                    System.out.println("Los libros prestados son: ");
                                    for (Prestamo recorridoLibrosPrestados : solicitarLibro) {
                                        System.out.println((k + 1) + ". " + recorridoLibrosPrestados.getNameBook());
                                        k++;
                                    }
                                    System.out.println();
                                    System.out.println();
                                    break;
                                case 5:
                                    // Registrar devolución de libros
                                    boolean salida6 = true;
                                    System.out.println("Ingrese el nombre del usuario que prestó el libro:");
                                    String nameUsersoli = entrada.nextLine();
                                    do {
                                        System.out.println("Título del libro a devolver");
                                        String tituloBook = entrada.nextLine();

                                        Prestamo prestamoDevolucion = null;
                                        for (Prestamo prestamo : solicitarLibro) {
                                            if (prestamo.getNameUser().equals(nameUsersoli) && prestamo.getNameBook().equals(tituloBook)) {
                                                prestamoDevolucion = prestamo;
                                                break;
                                            }
                                        }

                                        if (prestamoDevolucion != null) {
                                            solicitarLibro.remove(prestamoDevolucion); // Eliminar el libro prestado
                                            Libro libroDevolucion = null;
                                            for (Libro libro : agregarLibro) {
                                                if (libro.getTitle().equals(tituloBook)) {
                                                    libroDevolucion = libro;
                                                    break;
                                                }
                                            }
                                            boolean libroEncontrado = false;
                                            for (Libro libro : agregarLibro) {
                                                if (libro.getTitle().equals(tituloBook)) {
                                                    libroEncontrado = true;
                                                    break;
                                                }
                                            }
                                            if (!libroEncontrado) {
                                                libroDevolucion = new Libro(tituloBook, "", "", 0);
                                                agregarLibro.add(libroDevolucion);
                                            }


                                            // Agregar el libro a la lista de devolución
                                            devolverLibros.add(prestamoDevolucion);

                                            System.out.println("Devolución registrada con éxito.");
                                        } else {
                                            System.out.println("No se encontró el préstamo.");
                                        }
                                        System.out.println("¿Desea devolver otro libro? s/n");
                                        String resDevolver = entrada.nextLine();
                                        if (resDevolver.equalsIgnoreCase("n")) {
                                            salida6 = false;
                                        }
                                    } while (salida6);
                                    break;
                                case 6:
                                    // Imprimir lista de libros devueltos
                                    int j = 0;
                                    System.out.println("Los libros devueltos son:");
                                    for (Prestamo recorridoLibrosDevueltos : devolverLibros) {
                                        System.out.println((j + 1) + ". " + recorridoLibrosDevueltos.getNameBook());
                                        j++;
                                    }
                                    System.out.println();
                                    break;
                                case 7:
                                    // Volver al menú principal
                                    System.out.println("Saliendo al menú principal....");
                                    salida3 = false;
                                    break;
                            }
                        } while (salida3);

                    } else if (!bibliotecarioValido) {
                        System.out.println("Usuario o contraseña inválida. Vuelva a intentarlo");
                    }
                    break;
                case 3:
                    // Salir del programa
                    System.out.println("Gracias por visitar la Biblioteca. ¡Hasta luego!");
                    salida = false;
                    break;
            }
        } while (salida);

    }
}
