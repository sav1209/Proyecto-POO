import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Persona {
    // Atributos protegidos
    protected String id;
    protected String nombre;
    protected String domicilio;
    protected LocalDate fechaDeNacimiento; // Usando LocalDate para manejar fechas
    protected Character sexo;

    // Crear un formatter para el formato dd/MM/yyyy
    protected static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Constructor vacío
    public Persona() {}

    // Constructor con parámetros
    public Persona(String id, String nombre, String domicilio, String fechaDeNacimiento, Character sexo) {
        this.id = id;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.sexo = sexo;
        // Convertir la cadena fechaDeNacimiento a LocalDate usando el formato dd/MM/yyyy
        this.fechaDeNacimiento = LocalDate.parse(fechaDeNacimiento, FORMATO_FECHA);
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

    public Character getSexo() {
        return sexo;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    // Metodo para calcular la edad de la persona
    public int calcularEdad() {
        LocalDate hoy = LocalDate.now();
        Period periodo = Period.between(fechaDeNacimiento, hoy);
        return periodo.getYears();
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