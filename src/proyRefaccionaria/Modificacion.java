package proyRefaccionaria;

import javax.swing.*;
import java.awt.event.KeyEvent;
@SuppressWarnings("deprecation")
public class Modificacion extends javax.swing.JPanel {

    private static final long serialVersionUID = 1L;
	int op=0;
    String codigo,articu,linea,fecha,tcarro,cantid,precio;


    public void BotonAgregar(){
    taImpresion.setText("");
        boolean in=false,cin=false;
        double pr=-1;
        cantid = (Spiner.getValue().toString());
        precio = ""+ffPrecio.getText();


        //checarCodigoVacio//
        if(cbCodigo.getSelectedItem().toString().equals("Seleccionar"))
        {cin=true; taImpresion.append("Seleccionar Codigo\n");}
        else{
        //checarDoublePrecio//
        try{
            pr=Double.parseDouble(precio);
        }catch(NumberFormatException e){in=true;    taImpresion.append("Insertar Precio Correctamente\n");}
        //ChecarErroresAntesdeImprimir//

        if(!(cin||in||pr==0.0))Modificar();
        else taImpresion.append("Insertar Precio Correctamente\n");}

        }

    public Modificacion() {
        initComponents();
        Clear();
        LeerDatos();
        cbCodigo.setSelectedItem("Seleccionar");
        cbTipo.disable();
        tfArticulo.setEditable(false);
    }

    public void LeerDatos(){
        try{
               DefaultComboBoxModel modelCodigo= new DefaultComboBoxModel(new String[]{"Nuevo"});
              cbCodigo.setModel(modelCodigo);
              Alta.coneccionBD("else","select art_id from articulo");
       while(Alta.Rs.next()){
       cbCodigo.addItem(Alta.Rs.getString("art_id"));}
       
        }catch(Exception e){System.out.println(e);}
    }

    public void Clear(){
        cbCodigo.setSelectedItem("Seleccionar");
        tfArticulo.setText("");
        tfArticulo.setEditable(false);
        cbTipo.setSelectedItem("Chico");
        cbTipo.disable();
        Spiner.setValue(1);
        ffPrecio.setText("");
        ffPrecio.setEditable(false);}

