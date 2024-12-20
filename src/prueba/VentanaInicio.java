package prueba;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class VentanaInicio extends JFrame{
    JPanel panelPrincipal=new JPanel();
    //Variables
    boolean agrandar=false;
    
    public VentanaInicio(){
        setSize(800,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(agrandar);
        setTitle("Prueba");
        componentes();
    }
    private void componentes(){
        paneles();
        etiquetas();
        botones();
    }
    private void paneles(){
        //    Panel Principal
        this.add(panelPrincipal);
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(Color.darkGray);
    }
    private void etiquetas(){
        //   Etiqueta Titulo
        JLabel titulo=new JLabel("Juego de Dados",SwingConstants.CENTER);
        panelPrincipal.add(titulo);
        titulo.setBounds(0,100,800,80);
        titulo.setForeground(Color.white);
        titulo.setFont(new Font("arial",3,70));
        
        ///////////////////////////////
        //    Etiqueta Version
        JLabel version=new JLabel("1.0.0",SwingConstants.RIGHT);
        panelPrincipal.add(version);
        version.setBounds(0,515,780,50);
        version.setForeground(Color.white);
        version.setFont(new Font("arial",1,20));
    }
    private void botones(){
        //    Boton Jugar
        JButton btnJugar=new JButton("Jugar");
        panelPrincipal.add(btnJugar);
        btnJugar.setBounds(300,290,200,50);
        btnJugar.setBackground(Color.white);
        btnJugar.setFont(new Font("arial",3,20));
        btnJugar.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        //Efecto
        efectoLetra efectoBtnJugar=new efectoLetra();
        efectoBtnJugar.efectoBoton(btnJugar);
        //Accion
        ActionListener accionBtnJugar=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaJugar vJugar=new VentanaJugar();
                vJugar.setVisible(true);
                dispose();
            }
        };
        btnJugar.addActionListener(accionBtnJugar);
        
        //////////////////////////////
        //    Boton Configuracion
        JButton btnConfiguracion=new JButton("Configuracion");
        panelPrincipal.add(btnConfiguracion);
        btnConfiguracion.setBounds(300,350,200,50);
        btnConfiguracion.setBackground(Color.white);
        btnConfiguracion.setFont(new Font("arial",3,20));
        btnConfiguracion.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        //Efecto
        efectoLetra efectoBtnConfiguracion=new efectoLetra();
        efectoBtnConfiguracion.efectoBoton(btnConfiguracion);
        //Accion
        ActionListener accionBtnConfiguracion=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaConfiguracion vConfiguracion=new VentanaConfiguracion();
                vConfiguracion.setVisible(true);
                dispose();
            }
        };
        btnConfiguracion.addActionListener(accionBtnConfiguracion);
    }
}
