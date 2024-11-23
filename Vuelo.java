import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Vuelo implements Administrable {
    private String codigoVuelo;
    private Aeropuerto destino; // El origen es implícito, siempre es Aeropuerto.AEROPUERTO_PRINCIPAL
    private Avion avion; // Avión asignado al vuelo
    private LocalDateTime horaSalida; // Hora de salida del vuelo
    private LocalDateTime horaLlegada; // Hora de llegada del vuelo

    // Constructor
    public Vuelo(String codigoVuelo, Aeropuerto destino, Avion avion, String horaSalida, String horaLlegada) {
        this.codigoVuelo = codigoVuelo;
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

        // Asocia el vuelo al aeropuerto principal
        Aeropuerto.AEROPUERTO_PRINCIPAL.agregarVuelo(this);
    }

    // Método para convertir el String en LocalDateTime
    private LocalDateTime convertirStringAHora(String hora) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
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
    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
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

    public void setHoraSalida(LocalDateTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    // Getter y Setter para la hora de llegada
    public LocalDateTime getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(LocalDateTime horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return "Vuelo{" +
                "codigoVuelo='" + codigoVuelo + '\'' +
                ", destino=" + destino.getNombre() +
                ", avion=" + avion.getModelo() +
                ", horaSalida=" + horaSalida.format(formatter) +
                ", horaLlegada=" + horaLlegada.format(formatter) +
                '}';
    }

    @Override
    public void registrar() {
        System.out.println("Registrando vuelo: " + codigoVuelo);
    }

    @Override
    public String mostrarInformacion() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return "Vuelo: " + codigoVuelo + "\nDestino: " + destino.getNombre() +
                "\nAvión: " + avion.getModelo() +
                "\nHora de salida: " + horaSalida.format(formatter) +
                "\nHora de llegada: " + horaLlegada.format(formatter);
    }
}
