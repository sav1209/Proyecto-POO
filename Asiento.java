public class Asiento {
    public enum ClaseAsiento {
        ECONOMICA,
        EJECUTIVA,
        PRIMERA_CLASE
    }

    private String codigoAsiento;
    private ClaseAsiento clase;
    private boolean ocupado; // Indica si el asiento está reservado

    public Asiento(String codigoAsiento, ClaseAsiento clase, boolean ocupado) {
        this.codigoAsiento = codigoAsiento;
        this.clase = clase;
        this.ocupado = ocupado;
    }

    public String getCodigoAsiento() {
        return codigoAsiento;
    }

    public ClaseAsiento getClase() {
        return clase;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    @Override
    public String toString() {
        return "Asiento{" +
                "Código='" + codigoAsiento + '\'' +
                ", Clase='" + clase + '\'' +
                ", Ocupado=" + ocupado +
                '}';
    }
}
