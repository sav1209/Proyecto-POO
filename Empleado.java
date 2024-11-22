public class Empleado extends Persona {

    // Enumeración para los diferentes roles en el aeropuerto
    public enum Puesto {
        PILOTO,
        AZAFATA,
        PERSONAL_DE_TIERRA,
        MANTENIMIENTO,
        ADMINISTRATIVO
    }

    public enum Turno {
        PRIMERO, SEGUNDO, TERCERO
    }

    // Atributos específicos de Empleado
    private Puesto puesto;  // Cambio de tipo String a Puesto (enumeración)
    private Turno turno;
    private Double sueldo;

    // Constructor vacío
    public Empleado() {}

    // Constructor con parámetros
    public Empleado(String id, String nombre, String domicilio, String fechaDeNacimiento, Sexo sexo,
                    Puesto puesto, Turno turno, Double sueldo) {
        super(id, nombre, domicilio, fechaDeNacimiento, sexo);
        this.puesto = puesto;
        this.turno = turno;
        this.sueldo = sueldo;
    }

    // Getters
    public Puesto getPuesto() {
        return puesto;
    }

    public Turno getTurno() {
        return turno;
    }

    public Double getSueldo() {
        return sueldo;
    }

    // Setters
    public void setPuesto(Puesto puesto) {
        if (puesto != null) {
            this.puesto = puesto;
        } else {
            throw new IllegalArgumentException("El puesto no puede ser nulo.");
        }
    }

    public void setTurno(Turno turno) {
        if (turno != null) {
            this.turno = turno;
        } else {
            throw new IllegalArgumentException("El turno no puede ser nulo.");
        }
    }

    public void setSueldo(Double sueldo) {
        if (sueldo != null && sueldo >= 0) {
            this.sueldo = sueldo;
        } else {
            throw new IllegalArgumentException("El sueldo debe ser mayor o igual a 0.");
        }
    }

    // Método toString
    @Override
    public String toString() {
        return "Empleado {" +
                "ID='" + id + '\'' +
                ", Nombre='" + nombre + '\'' +
                ", Domicilio='" + domicilio + '\'' +
                ", FechaDeNacimiento=" + fechaDeNacimiento.format(FORMATO_FECHA) +
                ", Sexo=" + sexo +
                ", Puesto='" + puesto + '\'' + // Representación del puesto
                ", Turno='" + turno + '\'' +
                ", Sueldo=" + sueldo +
                '}';
    }

    public String obtenerInformacionEmpleado() {
        return "Puesto: " + puesto + "\nTurno: " + turno + "\nSueldo: " + sueldo;
    }

}