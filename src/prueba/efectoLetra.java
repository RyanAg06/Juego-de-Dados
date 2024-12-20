package prueba;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JToggleButton;

public class efectoLetra {
    public void efectoBoton(JButton boton){
        MouseListener efectoMouseBoton=new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {
                boton.setBackground(Color.green);
                boton.setForeground(Color.white);
                boton.setBorder(BorderFactory.createLineBorder(Color.white, 2));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                boton.setBackground(Color.white);
                boton.setForeground(Color.black);
                boton.setBorder(BorderFactory.createLineBorder(Color.black, 2));
            }
        };
        boton.addMouseListener(efectoMouseBoton);
    }
    public void efectoToggle(JToggleButton botonActivacion){
        MouseListener efectoMouseToggle=new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                botonActivacion.setBackground(Color.green);
                botonActivacion.setForeground(Color.white);
                botonActivacion.setBorder(BorderFactory.createLineBorder(Color.white, 2));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                botonActivacion.setBackground(Color.white);
                botonActivacion.setForeground(Color.black);
                botonActivacion.setBorder(BorderFactory.createLineBorder(Color.black, 2));
            }
        };
        botonActivacion.addMouseListener(efectoMouseToggle);
    }
}
