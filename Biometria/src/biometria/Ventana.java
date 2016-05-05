/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biometria;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author daniel
 */
public class Ventana extends javax.swing.JFrame {

    /**
     * Creates new form Ventana
     */
    
    private BufferedImage huella;
    private Biometria modelo;
    
    public Ventana() {
        initComponents();
        modelo = new Biometria();
        btAtras.setToolTipText("Regresa de un cambio de procesamiento a cambios de filtros");
        lbFiltros.setToolTipText("Solo se pueden aplicar anter de procesar la imagen");
        lbProcess.setToolTipText("Solo se pueden aplicar despues de hacer filtros");
    }

    private void setHuellaPrincipal(){
        ImageIcon iconHuella = new ImageIcon(huella.getScaledInstance(256, 256, Image.SCALE_DEFAULT));
        lbHuellaEntrada.setIcon(iconHuella);
        add(lbHuellaEntrada);
    }
    
    private void enableFiltros(){
        btBlancoNegro.setEnabled(true);
        btEcualizador.setEnabled(true);
        btGris.setEnabled(true);
        btRuido.setEnabled(true);
    }
    
    private void disableFiltros(){
        btBlancoNegro.setEnabled(false);
        btEcualizador.setEnabled(false);
        btGris.setEnabled(false);
    }
    
    private void enableProcesos(){
        btAdelgazar.setEnabled(true);
        btProceso2.setEnabled(true);
        btProceso3.setEnabled(true);
        
    }
    
