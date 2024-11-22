public class Avion extends MedioTransporte {
    private int capacidad;

    public Avion(String nombre, String id, int capacidad) {
        super(nombre, id);
        this.capacidad = capacidad;
    }

    @Override
    public void iniciar() {
        System.out.println("El avión " + nombre + " ha despegado.");
    }

    public int getCapacidad() {
        return capacidad;
    }
}
