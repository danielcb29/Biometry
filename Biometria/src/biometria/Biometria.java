/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biometria;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
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
    byte[] matriz;
    
    public Biometria(){
        
    }
    
    public void procesar(){
        System.out.println("alto: "+huella.getHeight()+" ancho:"+huella.getWidth());
              
    }
    
    public Image grises(){
        ImageFilter filter = new GrayFilter(false, 0);  
        ImageProducer producer = new FilteredImageSource(huella.getSource(), filter);  
        Image gray = Toolkit.getDefaultToolkit().createImage(producer);
        return gray;
    }
    
    public void setHuella(BufferedImage huella){
        this.huella=huella;
    }
}
