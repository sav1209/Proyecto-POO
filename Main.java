import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        // Obtener la fecha y hora actual
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        System.out.println("Fecha y hora actual: " + fechaHoraActual);

        // Crear una fecha y hora específica (por ejemplo, 15 de diciembre de 2024, a las 10:30)
        LocalDateTime fechaHoraEspecifica = LocalDateTime.of(2024, 12, 15, 10, 30);
        System.out.println("Fecha y hora específica: " + fechaHoraEspecifica);

        // Formatear la fecha y hora a un formato personalizado
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String fechaHoraFormateada = fechaHoraEspecifica.format(formato);
        System.out.println("Fecha y hora formateada: " + fechaHoraFormateada);
    }
}
