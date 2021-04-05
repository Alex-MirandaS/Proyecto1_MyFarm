/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JComponent;

/**
 *
 * @author alex
 */
public class ControladorCasillas {

    public void bloquearCasillas(JComponent component) {
        Component[] components = component.getComponents();
        component.setEnabled(false);
        component.setBackground(Color.darkGray);
        for (int i = 0; i < components.length; i++) {
            components[i].setEnabled(false);
        }
    }

    public void desbloquearCasillas(JComponent component, Color color) {
        Component[] components = component.getComponents();
        component.setEnabled(true);
        component.setBackground(color);
        for (int i = 0; i < components.length; i++) {
            components[i].setEnabled(true);
        }
    }

}
