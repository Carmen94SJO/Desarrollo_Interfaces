package C_nivel;

import java.io.*;
import java.util.ArrayList;

/**
 * Clase que representa una Persona
 * Implementa Serializable para poder guardarla en archivos
 */
public class Persona implements Serializable {
    // serialVersionUID: identificador único para la serialización
    // Controla la compatibilidad entre versiones de la clase
    private static final long serialVersionUID = 1L;

    // Atributos privados de la persona
    private String nombre;
    private int edad;
    private String email;

    /**
     * Constructor: crea una persona con sus datos
     * @param nombre nombre de la persona
     * @param edad edad de la persona
     * @param email email de la persona
     */
    public Persona(String nombre, int edad, String email) {
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
    }

    /**
     * Convierte el objeto a texto legible
     * Se ejecuta automáticamente al imprimir el objeto
     */
    @Override
    public String toString() {
        return nombre + ", " + edad + " años, " + email;
    }

    // Getters: métodos para obtener los valores
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getEmail() {
        return email;
    }

    /**
     * Programa de prueba de la clase Persona
     */
    public static void main(String[] args) {
        System.out.println("=== PRUEBA DE CLASE PERSONA ===\n");

        // Crear una persona
        Persona p1 = new Persona("Juan Pérez", 25, "juan@email.com");

        // Mostrar la persona
        System.out.println("Persona creada: " + p1);

        // Acceder a los atributos con getters
        System.out.println("\nDatos individuales:");
        System.out.println("  Nombre: " + p1.getNombre());
        System.out.println("  Edad: " + p1.getEdad());
        System.out.println("  Email: " + p1.getEmail());
    }
}