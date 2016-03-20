package proyRefaccionaria;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class JFrameApp extends JFrame {
	private static final long serialVersionUID = 1L;

	public JFrameApp() {
        initComponents();
        hacerTabs();
        setResizable(false);
        setLocationRelativeTo(null);
        try{setIconImage(ImageIO.read(this.getClass().getResource("/Images/md.jpeg")));}catch(IOException e){e.printStackTrace();}
	}

    public void hacerTabs(){try{
       final ImageIcon ia=new ImageIcon(getClass().getResource("/Images/ADD.jpeg"));
       final ImageIcon iv=new ImageIcon(getClass().getResource("/Images/Sales.jpeg"));
       final ImageIcon ib=new ImageIcon(getClass().getResource("/Images/bad.jpeg"));
       final ImageIcon im=new ImageIcon(getClass().getResource("/Images/modify.jpeg"));
       final ImageIcon ir=new ImageIcon(getClass().getResource("/Images/report.jpeg"));
       final ImageIcon ic=new ImageIcon(getClass().getResource("/Images/reporte.jpeg"));

    final Ventas v=new Ventas();
    final Alta a=new Alta();
    final Baja b=new Baja();
    final Modificacion m=new Modificacion();
    final Reportes r=new Reportes();
    final Consultas c=new Consultas();

    jTabbedPane1.addKeyListener(new KeyAdapter() {
            @Override
    	public void keyPressed(KeyEvent e) {
    		if(KeyEvent.getKeyText(e.getKeyChar()).equals("Escape")){
    			int s=JOptionPane.showOptionDialog(null, "Cerrar Sistema?\n      (o \"ESC\")",
                                "SALIR SISTEMA", 1, 0, null, (new String[]{"SI","NO"}),"SI");
    			if(s==0)System.exit(0);
    		}
    	}
    });

    jTabbedPane1.addMouseListener(new MouseAdapter() {
        @Override
             public void mouseClicked(MouseEvent e) {
            a.LeerDatos();
            b.LeerDatos();
            c.LeerDatos();
            r.LeerDatos();
            m.LeerDatos();
            v.LeerDatos();}});

    jTabbedPane1.addTab("Ventas",iv,v,"Ventana de Ventas");
    jTabbedPane1.addTab("Altas",ia,a,"Ventana de Altas");
    jTabbedPane1.addTab("Bajas",ib,b,"Ventana de Bajas");
    jTabbedPane1.addTab("Modificaciones",im,m,"Ventana de Modificaciones");
    jTabbedPane1.addTab("Reportes",ir,r,"Ventana de Reportes");
    jTabbedPane1.addTab("Consultas",ic,c,"Ventana de Consultas"); }
    catch(Exception e){JOptionPane.showMessageDialog(null,"Icono NO encontrado");}
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("REFACCIONES MD");
        setBounds(new java.awt.Rectangle(0, 0, 700, 540));
        setIconImage(getIconImage());
        //setSize(new Dimension(680,540));

        getContentPane().setLayout(null);

        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(695, 517));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(695, 517));
        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(0, -3, 695, 517);

        //java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        //setBounds((screenSize.width-711)/2, (screenSize.height-549)/2, 711, 549);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameApp().setVisible(true);


            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables



}
