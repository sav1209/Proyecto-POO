public class Vuelo {
    private String codigoVuelo;
    private Aeropuerto destino; // El origen es implícito, siempre es el AeropuertoPrincipal

    public Vuelo(String codigoVuelo, Aeropuerto destino) {
        this.codigoVuelo = codigoVuelo;
        this.destino = destino;
        // Aquí no es necesario definir origen, ya que siempre es Aeropuerto.AEROPUERTO_PRINCIPAL
        Aeropuerto.AEROPUERTO_PRINCIPAL.agregarVuelo(this);
    }

    // Getter y Setter para el código de vuelo
    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    // Getter y Setter para el destino
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
                ", destino=" + destino.getNombre() +
                '}';
    }
}
