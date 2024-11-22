public class Asiento {
    public enum ClaseAsiento {
        ECONOMICA,
        EJECUTIVA,
        PRIMERA_CLASE
    }

    private String codigoAsiento;
    private ClaseAsiento clase; // Ejemplo: Económica, Ejecutiva, Primera Clase

    public Asiento(String codigoAsiento, ClaseAsiento clase) {
        this.codigoAsiento = codigoAsiento;
        this.clase = clase;
    }

    public String getCodigoAsiento() {
        return codigoAsiento;
    }

    public ClaseAsiento getClase() {
        return clase;
    }

    @Override
    public String toString() {
        return "Asiento{" +
                "Código='" + codigoAsiento + '\'' +
                ", Clase='" + clase + '\'' +
                '}';
    }
}
