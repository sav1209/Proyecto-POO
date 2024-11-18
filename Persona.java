public class Persona implements Entidad {
    // Atributos de la clase Persona
    private String idPersona;
    private String nombre;
    private String genero;
    private String domicilio;
    private String fechaDeNacimiento;

    // Constructor vacío (opcional)
    public Persona() {
    }

    // Constructor con parámetros (opcional, si se desea)
    public Persona(String idPersona, String nombre, String genero, String domicilio, String fechaDeNacimiento) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.genero = genero;
        this.domicilio = domicilio;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    // CRUD
    public static String[] getLabels() {
        return new String[]{"ID", "Nombre", "Genero", "Domicilio", "Fecha de nacimiento"};
    }

    @Override
    public Object[] getColumns() {
        return new Object[]{ this.idPersona, this.nombre, this.genero, this.domicilio, this.fechaDeNacimiento };
    }

    @Override
    public String getId() {
        return this.idPersona;
    }

    @Override
    public String getPrnHdrs() {
        return "%-10s %-25s %-15s %-25s %-25s";
    }

    @Override
    public void print() {
        System.out.printf("%-10s %-25s %-15s %-25s %-25s %n", idPersona, nombre, genero, domicilio, fechaDeNacimiento);
    }

    @Override
    public void update(Object[] newValues) {
        this.nombre = (String) newValues[1];
        this.genero = (String) newValues[2];
        this.domicilio = (String) newValues[3];
        this.fechaDeNacimiento = (String) newValues[4];
    }
}