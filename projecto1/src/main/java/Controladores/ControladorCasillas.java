/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import CasillasGUI.AguaGUI;
import Juego.Jugador;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author alex
 */
public class ControladorCasillas {
//se encarga de bloquear y ocultar todo lo que obtenga dentro de un componente bloqueado al inicio de la partida
    public void bloquearCasillas(JComponent component) {
        Component[] components = component.getComponents();
        component.setEnabled(false);
        component.setBackground(Color.darkGray);
        JLabel label;
        if (component instanceof AguaGUI) {
            label = (JLabel) components[1];
            label.setText("");
        } else {
            label = (JLabel) components[0];
            label.setText("");
        }
        for (int i = 0; i < components.length; i++) {
            components[i].setEnabled(false);
            components[i].setVisible(false);
        }
    }
//se encarga de desbloquear y hacer visible los componentes, segun la casilla que sea y el contenido que posea dentro
    public void desbloquearCasillas(JComponent component, Color color, String nombreCasilla, Jugador jug) {
        if (jug.getOro() >= ControladorConstantes.PRECIO_CASILLA) {
            Component[] components = component.getComponents();
            component.setEnabled(true);
            component.setBackground(color);
            JLabel label;
            if (component instanceof AguaGUI) {
                label = (JLabel) components[1];
                label.setText(nombreCasilla);
            } else {
                label = (JLabel) components[0];
                label.setText(nombreCasilla);
            }
            for (int i = 0; i < components.length; i++) {
                components[i].setEnabled(true);
                components[i].setVisible(true);
            }

            jug.restarOro(ControladorConstantes.PRECIO_CASILLA);
            jug.agregarCasillasCompradas(1);
        }else{
            JOptionPane.showMessageDialog(null, "No tiene el oro necesario");
        }

    }

}
