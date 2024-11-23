public abstract class MedioTransporte {
    protected String id;     // Identificador único
    protected String modelo; // Modelo del medio de transporte

    public MedioTransporte(String id, String modelo) {
        this.id = id;
        this.modelo = modelo;
    }

    public abstract void iniciar();

    // Getter para el modelo
    public String getModelo() {
        return modelo;
    }

    // Setter para el modelo
    public void setModelo(String modelo) {
        if (modelo != null && !modelo.isEmpty()) {
            this.modelo = modelo;
        } else {
            throw new IllegalArgumentException("El modelo no puede ser nulo o vacío.");
        }
    }

    // Getter para el id
    public String getId() {
        return id;
    }

    // Setter para el id
    public void setId(String id) {
        if (id != null && !id.isEmpty()) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("El id no puede ser nulo o vacío.");
        }
    }
}
