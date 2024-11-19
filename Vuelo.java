public class Vuelo {
    private String codigoVuelo;
    private Aeropuerto origen;
    private Aeropuerto destino;

    public Vuelo(String codigoVuelo, Aeropuerto origen, Aeropuerto destino) {
        this.codigoVuelo = codigoVuelo;
        this.origen = origen;
        this.destino = destino;
        // Agregar el vuelo a la lista de vuelos del aeropuerto de origen
        origen.agregarVuelo(this);
    }

    // Métodos Getters y Setters
    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public Aeropuerto getOrigen() {
        return origen;
    }

    public void setOrigen(Aeropuerto origen) {
        this.origen = origen;
    }

    public Aeropuerto getDestino() {
        return destino;
    }

    public void setDestino(Aeropuerto destino) {
        this.destino = destino;
    }

    @Override
    public String toString() {
        return "Vuelo{" +
                "codigoVuelo='" + codigoVuelo + '\'' +
                ", origen=" + origen.getNombre() +
                ", destino=" + destino.getNombre() +
                '}';
    }
}