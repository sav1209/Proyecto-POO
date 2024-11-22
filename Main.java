import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear un solo aeropuerto principal
        Aeropuerto aeropuertoPrincipal = new Aeropuerto("Aeropuerto Internacional de Ciudad", "Ciudad A");

        // Crear aeropuertos de destino (sin operaciones, solo como destino)
        Aeropuerto aeropuertoDestino1 = new Aeropuerto("Aeropuerto de la Costa", "Ciudad B");
        Aeropuerto aeropuertoDestino2 = new Aeropuerto("Aeropuerto del Norte", "Ciudad C");

        // Crear vuelos desde el aeropuerto principal a los destinos
        Vuelo vuelo1 = new Vuelo("V123", aeropuertoDestino1);
        Vuelo vuelo2 = new Vuelo("V456", aeropuertoDestino2);

        // Crear empleados (que trabajan en el aeropuerto principal)
        Empleado empleado1 = new Empleado("E001", "Juan Pérez", "Calle 123", "01/01/1985", Persona.Sexo.MASCULINO,
                Empleado.Puesto.PILOTO, Empleado.Turno.PRIMERO, 3000.0);
        Empleado empleado2 = new Empleado("E002", "Ana García", "Avenida 456", "12/11/1990", Persona.Sexo.FEMENINO,
                Empleado.Puesto.AZAFATA, Empleado.Turno.SEGUNDO, 2500.0);

        // Crear un pasajero que realiza una reserva en el aeropuerto principal
        Pasajero pasajero1 = new Pasajero("P001", "Carlos López", "Calle 789", "15/08/1992", Persona.Sexo.MASCULINO, "A12345", "Clase A");

        // Mostrar información de las operaciones en el aeropuerto principal
        System.out.println("Información de Aeropuerto Principal:");
        System.out.println(aeropuertoPrincipal);

        System.out.println("\nVuelos disponibles desde " + aeropuertoPrincipal.getNombre() + ":");
        List<Vuelo> vuelos = aeropuertoPrincipal.obtenerVuelos();
        for (Vuelo vuelo : vuelos) {
            System.out.println(vuelo);
        }

        // Mostrar información de los empleados
        System.out.println("\nInformación del empleado (trabajando en el aeropuerto principal):");
        System.out.println(empleado1);
        System.out.println(empleado2);

        // Mostrar información del pasajero
        System.out.println("\nInformación del pasajero:");
        System.out.println(pasajero1.obtenerInformacionPasajero());

        // El pasajero se ha reservado un asiento en un vuelo desde el aeropuerto principal
        // El aeropuerto maneja la operación, por lo que no es necesario otro aeropuerto para este proceso.
    }
}
