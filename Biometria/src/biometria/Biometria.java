/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biometria;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
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
    
    public Huella adelgazar(Huella entrada){
        int width = huella.getWidth();
        int height = huella.getHeight();
        Huella salida = new Huella(entrada);
        int[][] nbrs = {{0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1},{-1, 1}, {-1, 0}, {-1, -1}, {0, -1}};
        int[][][] nbrGroups = {{{0, 2, 4}, {2, 4, 6}}, {{0, 2, 6},{0, 4, 6}}};
        List<Point> toWhite = new ArrayList<>();
        
        boolean firstStep = false;
        boolean hasChanged;
        
        do{
            hasChanged = false;
            firstStep = !firstStep;
            for (int x = 1; x < width-1; x++) {
                for (int y = 1; y < height-1; y++) {
                    if (salida.getPixel(x, y) != 1)
                        continue;
                    
                    int nn = numNeighbors(x, y,salida,nbrs);
                    if (nn < 2 || nn > 6)
                        continue;
 
                    if (numTransitions(x, y,salida,nbrs) != 1)
                        continue;
                    
                    if (!atLeastOneIsWhite(x, y, firstStep ? 0 : 1, nbrGroups,nbrs,salida))
                        continue;
                    
                    toWhite.add(new Point(y, x));
                    hasChanged = true;
                }
            }
            for (Point p : toWhite)
                salida.setPixel(p.y, p.x, 0);
            toWhite.clear();
            
        }while(firstStep || hasChanged);
        
        return salida;
    }
    
    private int numNeighbors(int r, int c,Huella entrada,int[][] nbrs) {
        
        int count = 0;
        for (int i = 0; i < nbrs.length - 1; i++)
            if (entrada.getPixel(r + nbrs[i][1], c + nbrs[i][0]) == 1)
                count++;
        return count;
    }
    
    private int numTransitions(int r, int c, Huella entrada, int[][] nbrs) {
        int count = 0;
        for (int i = 0; i < nbrs.length - 1; i++)
            if (entrada.getPixel(r + nbrs[i][1], c + nbrs[i][0]) == 0) {
                if (entrada.getPixel(r + nbrs[i + 1][1], c + nbrs[i + 1][0]) == 1)
                    count++;
            }
        return count;
    }
    
    private boolean atLeastOneIsWhite(int r, int c, int step, int[][][] nbrGroups, int[][] nbrs, Huella entrada) {
        int count = 0;
        int[][] group = nbrGroups[step];
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < group[i].length; j++) {
                int[] nbr = nbrs[group[i][j]];
                if (entrada.getPixel(r + nbr[1], c + nbr[0]) == 1) {
                    count++;
                    break;
                }
            }
        return count > 1;
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
