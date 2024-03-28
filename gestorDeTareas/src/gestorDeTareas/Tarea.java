package gestorDeTareas;

import java.util.Date;


class Tarea {
    private String titulo;
    private String descripcion;
    private Date fechaVencimiento;
    private boolean completada;

    public Tarea(String titulo, String descripcion, Date fechaVencimiento) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaVencimiento = fechaVencimiento;
        this.completada = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }
}