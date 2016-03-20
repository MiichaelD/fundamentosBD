package proyRefaccionaria;

import javax.swing.*;
import java.awt.event.KeyEvent;
@SuppressWarnings("deprecation")
public class Reportes extends javax.swing.JPanel {


	private static final long serialVersionUID = 1L;
	int op=0,n=0;
    String codigo,articu,linea,fecha,tcarro,cantid,precio;

    public Reportes() {
        initComponents();
        LeerDatos();
    }

    public void LeerDatos(){
     try{
        javax.swing.DefaultComboBoxModel modelCodigo= new javax.swing.DefaultComboBoxModel(new String[]{"General"});
        cbMostrar.setModel(modelCodigo);

        Alta.coneccionBD("else","select art_id from articulo where disponible=1");
        while(Alta.Rs.next()){
         cbMostrar.addItem(Alta.Rs.getString("art_id"));
     }
     cbMostrar.setSelectedItem("General");

 }catch(Exception e){System.out.println("Excepcion en LeerDatos de Consultas");}

}



public void General(){
    try{

        Alta.coneccionBD("else","select * from articulo where disponible=1");
        while(Alta.Rs.next()){
         taImpresion.append("Codigo:\t"+Alta.Rs.getString("art_id")+"\n");
         taImpresion.append("Artic.:\t"+Alta.Rs.getString("nombre")+"\n");
         taImpresion.append("Carro:\t"+Alta.Rs.getString("tipo_carro")+"\n");
         taImpresion.append("Cant.:\t"+Alta.Rs.getString("cantidad")+"\n");
         taImpresion.append("Precio:\t"+Alta.Rs.getString("precio")+"\n");
         taImpresion.append("Fecha:\t"+Alta.Rs.getString("fecha_adq")+"\n\n");
     }
 }catch(Exception e){System.out.println("Excepcion en OBTENER VALORES--->GENERAL-CONSULTAS\n"+e);}
}

public void Individual(){
   try{

       Alta.coneccionBD("else","select * from articulo where art_id='"
        +cbMostrar.getSelectedItem().toString()+"'");
       while(Alta.Rs.next()){
         taImpresion.append("Codigo:\t"+Alta.Rs.getString("art_id")+"\n");
         taImpresion.append("Artic.:\t"+Alta.Rs.getString("nombre")+"\n");
         taImpresion.append("Carro:\t"+Alta.Rs.getString("tipo_carro")+"\n");
         taImpresion.append("Cant.:\t"+Alta.Rs.getString("cantidad")+"\n");
         taImpresion.append("Precio:\t"+Alta.Rs.getString("precio")+"\n");
         taImpresion.append("Fecha:\t"+Alta.Rs.getString("fecha_adq")+"\n\n");
     }

 }catch(Exception e){System.out.println("Excepcion en OBTENER VALORES--->INVIDIVUAL-CONSULTAS\n"+e);}
}
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
private void initComponents() {

    Titulo = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    taImpresion = new javax.swing.JTextArea();
    cbMostrar = new javax.swing.JComboBox();
    jLabel2 = new javax.swing.JLabel();
    jSeparator1 = new javax.swing.JSeparator();
    btAceptar = new javax.swing.JButton();
    jButton1 = new javax.swing.JButton();
    btLimpiar = new javax.swing.JButton();
    jLabel1 = new javax.swing.JLabel();

    setBackground(new java.awt.Color(70, 153, 224));
    setMinimumSize(new java.awt.Dimension(400, 300));
    setPreferredSize(new java.awt.Dimension(695, 517));
    setLayout(null);

    Titulo.setFont(new java.awt.Font("Tahoma", 1, 24));
    Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    Titulo.setText("Reportes");
    add(Titulo);
    Titulo.setBounds(230, 20, 200, 42);

    taImpresion.setColumns(20);
    taImpresion.setEditable(false);
        taImpresion.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        taImpresion.setRows(5);
        taImpresion.setToolTipText("Impresion de Reportes");
        taImpresion.setFocusable(false);
        jScrollPane1.setViewportView(taImpresion);

        add(jScrollPane1);
        jScrollPane1.setBounds(70, 110, 280, 330);

        cbMostrar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "General", "Individual" }));
        cbMostrar.setToolTipText("Seleccionar Codigo a Mostrar");
        cbMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMostrarActionPerformed(evt);
            }
        });
        add(cbMostrar);
        cbMostrar.setBounds(420, 150, 190, 35);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel2.setText("Mostrar:");
        add(jLabel2);
        jLabel2.setBounds(480, 110, 80, 29);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(jSeparator1);
        jSeparator1.setBounds(380, 90, 40, 360);

        btAceptar.setFont(new java.awt.Font("Tahoma", 1, 14));
        btAceptar.setText("Aceptar");
        btAceptar.setToolTipText("Mostrar Reportes");
        btAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptarActionPerformed(evt);
            }
        });
        btAceptar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btAceptarKeyPressed(evt);
            }
        });
        add(btAceptar);
        btAceptar.setBounds(460, 230, 130, 40);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton1.setText("Imprimir");
        jButton1.setToolTipText("Imprimir Reportes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(460, 310, 130, 40);

        btLimpiar.setFont(new java.awt.Font("Tahoma", 1, 14));
        btLimpiar.setText("Limpiar");
        btLimpiar.setToolTipText("Limpiar Reportes");
        btLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiarActionPerformed(evt);
            }
        });
        btLimpiar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btLimpiarKeyPressed(evt);
            }
        });
        add(btLimpiar);
        btLimpiar.setBounds(460, 390, 130, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/(23).jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1);
        jLabel1.setBounds(0, 0, 700, 520);
    }// </editor-fold>//GEN-END:initComponents

    private void btAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptarActionPerformed
        taImpresion.setText("");
        if(cbMostrar.getSelectedItem().toString().equals("General")){General();}
        else{Individual();}
        LeerDatos();
    }//GEN-LAST:event_btAceptarActionPerformed

    private void cbMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMostrarActionPerformed

    }//GEN-LAST:event_cbMostrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     btAceptarActionPerformed(evt);
     taImpresion.append("||||||||-IMPRIMIENDOO-||||||||");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiarActionPerformed
        taImpresion.setText("");
        LeerDatos();
}//GEN-LAST:event_btLimpiarActionPerformed

    private void btAceptarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btAceptarKeyPressed
       if(evt.getKeyCode()==10)
        {taImpresion.setText("");
    if(cbMostrar.getSelectedItem().toString().equals("General")){General();}
    else{Individual();}
    LeerDatos();}
    if(KeyEvent.getKeyText(evt.getKeyChar()).equals("Escape")){
     int s=JOptionPane.showOptionDialog(null, "Cerrar Sistema?\n      (o \"ESC\")",
         "SALIR SISTEMA", 1, 0, null, (new String[]{"SI","NO"}),"SI");
     if(s==0)System.exit(0);}
    }//GEN-LAST:event_btAceptarKeyPressed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
      if(evt.getKeyCode()==10)
       {taImpresion.setText("");
   if(cbMostrar.getSelectedItem().toString().equals("General")){General();}
   else{Individual();}
   LeerDatos();
   taImpresion.append("||||||||-IMPRIMIENDOO-||||||||");}
   if(KeyEvent.getKeyText(evt.getKeyChar()).equals("Escape")){
     int s=JOptionPane.showOptionDialog(null, "Cerrar Sistema?\n      (o \"ESC\")",
        "SALIR SISTEMA", 1, 0, null, (new String[]{"SI","NO"}),"SI");
     if(s==0)System.exit(0);}
    }//GEN-LAST:event_jButton1KeyPressed

    private void btLimpiarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btLimpiarKeyPressed
     if(evt.getKeyCode()==10)
         {taImpresion.setText("");    LeerDatos();}
     if(KeyEvent.getKeyText(evt.getKeyChar()).equals("Escape")){
         int s=JOptionPane.showOptionDialog(null, "Cerrar Sistema?\n      (o \"ESC\")",
            "SALIR SISTEMA", 1, 0, null, (new String[]{"SI","NO"}),"SI");
         if(s==0)System.exit(0);}
    }//GEN-LAST:event_btLimpiarKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton btAceptar;
    private javax.swing.JButton btLimpiar;
    private javax.swing.JComboBox cbMostrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea taImpresion;
    // End of variables declaration//GEN-END:variables

}
