package proyRefaccionaria;

import javax.swing.*;
import java.awt.event.KeyEvent;
@SuppressWarnings("deprecation")
public class Baja extends javax.swing.JPanel {

	private static final long serialVersionUID = 1L;
	int op=0,n=0,cant=0;
    String codigo,articu,linea,fecha,tcarro,cantid,precio;


    public Baja() {
        initComponents();
        LeerDatos();
    }
    public void LeerDatos(){
         try{
         DefaultComboBoxModel modelCodigo= new DefaultComboBoxModel(new String[]{"Seleccionar"});
                cbCodigo.setModel(modelCodigo);
        Alta.coneccionBD("else","select art_id from articulo where disponible=1 ");
        while(Alta.Rs.next())
        cbCodigo.addItem(Alta.Rs.getString("art_id"));
	}catch(Exception e){System.out.println("Excepcion en LeerDatos de bajas\n"+e);}
    }

    public void Bajas(){
        taImpresion.setText("");
         codigo=cbCodigo.getSelectedItem().toString();
         boolean cb=false;

        //checarCodigoVacio//
        if(codigo.equals("Seleccionar")) {
             taImpresion.append("Seleccionar Codigo\n");cb=true;}
        if(cant!=0)taImpresion.append("No se Puede Eliminar\nAun hay existencias");
         if(!(cb||cant!=0)){
            try{

        Alta.coneccionBD("update","update articulo set disponible=0 where art_id='"+codigo+"';");
        taImpresion.append("\nCodigo\t"+codigo+"\nFue dado de baja correctamente");
	}catch(Exception e){System.out.println("Excepcion en LeerBoton\n"+e);}

            }
    }

    public void Clear(){
    cbCodigo.setSelectedItem("Seleccionar");
    taImpresion.setText("");}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titulo = new javax.swing.JLabel();
        cbCodigo = new javax.swing.JComboBox();
        codigoL = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taImpresion = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        btAgregar = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(70, 153, 224));
        setPreferredSize(new java.awt.Dimension(695, 517));
        setLayout(null);

        Titulo.setFont(new java.awt.Font("Tahoma", 1, 24));
        Titulo.setForeground(new java.awt.Color(186, 0, 0));
        Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo.setText("Bajas");
        add(Titulo);
        Titulo.setBounds(250, 10, 166, 42);

        cbCodigo.setFont(new java.awt.Font("Tahoma", 0, 12));
        cbCodigo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar" }));
        cbCodigo.setToolTipText("<html>Codigo a <b>Eliminar</b></html>");
        cbCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCodigoActionPerformed(evt);
            }
        });
        add(cbCodigo);
        cbCodigo.setBounds(80, 160, 210, 30);

        codigoL.setFont(new java.awt.Font("Tahoma", 1, 18));
        codigoL.setForeground(new java.awt.Color(159, 11, 0));
        codigoL.setText("Codigo:");
        add(codigoL);
        codigoL.setBounds(150, 120, 100, 30);

        taImpresion.setColumns(20);
        taImpresion.setEditable(false);
        taImpresion.setFont(new java.awt.Font("Verdana", 0, 13));
        taImpresion.setRows(5);
        taImpresion.setToolTipText("Impresion de Bajas");
        taImpresion.setFocusable(false);
        jScrollPane1.setViewportView(taImpresion);

        add(jScrollPane1);
        jScrollPane1.setBounds(380, 100, 240, 270);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(jSeparator1);
        jSeparator1.setBounds(320, 70, 10, 380);

        btAgregar.setFont(new java.awt.Font("Tahoma", 1, 18));
        btAgregar.setText("Aceptar");
        btAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarActionPerformed(evt);
            }
        });
        btAgregar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btAgregarKeyPressed(evt);
            }
        });
        add(btAgregar);
        btAgregar.setBounds(120, 250, 140, 30);

        btCancel.setFont(new java.awt.Font("Tahoma", 1, 18));
        btCancel.setText("Limpiar");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });
        btCancel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btCancelKeyPressed(evt);
            }
        });
        add(btCancel);
        btCancel.setBounds(120, 320, 140, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/(2).jpg"))); // NOI18N
        jLabel1.setLabelFor(this);
        jLabel1.setText("jLabel1");
        add(jLabel1);
        jLabel1.setBounds(0, 0, 690, 520);
    }// </editor-fold>//GEN-END:initComponents

    private void cbCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCodigoActionPerformed
        codigo=cbCodigo.getSelectedItem().toString();
        cant=0;

        if(!codigo.equals("Seleccionar")){
        taImpresion.setText("Codigo Seleccionado:\n\n");
        try{
            Alta.coneccionBD("else","select * from articulo where art_id='"+codigo+"'");
        while(Alta.Rs.next()){
                articu=Alta.Rs.getString("nombre");
                tcarro=Alta.Rs.getString("tipo_carro");
                cantid=Alta.Rs.getString("cantidad");
                precio=Alta.Rs.getString("precio");
                fecha=Alta.Rs.getString("fecha_adq");
               taImpresion.append("Codigo:\t"+Alta.Rs.getString("art_id")+"\n");
               taImpresion.append("Artic.:\t"+articu+"\n");
               taImpresion.append("Carro:\t"+tcarro+"\n");
               taImpresion.append("Cant.:\t"+cantid+"\n");
                           cant=Integer.parseInt(cantid);
               taImpresion.append("Precio:\t"+precio+"\n");
               taImpresion.append("Fecha:\t"+fecha+"\n\n");
        }
	}catch(Exception e){System.out.println("Excepcion en comboBox de BAJA\n"+e);}

        }
}//GEN-LAST:event_cbCodigoActionPerformed

    private void btAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarActionPerformed
        Bajas();
}//GEN-LAST:event_btAgregarActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        Clear();
        LeerDatos();
}//GEN-LAST:event_btCancelActionPerformed

    private void btAgregarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btAgregarKeyPressed
        if(evt.getKeyCode()==10)
             Bajas();
        if(KeyEvent.getKeyText(evt.getKeyChar()).equals("Escape")){
 			int s=JOptionPane.showOptionDialog(null, "Cerrar Sistema?\n      (o \"ESC\")",
                             "SALIR SISTEMA", 1, 0, null, (new String[]{"SI","NO"}),"SI");
 			if(s==0)System.exit(0);}
    }//GEN-LAST:event_btAgregarKeyPressed

    private void btCancelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btCancelKeyPressed
       if(evt.getKeyCode()==10)
             Clear();
         if(KeyEvent.getKeyText(evt.getKeyChar()).equals("Escape")){
  			int s=JOptionPane.showOptionDialog(null, "Cerrar Sistema?\n      (o \"ESC\")",
                              "SALIR SISTEMA", 1, 0, null, (new String[]{"SI","NO"}),"SI");
  			if(s==0)System.exit(0);}
    }//GEN-LAST:event_btCancelKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton btAgregar;
    private javax.swing.JButton btCancel;
    public javax.swing.JComboBox cbCodigo;
    private javax.swing.JLabel codigoL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea taImpresion;
    // End of variables declaration//GEN-END:variables

}
