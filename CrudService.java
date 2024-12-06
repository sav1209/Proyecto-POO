import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CrudService<T extends Administrable> {
    private List<T> elementos = new ArrayList<>();
    private final Class<T> tipoClase;

    public CrudService(Class<T> tipoClase) {
        this.tipoClase = tipoClase;
    }

    public void create(T elemento) {
        elementos.add(elemento);
    }

    public Optional<T> read(int index) {
        if (index >= 0 && index < elementos.size()) {
            return Optional.of(elementos.get(index));
        }
        return Optional.empty();
    }

    public void update(int index, T elemento) {
        if (index >= 0 && index < elementos.size()) {
            elementos.set(index, elemento);
        } else {
            System.out.println("Índice fuera de rango.");
        }
    }

    public void delete(String id) {
        for (int i = 0; i < elementos.size(); i++) {
            if(elementos.get(i).getId().equals(id)) {
                elementos.remove(i);
            }
        }
    }

    public void printAll() {
        try {
            // Invocar el método estático usando reflexión
            var metodo = tipoClase.getDeclaredMethod("printHdrs");
            metodo.invoke(null); // null porque es un método estático
        } catch (Exception e) {
            System.out.println("Error al imprimir los encabezados: " + e.getMessage());
        }

        for (T elemento : elementos) {
            elemento.print();
        }
    }

    // Método find para buscar un elemento por igualdad de IDs
    public Optional<T> find(String id) {
        return elementos.stream()
                .filter(e -> e.getId().equalsIgnoreCase(id))
                .findFirst();
    }

    public void updateEntity(String primaryKey) {
        boolean encontrado=false;
        for (T e : elementos) {
            String entityPrimaryKey = e.getId();

            if (entityPrimaryKey.equalsIgnoreCase(primaryKey)) {
                encontrado=true;

                e.update();

                System.out.println("Datos actualizados.");
                break;
            }
        }

        if ( !encontrado) {
            System.out.println("No se encontró el objeto con ID " + primaryKey);
        }
    }
}