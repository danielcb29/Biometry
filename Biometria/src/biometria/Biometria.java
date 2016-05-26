/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biometria;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author daniel
 */
public class Biometria {

    private BufferedImage huella;
    private Huella modelo;
    private Huella actual; 
    private Huella anterior;
    private List<Minutia> minutias;
    
    public Biometria(){
        
    }
    
    public BufferedImage GraytoRGB(Huella entrada){
        BufferedImage salida = new BufferedImage(huella.getWidth(), huella.getHeight(), BufferedImage.TYPE_INT_ARGB);
        for(int i=0;i<huella.getWidth();i++){
            for(int j=0;j<huella.getHeight();j++){
                int pix = entrada.getPixel(i, j);
                int rgb = (255 << 24 ) | (pix << 16) | (pix << 8) | pix;
                salida.setRGB(i, j, rgb);
            }
        }
        return salida;
        
    }    
    public Huella RGBtoGray(BufferedImage entrada){
        Huella salida = new Huella(entrada.getWidth(),entrada.getHeight());
        for(int i=0;i<entrada.getWidth();i++){
            for(int j=0;j<entrada.getHeight();j++){
                int rgb = entrada.getRGB(i, j);
                int r = (rgb >> 16) & 0xFF;
                int g = (rgb >> 8) & 0xFF;
                int b = (rgb & 0xFF);
                int gris = (r + g + b) / 3;
                salida.setPixel(i, j, gris);
            }
        }
        salida.setTipo("gris");
        //actual=salida;
        return salida;
    }
    
    //Metodos para procesar blanco y negro
    public Huella blancoNegro(Huella entrada,int humbral){
        //anterior = actual; 
         Huella salida = new Huella(huella.getWidth(),huella.getHeight());
         for(int i=0;i<huella.getWidth();i++){
            for(int j=0;j<huella.getHeight();j++){
                int pix = entrada.getPixel(i, j);
                if (pix<humbral){
                    salida.setPixel(i, j, 0);
                }else{
                    salida.setPixel(i, j, 1);
                }
            }
        }
        salida.setTipo("blanco-negro");
        //actual=entrada;
        return salida;
    }
    
    public Huella blancoNegrotoGray(Huella entrada){
        Huella salida = new Huella(huella.getWidth(),huella.getHeight());
        
        for(int i=0;i<huella.getWidth();i++){
            for(int j=0;j<huella.getHeight();j++){
                int pix = entrada.getPixel(i, j);
                if (pix==1){
                    salida.setPixel(i, j, 255);
                }else{
                    salida.setPixel(i, j, 0);
                }
            }
        }
        
        return salida;
    }
    //Fin metodos de blanco y negro
    
    public Huella ecualizador(Huella entrada){
        int width = huella.getWidth();
        int height = huella.getHeight();
        Huella salida = new Huella(width,height);
        
        int tampixel= width*height;
        int[] histograma = new int[256];
        int[] iarray = new int[1];
        int i;
        
        for (int x = 1; x < width; x++) {
            for (int y = 1; y < height; y++) {
                    int valor= entrada.getPixel(x, y);
                    histograma[valor]++;
                }
            }
        int sum =0;
        
        float[] lut = new float[256];
        for ( i=0; i < 256; ++i )
        {
            sum += histograma[i];
            lut[i] = sum * 255 / tampixel;
        }
        
        i=0;
        for (int x = 1; x < width; x++) {
            for (int y = 1; y < height; y++) {
                int valor= entrada.getPixel(x, y);
                int valorNuevo= (int) lut[valor];
                salida.setPixel(x, y, valorNuevo);
                i=i+1;
            }
        }
        
        return salida;
    }
    
