public class Pasajero extends Persona {

    // Atributos adicionales para Pasajero
    private String numeroPasaporte;
    private Asiento asientoAsignado;

    // Constructor
    public Pasajero(String id, String nombre, String domicilio, String fechaDeNacimiento, char sexo, String numeroPasaporte) {
        super(id, nombre, domicilio, fechaDeNacimiento, sexo);
        this.numeroPasaporte = numeroPasaporte;
        this.asientoAsignado = null;
    }

    public Pasajero(String id, String nombre, String domicilio, String fechaDeNacimiento, char sexo, String numeroPasaporte, Asiento asientoAsignado) {
        super(id, nombre, domicilio, fechaDeNacimiento, sexo);
        this.numeroPasaporte = numeroPasaporte;
        this.asientoAsignado = asientoAsignado;
    }

    // Métodos Getters
    public String getNumeroPasaporte() {
        return numeroPasaporte;
    }

    public Asiento getAsientoAsignado() {
        return asientoAsignado;
    }

    // Método para obtener información del pasajero
    public String obtenerInformacionPasajero() {
        return "Nombre: " + getNombre() +
                "\nNúmero de Pasaporte: " + numeroPasaporte +
                "\nAsiento Asignado: " + (asientoAsignado != null ? asientoAsignado.toString() : "No asignado");
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
                ", Asiento Asignado=" + (asientoAsignado != null ? asientoAsignado.toString() : "No asignado") +
                '}';
    }
}
