package Proyecto_DI;
import java.util.Scanner;

// Clase principal que ejecuta el programa
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda("contactos.csv"); // Crea la agenda con el archivo CSV

        int opcion;

        // Menú principal de la aplicación
        do {
            System.out.println("\n╔════════════════════════════════╗");
            System.out.println("║   AGENDA DE CONTACTOS          ║");
            System.out.println("╚════════════════════════════════╝");
            System.out.println("1. Crear contacto");
            System.out.println("2. Listar contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Exportar contactos");
            System.out.println("6. Importar contactos");
            System.out.println("0. Salir");
            System.out.print("\nSelecciona una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpia el buffer

            switch (opcion) {
                case 1: // Crear contacto
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    agenda.crearContacto(nombre, telefono, email);
                    break;

                case 2: // Listar contactos
                    agenda.listarContactos();
                    break;

                case 3: // Buscar contacto
                    System.out.print("Nombre a buscar: ");
                    String busqueda = scanner.nextLine();
                    agenda.buscarContacto(busqueda);
                    break;

                case 4: // Eliminar contacto
                    System.out.print("Nombre del contacto a eliminar: ");
                    String eliminar = scanner.nextLine();
                    agenda.eliminarContacto(eliminar);
                    break;

                case 5: // Exportar contactos
                    System.out.print("Nombre del archivo destino: ");
                    String destino = scanner.nextLine();
                    agenda.exportarContactos(destino);
                    break;

                case 6: // Importar contactos
                    System.out.print("Nombre del archivo origen: ");
                    String origen = scanner.nextLine();
                    agenda.importarContactos(origen);
                    break;

                case 0: // Salir
                    System.out.println("¡Hasta pronto!");
                    break;

                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 0);

        scanner.close();
    }
}