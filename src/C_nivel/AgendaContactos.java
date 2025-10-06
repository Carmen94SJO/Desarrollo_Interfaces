package C_nivel;

    import java.util.ArrayList;

    /**
     * Clase simple de Agenda de Contactos
     */
    public class AgendaContactos {
        // Lista para guardar los contactos (nombre y teléfono)
        private ArrayList<String> nombres;
        private ArrayList<String> telefonos;

        /**
         * Constructor: crea la agenda vacía
         */
        public AgendaContactos() {
            nombres = new ArrayList<>();
            telefonos = new ArrayList<>();
        }

        /**
         * Agrega un contacto nuevo
         */
        public void agregar(String nombre, String telefono) {
            nombres.add(nombre);
            telefonos.add(telefono);
            System.out.println("✓ Contacto agregado: " + nombre);
        }

        /**
         * Busca contactos por nombre
         */
        public void buscar(String nombre) {
            boolean encontrado = false;

            // Recorremos todos los contactos
            for (int i = 0; i < nombres.size(); i++) {
                // Si el nombre contiene lo que buscamos, lo mostramos
                if (nombres.get(i).toLowerCase().contains(nombre.toLowerCase())) {
                    System.out.println(nombres.get(i) + " - " + telefonos.get(i));
                    encontrado = true;
                }
            }

            if (!encontrado) {
                System.out.println("No se encontró ningún contacto");
            }
        }

        /**
         * Elimina un contacto por nombre exacto
         */
        public void eliminar(String nombre) {
            // Buscamos el contacto
            for (int i = 0; i < nombres.size(); i++) {
                if (nombres.get(i).equalsIgnoreCase(nombre)) {
                    nombres.remove(i);
                    telefonos.remove(i);
                    System.out.println("✓ Contacto eliminado");
                    return;
                }
            }
            System.out.println("No se encontró el contacto");
        }

        /**
         * Muestra todos los contactos
         */
        public void listar() {
            if (nombres.isEmpty()) {
                System.out.println("La agenda está vacía");
                return;
            }

            System.out.println("\n=== CONTACTOS ===");
            for (int i = 0; i < nombres.size(); i++) {
                System.out.println((i + 1) + ". " + nombres.get(i) + " - " + telefonos.get(i));
            }
            System.out.println();
        }

        /**
         * Devuelve el número total de contactos
         */
        public int total() {
            return nombres.size();
        }

        /**
         * Programa de prueba
         */
        public static void main(String[] args) {
            AgendaContactos agenda = new AgendaContactos();

            // Agregar contactos
            System.out.println("--- Agregando contactos ---");
            agenda.agregar("Juan Pérez", "666111222");
            agenda.agregar("María García", "666333444");
            agenda.agregar("Carlos López", "666555666");
            agenda.agregar("Ana Martínez", "666777888");

            // Listar todos
            System.out.println("\n--- Listando todos ---");
            agenda.listar();

            // Buscar contactos
            System.out.println("--- Buscando 'mar' ---");
            agenda.buscar("mar");

            System.out.println("\n--- Buscando 'Juan' ---");
            agenda.buscar("Juan");

            // Eliminar contacto
            System.out.println("\n--- Eliminando 'Carlos López' ---");
            agenda.eliminar("Carlos López");

            // Listar después de eliminar
            System.out.println("\n--- Listando después de eliminar ---");
            agenda.listar();

            // Total de contactos
            System.out.println("Total de contactos: " + agenda.total());
        }
    }
