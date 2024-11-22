public abstract class MedioTransporte {
    protected String nombre;
    protected String id;

    public MedioTransporte(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    public abstract void iniciar();

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }
}
