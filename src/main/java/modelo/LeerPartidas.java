package modelo;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import controlador.Jaula;
import controlador.Partida;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LeerPartidas {
    private static int contarEtiquetas(Node node, String nombreEtiqueta) {
        int contador = 0;
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element elemento = (Element) node;
            if (elemento.getTagName().equals(nombreEtiqueta)) {
                contador++;
            }
        }
        NodeList hijos = node.getChildNodes();
        for (int i = 0; i < hijos.getLength(); i++) {
            contador += contarEtiquetas(hijos.item(i), nombreEtiqueta);
        }
        return contador;
    }
    
    public static void guardarDatos(){
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.parse("src/main/java/Modelo/partidas_kenken.xml"); 
            int largo = contarEtiquetas(documento, "partida"); 
            for (int i = 0; i < largo; i++){   
                Partida partida = new Partida();
                Node primerTag = documento.getElementsByTagName("partida").item(i);
                if (primerTag != null){
                    NodeList subElementos = primerTag.getChildNodes();
                    for (int j = 0; j < subElementos.getLength(); j++){
                        Node subElemento = subElementos.item(j);
                        if (subElemento.getNodeType() == Node.ELEMENT_NODE && subElemento.getNodeName().equals("nivelDeDificultad")){
                            partida.setDificultad(subElemento.getTextContent());
                        }
                        else if (subElemento.getNodeType() == Node.ELEMENT_NODE && subElemento.getNodeName().equals("jaula")){
                            String[] partes1 = subElemento.getTextContent().split(", ");
                            int numeroResultado = Integer.parseInt(partes1[0]);
                            String operador = partes1[1];
                            List<Integer> listaEnteros = new ArrayList<>();
                            for (int k = 0; k < partes1.length; k++){
                                if (k == 0 || k == 1){
                                    continue;
                                }
                                if (k % 2 == 0){
                                    String enteroSolo = partes1[k].replace("(", "");
                                    int entero = Integer.parseInt(enteroSolo);
                                    listaEnteros.add(entero);
                                }
                                else{
                                    String enteroSolo = partes1[k].replace(")", "");
                                    int entero = Integer.parseInt(enteroSolo);    
                                    listaEnteros.add(entero);
                                }
                            }
                            Jaula celda = new Jaula(numeroResultado, operador);
                            int[] coordenadas = new int[2];
                            for (int k = 0; k < listaEnteros.size(); k++){
                                if (k % 2 == 0){
                                    coordenadas[0] = listaEnteros.get(k);
                                }
                                else{
                                    coordenadas[1] = listaEnteros.get(k);
                                    celda.agregarUbicacion(coordenadas[0], coordenadas[1]);
                                }
                            }
                            partida.agregarCelda(celda);
                        }
                        else if (subElemento.getNodeType() == Node.ELEMENT_NODE && subElemento.getNodeName().equals("constantes")){
                            List<Integer> listaConstantes = new ArrayList<>();
                            String[] parte1 = subElemento.getTextContent().split(", ");
                            for (int k = 0; k < parte1.length; k++){
                                if (k % 3 == 0){
                                    String numeroString = parte1[k].replace("(", "");
                                    int numero = Integer.parseInt(numeroString);
                                    listaConstantes.add(numero);
                                }
                                else if (k % 3 == 1){
                                    int numero = Integer.parseInt(parte1[k]);    
                                    listaConstantes.add(numero);
                                }
                                else{
                                    String numeroString = parte1[k].replace(")", "");
                                    int numero = Integer.parseInt(numeroString);
                                    
                                    listaConstantes.add(numero);
                                }
                            }
                            int contador = 0;
                            for (int k = 0; k < listaConstantes.size() / 3; k++){
                                int numeroResultado = listaConstantes.get(contador);
                                contador++;
                                String operador = "c";
                                int coordenadax = listaConstantes.get(contador);
                                contador++;
                                int coordenaday = listaConstantes.get(contador);
                                contador++;
                                Jaula celda = new Jaula(numeroResultado, operador);
                                celda.agregarUbicacion(coordenadax, coordenaday);
                                partida.agregarCelda(celda);
                            }
                        }
                    }
                }
                Datos.agregarPartida(partida);
            }
        } catch (IOException | ParserConfigurationException | DOMException | SAXException e)
        {
            e.printStackTrace();
        }
    }
}