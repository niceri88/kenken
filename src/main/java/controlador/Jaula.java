package controlador;

import java.util.ArrayList;
import java.util.List;

public class Jaula {
    private int numeroResultado;
    private String operando;
    private List<int[]> ubicaciones = new ArrayList<>();
    
    public Jaula(int nNumeroResultado, String nOperando){
        numeroResultado = nNumeroResultado;
        operando = nOperando;
    }

    public Jaula(){}

    public void setNumeroResultado(int nNumeroResultado){
        numeroResultado = nNumeroResultado;
    }

    public void setOperando(String nOperando){
        operando = nOperando;
    }

    public int getNumeroResultado(){
        return numeroResultado;
    }

    public String getOperando(){
        return operando;
    }

    public List<int[]> getUbicaciones(){
        return ubicaciones;
    }

    public void agregarUbicacion(int x, int y){
        int [] coordenadas = {x, y};
        ubicaciones.add(coordenadas);
    }
}
