import java.util.concurrent.atomic.AtomicInteger;

public class Aeropuerto implements Administrable {
    // Variable estática para generar IDs únicos automáticamente
    private static final AtomicInteger contadorId = new AtomicInteger(1);

    public static final Aeropuerto AEROPUERTO_PRINCIPAL = new Aeropuerto("Aeropuerto Internacional MAC", "Estado de México");

    private final String id; // Identificador único generado automáticamente
    private String nombre;
    private String ubicacion;

    // Constructor con parametros
    public Aeropuerto(String nombre, String ubicacion) {
        this.id = "AER" + contadorId.getAndIncrement(); // Generación automática del ID
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    // Métodos Getters (el ID no tendrá setter para mantener la unicidad)
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    // Sobrescribir equals para comparar solo el id
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Comparación por referencia
        if (obj == null || getClass() != obj.getClass()) return false; // Verificación de tipo
        Aeropuerto that = (Aeropuerto) obj;
        return id.equals(that.id); // Comparación de IDs
    }

    // Sobrescribir hashCode para consistencia con equals
    @Override
    public int hashCode() {
        return id.hashCode();
    }

    // Método toString
    @Override
    public String toString() {
        return "Aeropuerto{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }

    public void print() {
        System.out.printf("%-5s %-50s %-15s\n",
            id, nombre, ubicacion
        );
    }

    public static void printHdrs() {
        System.out.printf("%-5s %-50s %-15s\n", "ID", "NOMBRE", "UBICACION");
    }

    public void update() {

    }
}
