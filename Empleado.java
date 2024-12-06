import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Empleado extends Persona implements Administrable {
    // Variable estática para generar IDs únicos automáticamente
    private static final AtomicInteger contadorId = new AtomicInteger(1);

    // Enumeración para los diferentes roles en el aeropuerto
    public enum Puesto {
        PILOTO,
        AZAFATA,
        PERSONAL_DE_TIERRA,
        MANTENIMIENTO,
        ADMINISTRATIVO
    }

    public enum Turno {
        PRIMERO, SEGUNDO, TERCERO
    }

    // Atributos específicos de Empleado
    private Puesto puesto;  // Cambio de tipo String a Puesto (enumeración)
    private Turno turno;
    private Double sueldo;

    // Constructor vacío
    public Empleado() {}

    // Constructor con parámetros
    public Empleado(String nombre, String domicilio, String fechaDeNacimiento, char sexo,
                    Puesto puesto, Turno turno, Double sueldo) {
        super("EMP" + contadorId.getAndIncrement(), nombre, domicilio, fechaDeNacimiento, sexo);
        this.puesto = puesto;
        this.turno = turno;
        this.sueldo = sueldo;
    }

    // Getters
    public Puesto getPuesto() {
        return puesto;
    }

    public Turno getTurno() {
        return turno;
    }

    public Double getSueldo() {
        return sueldo;
    }

    // Setters
    public void setPuesto(Puesto puesto) {
        if (puesto != null) {
            this.puesto = puesto;
        } else {
            throw new IllegalArgumentException("El puesto no puede ser nulo.");
        }
    }

    public void setTurno(Turno turno) {
        if (turno != null) {
            this.turno = turno;
        } else {
            throw new IllegalArgumentException("El turno no puede ser nulo.");
        }
    }

    public void setSueldo(Double sueldo) {
        if (sueldo != null && sueldo >= 0) {
            this.sueldo = sueldo;
        } else {
            throw new IllegalArgumentException("El sueldo debe ser mayor o igual a 0.");
        }
    }

    // Método toString
    @Override
    public String toString() {
        return "Empleado {" +
                "ID='" + id + '\'' +
                ", Nombre='" + nombre + '\'' +
                ", Domicilio='" + domicilio + '\'' +
                ", FechaDeNacimiento=" + fechaDeNacimiento.format(FORMATO_FECHA) +
                ", Sexo=" + sexo +
                ", Puesto='" + puesto + '\'' + // Representación del puesto
                ", Turno='" + turno + '\'' +
                ", Sueldo=" + sueldo +
                '}';
    }

    @Override
    public void print() {
        System.out.printf("%-5s %-20s %-5d %-13s %-20s %-10s %-7.2f\n",
            id,
            nombre,
            this.calcularEdad(),
            sexo,
            puesto,
            turno,
            sueldo
        );
    }

    public static void printHdrs() {
        System.out.printf("%-5s %-20s %-5s %-13s %-20s %-10s %-7s\n",
                "ID",
                "NOMBRE",
                "EDAD",
                "SEXO",
                "PUESTO",
                "TURNO",
                "SUELDO"
        );
    }

    public void update() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        while (true) {
            System.out.println("Atributos disponibles para actualizar");
            System.out.println("1. Nombre");
            System.out.println("2. Domicilio");
            System.out.println("3. Fecha de nacimiento");
            System.out.println("4. Sexo");
            System.out.println("5. Puesto");
            System.out.println("6. Turno");
            System.out.println("7. Sueldo");
            System.out.println("8. Salir de la actualizacion");
            System.out.print("Opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre: ");
                    setNombre(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Ingrese el domicilio: ");
                    setDomicilio(scanner.nextLine());
                    break;
                case 3:
                    System.out.print("Ingrese la fecha de nacimiento del empleado (formato: dd/mm/aaaa): ");
                    setFechaDeNacimiento(scanner.nextLine());
                    break;
                case 4:
                    System.out.print("Ingrese el sexo: ");
                    setSexo(scanner.nextLine().charAt(0));
                    break;
                case 5:
                    Puesto[] puestos = Puesto.values();
                    int opPuesto;

                    System.out.print("Puestos disponibles:");
                    for (int i = 0; i < puestos.length; i++) {
                        System.out.println((i + 1) + ". " + puestos[i]);
                    }

                    do {
                        System.out.print("Ingrese el puesto del empleado: ");
                        opPuesto = scanner.nextInt();
                        scanner.nextLine();

                        if (opPuesto < 1 || opPuesto > 5) {
                            System.out.println("Opcion invalida, vuelva a intentar.");
                        }
                    } while (opPuesto < 1 || opPuesto > 5);
                    setPuesto(puestos[opPuesto - 1]);
                    break;
                case 6:
                    Turno[] turnos = Turno.values();
                    int opTurno;
                    do {
                        System.out.print("Turnos disponibles:");
                        System.out.println("1. Primero");
                        System.out.println("2. Segundo");
                        System.out.println("3. Tercero");
                        System.out.print("Ingrese el turno del empleado: ");
                        opTurno = scanner.nextInt();
                        scanner.nextLine();

                        if (opTurno < 1 || opTurno > 3) {
                            System.out.println("Opcion invalida, vuelva a intentar.");
                        }
                    } while (opTurno < 1 || opTurno > 3);
                    setTurno(turnos[opTurno - 1]);
                    break;
                case 7:
                    System.out.print("Ingrese el salario del empleado: ");
                    setSueldo(scanner.nextDouble());
                    scanner.nextLine();
                    break;
                case 8:
                    System.out.println("Saliendo de la actualización.");
                    return;
                default:
                    System.out.println("Opción invalida, vuelva a intentar.");
            }
        }
    }
}