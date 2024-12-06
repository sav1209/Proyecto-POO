public class Asiento {
    public enum ClaseAsiento {
        ECONOMICA,
        EJECUTIVA,
        PRIMERA_CLASE
    }

    private String id;
    private ClaseAsiento clase;
    private boolean ocupado; // Indica si el asiento está reservado

    public Asiento(String id, ClaseAsiento clase, boolean ocupado) {
        this.id = id;
        this.clase = clase;
        this.ocupado = ocupado;
    }

    public String getId() {
        return id;
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
                "Id='" + id + '\'' +
                ", Clase='" + clase + '\'' +
                ", Ocupado=" + ocupado +
                '}';
    }
}
