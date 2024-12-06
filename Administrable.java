import java.util.ArrayList;

public interface Administrable {
    void update();
    void print(); // Mostrar detalles de una entidad para mostrarlo en una tabla
    String getId(); // Método que debe implementar cualquier clase que se use en CrudService
}