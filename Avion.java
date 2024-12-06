import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Avion extends MedioTransporte implements Administrable {
    // Variable estática para generar IDs únicos automáticamente
    private static final AtomicInteger contadorId = new AtomicInteger(1);

    private int capacidad; // Capacidad total de pasajeros
    private ArrayList<Asiento> asientos; // Lista de asientos disponibles en el avión

    public Avion(String modelo, int capacidad) {
        super("AVI" + contadorId.getAndIncrement(), modelo);
        this.capacidad = capacidad;
        this.asientos = generarAsientos(capacidad); // Genera los asientos al crear el avión
    }

    @Override
    public void iniciar() {
        System.out.println("El avión con ID " + id + " y modelo " + modelo + " ha despegado.");
    }

    // Método para generar una lista de asientos distribuidos por clases
    private ArrayList<Asiento> generarAsientos(int capacidad) {
        ArrayList<Asiento> asientos = new ArrayList<>();
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
    public void desasignarAsientos() {
        asientos.clear();
        generarAsientos(capacidad);
    }

    // Obtener la lista de asientos
    public ArrayList<Asiento> getAsientos() {
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

    // Sobrescribimos el método equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Si es el mismo objeto, son iguales
        if (obj == null || getClass() != obj.getClass()) return false; // Verifica que el objeto no sea nulo y sea de la misma clase
        Avion avion = (Avion) obj; // Conversión segura
        return id != null && id.equals(avion.id); // Compara los IDs
    }

    public void print() {
        System.out.printf("%-5s %-15s %5d\n",
            id, modelo, capacidad
        );
    }

    public static void printHdrs() {
        System.out.printf("%-5s %-15s %5s\n", "ID", "MODELO", "CAPACIDAD");
    }

    public void update() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        while (true) {
            System.out.println("Atributos disponibles para actualizar");
            System.out.println("1. Capacidad");
            System.out.println("2. Modelo");
            System.out.println("3. Salir de la actualizacion");
            System.out.print("Opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la capacidad: ");
                    setCapacidad(scanner.nextInt());
                    scanner.nextLine();
                    break;
                case 2:
                    System.out.print("Ingrese el modelo: ");
                    setModelo(scanner.nextLine());
                    break;
                case 3:
                    System.out.println("Saliendo de la actualización.");
                    return;
                default:
                    System.out.println("Opción invalida, vuelva a intentar.");
            }
        }
    }
}
