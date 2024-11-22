public class Reserva<T> {
    private T itemReservado;
    private Pasajero pasajero;

    public Reserva(T itemReservado, Pasajero pasajero) {
        this.itemReservado = itemReservado;
        this.pasajero = pasajero;
    }

    public T getItemReservado() {
        return itemReservado;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void realizarReserva() {
        System.out.println("Reserva realizada para: " + pasajero.getNombre() + " en " + itemReservado.toString());
    }
}
