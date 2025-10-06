package B_nivel;
import java.util.Arrays; // Importamos para usar Arrays.sort()

    public class Ordenacion {
        public static void main(String[] args) {
            // Array de ejemplo (desordenado)
            int[] numeros = {64,72, 25, 12, 22, 11};

            // Mostramos el array original
            System.out.print("Array original: ");
            for (int num : numeros) {
                System.out.print(num + " ");
            }
            System.out.println();

            // Hacemos una copia para comparar con Arrays.sort()
            int[] copia = numeros.clone();

            // Ordenamos manualmente usando ordenación por selección
            seleccionSort(numeros);

            // Mostramos el array ordenado manualmente
            System.out.print("Array ordenado (Selection Sort): ");
            for (int num : numeros) {
                System.out.print(num + " ");
            }
            System.out.println();

            // Ordenamos la copia con Arrays.sort()
            Arrays.sort(copia);

            // Mostramos el array ordenado con Arrays.sort()
            System.out.print("Array ordenado (Arrays.sort): ");
            for (int num : copia) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        // Método para ordenar un array con el algoritmo de selección
        public static void seleccionSort(int[] arr) {
            int n = arr.length; // Tamaño del array

            // Recorremos todo el array
            for (int i = 0; i < n - 1; i++) {
                int indiceMinimo = i; // Suponemos que el actual es el más pequeño

                // Buscamos el valor mínimo en el resto del array
                for (int j = i + 1; j < n; j++) {
                    if (arr[j] < arr[indiceMinimo]) {
                        indiceMinimo = j; // Actualizamos el índice del mínimo
                    }
                }

                // Intercambiamos el elemento mínimo encontrado con el actual
                int temp = arr[indiceMinimo];
                arr[indiceMinimo] = arr[i];
                arr[i] = temp;
            }
        }
    }

