import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Aeropuerto aeropuerto = Aeropuerto.AEROPUERTO_PRINCIPAL;

    public static void main(String[] args) {
        while (true) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    // Crear un nuevo avión
                    crearAvion();
                    break;
                case 2:
                    // Crear un nuevo vuelo
                    crearVuelo();
                    break;
                case 3:
                    // Crear un nuevo pasajero
                    crearPasajero();
                    break;
                case 4:
                    // Mostrar vuelos registrados
                    mostrarVuelos();
                    break;
                case 5:
                    // Mostrar pasajeros registrados
                    mostrarPasajeros();
                    break;
                case 6:
                    // Realizar una reserva
                    realizarReserva();
                    break;
                case 7:
                    // Salir del programa
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción no válida. Intenta nuevamente.");
            }
        }
    }

    // Mostrar el menú
    private static void mostrarMenu() {
        System.out.println("\n===== MENÚ =====");
        System.out.println("1. Crear avión");
        System.out.println("2. Crear vuelo");
        System.out.println("3. Crear pasajero");
        System.out.println("4. Mostrar vuelos");
        System.out.println("5. Mostrar pasajeros");
        System.out.println("6. Realizar una reserva");
        System.out.println("7. Salir");
        System.out.print("Elige una opción: ");
    }

    // Crear un nuevo avión
    private static void crearAvion() {
        System.out.print("Ingrese el código del avión: ");
        String codigo = scanner.nextLine();
        System.out.print("Ingrese el modelo del avión: ");
        String modelo = scanner.nextLine();
        System.out.print("Ingrese la capacidad de pasajeros: ");
        int capacidad = scanner.nextInt();
        scanner.nextLine();

        Avion avion = new Avion(codigo, modelo, capacidad);
        System.out.println("Avión creado: " + avion.getModelo());
    }

    // Crear un nuevo vuelo
    private static void crearVuelo() {
        System.out.print("Ingrese el código del vuelo: ");
        String codigoVuelo = scanner.nextLine();

        // Elegir aeropuerto de destino
        System.out.print("Ingrese el nombre del aeropuerto de destino: ");
        String destino = scanner.nextLine();
        Aeropuerto aeropuertoDestino = new Aeropuerto(destino, "Ubicación desconocida");

        // Elegir avión asignado
        System.out.print("Ingrese el código del avión asignado: ");
        String codigoAvion = scanner.nextLine();
        // Aquí, deberías obtener el avión de una lista existente, pero por simplicidad se asume que existe.
        Avion avion = new Avion(codigoAvion, "Modelo Avión", 200);

        // Ingresar fechas y horas de salida y llegada
        System.out.print("Ingrese la hora de salida (formato: yyyy-MM-dd HH:mm): ");
        String horaSalida = scanner.nextLine();
        System.out.print("Ingrese la hora de llegada (formato: yyyy-MM-dd HH:mm): ");
        String horaLlegada = scanner.nextLine();

        try {
            Vuelo vuelo = new Vuelo(codigoVuelo, aeropuertoDestino, avion, horaSalida, horaLlegada);
            System.out.println("Vuelo creado: " + vuelo.mostrarInformacion());
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear el vuelo: " + e.getMessage());
        }
    }

    // Crear un nuevo pasajero
    private static void crearPasajero() {
        System.out.print("Ingrese el ID del pasajero: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese el nombre del pasajero: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el domicilio del pasajero: ");
        String domicilio = scanner.nextLine();
        System.out.print("Ingrese la fecha de nacimiento del pasajero (formato: dd/mm/aaaa): ");
        String fechaNacimiento = scanner.nextLine();
        System.out.print("Ingrese el sexo del pasajero (M/F): ");
        char sexo = scanner.nextLine().toLowerCase().charAt(0);
        System.out.print("Ingrese el numero de pasaporte del pasajero: ");
        String numeroPasaporte = scanner.nextLine();

        Pasajero pasajero = new Pasajero(id, nombre, domicilio, fechaNacimiento, sexo, numeroPasaporte);
        System.out.println("Pasajero creado: " + pasajero.getNombre());
    }

    // Mostrar vuelos registrados
    private static void mostrarVuelos() {
        System.out.println("\nVuelos registrados:");
        for (Vuelo vuelo : aeropuerto.obtenerVuelos()) {
            System.out.println(vuelo.mostrarInformacion());
        }
    }

    // Mostrar pasajeros registrados
    private static void mostrarPasajeros() {
        // Esto es solo un ejemplo, deberías tener una lista de pasajeros en algún lugar para gestionarlos
        System.out.println("\nPasajeros registrados:");
        // Aquí se debe listar los pasajeros de alguna colección.
    }

    // Realizar una reserva
    private static void realizarReserva() {
        System.out.print("Ingrese el código de vuelo para la reserva: ");
        String codigoVuelo = scanner.nextLine();
        Vuelo vuelo = null;

        // Buscar el vuelo
        for (Vuelo v : aeropuerto.obtenerVuelos()) {
            if (v.getCodigoVuelo().equals(codigoVuelo)) {
                vuelo = v;
                break;
            }
        }

        if (vuelo == null) {
            System.out.println("Vuelo no encontrado.");
            return;
        }

        // Crear un pasajero
        System.out.print("Ingrese el ID del pasajero: ");
        String idPasajero = scanner.nextLine();
        // Aquí se asume que ya existe el pasajero.
        Pasajero pasajero = new Pasajero(idPasajero, "Nombre Pasajero", "Domicilio", "01/01/1990", 'm', "1111");

        // Crear una reserva
        Reserva<Vuelo> reserva = new Reserva<>(vuelo, pasajero);
        reserva.realizarReserva();
    }
}
