package Proyecto_DI;

// Clase que representa un contacto individual
class Contacto {
    private String nombre;
    private String telefono;
    private String email;

    // Constructor: inicializa un contacto con sus datos
    public Contacto(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    // Getters: métodos para obtener los valores de los atributos
    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    // Setters: métodos para modificar los valores de los atributos
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Convierte el contacto a formato CSV (separado por comas)
    public String toCSV() {
        return nombre + "," + telefono + "," + email;
    }

    // Método toString para mostrar el contacto de forma legible
    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Teléfono: " + telefono + " | Email: " + email;
    }
}
