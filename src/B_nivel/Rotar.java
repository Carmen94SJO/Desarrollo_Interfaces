package B_nivel;

public class Rotar {
    public static void main(String[] args) {
        // Declaramos un array de ejemplo
        int[] numeros = {1, 2, 3, 4, 5, 6, 7};

        // Número de posiciones que queremos rotar
        int k = 3;

        // Mostramos el array original
        System.out.print("Array original: ");
        for (int num : numeros) {
            System.out.print(num + " ");
        }
        System.out.println(); // Salto de línea

        // Llamamos a la función que rota el array
        rotarArray(numeros, k);

        // Mostramos el array rotado
        System.out.print("Array rotado " + k + " posiciones a la derecha: ");
        for (int num : numeros) {
            System.out.print(num + " ");
        }
    }

    // Función que rota un array 'k' posiciones a la derecha
    public static void rotarArray(int[] arr, int k) {
        // Si el array está vacío o no hay rotación, salimos
        if (arr == null || arr.length == 0 || k == 0) return;

        int n = arr.length; // Guardamos el tamaño del array
        k = k % n; // Si k es mayor que n, usamos el módulo para evitar rotaciones innecesarias

        // Paso 1: Invertir todo el array
        invertir(arr, 0, n - 1);

        // Paso 2: Invertir los primeros 'k' elementos
        invertir(arr, 0, k - 1);

        // Paso 3: Invertir el resto de los elementos (de k a n-1)
        invertir(arr, k, n - 1);
    }

    // Función auxiliar para invertir una porción del array
    public static void invertir(int[] arr, int inicio, int fin) {
        while (inicio < fin) {
            // Intercambiamos los elementos en las posiciones inicio y fin
            int temp = arr[inicio];
            arr[inicio] = arr[fin];
            arr[fin] = temp;

            // Movemos los índices hacia el centro
            inicio++;
            fin--;
        }
    }
}
