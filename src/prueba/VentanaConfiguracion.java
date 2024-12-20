package prueba;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

public class VentanaConfiguracion extends JFrame{
    JPanel panelPrincipal=new JPanel();
    public VentanaConfiguracion(){
        setSize(600,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Prueba");
        componentes();
    }
    private void componentes(){
        paneles();
        etiquetas();
        separadores();
        botones();
    }
    private void paneles(){
        this.add(panelPrincipal);
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(Color.darkGray);
    }
    private void etiquetas(){
        //    Titulo de Configuracion
        JLabel titulo=new JLabel("Configuracion",SwingConstants.CENTER);
        panelPrincipal.add(titulo);
        titulo.setBounds(0,20,600,50);
        titulo.setForeground(Color.white);
        titulo.setFont(new Font("arial",1,25));
        
        //////////////////////////////////
        //    Texto de Tamano de Pantalla
        JLabel sizePantalla=new JLabel("Tamaño de Pantalla");
        panelPrincipal.add(sizePantalla);
        sizePantalla.setBounds(20,80,600,50);
        sizePantalla.setForeground(Color.white);
        sizePantalla.setFont(new Font("arial",1,20));
        
        ////////////////////////////////
        //    Texto de Modo de Pantalla
        JLabel temaPantalla=new JLabel("Tema de Pantalla");
        panelPrincipal.add(temaPantalla);
        temaPantalla.setBounds(20,200,600,50);
        temaPantalla.setForeground(Color.white);
        temaPantalla.setFont(new Font("arial",1,20));
    }
    private void separadores(){
        JSeparator separadorTitulo=new JSeparator(SwingConstants.HORIZONTAL);
        panelPrincipal.add(separadorTitulo);
        separadorTitulo.setBounds(20,80,540,10);
        separadorTitulo.setBackground(Color.white);
        
        JSeparator separadorSizePantalla=new JSeparator(SwingConstants.HORIZONTAL);
        panelPrincipal.add(separadorSizePantalla);
        separadorSizePantalla.setBounds(20,200,540,10);
        separadorSizePantalla.setBackground(Color.white);
        
        JSeparator separadorModoPantalla=new JSeparator(SwingConstants.HORIZONTAL);
        panelPrincipal.add(separadorModoPantalla);
        separadorModoPantalla.setBounds(20,320,540,10);
        separadorModoPantalla.setBackground(Color.white);
    }
    private void botones(){
        //    Boton Regresar
        JButton btnRegresar=new JButton("<");
        panelPrincipal.add(btnRegresar);
        btnRegresar.setBounds(7,7,50,50);
        btnRegresar.setBackground(Color.white);
        btnRegresar.setFont(new Font("arial",1,20));
        //Efecto
        efectoLetra efectoBtnRegresar=new efectoLetra();
        efectoBtnRegresar.efectoBoton(btnRegresar);
        //Accon
        ActionListener accionBtnRegresar=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaInicio vInicio=new VentanaInicio();
                vInicio.setVisible(true);
                dispose();
            }
        };
        btnRegresar.addActionListener(accionBtnRegresar);
        
        /////////////////////////////////////
        //    Boton Tamaño 800x600
        JToggleButton btnPantalla1=new JToggleButton("800x600",true);
        panelPrincipal.add(btnPantalla1);
        btnPantalla1.setBounds(20,130,150,50);
        btnPantalla1.setBackground(Color.white);
        btnPantalla1.setFont(new Font("arial",1,20));
        //Efecto
        efectoLetra efectoBtnPantalla1=new efectoLetra();
        efectoBtnPantalla1.efectoToggle(btnPantalla1);
        
        ////////////////////////////////////
        //    Boton Tamaño 1000x800
        JToggleButton btnPantalla2=new JToggleButton("1000x800",false);
        panelPrincipal.add(btnPantalla2);
        btnPantalla2.setBounds(215,130,150,50);
        btnPantalla2.setBackground(Color.white);
        btnPantalla2.setFont(new Font("arial",1,20));
        efectoLetra efectoBtnPantalla2=new efectoLetra();
        efectoBtnPantalla2.efectoToggle(btnPantalla2);
        ActionListener tamano1=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };
        btnPantalla2.addActionListener(tamano1);
        
        /////////////////////////////////////
        //    Boton Tamaño Pesonalizar
        JToggleButton btnPantalla3=new JToggleButton("Personalizar",false);
        panelPrincipal.add(btnPantalla3);
        btnPantalla3.setBounds(410,130,151,50);
        btnPantalla3.setBackground(Color.white);
        btnPantalla3.setFont(new Font("arial",1,20));
        //Efecto
        efectoLetra efectoBtnPantalla3=new efectoLetra();
        efectoBtnPantalla3.efectoToggle(btnPantalla3);
        //Grupo de Botones de Tamano Pantalla
        ButtonGroup grupoBtnsPantalla=new ButtonGroup();
        grupoBtnsPantalla.add(btnPantalla1);
        grupoBtnsPantalla.add(btnPantalla2);
        grupoBtnsPantalla.add(btnPantalla3);
        
        ///////////////////////////////////////////////////
        //    Boton Modo de Oscuro
        JToggleButton btnModoOscuro=new JToggleButton("Oscuro",true);
        panelPrincipal.add(btnModoOscuro);
        btnModoOscuro.setBounds(20,250,150,50);
        btnModoOscuro.setBackground(Color.white);
        btnModoOscuro.setFont(new Font("arial",1,20));
        //Efecto
        efectoLetra efectoBtnOscuro=new efectoLetra();
        efectoBtnOscuro.efectoToggle(btnModoOscuro);
        //Accion
        ActionListener accionModoOscuro=new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                panelPrincipal.setBackground(Color.darkGray);
            }
        };
        btnModoOscuro.addActionListener(accionModoOscuro);
        
        ////////////////////////////////////////////////
        //    Boton de Modo Claro
        JToggleButton btnModoClaro=new JToggleButton("Claro",false);
        panelPrincipal.add(btnModoClaro);
        btnModoClaro.setBounds(215,250,150,50);
        btnModoClaro.setBackground(Color.white);
        btnModoClaro.setFont(new Font("arial",1,20));
        //Efecto
        efectoLetra efectoBtnClaro=new efectoLetra();
        efectoBtnClaro.efectoToggle(btnModoClaro);
        //Accion
        ActionListener accionModoClaro=new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                panelPrincipal.setBackground(Color.white);
            }
        };
        btnModoClaro.addActionListener(accionModoClaro);
        
        //////////////////////////////////////////////
        //Grupo de Botones de Modo De Pantalla
        ButtonGroup grupoBtnsModo=new ButtonGroup();
        grupoBtnsModo.add(btnModoOscuro);
        grupoBtnsModo.add(btnModoClaro);
    }
}
