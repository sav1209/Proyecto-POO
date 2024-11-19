public class Persona {
    // Atributos protegidos
    protected String id; // Identificador de la persona
    protected String nombre;
    protected String domicilio;
    protected String fechaDeNacimiento;
    protected Character sexo; // Clases wrapper para tipos primitivos

    // Constructor vacío
    public Persona() {}

    // Constructor con parámetros
    public Persona(String id, String nombre, String domicilio, String fechaDeNacimiento, Character sexo) {
        this.id = id;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.sexo = sexo;
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

    public String getFechaDeNacimiento() {
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

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    // Metodo para obtener información
    public String obtenerInformacion() {
        return "ID: " + id + "\nNombre: " + nombre + "\nDomicilio: " + domicilio +
                "\nFecha de Nacimiento: " + fechaDeNacimiento + "\nSexo: " + sexo;
    }

    // Metodo para modificar datos
    public void modificarDatos(String id, String nombre, String domicilio, String fechaDeNacimiento, Character sexo) {
        this.id = id;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.sexo = sexo;
    }

    // Metodo toString
    @Override
    public String toString() {
        return "Persona {" +
                "ID='" + id + '\'' +
                ", Nombre='" + nombre + '\'' +
                ", Domicilio='" + domicilio + '\'' +
                ", FechaDeNacimiento='" + fechaDeNacimiento + '\'' +
                ", Sexo=" + sexo +
                '}';
    }
}