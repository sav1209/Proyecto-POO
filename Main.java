public class Main {
    public static void main(String[] args) {
        // Crear un pasajero
        Pasajero pasajero = new Pasajero(
                "P001", "Juan Pérez", "Calle Falsa 123", "20/01/2003", Persona.Sexo.MASCULINO,
                "ABC123456", "12A");

        // Crear un asiento con clase específica y reservarlo
        Asiento asiento = new Asiento("12A", Asiento.ClaseAsiento.ECONOMICA);
        Reserva<Asiento> reservaAsiento = new Reserva<>(asiento, pasajero);
        reservaAsiento.realizarReserva();

        Vuelo vuelo = new Vuelo("A1", new Aeropuerto("Aeropuerto de Mexicalli", "Teolyucan"));
        Reserva<Vuelo> reservaVuelo = new Reserva<>(vuelo, pasajero);
        reservaVuelo.realizarReserva();
    }
}
