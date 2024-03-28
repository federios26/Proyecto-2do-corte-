package gestorDeTareas;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;//entrada del usuario
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //entrada del usuario
        GestorTareas gestor = new GestorTareas();

        while (true) {
            System.out.println("1. Agregar tarea");
            System.out.println("2. Marcar tarea como completada");
            System.out.println("3. Mostrar tareas pendientes");
            System.out.println("4. Mostrar tareas completadas");
            System.out.println("5. Salir");
            System.out.print("Ingrese su opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el título de la tarea: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingrese la descripción de la tarea: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("Ingrese la fecha de vencimiento (dd/MM/yyyy) (deje en blanco si no tiene): ");
                    String fechaVencimientoStr = scanner.nextLine();
                    Date fechaVencimiento = null;
                    if (!fechaVencimientoStr.isEmpty()) {
                        try {
                            fechaVencimiento = new SimpleDateFormat("dd/MM/yyyy").parse(fechaVencimientoStr);
                            //parse=convertir una cadena de fecha en un dato
                        } catch (Exception e) {
                        	//se utiliza catch para manear excepciones
                            System.out.println("Formato de fecha inválido.");
                            continue;
                          
                        }
                    }
                    gestor.agregarTarea(titulo, descripcion, fechaVencimiento);
                    System.out.println("Tarea agregada correctamente.");
                    break;
                case 2:
                    System.out.print("Ingrese el número de la tarea que desea marcar como completada: ");
                    int indice = scanner.nextInt();
                    gestor.marcarComoCompletada(indice - 1);
                    System.out.println("Tarea marcada como completada correctamente.");
                    break;
                case 3:
                    gestor.mostrarTareasPendientes();
                    break;
                case 4:
                    gestor.mostrarTareasCompletadas();
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}