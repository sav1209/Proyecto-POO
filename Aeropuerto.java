import java.util.ArrayList;
import java.util.List;

public class Aeropuerto {
    public static final Aeropuerto AEROPUERTO_PRINCIPAL = new Aeropuerto("Aeropuerto Internacional MAC", "Estado de México");

    private String nombre;
    private String ubicacion;
    private List<Vuelo> vuelosOrigen; // Lista de vuelos que parten de este aeropuerto

    public Aeropuerto(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.vuelosOrigen = new ArrayList<>();
    }

    // Agregar un vuelo que parte de este aeropuerto
    public void agregarVuelo(Vuelo vuelo) {
        vuelosOrigen.add(vuelo);
    }

    // Obtener lista de vuelos que parten de este aeropuerto
    public List<Vuelo> obtenerVuelos() {
        return vuelosOrigen;
    }

    // Métodos Getters y Setters
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

    @Override
    public String toString() {
        return "Aeropuerto{" +
                "nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }
}
