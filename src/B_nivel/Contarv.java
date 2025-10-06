package B_nivel;

import java.util.Scanner; // Importa la clase Scanner para leer la entrada del usuario

public class Contarv {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Crea un objeto Scanner para leer la entrada
        System.out.print("Escribe la frase que tú quieras: "); // Pide al usuario que escriba una frase

        String frase = sc.nextLine(); // Lee la línea completa introducida por el usuario
        int contador = 0; // Inicializa un contador para las vocales

        // Recorre cada carácter de la frase
        for (int i = 0; i < frase.length(); i++) {
            char c = Character.toLowerCase(frase.charAt(i)); // Convierte el carácter a minúscula para facilitar la comparación

            // Comprueba si el carácter es una vocal
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                contador++; // Si es una vocal, incrementa el contador
            }
        }

        // Imprime el número total de vocales encontradas
        System.out.println("La frase tiene " + contador + " vocales.");

        // Muestra la frase completa que introdujo el usuario
        System.out.println("La frase introducida es: " + frase);

        sc.close(); // Cierra el Scanner para liberar recursos
    }
}
