package B_nivel;

public class Estadisticas {
    public static void main(String[] args) {
        // Primero, creo un array de enteros con algunos valores
        int[] numeros = {5, 10, 15, 20, 25, 5};

        // Inicializo variables para las operaciones
        int suma = 0;  // Aquí voy a guardar la suma de todos los números
        int maximo = numeros[0]; // Empiezo con el primer número como máximo
        double divisor = 2; // Defino el número por el que voy a dividir

        // Creo un array de double para guardar los resultados de la división
        double[] numerosDivididos = new double[numeros.length];

        // Recorro cada número del array usando un bucle for
        for (int i = 0; i < numeros.length; i++) {
            int n = numeros[i]; // Tomo el número actual del array

            suma += n; // Sumo el número a mi variable suma

            // Divido el número por el divisor y guardo el resultado en el array de doubles
            numerosDivididos[i] = (double) n / divisor;

            // Compruebo si este número es mayor que el máximo actual
            if (n > maximo) {
                maximo = n; // Actualizo el máximo si es necesario
            }
        }

        // Calculo el promedio dividiendo la suma entre la cantidad de elementos
        double promedio = (double) suma / numeros.length;

        // Imprimo los resultados
        System.out.println("La suma de los números es: " + suma);
        System.out.println("El promedio es: " + promedio);
        System.out.println("El número máximo es: " + maximo);

        // Imprimo los números divididos
        System.out.println("Números divididos por " + divisor + ":");
        for (int i = 0; i < numerosDivididos.length; i++) {
            System.out.println(numerosDivididos[i]); // Muestro cada resultado
        }
    }
}
