/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biometria;

import java.io.Serializable;

/**
 *
 * @author daniel
 */
public class Minutia implements Serializable {
    private int x;
    private int y; 
    private int angulo;
    private String tipo;
    private String nombreHuella;
    
    
    Minutia(){
        
    }
    
    Minutia(int x, int y, String tipo){
        this.x=x;
        this.y=y;
        this.tipo=tipo;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y=y;
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
    public String getTipo(){
        return tipo;
    }
}
