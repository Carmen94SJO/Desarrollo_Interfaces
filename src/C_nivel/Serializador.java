package C_nivel;

import java.io.*;
import java.util.ArrayList;

/**
 * Clase para guardar y cargar objetos usando serialización
 * Serialización: convertir objetos Java a bytes para guardarlos en archivos
 * Deserialización: convertir bytes de vuelta a objetos Java
 */
public class Serializador {

    // ===========================
    // MÉTODOS PRINCIPALES
    // ===========================

    /**
     * Guarda un objeto en un archivo binario
     */
    public static boolean guardar(String nombreArchivo, Object objeto) {
        try (FileOutputStream fileOut = new FileOutputStream(nombreArchivo);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(objeto); // Serializa el objeto
            System.out.println("✓ Objeto guardado: " + nombreArchivo);
            return true;
        } catch (IOException e) {
            System.out.println("Error al guardar objeto: " + e.getMessage());
            return false;
        }
    }

    /**
     * Carga un objeto desde un archivo binario
     */
    public static Object cargar(String nombreArchivo) {
        try (FileInputStream fileIn = new FileInputStream(nombreArchivo);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            Object objeto = objectIn.readObject();
            System.out.println("✓ Objeto cargado: " + nombreArchivo);
            return objeto;
        } catch (FileNotFoundException e) {
            System.out.println("Error: Archivo no encontrado - " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al cargar objeto: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Clase no encontrada - " + e.getMessage());
        }
        return null;
    }

    /**
     * Guarda una lista de objetos en un archivo
     */
    public static boolean guardarLista(String nombreArchivo, ArrayList<?> lista) {
        try (FileOutputStream fileOut = new FileOutputStream(nombreArchivo);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(lista);
            System.out.println("✓ Lista guardada: " + nombreArchivo + " (" + lista.size() + " objetos)");
            return true;
        } catch (IOException e) {
            System.out.println("Error al guardar lista: " + e.getMessage());
            return false;
        }
    }

    /**
     * Carga una lista de objetos desde un archivo
     */
    @SuppressWarnings("unchecked")
    public static ArrayList<?> cargarLista(String nombreArchivo) {
        try (FileInputStream fileIn = new FileInputStream(nombreArchivo);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            ArrayList<?> lista = (ArrayList<?>) objectIn.readObject();
            System.out.println("✓ Lista cargada: " + nombreArchivo + " (" + lista.size() + " objetos)");
            return lista;
        } catch (FileNotFoundException e) {
            System.out.println("Error: Archivo no encontrado - " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al cargar lista: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Clase no encontrada");
        }
        return null;
    }

    /**
     * Verifica si un archivo existe
     */
    public static boolean existe(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    /**
     * Elimina un archivo
     */
    public static boolean eliminar(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        if (!archivo.exists()) {
            System.out.println("El archivo no existe: " + nombreArchivo);
            return false;
        }
        boolean eliminado = archivo.delete();
        if (eliminado) {
            System.out.println("✓ Archivo eliminado: " + nombreArchivo);
        } else {
            System.out.println("Error: No se pudo eliminar - " + nombreArchivo);
        }
        return eliminado;
    }

    // ===========================
    // PROGRAMA DE PRUEBA
    // ===========================
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║  PRUEBA DE SERIALIZACIÓN           ║");
        System.out.println("╚════════════════════════════════════╝\n");

        // 1. Guardar y cargar un objeto
        System.out.println("═══ 1. Guardar y cargar un objeto ═══");
        Persona persona1 = new Persona("Pedro García", 35, "pedro@email.com");
        System.out.println("Persona original: " + persona1);
        guardar("persona.ser", persona1);
        Persona personaCargada = (Persona) cargar("persona.ser");
        if (personaCargada != null) {
            System.out.println("Persona cargada: " + personaCargada);
        }

        // 2. Guardar y cargar una lista
        System.out.println("\n═══ 2. Guardar y cargar una lista ═══");
        ArrayList<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.add(new Persona("Laura Pérez", 28, "laura@email.com"));
        listaPersonas.add(new Persona("Miguel Ruiz", 32, "miguel@email.com"));
        listaPersonas.add(new Persona("Sofia Torres", 25, "sofia@email.com"));
        guardarLista("personas.ser", listaPersonas);
        @SuppressWarnings("unchecked")
        ArrayList<Persona> listaCargada = (ArrayList<Persona>) cargarLista("personas.ser");
        if (listaCargada != null) {
            for (Persona p : listaCargada) {
                System.out.println("  - " + p);
            }
        }

        // 3. Verificar existencia de archivos
        System.out.println("\n═══ 3. Verificar archivos ═══");
        System.out.println("¿Existe persona.ser? " + existe("persona.ser"));
        System.out.println("¿Existe personas.ser? " + existe("personas.ser"));

        // 4. Guardar otros tipos de objetos
        System.out.println("\n═══ 4. Guardar otros tipos ═══");
        guardar("texto.ser", "Hola, esto es un String serializado");
        System.out.println("Texto cargado: " + cargar("texto.ser"));
        guardar("numero.ser", 42);
        System.out.println("Número cargado: " + cargar("numero.ser"));

        // 5. Limpieza de archivos
        System.out.println("\n═══ 5. Limpieza de archivos ═══");
        String[] archivos = {"persona.ser", "personas.ser", "texto.ser", "numero.ser"};
        for (String archivo : archivos) {
            eliminar(archivo);
        }

        System.out.println("\n✓ Todas las pruebas completadas");
    }
}
