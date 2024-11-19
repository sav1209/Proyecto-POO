public class Empleado extends Persona {
    // Atributos específicos de Empleado
    private String puesto;
    private String turno; // Atributo actualizado
    private Double sueldo; // Sueldo fijo mensual

    // Constructor vacío
    public Empleado() {}

    // Constructor con parámetros
    public Empleado(String id, String nombre, String domicilio, String fechaDeNacimiento, Character sexo,
                    String puesto, String turno, Double sueldo) {
        super(id, nombre, domicilio, fechaDeNacimiento, sexo);
        this.puesto = puesto;
        this.turno = turno;
        this.sueldo = sueldo;
    }

    // Getters
    public String getPuesto() {
        return puesto;
    }

    public String getTurno() {
        return turno;
    }

    public Double getSueldo() {
        return sueldo;
    }

    // Setters
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    // Metodo toString
    @Override
    public String toString() {
        return "Empleado {" +
                "ID='" + id + '\'' +
                ", Nombre='" + nombre + '\'' +
                ", Domicilio='" + domicilio + '\'' +
                ", FechaDeNacimiento=" + fechaDeNacimiento.format(FORMATO_FECHA) +
                ", Sexo=" + sexo +
                ", Puesto='" + puesto + '\'' +
                ", Turno='" + turno + '\'' +
                ", Sueldo=" + sueldo +
                '}';
    }
}