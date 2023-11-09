package modelo;

import java.util.ArrayList;
import java.util.List;
import controlador.Configuracion;
import controlador.Timer;
import controlador.Partida;


public class Datos {
    private static Configuracion configuracion = new Configuracion();
    private static Timer timer = new Timer();
    private static List<Partida> listaPartidas = new ArrayList<>();
    
    public static Configuracion getConfiguracion(){
        return configuracion;
    }
    
    public static void agregarDificultadConfiguracion(int indice){
        configuracion.setDificultadPorIndice(indice);
    }

    public static void agregarRelojConfiguracion(int indice){
        configuracion.setRelojPorIndice(indice);
    }
    
    public static void agregarPosicionDePanelConfiguracion(int indice){
        configuracion.setPosicionDelPanelPorIndice(indice);
    }

    public static void agregarSonidoFinalConfiguracion(int indice){
        configuracion.setSonidoFinalPorIndice(indice);
    }

    public static Timer getTimer(){
        return timer;
    }
    
    public static void agregarHorasTimer(int horas){
        timer.setHoras(horas);
    }

    public static void agregarMinutosTimer(int minutos){
        timer.setMinutos(minutos);
    }

    public static void agregarSegundosTimer(int segundos){
        timer.setSegundos(segundos);
    }

    public static void quitarHorasTimer(){
        timer.setHoras(-1);
    }

    public static void quitarMinutosTimer(){
        timer.setMinutos(-1);
    }

    public static void quitarSegundosTimer(){
        timer.setSegundos(-1);
    }

    public static List<Partida> getListaPartidas(){
        return listaPartidas;
    }

    public static void agregarPartida(Partida partida){
        listaPartidas.add(partida);
    }
}