package proyRefaccionaria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
@SuppressWarnings("deprecation")
public class Ventas extends javax.swing.JPanel {


    private static final long serialVersionUID = 1L;
    int op=0,n=0,cant=0;        boolean primero;
    double total;
    String codigo,articu,linea,fecha,tcarro,cantid,precio;

    public Ventas() {
        initComponents();
        primero=true;
        LeerDatos();
        ffPago.disable();
        ffPago.setEditable(false);
    }

    public void Agregar(){
             taError.setText("");
        codigo=cbCodigo.getSelectedItem().toString();
        boolean cb=false,sp=false;

        //checarCodigoVacio//
        if(cbCodigo.getSelectedItem().toString().equals("Seleccionar")) {
            taError.append("Seleccionar Codigo\n");cb=true; }
        else {
            if(Integer.parseInt(Spiner.getValue().toString()) > cant) {
            taError.append("Cantidad Maxima \ndel Articulo: " + cant);
            sp = true;}}
        if(!(cb||sp)){
            try{

                if(primero==true){taImpresion.setText("");
                taImpresion.append("\tREFACCIONES MD\n"
                + "               Mexicali, BC., Mexico\n\n****************************\n");}
                primero=false;
                int s=Integer.parseInt(Spiner.getValue().toString());
                double p=Double.parseDouble(ffPrecio.getText().toString())*s;
                total+=p;
                tfTotal.setText(total+"");
                ffPago.enable();ffPago.setEditable(true);
                taImpresion.append(codigo+"\t"+s+
                        "\n"+ffPrecio.getText().toString()+".............................."+p+"\n\n");

                cantid=""+(cant-Integer.parseInt(Spiner.getValue().toString()));
                coneLocal("update","update articulo set cantidad='"+cantid+"' where art_id='"+codigo+"';");

            }catch(Exception e){System.out.println("Excepcion en AgregarBoton\n"+e);}
             LeerDatos();
        }
    }

    public void Pagar(){
        taError.setText("");
        Double pago=0.0;
        try{pago=Double.parseDouble(ffPago.getText().toString());}catch(NumberFormatException e){}
        String feria="";
        if(total!=0.0){ffPago.enable();ffPago.setEditable(true);
            if(pago>=total){

                GregorianCalendar dia=new GregorianCalendar(TimeZone.getTimeZone("America/Tijuana"));
           fecha = (dia.get(Calendar.DATE)) + "/" + (dia.get(Calendar.MONTH)+1) + "/" + (dia.get(Calendar.YEAR));
                feria="\n               Cambio $"+(pago-total);      primero=true;
                    if((pago-total)==0.0)feria="";
                    taImpresion.append("\n****************************\n\n                    "+fecha
                            +"\n            Total Pagado: $"+total+"\n           Cantidad Recibida $"+pago+feria+" \n\n "
                       + "           Compra Satisfactoria! \n\tGracias Por \n               su Preferencia\n");
                            tfTotal.setText("");    ffPago.setText("");         total=0;
            }else {taError.append("Insertar Pago mayor a Total"); ffPago.selectAll(); primero=false;}
       }else {taError.append("Agregar Articulo\n"); ffPago.selectAll(); ffPago.disable(); ffPago.setEditable(false);}
    }

     Connection cone;
     Statement St;
     ResultSet Rs;

    public void coneLocal(String s1,String s2){
    	try{
    	Class.forName("com.mysql.jdbc.Driver");
        cone=DriverManager.getConnection("jdbc:mysql://"+Alta.host+"/"+Alta.bd+"?user="+Alta.usuario+"&password="+Alta.password);
        St=cone.createStatement();
        if(s1=="update")    St.executeUpdate(s2);
        else               Rs=St.executeQuery(s2);
    	}catch(Exception e){e.printStackTrace();}
    }
    public void LeerDatos(){

          try{
               DefaultComboBoxModel modelCodigo= new DefaultComboBoxModel(new String[]{"Seleccionar"});
              cbCodigo.setModel(modelCodigo);
             coneLocal("else","select art_id from articulo");
       while(Rs.next()){
       cbCodigo.addItem(Rs.getString("art_id"));
       }
        }catch(Exception e){System.out.println(e+"\nenLeerDatosVentas");e.printStackTrace();}
        Spiner.setValue(1); ffPrecio.setText(""); tfArticulo.setText("");
    }

