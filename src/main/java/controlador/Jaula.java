package controlador;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase Jaula representa una jaula en el juego, que contiene un número resultado, un operando y una lista de ubicaciones.
 */
public class Jaula {
    private int numeroResultado;
    private String operando;
    private List<int[]> ubicaciones = new ArrayList<>();
    
    /**
     * Constructor de la clase Jaula que inicializa el número resultado y el operando.
     *
     * @param nNumeroResultado El número resultado que se mostrará en la jaula.
     * @param nOperando El operando que se utilizará en la jaula.
     */
    public Jaula(int nNumeroResultado, String nOperando){
        numeroResultado = nNumeroResultado;
        operando = nOperando;
    }

    /**
     * Constructor por defecto de la clase Jaula.
     */
    public Jaula(){}

    /**
     * Establece el número resultado de la jaula.
     *
     * @param nNumeroResultado El número resultado que se mostrará en la jaula.
     */
    public void setNumeroResultado(int nNumeroResultado){
        numeroResultado = nNumeroResultado;
    }

    /**
     * Establece el operando de la jaula.
     *
     * @param nOperando El operando que se utilizará en la jaula.
     */
    public void setOperando(String nOperando){
        operando = nOperando;
    }

    /**
     * Obtiene el número resultado de la jaula.
     *
     * @return El número resultado de la jaula.
     */
    public int getNumeroResultado(){
        return numeroResultado;
    }

    /**
     * Obtiene el operando de la jaula.
     *
     * @return El operando de la jaula.
     */
    public String getOperando(){
        return operando;
    }
    
    /**
     * Obtiene la lista de ubicaciones de la jaula.
     *
     * @return Una lista de arrays de enteros representando las coordenadas de la jaula.
     */
    public List<int[]> getUbicaciones(){
        return ubicaciones;
    }

    /**
     * Agrega una ubicación a la jaula.
     *
     * @param x La coordenada x de la ubicación a agregar.
     * @param y La coordenada y de la ubicación a agregar.
     */
    public void agregarUbicacion(int x, int y){
        int [] coordenadas = {x, y};
        ubicaciones.add(coordenadas);
    }
}