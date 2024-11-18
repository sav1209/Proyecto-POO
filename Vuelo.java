public class Vuelo {
    // Atributos de la clase Vuelo
    private String origen;
    private String destino;
    private String fechaSalida;
    private String horaSalida;
    private String id;
    private String[] pasajeros;
    private String tripulacion;
    private String avion;
    private double costo;

    // Constructor vacío (opcional)
    public Vuelo() {
    }

    // Constructor con parámetros (opcional, si se desea)
    public Vuelo(String origen, String destino, String fechaSalida, String horaSalida, String id,
                 String[] pasajeros, String tripulacion, String avion, double costo) {
        this.origen = origen;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.horaSalida = horaSalida;
        this.id = id;
        this.pasajeros = pasajeros;
        this.tripulacion = tripulacion;
        this.avion = avion;
        this.costo = costo;
    }

}
