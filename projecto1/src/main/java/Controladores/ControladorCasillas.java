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
        }
    }

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
            }

            jug.restarOro(ControladorConstantes.PRECIO_CASILLA);
        }else{
            JOptionPane.showMessageDialog(null, "No tiene el oro necesario");
        }

    }

}
