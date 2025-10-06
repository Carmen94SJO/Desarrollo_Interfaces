package C_nivel;
/**
 * Clase que representa un punto en un plano bidimensional (2D)
 * con coordenadas x e y.
 */
public class Punto2D {
    // Atributos privados para encapsular las coordenadas
    private double x;
    private double y;

    /**
     * Constructor que inicializa un punto con coordenadas específicas
     * @param x coordenada en el eje horizontal
     * @param y coordenada en el eje vertical
     */
    public Punto2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructor por defecto que crea un punto en el origen (0,0)
     */
    public Punto2D() {
        this(0, 0);
    }

    // Getters y Setters para acceder y modificar las coordenadas

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    /**
     * Calcula la distancia euclidiana entre este punto y otro punto.
     * Utiliza la fórmula: d = √((x2-x1)² + (y2-y1)²)
     *
     * @param otro el punto al que se calcula la distancia
     * @return la distancia entre los dos puntos
     */
    public double distancia(Punto2D otro) {
        // Calculamos la diferencia en x
        double deltaX = this.x - otro.x;

        // Calculamos la diferencia en y
        double deltaY = this.y - otro.y;

        // Aplicamos el teorema de Pitágoras
        // Math.sqrt() calcula la raíz cuadrada
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    /**
     * Método estático que calcula la distancia entre dos puntos
     * sin necesidad de tener una instancia específica.
     *
     * @param p1 primer punto
     * @param p2 segundo punto
     * @return la distancia entre los dos puntos
     */
    public static double distancia(Punto2D p1, Punto2D p2) {
        double deltaX = p1.x - p2.x;
        double deltaY = p1.y - p2.y;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    /**
     * Calcula la distancia desde este punto al origen (0,0)
     * @return la distancia al origen
     */
    public double distanciaAlOrigen() {
        // Simplemente calculamos: √(x² + y²)
        return Math.sqrt(x * x + y * y);
    }

    /**
     * Representa el punto como una cadena de texto
     * @return representación en formato (x, y)
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    /**
     * Compara si dos puntos son iguales (mismas coordenadas)
     * @param obj objeto a comparar
     * @return true si los puntos son iguales, false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        // Verificamos si es el mismo objeto
        if (this == obj) return true;

        // Verificamos si es null o de otra clase
        if (obj == null || getClass() != obj.getClass()) return false;

        // Convertimos y comparamos coordenadas
        Punto2D otro = (Punto2D) obj;
        return Double.compare(otro.x, x) == 0 &&
                Double.compare(otro.y, y) == 0;
    }

    /**
     * Clase de prueba para demostrar el uso de Punto2D
     */
    public static void main(String[] args) {
        // Creamos dos puntos
        Punto2D p1 = new Punto2D(3, 4);
        Punto2D p2 = new Punto2D(6, 8);

        // Mostramos los puntos
        System.out.println("Punto 1: " + p1);
        System.out.println("Punto 2: " + p2);

        // Calculamos distancia usando método de instancia
        double dist1 = p1.distancia(p2);
        System.out.println("\nDistancia entre p1 y p2: " + dist1);

        // Calculamos distancia usando método estático
        double dist2 = Punto2D.distancia(p1, p2);
        System.out.println("Distancia (método estático): " + dist2);

        // Calculamos distancia al origen
        double distOrigen = p1.distanciaAlOrigen();
        System.out.println("\nDistancia de p1 al origen: " + distOrigen);

        // Ejemplo con puntos en el origen
        Punto2D origen = new Punto2D();
        System.out.println("\nPunto origen: " + origen);
        System.out.println("Distancia de p1 al origen: " + p1.distancia(origen));
    }
}