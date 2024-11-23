import java.util.ArrayList;
import java.util.List;

public class Avion extends MedioTransporte implements Administrable {
    private int capacidad; // Capacidad total de pasajeros
    private List<Asiento> asientos; // Lista de asientos disponibles en el avión

    public Avion(String id, String modelo, int capacidad) {
        super(id, modelo);
        this.capacidad = capacidad;
        this.asientos = generarAsientos(capacidad); // Genera los asientos al crear el avión
    }

    @Override
    public void iniciar() {
        System.out.println("El avión con ID " + id + " y modelo " + modelo + " ha despegado.");
    }

    // Método para generar una lista de asientos distribuidos por clases
    private List<Asiento> generarAsientos(int capacidad) {
        List<Asiento> asientos = new ArrayList<>();
        int primeraClase = capacidad / 10; // 10% de la capacidad
        int ejecutiva = capacidad / 5;    // 20% de la capacidad
        int economica = capacidad - primeraClase - ejecutiva; // Resto para clase económica

        // Crear asientos de Primera Clase
        for (int i = 1; i <= primeraClase; i++) {
            String codigo = "P" + i; // Ejemplo: P1, P2, ...
            asientos.add(new Asiento(codigo, Asiento.ClaseAsiento.PRIMERA_CLASE, false));
        }

        // Crear asientos de Clase Ejecutiva
        for (int i = 1; i <= ejecutiva; i++) {
            String codigo = "E" + i; // Ejemplo: E1, E2, ...
            asientos.add(new Asiento(codigo, Asiento.ClaseAsiento.EJECUTIVA, false));
        }

        // Crear asientos de Clase Económica
        for (int i = 1; i <= economica; i++) {
            String codigo = "C" + i; // Ejemplo: C1, C2, ...
            asientos.add(new Asiento(codigo, Asiento.ClaseAsiento.ECONOMICA, false));
        }

        return asientos;
    }

    // Getter para la capacidad
    public int getCapacidad() {
        return capacidad;
    }

    // Setter para la capacidad
    public void setCapacidad(int capacidad) {
        if (capacidad > 0) {
            this.capacidad = capacidad;
        } else {
            throw new IllegalArgumentException("La capacidad debe ser mayor que cero.");
        }
    }

    // Obtener la lista de asientos
    public List<Asiento> getAsientos() {
        return asientos;
    }

    @Override
    public String toString() {
        return "Avion{" +
                "modelo='" + modelo + '\'' +
                ", id='" + id + '\'' +
                ", capacidad=" + capacidad +
                '}';
    }

    @Override
    public void registrar() {
        System.out.println("Registrando avión: " + modelo + " (ID: " + id + ")");
    }

    @Override
    public String mostrarInformacion() {
        return "Avión: " + modelo + "\nID: " + id + "\nCapacidad: " + capacidad;
    }
}
