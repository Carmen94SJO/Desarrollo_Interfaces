package C_nivel;

/**
 * Clase que representa una cuenta bancaria con operaciones básicas
 * de ingreso y retirada de dinero, sin permitir saldo negativo.
 */
public class CuentaBancaria {
    // Atributos privados de la cuenta
    private String titular;
    private String numeroCuenta;
    private double saldo;

    /**
     * Constructor completo que inicializa una cuenta con todos los datos
     * @param titular nombre del titular de la cuenta
     * @param numeroCuenta número identificador de la cuenta
     * @param saldoInicial saldo inicial (debe ser >= 0)
     */
    public CuentaBancaria(String titular, String numeroCuenta, double saldoInicial) {
        this.titular = titular;
        this.numeroCuenta = numeroCuenta;
        // Validamos que el saldo inicial no sea negativo
        if (saldoInicial < 0) {
            System.out.println("ADVERTENCIA: El saldo inicial no puede ser negativo. Se establece en 0.");
            this.saldo = 0;
        } else {
            this.saldo = saldoInicial;
        }
    }

    /**
     * Constructor que crea una cuenta con saldo inicial de 0
     * @param titular nombre del titular
     * @param numeroCuenta número de cuenta
     */
    public CuentaBancaria(String titular, String numeroCuenta) {
        this(titular, numeroCuenta, 0);
    }

    // Getters para consultar información

    public String getTitular() {
        return titular;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    /**
     * Ingresa dinero en la cuenta
     * @param cantidad cantidad a ingresar
     * @return true si el ingreso fue exitoso, false si no
     */
    public boolean ingresar(double cantidad) {
        // Validamos que la cantidad sea positiva
        if (cantidad <= 0) {
            System.out.println("ERROR: La cantidad a ingresar debe ser positiva.");
            return false;
        }

        // Realizamos el ingreso
        saldo += cantidad;
        System.out.println("Ingreso exitoso de " + cantidad + " €");
        System.out.println("Nuevo saldo: " + saldo + " €");
        return true;
    }

    /**
     * Retira dinero de la cuenta, sin permitir saldo negativo
     * @param cantidad cantidad a retirar
     * @return true si la retirada fue exitosa, false si no
     */
    public boolean retirar(double cantidad) {
        // Validamos que la cantidad sea positiva
        if (cantidad <= 0) {
            System.out.println("ERROR: La cantidad a retirar debe ser positiva.");
            return false;
        }

        // Verificamos que hay suficiente saldo
        if (cantidad > saldo) {
            System.out.println("ERROR: Saldo insuficiente.");
            System.out.println("Saldo disponible: " + saldo + " €");
            System.out.println("Cantidad solicitada: " + cantidad + " €");
            return false;
        }

        // Realizamos la retirada
        saldo -= cantidad;
        System.out.println("Retirada exitosa de " + cantidad + " €");
        System.out.println("Nuevo saldo: " + saldo + " €");
        return true;
    }

    /**
     * Consulta el saldo actual de la cuenta
     */
    public void consultarSaldo() {
        System.out.println("Saldo actual de " + titular + ": " + saldo + " €");
    }

    /**
     * Transfiere dinero a otra cuenta
     * @param destino cuenta destino de la transferencia
     * @param cantidad cantidad a transferir
     * @return true si la transferencia fue exitosa, false si no
     */
    public boolean transferir(CuentaBancaria destino, double cantidad) {
        System.out.println("\n--- Transferencia ---");

        // Intentamos retirar de esta cuenta
        if (retirar(cantidad)) {
            // Si se pudo retirar, ingresamos en la cuenta destino
            destino.ingresar(cantidad);
            System.out.println("Transferencia completada a " + destino.getTitular());
            return true;
        } else {
            System.out.println("Transferencia cancelada.");
            return false;
        }
    }

    /**
     * Muestra información completa de la cuenta
     */
    public void mostrarInfo() {
        System.out.println("\n=== INFORMACIÓN DE LA CUENTA ===");
        System.out.println("Titular: " + titular);
        System.out.println("Número de cuenta: " + numeroCuenta);
        System.out.println("Saldo: " + saldo + " €");
        System.out.println("================================\n");
    }

    /**
     * Representa la cuenta como texto
     */
    @Override
    public String toString() {
        return "CuentaBancaria[" + titular + ", " + numeroCuenta + ", saldo=" + saldo + "€]";
    }

    /**
     * Clase de prueba para demostrar el funcionamiento de CuentaBancaria
     */
    public static void main(String[] args) {
        System.out.println("=== SIMULACIÓN DE CUENTA BANCARIA ===\n");

        // Creamos dos cuentas
        CuentaBancaria cuenta1 = new CuentaBancaria("Juan Pérez", "ES12-3456-7890", 1000);
        CuentaBancaria cuenta2 = new CuentaBancaria("María García", "ES98-7654-3210", 500);

        // Mostramos información inicial
        cuenta1.mostrarInfo();
        cuenta2.mostrarInfo();

        // Operaciones en cuenta1
        System.out.println("--- Operaciones en cuenta de Juan ---");
        cuenta1.consultarSaldo();

        System.out.println("\n1. Intentando ingresar 200€:");
        cuenta1.ingresar(200);

        System.out.println("\n2. Intentando retirar 300€:");
        cuenta1.retirar(300);

        System.out.println("\n3. Intentando retirar 2000€ (más del saldo):");
        cuenta1.retirar(2000);

        System.out.println("\n4. Intentando ingresar cantidad negativa:");
        cuenta1.ingresar(-50);

        System.out.println("\n5. Intentando retirar cantidad negativa:");
        cuenta1.retirar(-100);

        // Transferencia entre cuentas
        System.out.println("\n--- Transferencia ---");
        System.out.println("Transferir 400€ de Juan a María:");
        cuenta1.transferir(cuenta2, 400);

        // Estado final
        System.out.println("\n--- ESTADO FINAL ---");
        cuenta1.consultarSaldo();
        cuenta2.consultarSaldo();

        // Intentar transferencia sin saldo suficiente
        System.out.println("\n--- Transferencia sin saldo suficiente ---");
        System.out.println("Transferir 1000€ de Juan a María:");
        cuenta1.transferir(cuenta2, 1000);

        // Crear cuenta con saldo negativo
        System.out.println("\n--- Crear cuenta con saldo inicial negativo ---");
        CuentaBancaria cuenta3 = new CuentaBancaria("Pedro López", "ES11-1111-1111", -100);
        cuenta3.consultarSaldo();
    }
}