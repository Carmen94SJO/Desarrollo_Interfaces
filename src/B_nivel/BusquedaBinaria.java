package B_nivel;

public class BusquedaBinaria {
    public static void main(String[] args) {
        // Array ORDENADO (requisito para la búsqueda binaria)
        int[] numeros = {2, 4, 6, 8, 10, 12, 14, 16, 18};

        // Número que queremos buscar
        int objetivo = 10;

        // Mostramos el array original
        System.out.print("Array ordenado: ");
        for (int num : numeros) {
            System.out.print(num + " ");
        }
        System.out.println(); // salto de línea

        // Llamamos a la función de búsqueda binaria
        int resultado = busquedaBinaria(numeros, objetivo);

        // Mostramos el resultado
        if (resultado == -1) {
            System.out.println("El número " + objetivo + " NO se encuentra en el array.");
        } else {
            System.out.println("El número " + objetivo + " se encuentra en la posición (índice): " + resultado);
        }
    }

    // Función de búsqueda binaria
    public static int busquedaBinaria(int[] arr, int objetivo) {
        int inicio = 0;              // Índice inicial del array
        int fin = arr.length - 1;    // Índice final del array

        // Mientras el rango de búsqueda sea válido
        while (inicio <= fin) {
            // Calculamos el punto medio
            int medio = inicio + (fin - inicio) / 2;

            // Comparamos el elemento medio con el objetivo
            if (arr[medio] == objetivo) {
                return medio; // Encontrado: devolvemos la posición
            }
            else if (arr[medio] < objetivo) {
                // Si el medio es menor que el objetivo, buscamos en la mitad derecha
                inicio = medio + 1;
            }
            else {
                // Si el medio es mayor que el objetivo, buscamos en la mitad izquierda
                fin = medio - 1;
            }
        }

        // Si salimos del bucle, el número no está en el array
        return -1;
    }
}
