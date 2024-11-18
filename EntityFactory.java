import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class EntityFactory<T> {
    private final String title;
    private final String[] labels;
    private final String types;
    private final Class<T> type;
    private final List<T> entities;
    // ANSI escape codes for colors
    public static final String RESET = "\u001B[0m";  // Reset color
    public static final String YELLOW = "\u001B[1;33m"; // Yellow color

    public EntityFactory(String title, String types, Class<T> type) {
        this.title = title;
        this.labels = getEntityLabels( type );
        this.types = types;
        this.type = type;
        this.entities = new ArrayList<>();
    }

    public String[] getEntityLabels( Class<T> cls ) { // se agregó este método para leer etiquetas de cada clase, en un método estático
        try {
            return (String[]) cls.getMethod("getLabels").invoke(null);
        } catch (NoSuchMethodException e) {
            System.out.println("El método estático 'getLabels' no existe en la clase : " + cls.getName());
        } catch (Exception e) { // hay que poner todos estos "catch" que exige la clase "Method.invoke(...)"
            e.printStackTrace();
        }

        return null;
    }

    public Object[] readColumns( String action, int iStart, Object[] realValues  ) {
        Scanner scanner = new Scanner(System.in);
        Object[] values = new Object[labels.length];

        System.out.println("== " + action + " de " + title + " ==");
        for (int i = iStart; i < labels.length; i++) {
            System.out.print(labels[i] + ((iStart == 0)?"":"["+realValues[i]+"]") +" :" );
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                values[i] = realValues[i];
            } else {
                values[i] = parseInput(input, types.charAt(i));
            }
        }
        return values;
    }

    public T createEntity() {

        T entity = instantiateEntity(readColumns("Creación",0, new Object[0]));
        entities.add(entity);
        return entity;
    }

    public void printEntities() {
        boolean hdrsPrinted=false;
        System.out.printf("\n== Lista de %s ==%n", title);

        for (T entity:entities) {
            if ( !hdrsPrinted ) {
                System.out.printf( ((Entidad) entity).getPrnHdrs() + "%n", labels );
                hdrsPrinted = true;
            }
            ((Entidad) entity).print();
        }
    }

    public void updateEntity(String primaryKey) {
        boolean encontrado=false;
        for (T entity : entities) {
            String entityPrimaryKey = ((Entidad) entity).getId();

            if (entityPrimaryKey.equals(primaryKey)) {
                encontrado=true;
                System.out.println("Actualización de datos del " + title + ":");

                ((Entidad) entity).update( readColumns("Modificación",1, ((Entidad) entity).getColumns() ) );

                System.out.println("Datos actualizados.");
                break;
            }
        }

        if ( !encontrado) {
            System.out.println( YELLOW + "No se encontró " + RESET + title + " con clave " + primaryKey );
        }
    }

    public void deleteEntity(String primaryKey) {
        for (Iterator<T> iterator = entities.iterator(); iterator.hasNext(); ) {
            T entity = iterator.next();
            String entityPrimaryKey = ((Entidad) entity).getId();

            if (entityPrimaryKey.equals(primaryKey)) {
                iterator.remove();
                System.out.println(title + " con " + primaryKey + " ha sido eliminado."  );
                return;
            }
        }
        System.out.println(title + " con " + primaryKey + YELLOW + " no encontrado." + RESET);
    }

    private Object parseInput(String input, char type) {
        switch (type) {
            case 'S':
                return input; // String
            case 'I':
                return Integer.parseInt(input); // Integer
            case 'D':
                return Double.parseDouble(input); // Double
            case 'B':
                return input.trim().equalsIgnoreCase("S") ||
                        input.trim().equalsIgnoreCase("Sí") ||
                        input.trim().equalsIgnoreCase("SI"); // Boolean
            case 'A':
                System.out.println("Ingrese los temas separados por comas:");
                String topics = new Scanner(System.in).nextLine();
                return topics.split(","); // String array
            default:
                throw new IllegalArgumentException("Tipo de dato desconocido.");
        }
    }

    private T instantiateEntity(Object[] values) {
        if ( type == Persona.class ) {  // equivale a "type instanceof Alumno"; sólo que "type" no es una variable
            return type.cast(new Persona((String) values[0], (String) values[1], (String) values[2],
                    (String) values[3], (String) values[4]));
        }

        throw new IllegalArgumentException("Clase desconocida.");
    }
}