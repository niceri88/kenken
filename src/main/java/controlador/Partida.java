package controlador;

import java.util.ArrayList;
import java.util.List;

public class Partida {
    private String dificultad;
    private List<Jaula> celdas = new ArrayList<>();

    public void setDificultad(String nDificultad){
        dificultad = nDificultad;
    }

    public String getDificultad(){
        return dificultad;
    }

    public List<Jaula> getCeldas(){
        return celdas;
    }

    public void agregarCelda(Jaula celda){
        celdas.add(celda);
    }
}
