package C_nivel;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase para manejar archivos CSV (Comma-Separated Values)
 * CSV es un formato simple: cada línea es una fila, separada por comas
 * Ejemplo: Juan,25,Madrid
 */
public class ManejadorCSV {

    /**
     * Escribe datos en un archivo CSV
     * Cada array de Strings se convierte en una línea del CSV
     *
     * @param nombreArchivo nombre del archivo a crear (ej: "datos.csv")
     * @param datos lista de arrays, cada array es una fila
     */
    public static void escribir(String nombreArchivo, ArrayList<String[]> datos) {
        try {
            // FileWriter: clase que permite escribir texto en archivos
            // Si el archivo existe, lo sobrescribe
            // Si no existe, lo crea
            FileWriter writer = new FileWriter(nombreArchivo);

            // Recorremos cada fila de datos
            for (String[] fila : datos) {
                // String.join(",", array) une los elementos con comas
                // Ejemplo: ["Juan", "25", "Madrid"] → "Juan,25,Madrid"
                String linea = String.join(",", fila);

                // Escribimos la línea en el archivo
                // \n añade un salto de línea al final
                writer.write(linea + "\n");
            }

            // IMPORTANTE: cerrar el archivo para guardar los cambios
            writer.close();

            System.out.println("✓ CSV escrito: " + nombreArchivo);

        } catch (IOException e) {
            // IOException: error al escribir (disco lleno, sin permisos, etc.)
            System.out.println("Error al escribir CSV: " + e.getMessage());
        }
    }

    /**
     * Lee un archivo CSV y devuelve los datos como ArrayList
     * Cada línea del archivo se convierte en un array de Strings
     *
     * @param nombreArchivo nombre del archivo a leer
     * @return ArrayList con todas las filas leídas
     */
    public static ArrayList<String[]> leer(String nombreArchivo) {
        // ArrayList para almacenar los datos leídos
        ArrayList<String[]> datos = new ArrayList<>();

        try {
            // File: representa un archivo en el disco
            File archivo = new File(nombreArchivo);

            // Scanner: clase que permite leer archivos línea por línea
            Scanner scanner = new Scanner(archivo);

            // hasNextLine() devuelve true mientras haya líneas por leer
            while (scanner.hasNextLine()) {
                // Leemos una línea completa del archivo
                String linea = scanner.nextLine();

                // split(",") divide la línea por las comas
                // Ejemplo: "Juan,25,Madrid" → ["Juan", "25", "Madrid"]
                String[] campos = linea.split(",");

                // Añadimos el array a nuestra lista de datos
                datos.add(campos);
            }

            // Cerramos el scanner para liberar recursos
            scanner.close();

            System.out.println("✓ CSV leído: " + nombreArchivo +
                    " (" + datos.size() + " líneas)");

        } catch (FileNotFoundException e) {
            // Esta excepción se lanza si el archivo no existe
            System.out.println("Error: Archivo no encontrado - " + nombreArchivo);
        }

        return datos;
    }

    /**
     * Muestra el contenido de un CSV de forma legible en consola
     *
     * @param datos el ArrayList con los datos del CSV
     */
    public static void mostrar(ArrayList<String[]> datos) {
        // Verificamos si hay datos
        if (datos.isEmpty()) {
            System.out.println("No hay datos para mostrar");
            return;
        }

        System.out.println("\n--- Contenido del CSV ---");

        // Recorremos todas las filas (con índice para numerarlas)
        for (int i = 0; i < datos.size(); i++) {
            // Obtenemos cada fila (que es un array de Strings)
            String[] fila = datos.get(i);

            // Mostramos el número de fila
            System.out.print("Fila " + (i + 1) + ": ");

            // Recorremos cada campo de la fila
            // for-each: por cada String en el array fila
            for (String campo : fila) {
                System.out.print(campo + " | ");
            }

            // Salto de línea al terminar la fila
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Programa de prueba para la clase ManejadorCSV
     */
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════╗");
        System.out.println("║  PRUEBA DE MANEJO DE CSV       ║");
        System.out.println("╚════════════════════════════════╝\n");

        // 1. CREAR DATOS
        System.out.println("1. Creando datos...");

        // ArrayList para almacenar las filas del CSV
        ArrayList<String[]> datos = new ArrayList<>();

        // Añadimos la cabecera (nombres de columnas)
        datos.add(new String[]{"Nombre", "Edad", "Ciudad"});

        // Añadimos varias filas de datos
        datos.add(new String[]{"Juan", "25", "Madrid"});
        datos.add(new String[]{"María", "30", "Barcelona"});
        datos.add(new String[]{"Carlos", "28", "Valencia"});
        datos.add(new String[]{"Ana", "22", "Sevilla"});
        datos.add(new String[]{"Luis", "35", "Bilbao"});

        System.out.println("✓ Datos creados: " + datos.size() + " filas\n");

        // 2. ESCRIBIR CSV
        System.out.println("2. Escribiendo CSV...");
        escribir("personas.csv", datos);

        // 3. LEER CSV
        System.out.println("\n3. Leyendo CSV...");
        ArrayList<String[]> datosLeidos = leer("personas.csv");

        // 4. MOSTRAR CONTENIDO
        System.out.println("\n4. Mostrando contenido:");
        mostrar(datosLeidos);

        // 5. EJEMPLO: Trabajar con los datos leídos
        System.out.println("5. Procesando datos leídos:");

        // Saltamos la primera fila (cabecera) y mostramos el resto
        System.out.println("\nPersonas encontradas:");
        for (int i = 1; i < datosLeidos.size(); i++) {
            String[] persona = datosLeidos.get(i);
            // persona[0] = nombre, persona[1] = edad, persona[2] = ciudad
            System.out.println("  - " + persona[0] + " tiene " +
                    persona[1] + " años y vive en " + persona[2]);
        }

        System.out.println("\n✓ Prueba completada");
    }
}