    public void Clear(){
    cbCodigo.setSelectedItem("Seleccionar");
    taError.setText("");
    Spiner.setValue(1);
    tfArticulo.setText("");
    ffPrecio.setText("");

    cbTipo.setSelectedItem("Chico");}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FONDO = new JLabel();
        FONDO.setBounds(new Rectangle(-5, 0, 745, 525));
        FONDO.setText("jLabel2");
        FONDO.setIcon(new ImageIcon(getClass().getResource("/Images/(9).jpg")));
        Titulo = new javax.swing.JLabel();
        codigoL = new javax.swing.JLabel();
        cbCodigo = new javax.swing.JComboBox();
        btAgregar = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        taImpresion = new javax.swing.JTextArea();
        btPagar = new javax.swing.JButton();
        tfTotal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        articuloL = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfArticulo = new javax.swing.JTextField();
        Spiner = new javax.swing.JSpinner();
        cbTipo = new javax.swing.JComboBox();
        ffPrecio = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        taError = new javax.swing.JTextArea();
        ffPago = new javax.swing.JFormattedTextField();
        setBackground(new java.awt.Color(70, 153, 224));
        setLayout(null);

        this.setSize(new Dimension(680, 494));
        Titulo.setFont(new java.awt.Font("Tahoma", 1, 24));
        Titulo.setForeground(new java.awt.Color(0, 204, 0));
        Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo.setText("Ventas");
        add(Titulo);
        Titulo.setBounds(250, 10, 166, 42);

        codigoL.setFont(new java.awt.Font("Tahoma", 1, 18));
        codigoL.setText("Codigo:");
        add(codigoL);
        codigoL.setBounds(150, 60, 100, 30);

