public class Pasajero extends Persona {

    // Atributos adicionales para Pasajero
    private String numeroPasaporte;
    private String asientoAsignado;

    // Constructor
    public Pasajero(String id, String nombre, String domicilio, String fechaDeNacimiento, Sexo sexo, String numeroPasaporte, String asientoAsignado) {
        super(id, nombre, domicilio, fechaDeNacimiento, sexo);
        this.numeroPasaporte = numeroPasaporte;
        this.asientoAsignado = asientoAsignado;
    }

    // Métodos Getters
    public String getNumeroPasaporte() {
        return numeroPasaporte;
    }

    public String getAsientoAsignado() {
        return asientoAsignado;
    }

    // Método para obtener información del pasajero
    public String obtenerInformacionPasajero() {
        return "Nombre: " + getNombre() + "\nNúmero de Pasaporte: " + numeroPasaporte + "\nAsiento Asignado: " + asientoAsignado;
    }

    @Override
    public String toString() {
        return "Pasajero {" +
                "ID='" + getId() + '\'' +
                ", Nombre='" + getNombre() + '\'' +
                ", Domicilio='" + getDomicilio() + '\'' +
                ", FechaDeNacimiento=" + getFechaDeNacimiento().format(FORMATO_FECHA) +
                ", Sexo=" + getSexo() +
                ", Número de Pasaporte='" + numeroPasaporte + '\'' +
                ", Asiento Asignado='" + asientoAsignado + '\'' +
                '}';
    }
}
