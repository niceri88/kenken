package controlador;

public class Timer {
    private int horas;
    private int minutos;
    private int segundos;

    public Timer(){
        horas = -1;
        minutos = -1;
        segundos = -1;
    }

    public void setHoras(int horas){
        this.horas = horas;
    }

    public void setMinutos(int minutos){
        this.minutos = minutos;
    }

    public void setSegundos(int segundos){
        this.segundos = segundos;
    }
    
    public int getHoras(){
        return horas;
    }

    public int getMinutos(){
        return minutos;
    }

    public int getSegundos(){
        return segundos;
    }
}
