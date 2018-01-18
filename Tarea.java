import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Esta clase define objetos que contienen tareas, su estado (finalizadas o no), su prioridad
 * y la fecha de vencimiento de las mismas.
 *
 * @author Dasins
 * @version 18/01/2018
 */
public class Tarea {
    // El objetivo de la tarea a realizar.
    private String tarea;
    // El estado de la tarea. True: Finalizada. False: Pendiente.
    private boolean estado;
    // La prioridad de la tarea. Max: 5. Min: 1.
    private int prioridad;
    // La fecha de vencimiento de la tarea.
    private LocalDate fechaLimite;
    
    /**
     * Constructor de objetos de la clase tarea.
     * @param tarea El objetivo de la tarea a realizar.
     */
    public Tarea(String tarea) {
        this.tarea = tarea;
        estado = false;
        prioridad = 1;
        fechaLimite = null;
    }
    
    /**
     * @return Devuelve el objetivo de la tarea.
     */
    public String getTarea() {
        return tarea;
    }
    
    /**
     * @return Devuelve el estado de la tarea.
     */
    public boolean getEstado() {
        return estado;
    }
    
    /**
     * @return Devuelve la prioridad de la tarea.
     */
    public int getPrioridad() {
        return prioridad;
    }
    
    /**
     * @return Devuelve la fecha de vencimiento de la tarea. 
     */
    public LocalDate getFechaLimite() {
        return fechaLimite;
    }
    
    /**
     * Devuelve toda la informacion de la tarea.
     * Formato: [Estado de la tarea]    [Prioridad]     [Objetivo de la tarea]      (Fecha de Vencimiento).
     * Estado de la tarea: '[ ]' Tarea pendiente. '[X]' Tarea completada.
     * @return Devuelve toda la informacion de la tarea como cadena.
     */
    public String devolverTarea() {
        String tarea = "\t\tPrioridad: [" + prioridad + "]\t\t" + this.tarea;  
        if(fechaLimite != null) { // Si existe fecha de vencimiento para la tarea, la indica.
            tarea = "\t" + formatearFechaSP(fechaLimite,"dd' de 'MMMM' de 'yyyy" )  + tarea;
        }
        else {
            tarea = "\t\t\t" + tarea;
        }
         if (estado){
            tarea = "   [X]\t" + tarea;
        }
        else {
            tarea = "   [ ]\t" + tarea;
        } 

        return tarea;
    }
    
    /**
     * @return Devuelve una fecha con un determinado formato con el ISO de Espana.
     */
    public String formatearFechaSP(LocalDate fecha, String format) {
        String fechaFormateada = fechaLimite.format(DateTimeFormatter.ISO_DATE); //Indica formato espanol.
        fechaFormateada = fecha.format(DateTimeFormatter.ofPattern(format));
        return fechaFormateada;
    }
    
    /**
     * Edita el objetivo de la tarea.
     * @param tarea El nuevo objetivo de la tarea.
     */
    public void setTarea(String tarea) {
        this.tarea = tarea;
    }
    
    /**
     * Edita el estado de la tarea.
     * @param estado El nuevo estado de la tarea.
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    /**
     * Edita la prioridad de la tarea. Si el nuevo valor no es valido no hace nada. 
     * @param prioridad La nueva prioridad de la tarea.
     */
    public void setPrioridad(int prioridad) {
        if(prioridad <= 5 && prioridad >= 1) {
            this.prioridad = prioridad;
        }
    }
    
    /**
     * Edita la fecha de vencimiento de la tarea.
     * @param dia El dia de vencimiento.
     * @param mes El mes de vencimiento.
     * @param ano El ano de vencimiento.
     */
    public void setFechaLimite(int dia, int mes, int ano) {
        fechaLimite = LocalDate.of(ano,mes,dia);
    }
    
}
