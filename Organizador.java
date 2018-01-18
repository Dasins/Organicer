import java.util.ArrayList;

/**
 * Clase que define objetos que actuan como organizadores de tareas.
 *
 * @author Dasins
 * @version 18/01/2018
 */
public class Organizador {
    private ArrayList<Tarea> tareas;
    
    /**
     * Constructor de objetos de la clase Organizador.
     */
    public Organizador() {
        tareas = new ArrayList<>();
    }
    
    /**
     * Anade una nueva tarea al organizador
     */
    public void addTarea(String tarea) {
        tareas.add(new Tarea(tarea));
    }
    
    /**
     * @return Devuelve true si el indice es valido y false si es invalido.
     */
    private boolean validarIndice(int index) {
        boolean indiceValido = false;
        if (index >= 0 && index < tareas.size()) { 
            indiceValido = true;
        }
        return indiceValido;
    }
    
    /**
     * Imprime por terminal una coleccion de tareas.
     */
    private void imprimirColeccion(ArrayList<Tarea> coleccion) {
        int numTareas = coleccion.size();
        System.out.println("Nº\tCompletada\tFecha vencimiento\t\tPrioridad\t\tTarea");
        if(numTareas > 0) {
            for(int i = 0; i < numTareas; i++) {
                System.out.println((i + 1) + ".\t" + coleccion.get(i).devolverTarea());
            }
        }
    }
    
    /**
     * Edita el objetivo de la tarea indicada por parametro.
     * @param index El indice de la tarea. (0 para la primera tarea, 1 para la segunda...).
     * @param tarea El nuevo objetivo de la tarea.
     */
    public void editarTarea(int index, String tarea) {
        if (validarIndice(index)) {
            tareas.get(index).setTarea(tarea);
        }
    }
    
    /**
     * Marca la tarea en el indice dado por parametro como completada. 
     * @param index El indice de la tarea a completar. (0 para la primera tarea, 1 para la segunda...).
     */
    public void completarTarea(int index) {
        if (validarIndice(index)) {
            tareas.get(index).setEstado(true);
        }
    }
    
    /**
     * Edita la prioridad de la tarea indicada por parametro.
     * @param index El indice de la tarea. (0 para la primera tarea, 1 para la segunda...).
     * @param prioridad La nueva prioridad de la tarea.
     */
    public void editarPrioridad(int index, int prioridad) {
        if (validarIndice(index)) {
            tareas.get(index).setPrioridad(prioridad);
        }
    }
    
    /**
     * Edita la fecha de vencimiento de una tarea indicada por parametro.
     * @param index El indice de la tarea. (0 para la primera tarea, 1 para la segunda...).
     * @param dia El dia de vencimiento.
     * @param mes El mes de vencimiento.
     * @param ano El ano de vencimiento.
     */
    public void editarFechaLimite(int index, int dia, int mes, int ano) {
        if (validarIndice(index)) {
            tareas.get(index).setFechaLimite(dia,mes,ano);
        }
    }
    
    /**
     * Imprime por terminal todas las tareas numeradas.
     * Si no hay tareas, no hace nada.
     */
    public void mostrarTareasNumeradas() {
        imprimirColeccion(tareas);
    }
    
    /**
     * 
     */
    public void mostrarEstadisticas() {
        int tareasTotales = tareas.size();
        int tareasCompletadas = 0;
        for (Tarea tarea : tareas){
            if (tarea.getEstado()){
                tareasCompletadas++;
            }
        }
        System.out.println("Tareas totales: " + tareasTotales);
        tareasCompletadas = tareasCompletadas * 100 / tareasTotales;
        System.out.println("Completadas: " + " [" + tareasCompletadas + "%]");
        System.out.println("Incompletas: " + " [" + (100 - tareasCompletadas) + "%]");
    }
    
