import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Persona {
    public enum Sexo {
        MASCULINO, FEMENINO
    }

    // Atributos protegidos
    protected String id;
    protected String nombre;
    protected String domicilio;
    protected LocalDate fechaDeNacimiento; // Usando LocalDate para manejar fechas
    protected Sexo sexo;

    // Crear un formatter para el formato dd/MM/yyyy
    protected static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Constructor vacío
    public Persona() {}

    // Constructor con parámetros
    public Persona(String id, String nombre, String domicilio, String fechaDeNacimiento, char sexo) {
        this.id = id;
        this.nombre = nombre;
        this.domicilio = domicilio;
        switch(sexo) {
            case 'M': this.sexo = Sexo.MASCULINO; break;
            case 'F': this.sexo = Sexo.FEMENINO; break;
        }
        // Convertir la cadena fechaDeNacimiento a LocalDate usando el formato dd/MM/yyyy
        this.fechaDeNacimiento = LocalDate.parse(fechaDeNacimiento, FORMATO_FECHA);
        if (this.fechaDeNacimiento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede estar en el futuro.");
        }
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    // Setters
    public void setId(String id) {
        if (id != null && !id.trim().isEmpty()) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("ID no puede ser nulo o vacío.");
        }
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        } else {
            throw new IllegalArgumentException("Nombre no puede ser nulo o vacío.");
        }
    }

    public void setDomicilio(String domicilio) {
        if (domicilio != null && !domicilio.trim().isEmpty()) {
            this.domicilio = domicilio;
        } else {
            throw new IllegalArgumentException("Domicilio no puede ser nulo o vacío.");
        }
    }

    public void setFechaDeNacimiento(String fecha) {
        try {
            // Parsear la fecha y verificar que no sea en el futuro
            LocalDate fechaParsed = LocalDate.parse(fecha, FORMATO_FECHA);
            if (fechaParsed.isAfter(LocalDate.now())) {
                throw new IllegalArgumentException("La fecha de nacimiento no puede estar en el futuro.");
            }
            this.fechaDeNacimiento = fechaParsed; // Asignar la fecha si es válida
        } catch (DateTimeParseException e) {
            System.out.println("Error: Formato de fecha inválido. Use el formato " + FORMATO_FECHA.toString());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void setSexo(char sexo) {
        // Convertir el carácter a mayúsculas para que no sea case-sensitive
        char sexoMayus = Character.toUpperCase(sexo);

        // Determinar el valor de Sexo en función del carácter
        switch (sexoMayus) {
            case 'M':
                this.sexo = Sexo.MASCULINO;
                System.out.println("Sexo actualizado a Masculino.");
                break;
            case 'F':
                this.sexo = Sexo.FEMENINO;
                System.out.println("Sexo actualizado a Femenino.");
                break;
            default:
                System.out.println("Entrada no válida. Sexo no actualizado. Use 'M' o 'F'.");
                break;
        }
    }

    // Metodo para calcular la edad de la persona
    public int calcularEdad() {
        if (fechaDeNacimiento == null) {
            throw new IllegalStateException("La fecha de nacimiento no está definida.");
        }
        LocalDate hoy = LocalDate.now();
        return Period.between(fechaDeNacimiento, hoy).getYears();
    }

    // Metodo para obtener información
    public String obtenerInformacion() {
        return "ID: " + id + "\nNombre: " + nombre + "\nDomicilio: " + domicilio +
                "\nFecha de Nacimiento: " + fechaDeNacimiento.format(FORMATO_FECHA) + "\nSexo: " + sexo;
    }

    // Metodo toString
    @Override
    public String toString() {
        return "Persona {" +
                "ID='" + id + '\'' +
                ", Nombre='" + nombre + '\'' +
                ", Domicilio='" + domicilio + '\'' +
                ", FechaDeNacimiento=" + fechaDeNacimiento.format(FORMATO_FECHA) +
                ", Sexo=" + sexo +
                '}';
    }
}