        cbCodigo.setFont(new java.awt.Font("Tahoma", 0, 12));
        cbCodigo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar" }));
        cbCodigo.setToolTipText("<html>Codigo a <b>Comprar</b></html>");
        cbCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCodigoActionPerformed(evt);
            }
        });
        add(cbCodigo);
        cbCodigo.setBounds(100, 100, 180, 30);

        btAgregar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btAgregar.setText("Agregar");
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
        btAgregar.setBounds(60, 370, 110, 30);

        btCancel.setFont(new java.awt.Font("Tahoma", 1, 18));
        btCancel.setText("Cancelar");
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
        btCancel.setBounds(190, 370, 120, 30);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(jSeparator1);
        jSeparator1.setBounds(340, 60, 10, 380);

        taImpresion.setColumns(20);
        taImpresion.setEditable(false);
        taImpresion.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        taImpresion.setRows(5);
        taImpresion.setToolTipText("Ticket de Compra");
        taImpresion.setFocusable(false);
        jScrollPane2.setViewportView(taImpresion);

        add(jScrollPane2);
        jScrollPane2.setBounds(360, 70, 270, 300);

        btPagar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btPagar.setText("Pagar");
        btPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPagarActionPerformed(evt);
            }
        });
        btPagar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btPagarKeyPressed(evt);
            }
        });
        add(btPagar);
        btPagar.setBounds(510, 420, 120, 30);

        tfTotal.setEditable(false);
        tfTotal.setFont(new java.awt.Font("Verdana", 0, 13));
        tfTotal.setToolTipText("Total a Pagar");
        tfTotal.setFocusable(false);
        tfTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTotalActionPerformed(evt);
            }
        });
        add(tfTotal);
        tfTotal.setBounds(474, 370, 156, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel1.setForeground(new java.awt.Color(60, 231, 0));
        jLabel1.setText("TOTAL:");
        add(jLabel1);
        jLabel1.setBounds(403, 370, 70, 30);

        articuloL.setFont(new java.awt.Font("Tahoma", 1, 14));
        articuloL.setText("Articulo:");
        add(articuloL);
        articuloL.setBounds(60, 160, 106, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel7.setText("Cantidad:");
        add(jLabel7);
        jLabel7.setBounds(60, 210, 120, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel6.setText("Tipo de Carro:");
        add(jLabel6);
        jLabel6.setBounds(60, 260, 139, 27);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel4.setText("Precio Unitario:");
        add(jLabel4);
        jLabel4.setBounds(60, 310, 123, 27);

        tfArticulo.setEditable(false);
        tfArticulo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfArticulo.setToolTipText("Campo no modificable");
        tfArticulo.setFocusable(false);
        tfArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfArticuloActionPerformed(evt);
            }
        });
        add(tfArticulo);
        tfArticulo.setBounds(140, 160, 180, 30);

        Spiner.setFont(new java.awt.Font("Tahoma", 0, 14));
        Spiner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        Spiner.setToolTipText("Cantidad a Comprar");
        add(Spiner);
        Spiner.setBounds(200, 210, 120, 30);

        cbTipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "General", "Chico", "Mediano", "Grande" }));
        cbTipo.setToolTipText("Campo no Modificable");
        cbTipo.setEditor(null);
        cbTipo.setEnabled(false);
        cbTipo.setFocusable(false);
        cbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoActionPerformed(evt);
            }
        });
        add(cbTipo);
        cbTipo.setBounds(200, 260, 120, 30);

        ffPrecio.setEditable(false);
        ffPrecio.setToolTipText("Campo no Modificable");
        ffPrecio.setFocusable(false);
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
        ffPrecio.setBounds(200, 310, 120, 30);

        taError.setColumns(20);
        taError.setEditable(false);
        taError.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        taError.setRows(2);
        taError.setToolTipText("Campo de Errores");
        taError.setFocusable(false);
        jScrollPane1.setViewportView(taError);

        add(jScrollPane1);
        jScrollPane1.setBounds(60, 410, 240, 50);

        ffPago.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0.00;(###0.00)"))));
        ffPago.setToolTipText("Pago Realizado");
        ffPago.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                ffPagoInputMethodTextChanged(evt);
            }
        });
        ffPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ffPagoKeyPressed(evt);
            }
        });
        add(ffPago);
        this.add(FONDO, null);
        ffPago.setBounds(380, 420, 120, 30);

    }// </editor-fold>//GEN-END:initComponents


	private void cbCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCodigoActionPerformed
        if(primero)taImpresion.setText("");
         codigo=cbCodigo.getSelectedItem().toString();
        cant=0;
        if(!codigo.equals("Seleccionar")){
            try{
                coneLocal("else","select * from articulo where art_id='"+codigo+"'");
        while(Rs.next()){
                articu=Rs.getString("nombre");
                tcarro=Rs.getString("tipo_carro");
                cantid=Rs.getString("cantidad");
                precio=Rs.getString("precio");
                fecha=Rs.getString("fecha_adq");
            tfArticulo.setText(articu);
            cbTipo.setSelectedItem(tcarro);
            cant=Integer.parseInt(cantid);
            ffPrecio.setText(precio);
            }

            }catch(Exception e){System.out.println("Excepcion en comboBox\n"+e);}

        }else {Spiner.setValue(1); ffPrecio.setText(""); tfArticulo.setText("");}
}//GEN-LAST:event_cbCodigoActionPerformed

    private void btAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarActionPerformed
    Agregar();
}//GEN-LAST:event_btAgregarActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        Clear();        LeerDatos();
        ffPago.setText("");     ffPago.disable();    tfTotal.setText("");
}//GEN-LAST:event_btCancelActionPerformed

    private void btPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPagarActionPerformed
       Pagar();
    }//GEN-LAST:event_btPagarActionPerformed

    private void tfArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfArticuloActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_tfArticuloActionPerformed

    private void cbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoActionPerformed

}//GEN-LAST:event_cbTipoActionPerformed

    private void ffPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ffPrecioActionPerformed

}//GEN-LAST:event_ffPrecioActionPerformed

    private void ffPrecioInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_ffPrecioInputMethodTextChanged

}//GEN-LAST:event_ffPrecioInputMethodTextChanged

    private void tfTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTotalActionPerformed

    private void ffPrecioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ffPrecioKeyPressed

    }//GEN-LAST:event_ffPrecioKeyPressed

    private void btAgregarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btAgregarKeyPressed
         if(evt.getKeyCode()==10)
        	 Agregar();
         if(KeyEvent.getKeyText(evt.getKeyChar()).equals("Escape")){
  			int s=JOptionPane.showOptionDialog(null, "Cerrar Sistema?\n      (o \"ESC\")",
                              "SALIR SISTEMA", 1, 0, null, (new String[]{"SI","NO"}),"SI");
  			if(s==0)System.exit(0);}
    }//GEN-LAST:event_btAgregarKeyPressed

    private void btCancelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btCancelKeyPressed
         if(evt.getKeyCode()==10)
         		{Clear();      LeerDatos();    ffPago.setText("");     ffPago.disable();    tfTotal.setText("");}
         if(KeyEvent.getKeyText(evt.getKeyChar()).equals("Escape")){
  			int s=JOptionPane.showOptionDialog(null, "Cerrar Sistema?\n      (o \"ESC\")",
                              "SALIR SISTEMA", 1, 0, null, (new String[]{"SI","NO"}),"SI");
  			if(s==0)System.exit(0);}
    }//GEN-LAST:event_btCancelKeyPressed

    private void btPagarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btPagarKeyPressed
       if(evt.getKeyCode()==10) {
            			Pagar();}
        if(KeyEvent.getKeyText(evt.getKeyChar()).equals("Escape")){
 			int s=JOptionPane.showOptionDialog(null, "Cerrar Sistema?\n      (o \"ESC\")",
                             "SALIR SISTEMA", 1, 0, null, (new String[]{"SI","NO"}),"SI");
 			if(s==0)System.exit(0);}
    }//GEN-LAST:event_btPagarKeyPressed


    private void ffPagoInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_ffPagoInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_ffPagoInputMethodTextChanged

    private void ffPagoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ffPagoKeyPressed
       if(evt.getKeyCode()==10) {
            Pagar();}
       if(KeyEvent.getKeyText(evt.getKeyChar()).equals("Escape")){
			int s=JOptionPane.showOptionDialog(null, "Cerrar Sistema?\n      (o \"ESC\")",
                            "SALIR SISTEMA", 1, 0, null, (new String[]{"SI","NO"}),"SI");
			if(s==0)System.exit(0);}
    }//GEN-LAST:event_ffPagoKeyPressed


    private javax.swing.JSpinner Spiner;
    private javax.swing.JLabel Titulo;
    private javax.swing.JLabel articuloL;
    private javax.swing.JButton btAgregar;
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btPagar;
    private javax.swing.JComboBox cbCodigo;
    private javax.swing.JComboBox cbTipo;
    private javax.swing.JLabel codigoL;
    private javax.swing.JFormattedTextField ffPago;
    private javax.swing.JFormattedTextField ffPrecio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea taError;
    private javax.swing.JTextArea taImpresion;
    private javax.swing.JTextField tfArticulo;
    private javax.swing.JTextField tfTotal;
	private JLabel FONDO = null;

}  //  @jve:decl-index=0:visual-constraint="-11,-5"