        public void Modificar(){try{

            if(Integer.parseInt(cantid)==0){String um="Se Agoto:\ncodigo: "+codigo+"\nArticulo: "+codigo.substring(3,codigo.length())+"\n\n\n";
       taImpresion.append(um); }

            Alta.coneccionBD("update","replace into articulo values ('"+codigo+"','"+articu+"',"
                 + ""+cantid+",'"+tcarro+"',"+precio+","+null+",CURRENT_DATE(),"+1+") ");

             taImpresion.append("Articulo Modificado\n\nCodigo:\t"+codigo+"\nArtic.:\t"+articu+"\nCarro:\t"+tcarro+"\n"
                    + "Cant.:\t"+cantid+"\nPrecio:\t"+precio+"\n\n");


    }catch(Exception e){System.out.println("EXCEPCION EN MODIFICAR :S "+e);}
 }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titulo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        codigoL = new javax.swing.JLabel();
        articuloL = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        taImpresion = new javax.swing.JTextArea();
        cbCodigo = new javax.swing.JComboBox();
        tfArticulo = new javax.swing.JTextField();
        Spiner = new javax.swing.JSpinner();
        cbTipo = new javax.swing.JComboBox();
        ffPrecio = new javax.swing.JFormattedTextField();
        btCancel = new javax.swing.JButton();
        btAgregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(70, 153, 224));
        setMinimumSize(new java.awt.Dimension(400, 300));
        setLayout(null);

        Titulo.setFont(new java.awt.Font("Tahoma", 1, 24));
        Titulo.setForeground(new java.awt.Color(240, 240, 240));
        Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo.setText("Modificaciones");
        add(Titulo);
        Titulo.setBounds(240, 20, 200, 42);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("Campos a Modificar:");
        add(jLabel5);
        jLabel5.setBounds(420, 90, 200, 30);

        codigoL.setFont(new java.awt.Font("Tahoma", 1, 18));
        codigoL.setForeground(new java.awt.Color(240, 240, 240));
        codigoL.setText("Codigo:");
        add(codigoL);
        codigoL.setBounds(140, 90, 100, 30);

        articuloL.setFont(new java.awt.Font("Tahoma", 1, 18));
        articuloL.setForeground(new java.awt.Color(240, 240, 240));
        articuloL.setText("Articulo:");
        add(articuloL);
        articuloL.setBounds(350, 130, 106, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel7.setText("Cantidad:");
        add(jLabel7);
        jLabel7.setBounds(350, 180, 120, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Tipo de Carro:");
        add(jLabel6);
        jLabel6.setBounds(350, 230, 139, 27);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel4.setText("Precio Unitario:");
        add(jLabel4);
        jLabel4.setBounds(350, 280, 150, 27);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(jSeparator1);
        jSeparator1.setBounds(330, 80, 10, 380);

        taImpresion.setColumns(20);
        taImpresion.setEditable(false);
        taImpresion.setFont(new java.awt.Font("Verdana", 0, 13));
        taImpresion.setRows(5);
        taImpresion.setToolTipText("Impresion de Actualizaciones");
        taImpresion.setFocusable(false);
        jScrollPane1.setViewportView(taImpresion);

        add(jScrollPane1);
        jScrollPane1.setBounds(70, 190, 230, 270);

        cbCodigo.setFont(new java.awt.Font("Tahoma", 0, 12));
        cbCodigo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar" }));
        cbCodigo.setToolTipText("<html>Codigo a <b>Modificar</b></html>");
        cbCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCodigoActionPerformed(evt);
            }
        });
        add(cbCodigo);
        cbCodigo.setBounds(80, 130, 210, 30);

        tfArticulo.setEditable(false);
        tfArticulo.setFont(new java.awt.Font("Tahoma", 0, 12));
        tfArticulo.setToolTipText("Campo no modificable");
        tfArticulo.setFocusable(false);
        tfArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfArticuloActionPerformed(evt);
            }
        });
        add(tfArticulo);
        tfArticulo.setBounds(440, 130, 200, 30);

        Spiner.setFont(new java.awt.Font("Tahoma", 0, 14));
        Spiner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(0), null, Integer.valueOf(1)));
        Spiner.setToolTipText("Cantidad a Modificar");
        add(Spiner);
        Spiner.setBounds(520, 180, 120, 30);

        cbTipo.setFont(new java.awt.Font("Tahoma", 0, 14));
        cbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "General", "Chico", "Mediano", "Grande" }));
        cbTipo.setToolTipText("Campo no Modificable");
        cbTipo.setEditor(null);
        cbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoActionPerformed(evt);
            }
        });
        add(cbTipo);
        cbTipo.setBounds(520, 230, 120, 30);

        ffPrecio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0.00;(###0.00)"))));
        ffPrecio.setToolTipText("Precio a Modificar");
        ffPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ffPrecioActionPerformed(evt);
            }
        });
        ffPrecio.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                ffPrecioInputMethodTextChanged(evt);
            }
        });
        ffPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ffPrecioKeyPressed(evt);
            }
        });
        add(ffPrecio);
        ffPrecio.setBounds(520, 280, 120, 30);

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
        btCancel.setBounds(430, 400, 140, 30);

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
        btAgregar.setBounds(430, 340, 140, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/(22).jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1);
        jLabel1.setBounds(0, 0, 700, 520);
    }// </editor-fold>//GEN-END:initComponents

    private void cbCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCodigoActionPerformed
        if (!(cbCodigo.getSelectedItem().toString().equals("Seleccionar"))) {
            codigo = cbCodigo.getSelectedItem().toString();
            try{

                Alta.coneccionBD("elsE","select * from articulo where art_id='"+codigo+"'");
                while (Alta.Rs.next()){
                    articu=Alta.Rs.getString("nombre");
                tfArticulo.setText(articu);
                tfArticulo.setEditable(false);
                Spiner.setValue(Alta.Rs.getInt("cantidad"));
                ffPrecio.setText(Alta.Rs.getString("precio"));
                cbTipo.disable();
                cbTipo.setSelectedIndex(Integer.parseInt(codigo.substring(2,3))-1);
                tcarro=cbTipo.getSelectedItem().toString();
                ffPrecio.setEditable(true);
                }
               
            }catch(Exception e){System.out.println("Excepcion en OBTENER VALORES--->Modi");}

        }
    }//GEN-LAST:event_cbCodigoActionPerformed

    private void tfArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfArticuloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfArticuloActionPerformed

    private void cbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoActionPerformed

}//GEN-LAST:event_cbTipoActionPerformed

    private void ffPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ffPrecioActionPerformed

}//GEN-LAST:event_ffPrecioActionPerformed

    private void ffPrecioInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_ffPrecioInputMethodTextChanged

}//GEN-LAST:event_ffPrecioInputMethodTextChanged

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        Clear();
        LeerDatos();
}//GEN-LAST:event_btCancelActionPerformed

    private void btAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarActionPerformed
        BotonAgregar();
}//GEN-LAST:event_btAgregarActionPerformed

    private void ffPrecioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ffPrecioKeyPressed
        if(evt.getKeyCode()==10){
        	BotonAgregar();}
        if(KeyEvent.getKeyText(evt.getKeyChar()).equals("Escape")){
 			int s=JOptionPane.showOptionDialog(null, "Cerrar Sistema?\n      (o \"ESC\")",
                             "SALIR SISTEMA", 1, 0, null, (new String[]{"SI","NO"}),"SI");
 			if(s==0)System.exit(0);}
    }//GEN-LAST:event_ffPrecioKeyPressed

    private void btAgregarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btAgregarKeyPressed
      if(evt.getKeyCode()==10){
        BotonAgregar();}
       if(KeyEvent.getKeyText(evt.getKeyChar()).equals("Escape")){
			int s=JOptionPane.showOptionDialog(null, "Cerrar Sistema?\n      (o \"ESC\")",
                            "SALIR SISTEMA", 1, 0, null, (new String[]{"SI","NO"}),"SI");
			if(s==0)System.exit(0);}
    }//GEN-LAST:event_btAgregarKeyPressed

    private void btCancelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btCancelKeyPressed
       if(evt.getKeyCode()==10){
    	   	Clear();    LeerDatos();}
       if(KeyEvent.getKeyText(evt.getKeyChar()).equals("Escape")){
			int s=JOptionPane.showOptionDialog(null, "Cerrar Sistema?\n      (o \"ESC\")",
                            "SALIR SISTEMA", 1, 0, null, (new String[]{"SI","NO"}),"SI");
			if(s==0)System.exit(0);}
    }//GEN-LAST:event_btCancelKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner Spiner;
    private javax.swing.JLabel Titulo;
    private javax.swing.JLabel articuloL;
    private javax.swing.JButton btAgregar;
    private javax.swing.JButton btCancel;
    private javax.swing.JComboBox cbCodigo;
    private javax.swing.JComboBox cbTipo;
    private javax.swing.JLabel codigoL;
    private javax.swing.JFormattedTextField ffPrecio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea taImpresion;
    private javax.swing.JTextField tfArticulo;
    // End of variables declaration//GEN-END:variables

}