    /**
     * Imprime todos los datos de la tarea con mayor prioridad. Si hay varias, imprime la última encontrada. 
     */
    public void mostrarMasUrgente() {
        if (validarIndice(0)){
            Tarea prioritaria = tareas.get(0);
            for(Tarea tarea : tareas){ 
                if (tarea.getPrioridad() >= prioritaria.getPrioridad()){
                   prioritaria = tarea;
                }
            }
            System.out.println(prioritaria.devolverTarea());
        }
    }
    
    /**
     * Imprime todos los datos de la tarea con menor prioridad. Si hay varias, imprime la última encontrada. 
     */
    public void mostrarMenosUrgente() {
        if (validarIndice(0)){
            Tarea prioritaria = tareas.get(0);
            for(Tarea tarea : tareas){ 
                if (tarea.getPrioridad() <= prioritaria.getPrioridad()){
                   prioritaria = tarea;
                }
            }
            System.out.println(prioritaria.devolverTarea());
        }
    }
    
    /**
     * Imprime todos los datos de la tarea con mayor prioridad. Si hay varias, imprime todas.
     */
    public void mostrarMasPrioritarias(){
        if (validarIndice(0)){
            ArrayList<Tarea> tareasAImprimir = new ArrayList<>();
            Tarea prioritaria = tareas.get(0);
            int prioridadMax = prioritaria.getPrioridad();
            for(Tarea tarea : tareas){
                int prioridadActual = tarea.getPrioridad();
                if(prioridadActual > prioridadMax){
                    tareasAImprimir = new ArrayList<>();
                    prioritaria = tarea;
                    tareasAImprimir.add(tarea);
                    prioridadMax = prioritaria.getPrioridad();
                }
                else if(prioridadActual == prioridadMax) {
                    tareasAImprimir.add(tarea);
                }
            }
            imprimirColeccion(tareasAImprimir);
        }
    }
       
    /**
     * Anade 10 tareas de prueba
     */
    public void prueba(){
        addTarea("Comerse al perro");
        addTarea("Pasear a la suegra");
        addTarea("Limpiar la basura");
        addTarea("Verter fluídos gaussianos");
        addTarea("Perseguir un dracoliche");
        addTarea("Bailar con un tigre");
        addTarea("Descifrar el necronomicón");
        addTarea("Peinar las bombillas del salon");
        addTarea("Ordenarse sacerdote de Chtullu");
        addTarea("Tener dulces pesadillas");
        addTarea("Buscar una nutria reversible");
        addTarea("Hervir mandarinas");
        addTarea("Besar al sapo");
        addTarea("Bailar sobre un aguja");
        addTarea("Jugar al Hearthstone");
        addTarea("Estudiar adivinación");
        addTarea("Matar al ruiseñor");
        addTarea("Tropezar con la misma roca");
        addTarea("Encerrar al gato");
        addTarea("Interrogar al gato");
        completarTarea(1);
        completarTarea(3);
        completarTarea(5);
        completarTarea(7);
        completarTarea(9);
        completarTarea(11);
        completarTarea(13);
        completarTarea(15);
        completarTarea(17);
        completarTarea(19);
        editarPrioridad(5, 2);
        editarPrioridad(6, 3);
        editarPrioridad(7, 4);
        editarPrioridad(8, 5);
        editarPrioridad(14, 2);
        editarPrioridad(15, 3);
        editarPrioridad(17, 4);
        editarPrioridad(18, 5);
        editarPrioridad(9, 3);
        editarPrioridad(10, 4);
        editarFechaLimite(1, 3, 4, 2019);
        editarFechaLimite(3, 18, 5, 2020);
        editarFechaLimite(6, 18, 5, 2020);
        editarFechaLimite(7, 3, 4, 2019);
        editarFechaLimite(10, 19, 12, 2021);
        editarFechaLimite(12, 19, 12, 2021);
        editarFechaLimite(18, 1, 11, 2019);
        editarFechaLimite(19, 1, 11, 2019);
    }
}
