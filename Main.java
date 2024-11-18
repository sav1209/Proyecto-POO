import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Map<String, EntityFactory<?>> factories = new HashMap<>();
    public static void main(String[] args) {
        EntityFactory<Persona> personaFactory = new EntityFactory<>("Persona", "SSSSS", Persona.class);

        // Crea un hashmap de entidades
        factories.put("Persona", personaFactory);

        Scanner scanner = new Scanner(System.in);
        String entityType="Persona";
        while (true) {
            System.out.println("\n== ABC " + entityType + " ==");
            System.out.println("1. Crear " + entityType);
            System.out.println("2. Imprimir " + entityType + "s");
            System.out.println("3. Actualizar " + entityType);
            System.out.println("4. Eliminar " + entityType);
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int entityOption = Integer.parseInt(scanner.nextLine());

            switch (entityOption) {
                case 1:
                    factories.get(entityType).createEntity();
                    break;
                case 2:
                    factories.get(entityType).printEntities();
                    break;
                case 3:
                    System.out.print("Ingrese clave de " + entityType + " a modificar: ");
                    String primaryKeyToUpdate = scanner.nextLine();
                    factories.get(entityType).updateEntity(primaryKeyToUpdate);
                    break;
                case 4:
                    System.out.print("Ingrese clave de " + entityType + " a eliminar: ");
                    String primaryKeyToDelete = scanner.nextLine();
                    factories.get(entityType).deleteEntity(primaryKeyToDelete);
                    break;
                case 5:
                    break;
                default:
                    //throw new IllegalArgumentException("Opción inválida.");
                    System.out.println("Opción inválida, Reintente...");
            }
            if (entityOption == 5) break;
        }
    }
}
