/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biometria;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.WritableRaster;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.imageio.ImageIO;
import javax.swing.GrayFilter;

/**
 *
 * @author daniel
 */
public class Biometria {

    private BufferedImage huella;
    private Huella modelo;
    private Huella actual; 
    private Huella anterior;
    
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
    
    public Huella ecualizar(){
        return null;
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
    
    public void setHuella(BufferedImage huella){
        this.huella=huella;
        //modelo = new Huella(huella.getWidth(),huella.getHeight());
        modelo = RGBtoGray(huella);
        //actual = modelo;
        //anterior = actual;
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
