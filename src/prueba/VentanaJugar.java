package prueba;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class VentanaJugar extends JFrame{
    JPanel panelPrincipal=new JPanel();
    JPanel panelVictoria=new JPanel();
    JPanel panelConsola=new JPanel();
    
    JTextArea areaVictoria=new JTextArea();
    JTextArea areaConsola=new JTextArea();
    
    //Variables
    int jugadores=Integer.parseInt(JOptionPane.showInputDialog(null,"Cuantos Jugadores Son"));
    int victoria[][]=new int[jugadores][2],turno=0,suma=0;
    
    public VentanaJugar(){
        setSize(800,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Prueba");
        componentes();
    }
    private void componentes(){
        paneles();
        etiquetas();
        areasTexto();
        barrasDesplazamiento();
        separadores();
        botones();
        accionesInicio();
    }
    private void paneles(){
        this.add(panelPrincipal);
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(Color.darkGray);
        
        panelPrincipal.add(panelVictoria);
        panelVictoria.setLayout(null);
        panelVictoria.setBackground(Color.white);
        panelVictoria.setBounds(120,25,170,240);
        
        panelPrincipal.add(panelConsola);
        panelConsola.setLayout(null);
        panelConsola.setBackground(Color.white);
        panelConsola.setBounds(360,25,400,240);
    }
    private void etiquetas(){
        //    Texto Victoria
        JLabel tituloVictoria=new JLabel("Tabla de Victoria",SwingConstants.CENTER);
        panelVictoria.add(tituloVictoria);
        tituloVictoria.setBounds(0,2,170,30);
        tituloVictoria.setFont(new Font("arial",3,18));
        
        ///////////////////////////////
        //    Texto Consola
        JLabel tituloConsola=new JLabel("Consola",SwingConstants.CENTER);
        panelConsola.add(tituloConsola);
        tituloConsola.setBounds(0,2,400,30);
        tituloConsola.setFont(new Font("arial",3,20));
        
        ///////////////////////////////
        //    Gif Dados
        JLabel gifDados=new JLabel(new ImageIcon("dados_animados.gif"));
        panelPrincipal.add(gifDados);
        gifDados.setBounds(330,300,120,120);
    }
    private void areasTexto(){
        panelVictoria.add(areaVictoria);
        areaVictoria.setBounds(10,30,150,200);
        areaVictoria.setBackground(Color.darkGray);
        areaVictoria.setFont(new Font("arial",0,25));
        areaVictoria.setForeground(Color.white);
        areaVictoria.setEditable(false);
        
        panelConsola.add(areaConsola);
        areaConsola.setBackground(Color.darkGray);
        areaConsola.setBounds(10,30,380,200);
        areaConsola.setFont(new Font("arial",0,25));
        areaConsola.setForeground(Color.white);
        areaConsola.setEditable(false);
    }
    private void barrasDesplazamiento(){
        //    Scrolls de Area de Victoria
        JScrollPane scrollVictoria=new JScrollPane(areaVictoria);
        panelVictoria.add(scrollVictoria);
        scrollVictoria.setBounds(10,30,150,200);
        scrollVictoria.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollVictoria.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        //    Scroll de Area de Consola
        JScrollPane scrollConsola=new JScrollPane(areaConsola);
        panelConsola.add(scrollConsola);
        scrollConsola.setBounds(10,30,380,200);
        scrollConsola.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollConsola.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }
    private void separadores(){
        JSeparator separadorImagen=new JSeparator(SwingConstants.HORIZONTAL);
        panelPrincipal.add(separadorImagen);
        separadorImagen.setBounds(20,290,740,10);
        separadorImagen.setBackground(Color.white);
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
        
        ////////////////////////////////////
        //    Boton Tirar
        JButton btnTirar=new JButton("Tirar dados");
        panelPrincipal.add(btnTirar);
        btnTirar.setBounds(310,410,170,50);
        btnTirar.setBackground(Color.white);
        btnTirar.setFont(new Font("arial",1,20));
        //Efecto
        efectoLetra efectoBtnTirar=new efectoLetra();
        efectoBtnTirar.efectoBoton(btnTirar);
        //Accion
        ActionListener accionTirar=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaConsola.setText("                   Jugador "+(turno+1)+"\n");
                for(int a=0;a<2;a++){
                    int dados=(int)(Math.random()*6);
                    areaConsola.append(dados+"\n");
                    suma+=dados;
                }
                areaConsola.append("La suma es "+suma+"\n");
                if(suma==victoria[turno][0]||suma==victoria[turno][1]){
                    areaConsola.append("Ganaste\n");
                    btnTirar.setEnabled(false);
                }
                else{
                    areaConsola.append("Perdiste\n");
                    for(int a=0;a<jugadores;a++){
                        for(int b=0;b<2;b++){
                            if(a==turno){
                                victoria[a][b]=suma;
                            }
                        }
                    }
                    areaVictoria.setText("");
                    for(int a=0;a<jugadores;a++){
                        for(int b=0;b<2;b++){
                            areaVictoria.append(""+victoria[a][b]+" ");
                        }
                        areaVictoria.append("\n");
                    }
                    turno++;
                    if(turno==jugadores){
                        turno=0;
                    }
                    suma=0;
                }
            }
        };
        btnTirar.addActionListener(accionTirar);
    }
    private void accionesInicio(){
            for(int a=0;a<jugadores;a++){
                for(int b=0;b<2;b++){
                    victoria[a][b]=0;
                    if(b==0){
                        victoria[a][b]=7;
                    }
                    if(b==1){
                        victoria[a][b]=11;
                    }
                }
            }
            for(int a=0;a<jugadores;a++){
                for(int b=0;b<2;b++){
                    areaVictoria.append(victoria[a][b]+" ");
                }
                areaVictoria.append("\n");
            }
            areaConsola.setText("                   Jugador "+(turno+1)+" \nTira los Dados\n");
        }
}
