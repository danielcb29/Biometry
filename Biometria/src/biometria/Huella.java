/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biometria;

/**
 *
 * @author daniel
 */
public class Huella {
    int[][] imagen;
    
    public Huella(int ancho, int alto){
        imagen = new int[ancho][alto];
    }
    
    public void setPixel(int ancho,int alto, int gris){
        imagen[ancho][alto] = gris;
    }
    
    public int getPixel(int ancho,int alto){
        return imagen[ancho][alto];
    }
    
    public int[][] getImagen(){
        return imagen;
    }
}