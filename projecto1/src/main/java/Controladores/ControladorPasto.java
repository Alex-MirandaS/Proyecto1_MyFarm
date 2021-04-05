/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 *
 * @author alex
 */
public class ControladorPasto {

    public void añadirParcelaCultivo(JLabel component, String text) {
        if (component.getText().equals("")) {
            Component[] components = component.getComponents();
            component.setText(text);
            component.setEnabled(true);

            for (int i = 0; i < components.length; i++) {
                components[i].setEnabled(true);
            }
        }
    }
}
