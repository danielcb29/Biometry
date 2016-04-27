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
    
    public void procesar(){
        System.out.println("alto: "+huella.getHeight()+" ancho:"+huella.getWidth());
              
    }
    
    public BufferedImage GraytoRGB(Huella modelo){
        BufferedImage salida = new BufferedImage(huella.getWidth(), huella.getHeight(), BufferedImage.TYPE_INT_ARGB);
        for(int i=0;i<huella.getWidth();i++){
            for(int j=0;j<huella.getHeight();j++){
                int pix = modelo.getPixel(i, j);
                int rgb = (255 << 24 ) | (pix << 16) | (pix << 8) | pix;
                salida.setRGB(i, j, rgb);
            }
        }
        return salida;
        
    }    
    public Huella RGBtoGray(BufferedImage huella){
        Huella modelo = new Huella(huella.getWidth(),huella.getHeight());
        for(int i=0;i<huella.getWidth();i++){
            for(int j=0;j<huella.getHeight();j++){
                int rgb = huella.getRGB(i, j);
                int r = (rgb >> 16) & 0xFF;
                int g = (rgb >> 8) & 0xFF;
                int b = (rgb & 0xFF);
                int gris = (r + g + b) / 3;
                modelo.setPixel(i, j, gris);
            }
        }
        
        return modelo;
    }
    
    public Huella ecualizar(){
        
        
        return null;
    }
    
    public void setHuella(BufferedImage huella){
        this.huella=huella;
        modelo = new Huella(huella.getWidth(),huella.getHeight());
        modelo = RGBtoGray(huella);
        actual = modelo;
        anterior = actual;
    }
    public Huella getModelo(){
        return modelo;
    }
    
    
}
