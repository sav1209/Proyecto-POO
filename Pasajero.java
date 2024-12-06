import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Pasajero extends Persona implements Administrable {
    // Variable estática para generar IDs únicos automáticamente
    private static final AtomicInteger contadorId = new AtomicInteger(1);

    // Atributos adicionales para Pasajero
    private String numeroPasaporte;
    private Asiento asientoAsignado;

    // Constructor
    public Pasajero(String nombre, String domicilio, String fechaDeNacimiento, char sexo, String numeroPasaporte) {
        super("PAS" + contadorId.getAndIncrement(), nombre, domicilio, fechaDeNacimiento, sexo);
        this.numeroPasaporte = numeroPasaporte;
        this.asientoAsignado = null;
    }

    public Pasajero(String nombre, String domicilio, String fechaDeNacimiento, char sexo, String numeroPasaporte, Asiento asientoAsignado) {
        super("PAS" + contadorId.getAndIncrement(), nombre, domicilio, fechaDeNacimiento, sexo);
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

    // Métodos Setters
    public void setNumeroPasaporte(String numeroPasaporte) {
        this.numeroPasaporte = numeroPasaporte;
    }

    public void setAsientoAsignado(Asiento asientoAsignado) {
        this.asientoAsignado = asientoAsignado;
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

    @Override
    public void print() {
        System.out.printf("%-5s %-20s %-5d %-13s %-12s %-13s\n",
            id, nombre, calcularEdad(), sexo, numeroPasaporte, (asientoAsignado != null ? asientoAsignado.toString() : "No asignado")
        );
    }

    public static void printHdrs() {
        System.out.printf("%-5s %-20s %-5s %-13s %-12s %-13s\n",
                "ID", "NOMBRE", "EDAD", "SEXO", "PASAPORTE", "ASIENTO"
        );
    }

    public void update() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        while (true) {
            System.out.println("Atributos disponibles para actualizar");
            System.out.println("1. Nombre");
            System.out.println("2. Domicilio");
            System.out.println("3. Fecha de nacimiento");
            System.out.println("4. Sexo");
            System.out.println("5. Pasaporte");
            System.out.println("6. Salir de la actualizacion");
            System.out.print("Opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre: ");
                    setNombre(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Ingrese el domicilio: ");
                    setDomicilio(scanner.nextLine());
                    break;
                case 3:
                    System.out.print("Ingrese la fecha de nacimiento del pasajero (formato: dd/mm/aaaa): ");
                    setFechaDeNacimiento(scanner.nextLine());
                    break;
                case 4:
                    System.out.print("Ingrese el sexo: ");
                    setSexo(scanner.nextLine().charAt(0));
                    break;
                case 5:
                    System.out.print("Ingrese el pasaporte: ");
                    setNumeroPasaporte(scanner.nextLine());
                    break;
                case 6:
                    System.out.println("Saliendo de la actualización.");
                    return;
                default:
                    System.out.println("Opción invalida, vuelva a intentar.");
            }
        }
    }
}
