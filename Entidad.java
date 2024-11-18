public interface Entidad {
    // Para usar esta fábrica de objetos, cada clase debe implementar estos métodos
    Object[] getColumns();
    String getId();
    String getPrnHdrs();
    void print();
    void update(Object[] newValues );
}