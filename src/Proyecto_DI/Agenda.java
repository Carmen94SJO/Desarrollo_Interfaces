package Proyecto_DI;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Clase que gestiona la colección de contactos
class Agenda {
    private List<Contacto> contactos; // Lista que almacena todos los contactos
    private String archivoCSV; // Ruta del archivo CSV donde se guardan los datos

    // Constructor: inicializa la agenda con un archivo CSV
    public Agenda(String archivoCSV) {
        this.contactos = new ArrayList<>();
        this.archivoCSV = archivoCSV;
        cargarContactos(); // Carga contactos existentes al iniciar
    }

    // Método para agregar un nuevo contacto
    public void crearContacto(String nombre, String telefono, String email) {
        Contacto nuevoContacto = new Contacto(nombre, telefono, email);
        contactos.add(nuevoContacto);
        System.out.println("✓ Contacto creado exitosamente");
        guardarContactos(); // Guarda automáticamente después de crear
    }

    // Método para listar todos los contactos
    public void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("No hay contactos en la agenda");
            return;
        }

        System.out.println("\n=== LISTA DE CONTACTOS ===");
        for (int i = 0; i < contactos.size(); i++) {
            System.out.println((i + 1) + ". " + contactos.get(i));
        }
        System.out.println("Total de contactos: " + contactos.size());
    }

    // Método para buscar contactos por nombre (búsqueda parcial)
    public void buscarContacto(String nombre) {
        List<Contacto> encontrados = new ArrayList<>();

        // Busca contactos que contengan el texto ingresado (ignora mayúsculas)
        for (Contacto c : contactos) {
            if (c.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                encontrados.add(c);
            }
        }

        if (encontrados.isEmpty()) {
            System.out.println("No se encontraron contactos con ese nombre");
        } else {
            System.out.println("\n=== RESULTADOS DE BÚSQUEDA ===");
            for (Contacto c : encontrados) {
                System.out.println(c);
            }
        }
    }

    // Método para eliminar un contacto por nombre exacto
    public void eliminarContacto(String nombre) {
        boolean eliminado = false;

        // Recorre la lista en reversa para evitar problemas al eliminar
        for (int i = contactos.size() - 1; i >= 0; i--) {
            if (contactos.get(i).getNombre().equalsIgnoreCase(nombre)) {
                contactos.remove(i);
                eliminado = true;
                System.out.println("✓ Contacto eliminado exitosamente");
            }
        }

        if (!eliminado) {
            System.out.println("No se encontró ningún contacto con ese nombre");
        } else {
            guardarContactos(); // Guarda cambios después de eliminar
        }
    }

    // Método para guardar contactos en el archivo CSV
    public void guardarContactos() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(archivoCSV))) {
            // Escribe cada contacto en una línea del archivo
            for (Contacto c : contactos) {
                writer.println(c.toCSV());
            }
            System.out.println("✓ Contactos guardados en " + archivoCSV);
        } catch (IOException e) {
            System.out.println("Error al guardar contactos: " + e.getMessage());
        }
    }

    // Método para cargar contactos desde el archivo CSV
    private void cargarContactos() {
        File archivo = new File(archivoCSV);

        // Si el archivo no existe, no hay nada que cargar
        if (!archivo.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoCSV))) {
            String linea;

            // Lee el archivo línea por línea
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(","); // Separa por comas

                // Verifica que la línea tenga los 3 campos necesarios
                if (datos.length == 3) {
                    contactos.add(new Contacto(datos[0], datos[1], datos[2]));
                }
            }
            System.out.println("✓ Contactos cargados desde " + archivoCSV);
        } catch (IOException e) {
            System.out.println("Error al cargar contactos: " + e.getMessage());
        }
    }

    // Método para exportar contactos a un archivo diferente
    public void exportarContactos(String archivoDestino) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(archivoDestino))) {
            for (Contacto c : contactos) {
                writer.println(c.toCSV());
            }
            System.out.println("✓ Contactos exportados a " + archivoDestino);
        } catch (IOException e) {
            System.out.println("Error al exportar contactos: " + e.getMessage());
        }
    }

    // Método para importar contactos desde otro archivo
    public void importarContactos(String archivoOrigen) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoOrigen))) {
            String linea;
            int importados = 0;

            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");

                if (datos.length == 3) {
                    contactos.add(new Contacto(datos[0], datos[1], datos[2]));
                    importados++;
                }
            }

            System.out.println("✓ " + importados + " contactos importados desde " + archivoOrigen);
            guardarContactos(); // Guarda los cambios
        } catch (IOException e) {
            System.out.println("Error al importar contactos: " + e.getMessage());
        }
    }
}
