import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Vuelo implements Administrable {
    // Variable estática para generar IDs únicos automáticamente
    private static final AtomicInteger contadorId = new AtomicInteger(1);

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private String id;
    private Aeropuerto destino; // El origen es implícito, siempre es Aeropuerto.AEROPUERTO_PRINCIPAL
    private Avion avion; // Avión asignado al vuelo
    private LocalDateTime horaSalida; // Hora de salida del vuelo
    private LocalDateTime horaLlegada; // Hora de llegada del vuelo
    private ArrayList<Pasajero> pasajeros = new ArrayList<>();

    // Constructor
    public Vuelo(Aeropuerto destino, Avion avion, String horaSalida, String horaLlegada) {
        this.id = "VUE" + contadorId.getAndIncrement(); // Generación automática del ID;

        this.destino = destino;
        this.avion = avion;

        // Convertir las fechas de salida y llegada de String a LocalDateTime
        LocalDateTime salida = convertirStringAHora(horaSalida);
        LocalDateTime llegada = convertirStringAHora(horaLlegada);

        // Validar que las fechas sean correctas
        if (!esFechaValida(salida, llegada)) {
            throw new IllegalArgumentException("Las fechas no son válidas. La hora de salida debe ser anterior a la hora de llegada y ambas deben ser en el futuro.");
        }

        this.horaSalida = salida;
        this.horaLlegada = llegada;
    }

    // Método para convertir el String en LocalDateTime
    private LocalDateTime convertirStringAHora(String hora) {
        return LocalDateTime.parse(hora, formatter);
    }

    // Validación de fechas y horas
    private boolean esFechaValida(LocalDateTime horaSalida, LocalDateTime horaLlegada) {
        // La fecha de salida debe ser en el futuro
        if (horaSalida.isBefore(LocalDateTime.now())) {
            System.out.println("La hora de salida debe ser en el futuro.");
            return false;
        }

        // La fecha de llegada debe ser en el futuro
        if (horaLlegada.isBefore(LocalDateTime.now())) {
            System.out.println("La hora de llegada debe ser en el futuro.");
            return false;
        }

        // La hora de salida debe ser anterior a la hora de llegada
        if (horaSalida.isAfter(horaLlegada)) {
            System.out.println("La hora de salida debe ser anterior a la hora de llegada.");
            return false;
        }

        return true;
    }

    // Getter y Setter para el código de vuelo
    public String getId() {
        return id;
    }

    public void setId(String codigoVuelo) {
        this.id = codigoVuelo;
    }

    // Getter y Setter para el destino
    public Aeropuerto getDestino() {
        return destino;
    }

    public void setDestino(Aeropuerto destino) {
        this.destino = destino;
    }

    // Getter y Setter para el avión
    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    // Getter y Setter para la hora de salida
    public LocalDateTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horario) {
        try {
            // Intentar parsear el horario con el formato especificado
            LocalDateTime nuevaHoraSalida = LocalDateTime.parse(horario, formatter);

            // Validar que la hora de salida no sea en el pasado
            if (nuevaHoraSalida.isBefore(LocalDateTime.now())) {
                System.out.println("El horario no puede estar en el pasado.");
                return;
            }

            // Actualizar el atributo si el horario es válido
            this.horaSalida = nuevaHoraSalida;
            System.out.println("Horario actualizado correctamente.");
        } catch (DateTimeParseException e) {
            // Capturar errores de formato
            System.out.println("Horario inválido. Por favor, use el formato 'dd/MM/yyyy HH:mm'.");
        }
    }

    // Getter y Setter para la hora de llegada
    public LocalDateTime getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horario) {
        try {
            // Intentar parsear el horario con el formato especificado
            LocalDateTime nuevaHoraLlegada = LocalDateTime.parse(horario, formatter);

            // Validar que la hora de llegada sea posterior a la hora de salida
            if (horaSalida != null && nuevaHoraLlegada.isBefore(horaSalida)) {
                System.out.println("La hora de llegada no puede ser anterior a la hora de salida.");
                return;
            }

            // Actualizar el atributo si el horario es válido
            this.horaLlegada = nuevaHoraLlegada;
            System.out.println("Hora de llegada actualizada correctamente.");
        } catch (DateTimeParseException e) {
            // Capturar errores de formato
            System.out.println("Horario inválido. Por favor, use el formato 'dd/MM/yyyy HH:mm'.");
        }
    }

    @Override
    public String toString() {
        return "Vuelo{" +
                "codigoVuelo='" + id + '\'' +
                ", destino=" + destino.getNombre() +
                ", avion=" + avion.getModelo() +
                ", horaSalida=" + horaSalida.format(formatter) +
                ", horaLlegada=" + horaLlegada.format(formatter) +
                '}';
    }

    public ArrayList<Pasajero> getPasajeros() {
        return pasajeros;
    }

    public void agregarPasajero(Pasajero p) {
        pasajeros.add(p);
    }

    public void mostrarPasajeros() {
        for (Pasajero p: pasajeros) {
            System.out.println(p);
        }
    }

    @Override
    public void print() {
        System.out.printf("%-5s %-50s %-10s %-20s %-20s\n",
                id, destino.getNombre(), avion.getId(), horaSalida.format(formatter), horaLlegada.format(formatter)
        );
    }

    public static void printHdrs() {
        System.out.printf("%-5s %-50s %-10s %-20s %-20s\n",
            "ID", "DESTINO", "AVION", "HORARIO SALIDA", "HORARIO LLEGADA"
        );
    }

    public void update() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        while (true) {
            System.out.println("Atributos disponibles para actualizar");
            System.out.println("1. Hora de salida");
            System.out.println("2. Hora de llegada");
            System.out.println("3. Salir de la actualizacion");
            System.out.print("Opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el horario de salida (formato: dd/MM/yyyy HH:mm): ");
                    setHoraSalida(scanner.nextLine());
                    scanner.nextLine();
                    break;
                case 2:
                    System.out.print("Ingrese el horario de llegada (formato: dd/MM/yyyy HH:mm): ");
                    setHoraLlegada(scanner.nextLine());
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
