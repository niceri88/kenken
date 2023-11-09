package controlador;

/**
 * La clase Timer representa un temporizador con horas, minutos y segundos.
 */
public class Timer {
    private int horas;
    private int minutos;
    private int segundos;

    /**
     * Constructor por defecto de la clase Timer. Inicializa horas, minutos y segundos a -1.
     */
    public Timer(){
        horas = -1;
        minutos = -1;
        segundos = -1;
    }

    /**
     * Establece las horas en el temporizador.
     *
     * @param horas Las horas que se establecerán en el temporizador.
     */
    public void setHoras(int horas){
        this.horas = horas;
    }

    /**
     * Establece los minutos en el temporizador.
     *
     * @param minutos Los minutos que se establecerán en el temporizador.
     */
    public void setMinutos(int minutos){
        this.minutos = minutos;
    }

    /**
     * Establece los segundos en el temporizador.
     *
     * @param segundos Los segundos que se establecerán en el temporizador.
     */
    public void setSegundos(int segundos){
        this.segundos = segundos;
    }
    
    /**
     * Obtiene las horas del temporizador.
     *
     * @return Las horas del temporizador.
     */
    public int getHoras(){
        return horas;
    }

    /**
     * Obtiene los minutos del temporizador.
     *
     * @return Los minutos del temporizador.
     */
    public int getMinutos(){
        return minutos;
    }

    /**
     * Obtiene los segundos del temporizador.
     *
     * @return Los segundos del temporizador.
     */
    public int getSegundos(){
        return segundos;
    }
}