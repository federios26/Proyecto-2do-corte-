package gestorDeTareas;
import java.util.ArrayList;// lista dinámica.
import java.util.Date;//instancia específica de fecha y hora
import java.util.List;// representa una colección ordenada de elementos
import java.text.SimpleDateFormat;// representa una colección ordenada de elementos
class GestorTareas {


    private List<Tarea> tareasPendientes;
    private List<Tarea> tareasCompletadas;
    private SimpleDateFormat sdf;

    public GestorTareas() {
        this.tareasPendientes = new ArrayList<>();
        this.tareasCompletadas = new ArrayList<>(); 	
        this.sdf = new SimpleDateFormat("dd/MM/yyyy");
    }

    public void agregarTarea(String titulo, String descripcion, Date fechaVencimiento) {
        Tarea tarea = new Tarea(titulo, descripcion, fechaVencimiento);
        tareasPendientes.add(tarea);
    }

    public void marcarComoCompletada(int indice) {
        Tarea tarea = tareasPendientes.get(indice);
        tarea.setCompletada(true);
        tareasPendientes.remove(tarea);
        tareasCompletadas.add(tarea);
    }

    
    public void mostrarTareasPendientes() {
        System.out.println("Tareas pendientes:");
        // obtener el número de elementos en la lista.
        Date ahora = new Date(); // Obtener la fecha y hora actual
        for (int i = 0; i < tareasPendientes.size(); i++) {
            Tarea tarea = tareasPendientes.get(i);
            //accedemos  a cada tarea individual
            if (tarea.getFechaVencimiento() != null) {
                if (tarea.getFechaVencimiento().getTime() - ahora.getTime() < 24 * 60 * 60 * 1000) { // Verificar si la tarea está próxima a vencer (dentro de 24 horas)
                    System.out.println((i + 1) + ". " + tarea.getTitulo() + " - " + tarea.getDescripcion() + " - Vencimiento: " + sdf.format(tarea.getFechaVencimiento()) + " (Próxima a vencer)");
                } else {
                    System.out.println((i + 1) + ". " + tarea.getTitulo() + " - " + tarea.getDescripcion() + " - Vencimiento: " + sdf.format(tarea.getFechaVencimiento()));
                }
            } else {
                System.out.println((i + 1) + ". " + tarea.getTitulo() + " - " + tarea.getDescripcion() + " - Vencimiento: No especificado");
            }
        }
    }


    public void mostrarTareasCompletadas() {
        System.out.println("Tareas completadas:");
        for (int i = 0; i < tareasCompletadas.size(); i++) {
            Tarea tarea = tareasCompletadas.get(i);
            System.out.println((i + 1) + ". " + tarea.getTitulo() + " - " + tarea.getDescripcion() + " - Vencimiento: " + sdf.format(tarea.getFechaVencimiento()));
        }
    }
}