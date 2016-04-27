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
    
    public Biometria(){
        
    }
    
    public void procesar(){
        System.out.println("alto: "+huella.getHeight()+" ancho:"+huella.getWidth());
              
    }
    
    public BufferedImage GraytoRGB(){
        BufferedImage salida = new BufferedImage(huella.getWidth(), huella.getHeight(), BufferedImage.TYPE_INT_ARGB);
        for(int i=0;i<huella.getWidth();i++){
            for(int j=0;j<huella.getHeight();j++){
                int pix = modelo.getPixel(i, j);
                //System.out.println(pix);
                //int rgb = pix;
                //rgb = (rgb << 16 ) + rgb;
                //rgb = (rgb << 8 ) + rgb;
                int rgb = (255 << 24 ) | (pix << 16) | (pix << 8) | pix;
                //System.out.println("rgb: "+rgb);
                salida.setRGB(i, j, rgb);
            }
        }
        return salida;
        
    }    
    public Huella RGBtoGray(){
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
    
    /*public Image grisesDos(){
        //gris = new int[huella.getHeight()*huella.getWidth()];
        int pos = 0;
        for(int i=0;i<huella.getHeight();i++){
            for(int j=0;j<huella.getWidth();j++){
                int argb = huella.getRGB(j, i);
                int rgb[] = new int[] {
                    (argb >> 16) & 0xff, //red
                    (argb >>  8) & 0xff, //green
                    (argb      ) & 0xff  //blue
                };
                //gris[pos] = (rgb[0] + rgb[1] + rgb[2])/3;
                pos++;
            }
        }
        
        BufferedImage image = new BufferedImage(huella.getHeight(), huella.getWidth(), BufferedImage.TYPE_INT_ARGB);
        WritableRaster raster = (WritableRaster) image.getData();
        //raster.setPixels(0,0,huella.getHeight(),huella.getWidth(),gris);
        return image;

        
    }
    
    public Image grises(){
        ImageFilter filter = new GrayFilter(false, 0);  
        ImageProducer producer = new FilteredImageSource(huella.getSource(), filter);  
        Image gray = Toolkit.getDefaultToolkit().createImage(producer);
        byte[] pixels = ((DataBufferByte) huella.getRaster().getDataBuffer()).getData();
        System.out.println(pixels[0]);
        return gray;
    }*/
    
    public void setHuella(BufferedImage huella){
        this.huella=huella;
        modelo = new Huella(huella.getWidth(),huella.getHeight());
    }
}