    //Metodos de quitar ruido
    public Huella quitarHuecos(Huella entrada){
        int width = huella.getWidth();
        int height = huella.getHeight();
        Huella salida = new Huella(width,height);
        
        for (int x = 1; x < width-1; x++) {
            for (int y = 1; y < height-1; y++) {
                int p = entrada.getPixel(x, y);
                int b = entrada.getPixel(x-1, y);
                int d = entrada.getPixel(x, y-1);
                int e = entrada.getPixel(x, y+1);
                int g = entrada.getPixel(x+1, y);
                
                int result = p|b&g&(d|e)|d&e&(b|g);
                salida.setPixel(x, y,result);
            }
        }
        
        return salida;
    }
    
    public Huella quitarPixels(Huella entrada){
        int width = huella.getWidth();
        int height = huella.getHeight();
        Huella salida = new Huella(width,height);
        
        for (int x = 1; x < width-1; x++) {
            for (int y = 1; y < height-1; y++) {
                int p = entrada.getPixel(x, y);
                int a = entrada.getPixel(x-1, y-1);
                int b = entrada.getPixel(x-1, y);
                int c = entrada.getPixel(x-1, y+1);
                int d = entrada.getPixel(x, y-1);
                int e = entrada.getPixel(x, y+1);
                int f = entrada.getPixel(x+1, y-1);
                int g = entrada.getPixel(x+1, y);
                int h = entrada.getPixel(x+1, y+1);
                
                int result = p&((a|b|d)&(e|g|h)|(b|c|e)&(d|f|g));
                salida.setPixel(x, y,result);
            }
        }
        
        return salida;
    }
    
    //Fin metodos quitar ruido
    
    //adelgazar 
    public BufferedImage adelgazar(BufferedImage entrada){
        Thinner adelgazador = new Thinner(entrada);
        return adelgazador.getResult();
    }
    
    //Detectar minutias
    
    public List<Minutia> detectarMinutias(Huella entrada, int marcox, int marcoy){
        int width = huella.getWidth();
        int height = huella.getHeight();
        
        List<Minutia> listaMinutias;
        listaMinutias = new LinkedList<>();
        for (int x = (1 + marcox); x < ((width-1)-marcox); x++) {
            for (int y = (1+marcoy); y < ((height-1)-marcoy); y++) {
                int resultado = cnminutias(entrada, x, y);
                System.out.println("CALCULO:"+resultado);
                if(resultado == 1){
                    //Corte
                    //System.out.println("CORTE");
                    Minutia min = new Minutia(x,y,"Corte");
                    listaMinutias.add(min);
                }else{
                    if(resultado == 3){
                        //Bifulcacion
                        //System.out.println("BIFULCACION");
                        Minutia min = new Minutia(x,y,"Bifulcacion");
                        listaMinutias.add(min);
                    }
                }
            }
        }
        minutias = listaMinutias;
        return listaMinutias;
       
    }
    
    public int cnminutias(Huella entrada, int x, int y){
                //int p = entrada.getPixel(x, y);
                int p4 = entrada.getPixel(x-1, y-1);
                int p5 = entrada.getPixel(x-1, y);
                int p6 = entrada.getPixel(x-1, y+1);
                int p3 = entrada.getPixel(x, y-1);
                int p7 = entrada.getPixel(x, y+1);
                int p2 = entrada.getPixel(x+1, y-1);
                int p1 = entrada.getPixel(x+1, y);
                int p8 = entrada.getPixel(x+1, y+1);
                int[] puntos = {p1,p2,p3,p4,p5,p6,p7,p8,p1};
                int result = 0;
                for(int i = 0; i<puntos.length-1;i++){
                    result += Math.abs(puntos[i] - puntos[i+1]);
                }
                result*=0.5;
            
        return result;
    }
    
    
    //Setters y Getters
    public void setHuella(BufferedImage huella){
        this.huella=huella;
        modelo = RGBtoGray(huella);
        actual = new Huella(modelo);
    }
    public Huella getModelo(){
        return this.modelo;
    }
    
    public void setActual(Huella nueva){
        this.actual = nueva;
    }
    
    public void setAnterior(Huella nueva){
        this.anterior = nueva;
    }
    
    public Huella getActual(){
        return this.actual;
    }
    
    public Huella getAnterior(){
        return this.anterior;
    }
    
}
