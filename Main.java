import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    private static final Aeropuerto aeropuerto = Aeropuerto.AEROPUERTO_PRINCIPAL;

    private static CrudService<Aeropuerto> aeropuertosDestino = new CrudService<>(Aeropuerto.class);
    private static CrudService<Pasajero> pasajeros = new CrudService<>(Pasajero.class);
    private static CrudService<Empleado> empleados = new CrudService<>(Empleado.class);
    private static CrudService<Vuelo> vuelos = new CrudService<>(Vuelo.class);
    private static CrudService<Avion> aviones = new CrudService<>(Avion.class);

    static {
        // Aeropuertos destino por defecto
        aeropuertosDestino.create(new Aeropuerto(
                "Aeropuerto Internacional de la Ciudad de México",
                "Ciudad de México"
        ));
        aeropuertosDestino.create(new Aeropuerto(
                "Aeropuerto Internacional de Cancún",
                "Cancún"
        ));
        aeropuertosDestino.create(new Aeropuerto(
                "Aeropuerto Internacional de Monterrey",
                "Monterrey"
        ));
        aeropuertosDestino.create(new Aeropuerto(
                "Aeropuerto Internacional de Guadalajara",
                "Guadalajara"
        ));
        aeropuertosDestino.create(new Aeropuerto(
                "Aeropuerto Internacional de Los Ángeles",
                "Los Ángeles"
        ));
        aeropuertosDestino.create(new Aeropuerto(
                "Aeropuerto Internacional de Tijuana",
                "Tijuana"
        ));
        aeropuertosDestino.create(new Aeropuerto(
                "Aeropuerto Internacional de Miami",
                "Miami"
        ));
        aeropuertosDestino.create(new Aeropuerto(
                "Aeropuerto Internacional de Houston",
                "Houston"
        ));
        aeropuertosDestino.create(new Aeropuerto(
                "Aeropuerto Internacional de Nueva York",
                "Nueva York"
        ));
        aeropuertosDestino.create(new Aeropuerto(
                "Aeropuerto Internacional de Mérida",
                "Mérida"
        ));


        // Aviones por defecto
        aviones.create(new Avion(
                "Boeing 737",
                150
        ));

        aviones.create(new Avion(
                "Airbus A320",
                180
        ));

        aviones.create(new Avion(
                "Embraer E190",
                100
        ));

        aviones.create(new Avion(
                "Boeing 777",
                350
        ));

        aviones.create(new Avion(
                "Airbus A380",
                500
        ));



        // Personas por defecto
        pasajeros.create(new Pasajero(
                "Juan Pérez",
                "Calle Ficticia 123, Ciudad",
                "01/05/1985",
                'M',
                "P1234567"
        ));

        pasajeros.create(new Pasajero(
                "María Gómez",
                "Avenida Principal 456, Ciudad",
                "23/07/1992",
                'F',
                "P7654321"
        ));

        pasajeros.create(new Pasajero(
                "Carlos López",
                "Calle Secundaria 789, Ciudad",
                "15/03/1980",
                'M',
                "P1122334"
        ));

        pasajeros.create(new Pasajero(
                "Laura Martínez",
                "Calle Norte 321, Ciudad",
                "10/11/1990",
                'F',
                "P4455667"
        ));

        pasajeros.create(new Pasajero(
                "Pedro Sánchez",
                "Calle Sur 555, Ciudad",
                "30/09/1987",
                'M',
                "P9988776"
        ));



        // Empleados por defecto
        empleados.create(new Empleado(
                "Fermin Pérez",
                "Avenida Siempre Viva 123",
                "12/06/1985",
                'M',
                Empleado.Puesto.PILOTO,
                Empleado.Turno.PRIMERO,
                85000.0
        ));

        empleados.create(new Empleado(
                "Renata González",
                "Calle Luna 456",
                "25/04/1990",
                'F',
                Empleado.Puesto.AZAFATA,
                Empleado.Turno.SEGUNDO,
                45000.0
        ));

        empleados.create(new Empleado(
                "Pedro Rodríguez",
                "Boulevard Sol 789",
                "18/09/1978",
                'M',
                Empleado.Puesto.MANTENIMIENTO,
                Empleado.Turno.TERCERO,
                35000.0
        ));

        empleados.create(new Empleado(
                "Laura Martínez",
                "Calle Sol 321",
                "09/11/1992",
                'F',
                Empleado.Puesto.PERSONAL_DE_TIERRA,
                Empleado.Turno.PRIMERO,
                28000.0
        ));

        empleados.create(new Empleado(
                "José González",
                "Avenida Central 987",
                "30/01/1987",
                'M',
                Empleado.Puesto.ADMINISTRATIVO,
                Empleado.Turno.SEGUNDO,
                40000.0
        ));

    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== MENÚ PRINCIPAL =====");
            System.out.println("1. ADMINISTRACION DE AVIONES");
            System.out.println("2. ADMINISTRACION DE VUELOS");
            System.out.println("3. ADMINISTRACION DE PASAJEROS");
            System.out.println("4. ADMINISTRACION DE EMPLEADOS");
            System.out.println("5. SALIR");
            System.out.print("Elige una opcion: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    menuAviones();
                    break;
                case 2:
                    menuVuelos();
                    break;
                case 3:
                    menuPasajeros();
                    break;
                case 4:
                    menuEmpleados();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción no válida. Intenta nuevamente.");
            }
        }
    }

    // Menu de aviones
    private static void menuAviones() {
        while (true) {
            System.out.println("\n===== MENÚ DE AVIONES =====");
            System.out.println("1. Agregar un avión.");
            System.out.println("2. Remover un avión.");
            System.out.println("3. Actualizar avion");
            System.out.println("4. Imprimir todos los aviones.");
            System.out.println("5. Regresar al menu principal.");
            System.out.print("Elige una opcion: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    crearAvion();
                    break;
                case 2:
                    eliminarAvion();
                    break;
                case 3:
                    System.out.print("Ingrese el ID del avión a actualizar: ");
                    aviones.updateEntity(scanner.nextLine());
                    break;
                case 4:
                    aviones.printAll();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opción no válida. Intenta nuevamente.");
            }
        }
    }

    // Menu de vuelos
    private static void menuVuelos() {
        while (true) {
            System.out.println("\n===== MENÚ DE VUELOS =====");
            System.out.println("1. Crear un vuelo.");
            System.out.println("2. Eliminar un vuelo.");
            System.out.println("3. Agregar pasajeros a un vuelo.");
            System.out.println("4. Actualizar un vuelo.");
            System.out.println("5. Imprimir todos los vuelos.");
            System.out.println("6. Imprimir los pasajeros de un vuelo.");
            System.out.println("7. Regresar al menu principal.");
            System.out.print("Elige una opcion: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    crearVuelo();
                    break;
                case 2:
                    eliminarVuelo();
                    break;
                case 3:
                    agregarPasajeroVuelo();
                    break;
                case 4:
                    System.out.print("Ingrese el ID del vuelo a actualizar: ");
                    vuelos.updateEntity(scanner.nextLine());
                    break;
                case 5:
                    vuelos.printAll();
                    break;
                case 6:
                    System.out.println("Vuelos actuales");
                    vuelos.printAll();
                    System.out.print("Ingrese el ID del vuelo: ");
                    String id = scanner.nextLine();
                    Vuelo vueloEncontrado = vuelos.find(id).orElse(null); // Si no se encuentra, retorna null
                    if (vueloEncontrado == null) {
                        System.out.println("El vuelo con el ID ingresado no existe.");
                    } else {
                        Pasajero.printHdrs();
                        for (Pasajero pasajero : vueloEncontrado.getPasajeros()) {
                            pasajero.print();
                        }
                    }
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Opción no válida. Intenta nuevamente.");
            }
        }
    }

    // Menu de pasajeros
    private static void menuPasajeros() {
        while (true) {
            System.out.println("\n===== MENÚ DE PASAJEROS =====");
            System.out.println("1. Agregar un pasajero.");
            System.out.println("2. Actualizar pasajero");
            System.out.println("3. Imprimir todos los pasajeros.");
            System.out.println("4. Regresar al menu principal.");
            System.out.print("Elige una opcion: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    crearPasajero();
                    break;
                case 2:
                    System.out.print("Ingrese el ID del pasajero a actualizar: ");
                    pasajeros.updateEntity(scanner.nextLine());
                    break;
                case 3:
                    pasajeros.printAll();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opción no válida. Intenta nuevamente.");
            }
        }
    }

    // Menu de empleados
    private static void menuEmpleados() {
        while (true) {
            System.out.println("\n===== MENÚ DE EMPLEADOS =====");
            System.out.println("1. Agregar un empleado.");
            System.out.println("2. Actualizar un empleado.");
            System.out.println("3. Imprimir todos los empleados.");
            System.out.println("4. Regresar al menu principal.");
            System.out.print("Elige una opcion: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    crearVuelo();
                    break;
                case 2:
                    System.out.print("Ingrese el ID del empleado a actualizar: ");
                    empleados.updateEntity(scanner.nextLine());
                    break;
                case 3:
                    empleados.printAll();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opción no válida. Intenta nuevamente.");
            }
        }
    }


    /* *
     * Avion
     * */
    // Crear un nuevo avión
    private static void crearAvion() {
        System.out.print("Ingrese el modelo del avión: ");
        String modelo = scanner.nextLine();
        System.out.print("Ingrese la capacidad de pasajeros: ");
        int capacidad = scanner.nextInt();
        scanner.nextLine();

        aviones.create(new Avion(modelo, capacidad));
        System.out.println("El avión ha sido creado satisfactoriamente.");
    }

    private static void eliminarAvion() {
        System.out.print("Ingrese el ID del avión a eliminar: ");
        String idAvion = scanner.nextLine();
        Avion avionEncontrado = aviones.find(idAvion).orElse(null); // Si no se encuentra, retorna null
        if (avionEncontrado == null) {
            System.out.println("El avion con el ID ingresado no existe.");
        } else {
            aviones.delete(idAvion);
            System.out.println("El avion ha sido eliminado correctamente.");
        }
    }


    /*
     * Vuelo
     */
    // Crear un nuevo vuelo
    private static void crearVuelo() {
        // Elegir aeropuerto de destino
        Aeropuerto aeropuertoEncontrado;
        System.out.println("Aeropuertos de destino disponibles:");
        aeropuertosDestino.printAll();

        while (true) {
            System.out.print("Ingrese el ID del aeropuerto de destino: ");
            String idAeropuerto = scanner.nextLine();

            aeropuertoEncontrado = aeropuertosDestino.find(idAeropuerto).orElse(null);

            if (aeropuertoEncontrado != null) {
                System.out.println("Aeropuerto encontrado: " + aeropuertoEncontrado);
                break;
            } else {
                System.out.println("No se encontró el aeropuerto, vuelva a intentar.");
            }
        }

        // Elegir avión asignado
        System.out.println("Aviones disponibles:");
        aviones.printAll();
        Avion avionEncontrado;
        while (true) {
            System.out.print("Ingrese el ID del avión asignado: ");
            String idAvion = scanner.nextLine();

            avionEncontrado = aviones.find(idAvion).orElse(null); // Si no se encuentra, retorna null

            // Usar el avión encontrado
            if (avionEncontrado != null) {
                System.out.println("Avión encontrado: " + avionEncontrado);
                break;
            } else {
                System.out.println("Avión no encontrado, vuelva a intentar");
            }
        }

        // Ingresar fechas y horas de salida y llegada
        System.out.print("Ingrese el horario de salida (formato: dd/MM/yyyy HH:mm): ");
        String horaSalida = scanner.nextLine();
        System.out.print("Ingrese el horario de llegada (formato: dd/MM/yyyy HH:mm): ");
        String horaLlegada = scanner.nextLine();

        try {
            Vuelo vuelo = new Vuelo(aeropuertoEncontrado, avionEncontrado, horaSalida, horaLlegada);
            vuelos.create(vuelo);
            System.out.println("Vuelo creado satisfactoriamente");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear el vuelo: " + e.getMessage());
        }
    }

    private static void eliminarVuelo() {
        System.out.print("Ingrese el ID del vuelo a eliminar: ");
        String id = scanner.nextLine();
        Vuelo vueloEncontrado = vuelos.find(id).orElse(null); // Si no se encuentra, retorna null
        if (vueloEncontrado == null) {
            System.out.println("El vuelo con el ID ingresado no existe.");
        } else {
            // Desasigna los asientos a los pasajeros
            for (Pasajero pasajero : vueloEncontrado.getPasajeros()) {
                pasajero.setAsientoAsignado(null);
            }
            // Desasigna los asientos del avion
            vueloEncontrado.getAvion().desasignarAsientos();

            vuelos.delete(id);
            System.out.println("El vuelo ha sido eliminado correctamente.");
        }
    }

    private static void agregarPasajeroVuelo() {
        System.out.println("Vuelos disponibles:");
        vuelos.printAll();

        System.out.print("Ingrese el ID del vuelo: ");
        String id = scanner.nextLine();
        Vuelo vueloEncontrado = vuelos.find(id).orElse(null); // Si no se encuentra, retorna null
        if (vueloEncontrado == null) {
            System.out.println("No se encontro el vuelo con el ID proporcionado.");
            return;
        }

        System.out.println("Pasajeros disponibles:");
        pasajeros.printAll();
        System.out.print("Ingrese el ID del pasajero: ");
        id = scanner.nextLine();
        Pasajero pasajero = pasajeros.find(id).orElse(null);
        if (pasajero == null) {
            System.out.println("No se encontro el pasajero con el ID proporcionado.");
            return;
        }


        int opcionAsiento;
        do {
            System.out.print("Ingrese su clase de asiento (1: ECONOMICA, 2: EJECUTIVA, 3: PRIMERA CLASE): ");
            opcionAsiento = scanner.nextInt();
            scanner.nextLine();

            if (opcionAsiento < 1 || opcionAsiento > 3) {
                System.out.println("Opcion invalida vuelva a intentar.");
            }
        } while (opcionAsiento < 1 || opcionAsiento > 3);

        Asiento.ClaseAsiento tipoAsiento = null;
        switch(opcionAsiento) {
            case 1:
                tipoAsiento = Asiento.ClaseAsiento.ECONOMICA;
                break;
            case 2:
                tipoAsiento = Asiento.ClaseAsiento.EJECUTIVA;
                break;
            case 3:
                tipoAsiento = Asiento.ClaseAsiento.PRIMERA_CLASE;
                break;
        }

        ArrayList<Asiento> asientos = vueloEncontrado.getAvion().getAsientos();
        boolean asientoEncontrado = false;
        for (int i = 0; i < asientos.size(); i++) {
            Asiento asiento = asientos.get(i);
            if (asiento.getClase() == tipoAsiento && (!asiento.isOcupado())) {
                asiento.setOcupado(true);
                asientoEncontrado = true;
                pasajero.setAsientoAsignado(asiento);
                System.out.println("Se le ha asignado el asiento " + asiento.getId() + " al pasajero");
                break;
            }
        }

        if (!asientoEncontrado) {
            System.out.println("No se encontró un asiento del tipo solicitado. El pasajero no se agregara al vuelo.");
            return;
        }

        vueloEncontrado.agregarPasajero(pasajero);
        System.out.println("El pasajero se ha agregado satisfactoriamente.");
    }

    /*
     * Pasajero
     */
    // Crear un nuevo pasajero
    private static void crearPasajero() {
        System.out.print("Ingrese el nombre del pasajero: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el domicilio del pasajero: ");
        String domicilio = scanner.nextLine();
        System.out.print("Ingrese la fecha de nacimiento del pasajero (formato: dd/mm/aaaa): ");
        String fechaNacimiento = scanner.nextLine();
        System.out.print("Ingrese el sexo del pasajero (M/F): ");
        char sexo = scanner.nextLine().toUpperCase().charAt(0);
        System.out.print("Ingrese el numero de pasaporte del pasajero: ");
        String numeroPasaporte = scanner.nextLine();

        Pasajero pasajero = new Pasajero(nombre, domicilio, fechaNacimiento, sexo, numeroPasaporte);
        System.out.println("El pasajero se ha creado satisfactoriamente.");
        pasajeros.create(pasajero);
    }

    /*
     * Empleado
     */
    // Crear un nuevo pasajero
    private static void crearEmpleado() {
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el domicilio del empleado: ");
        String domicilio = scanner.nextLine();
        System.out.print("Ingrese la fecha de nacimiento del empleado (formato: dd/mm/aaaa): ");
        String fechaNacimiento = scanner.nextLine();
        System.out.print("Ingrese el sexo del empleado (M/F): ");
        char sexo = scanner.nextLine().toUpperCase().charAt(0);

        Empleado.Puesto[] puestos = {Empleado.Puesto.PILOTO, Empleado.Puesto.AZAFATA, Empleado.Puesto.PERSONAL_DE_TIERRA, Empleado.Puesto.MANTENIMIENTO, Empleado.Puesto.ADMINISTRATIVO};
        int puesto;
        do {
            System.out.print("Puestos disponibles:");
            System.out.println("1. Piloto");
            System.out.println("2. Azafata");
            System.out.println("3. Personal de tierra");
            System.out.println("4. Mantenimiento");
            System.out.println("5. Administrativo");
            System.out.print("Ingrese el puesto del empleado: ");
            puesto = scanner.nextInt();
            scanner.nextLine();

            if (puesto < 1 || puesto > 5) {
                System.out.println("Opcion invalida, vuelva a intentar.");
            }
        } while (puesto < 1 || puesto > 5);

        Empleado.Turno[] turnos = {Empleado.Turno.PRIMERO, Empleado.Turno.SEGUNDO, Empleado.Turno.TERCERO};
        int turno;
        do {
            System.out.print("Turnos disponibles:");
            System.out.println("1. Primero");
            System.out.println("2. Segundo");
            System.out.println("3. Tercero");
            System.out.print("Ingrese el turno del empleado: ");
            turno = scanner.nextInt();
            scanner.nextLine();

            if (turno < 1 || turno > 3) {
                System.out.println("Opcion invalida, vuelva a intentar.");
            }
        } while (turno < 1 || turno > 3);

        System.out.println("Ingrese el salario del empleado: ");
        double sueldo = scanner.nextDouble();
        scanner.nextLine();

        Empleado empleado = new Empleado(nombre, domicilio, fechaNacimiento, sexo, puestos[puesto - 1], turnos[turno - 1], sueldo);
        empleados.create(empleado);
        System.out.println("El empleado se ha creado satisfactoriamente.");
    }

}