    private void disableProcesos(){
        btAdelgazar.setEnabled(false);
        btProceso2.setEnabled(false);
        btProceso3.setEnabled(false);
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        taLog = new javax.swing.JTextArea();
        btCargar = new javax.swing.JButton();
        btGris = new javax.swing.JButton();
        lbCargar = new javax.swing.JLabel();
        btSalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lbHuellaSalida = new javax.swing.JLabel();
        lbHuellaEntrada = new javax.swing.JLabel();
        btBlancoNegro = new javax.swing.JButton();
        btEcualizador = new javax.swing.JButton();
        lbFiltros = new javax.swing.JLabel();
        btAtras = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lbProcess = new javax.swing.JLabel();
        btAdelgazar = new javax.swing.JButton();
        btProceso2 = new javax.swing.JButton();
        btProceso3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btRuido = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        taLog.setEditable(false);
        taLog.setColumns(20);
        taLog.setRows(5);
        taLog.setDragEnabled(false);
        jScrollPane1.setViewportView(taLog);

        btCargar.setText("Cargar Imagen");
        btCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCargarActionPerformed(evt);
            }
        });

        btGris.setText("Escala Gris");
        btGris.setEnabled(false);
        btGris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGrisActionPerformed(evt);
            }
        });

        lbCargar.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        lbCargar.setText("Cargar:");

        btSalir.setText("Salir");
        btSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalirActionPerformed(evt);
            }
        });

        jLabel2.setText("Daniel Correa Barrios");

        lbHuellaSalida.setText("Huella Resultado");
        lbHuellaSalida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbHuellaEntrada.setText("Huella entrante");
        lbHuellaEntrada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btBlancoNegro.setText("Blanco/Negro");
        btBlancoNegro.setEnabled(false);
        btBlancoNegro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBlancoNegroActionPerformed(evt);
            }
        });

        btEcualizador.setText("Ecualizacion");
        btEcualizador.setEnabled(false);
        btEcualizador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEcualizadorActionPerformed(evt);
            }
        });

        lbFiltros.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        lbFiltros.setText("Filtros:");

        btAtras.setText("Atras");
        btAtras.setEnabled(false);
        btAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtrasActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jLabel4.setText("Logs:");

        lbProcess.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        lbProcess.setText("Procesamiento:");

        btAdelgazar.setText("Adelgazamiento");
        btAdelgazar.setEnabled(false);
        btAdelgazar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdelgazarActionPerformed(evt);
            }
        });

        btProceso2.setText("Proceso2");
        btProceso2.setEnabled(false);
        btProceso2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProceso2ActionPerformed(evt);
            }
        });

        btProceso3.setText("Proceso3");
        btProceso3.setEnabled(false);
        btProceso3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProceso3ActionPerformed(evt);
            }
        });

        jLabel6.setText("Escuela Politecnica");

        jLabel7.setText("- UEX");

        btRuido.setText("Eliminar Ruido");
        btRuido.setEnabled(false);
        btRuido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRuidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbProcess)
                        .addGap(18, 18, 18)
                        .addComponent(btAdelgazar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btProceso2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btProceso3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbHuellaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbHuellaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbCargar)
                                            .addComponent(lbFiltros))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btAtras))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btGris)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btEcualizador)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btBlancoNegro)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btRuido))))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel6)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel7)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(41, 41, 41))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbHuellaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbHuellaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCargar)
                    .addComponent(btCargar)
                    .addComponent(btAtras))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbFiltros)
                    .addComponent(btGris)
                    .addComponent(btEcualizador)
                    .addComponent(btBlancoNegro)
                    .addComponent(btRuido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbProcess)
                    .addComponent(btAdelgazar)
                    .addComponent(btProceso2)
                    .addComponent(btProceso3))
                .addGap(3, 3, 3)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btGrisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGrisActionPerformed

            Huella result  = modelo.getModelo();
            BufferedImage gris = modelo.GraytoRGB(result);
            ImageIcon iconSalida = new ImageIcon(gris.getScaledInstance(256, 256, Image.SCALE_DEFAULT));
            lbHuellaSalida.setIcon(iconSalida);
            add(lbHuellaSalida);
            taLog.append("Imagen cargada en escala de grises \n");
            //enableProcesos();
            modelo.setAnterior(new Huella(modelo.getActual()));
            modelo.setActual(result);
            btAtras.setEnabled(true);
    }//GEN-LAST:event_btGrisActionPerformed

    private void btCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCargarActionPerformed
        // TODO add your handling code here:
        String cwd = System.getProperty("user.dir");
        final JFileChooser jfc = new JFileChooser(cwd);
        jfc.addChoosableFileFilter(new FileNameExtensionFilter("Imagenes", ImageIO.getReaderFileSuffixes()));
        jfc.setAcceptAllFileFilterUsed(false);
        if (jfc.showOpenDialog(this) !=JFileChooser.APPROVE_OPTION)return;
        File archivo = jfc.getSelectedFile();
        try {
            huella = ImageIO.read(archivo);
            ImageIcon iconHuella = new ImageIcon(huella.getScaledInstance(256, 256, Image.SCALE_DEFAULT));
            lbHuellaEntrada.setIcon(iconHuella);
            add(lbHuellaEntrada);
            modelo.setHuella(huella);
            enableFiltros();            
            taLog.append("Imagen cargada correctamente! \n");

        } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        


        
    }//GEN-LAST:event_btCargarActionPerformed

    private void btSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_btSalirActionPerformed

    private void btBlancoNegroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBlancoNegroActionPerformed
        // TODO add your handling code here:
        int val = 0;
        try{
            val = Integer.parseInt(JOptionPane.showInputDialog("Valor del humbral: "));
        }catch(Exception e){
            taLog.append("Ha cancelado o debe ingresar un valor de umbral correcto para procesar blanco y negro \n");
            return;
        }
        taLog.append("Valor de humbral para blanco y negro: "+val+"\n");
        
        Huella entrada = modelo.getModelo();
        //entrada = modelo.ecualizador(entrada);
        Huella salidabyn = modelo.blancoNegro(entrada,val);
        Huella salidagray = modelo.blancoNegrotoGray(salidabyn);
        BufferedImage byn = modelo.GraytoRGB(salidagray);
        ImageIcon iconSalida = new ImageIcon(byn.getScaledInstance(256, 256, Image.SCALE_DEFAULT));
        lbHuellaSalida.setIcon(iconSalida);
        add(lbHuellaSalida);
        taLog.append("Imagen cargada en blanco y negro \n");
        
        modelo.setAnterior(new Huella(modelo.getActual()));
        modelo.setActual(salidabyn);
        btAtras.setEnabled(true);
        //enableProcesos();
    }//GEN-LAST:event_btBlancoNegroActionPerformed

    private void btAdelgazarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdelgazarActionPerformed
        // TODO add your handling code here:
        disableFiltros();
    }//GEN-LAST:event_btAdelgazarActionPerformed

    private void btAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtrasActionPerformed
        // TODO add your handling code here:
        btAtras.setEnabled(false);
        Huella anterior = modelo.getAnterior();
        modelo.setActual(new Huella(anterior));
        Huella salida = new Huella(anterior);
        if(salida.getTipo().equals("blanco-negro") || salida.getTipo().equals("ruido")){
            salida = modelo.blancoNegrotoGray(salida);
        }
        BufferedImage buf = modelo.GraytoRGB(salida);
        ImageIcon iconSalida = new ImageIcon(buf.getScaledInstance(256, 256, Image.SCALE_DEFAULT));
        lbHuellaSalida.setIcon(iconSalida);
        add(lbHuellaSalida);
        taLog.append("Imagen anterior cargada \n");
        
    }//GEN-LAST:event_btAtrasActionPerformed

    private void btProceso2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProceso2ActionPerformed
        // TODO add your handling code here:
        disableFiltros();
    }//GEN-LAST:event_btProceso2ActionPerformed

    private void btProceso3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProceso3ActionPerformed
        // TODO add your handling code here:
        disableFiltros();
    }//GEN-LAST:event_btProceso3ActionPerformed

    private void btEcualizadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEcualizadorActionPerformed
        // TODO add your handling code here:
        Huella entrada = modelo.getModelo();
        Huella salida = modelo.ecualizador(entrada);
        BufferedImage pantalla = modelo.GraytoRGB(salida);
        ImageIcon iconSalida = new ImageIcon(pantalla.getScaledInstance(256, 256, Image.SCALE_DEFAULT));
        lbHuellaSalida.setIcon(iconSalida);
        add(lbHuellaSalida);
        taLog.append("Imagen ecualizada y cargada \n");
        salida.setTipo("ecualizada");
        modelo.setAnterior(new Huella(modelo.getActual()));
        modelo.setActual(salida);
        btAtras.setEnabled(true);
    }//GEN-LAST:event_btEcualizadorActionPerformed

    private void btRuidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRuidoActionPerformed
        // TODO add your handling code here:
        Huella actual = modelo.getActual();
        Huella salida;
        if(actual.getTipo().equals("blanco-negro")){
            taLog.append("La imagen ya estaba cargada en blanco y negro \n");
            
            salida = modelo.quitarHuecos(actual);
            salida = modelo.quitarPixels(salida);
            salida = modelo.blancoNegrotoGray(salida);
            BufferedImage sinhueco = modelo.GraytoRGB(salida);
            ImageIcon iconSalida = new ImageIcon(sinhueco.getScaledInstance(256, 256, Image.SCALE_DEFAULT));
            lbHuellaSalida.setIcon(iconSalida);
            add(lbHuellaSalida);
            taLog.append("Imagen cargada suavizada \n");
        }else{
            taLog.append("Debe cargarse primero en blanco y negro \n");
            int val = 0;
            try{
                val = Integer.parseInt(JOptionPane.showInputDialog("Valor del humbral: "));
            }catch(Exception e){
                taLog.append("Ha cancelado o debe ingresar un valor de umbral correcto para procesar blanco y negro \n");
                return;
            }
            taLog.append("Valor de humbral para blanco y negro: "+val+"\n");

            Huella entrada = modelo.getModelo();
            Huella salidabyn = modelo.blancoNegro(entrada,val);
            salida = modelo.quitarHuecos(salidabyn);
            salida = modelo.quitarPixels(salida);
            Huella salidagris = modelo.blancoNegrotoGray(salida);
            BufferedImage sinhueco = modelo.GraytoRGB(salidagris);
            ImageIcon iconSalida = new ImageIcon(sinhueco.getScaledInstance(256, 256, Image.SCALE_DEFAULT));
            lbHuellaSalida.setIcon(iconSalida);
            add(lbHuellaSalida);
            taLog.append("Imagen cargada suavizada \n");
            
        }
        salida.setTipo("ruido");
        modelo.setAnterior(new Huella(modelo.getActual()));
        modelo.setActual(salida);
        btAtras.setEnabled(true);
        btAdelgazar.setEnabled(true);
    }//GEN-LAST:event_btRuidoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdelgazar;
    private javax.swing.JButton btAtras;
    private javax.swing.JButton btBlancoNegro;
    private javax.swing.JButton btCargar;
    private javax.swing.JButton btEcualizador;
    private javax.swing.JButton btGris;
    private javax.swing.JButton btProceso2;
    private javax.swing.JButton btProceso3;
    private javax.swing.JButton btRuido;
    private javax.swing.JButton btSalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCargar;
    private javax.swing.JLabel lbFiltros;
    private javax.swing.JLabel lbHuellaEntrada;
    private javax.swing.JLabel lbHuellaSalida;
    private javax.swing.JLabel lbProcess;
    private javax.swing.JTextArea taLog;
    // End of variables declaration//GEN-END:variables
}
