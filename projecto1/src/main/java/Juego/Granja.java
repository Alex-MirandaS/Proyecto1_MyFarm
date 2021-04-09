/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import Casillas.Agua;
import Casillas.Casilla;
import Casillas.Desierto;
import Casillas.Pasto;
import Controladores.ControladorAnimales;
import Controladores.ControladorCasillas;
import Controladores.ControladorConstantes;
import Controladores.ControladorPlantas;
import Listas.Lista;
import java.awt.GridLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author alex/
 */
public class Granja {

    private Lista<Casilla> casillas = new Lista<>();
    private int PRIMERA_CASILLA_POS = 36;
    private Jugador jug;
    private Bodega bodega;
    private ControladorPlantas plantas;
    private ControladorAnimales animales;

    public Granja(Jugador jug, Bodega bodega, ControladorPlantas plantas, ControladorAnimales animales) {
        this.jug = jug;
        this.bodega = bodega;
        this.plantas = plantas;
        this.animales = animales;
        LlenarCasillasAleatorias();
    }

    private void LlenarCasillasAleatorias() {
        int numAleatorio;
        for (int i = 0; i < (ControladorConstantes.X * ControladorConstantes.Y); i++) {
            numAleatorio = (int) (Math.random() * 100 + 1);

            if (numAleatorio > 0 && numAleatorio < 41) {
                casillas.add(new Pasto(i, jug, plantas, animales, bodega));
            } else if (numAleatorio > 40 && numAleatorio < 76) {
                casillas.add(new Agua(i, jug, bodega));
            } else {
                casillas.add(new Desierto(i, jug));
            }
        }
    }

    public void LlenarTablero(JPanel panel) {
        panel.setLayout(new GridLayout(ControladorConstantes.Y, ControladorConstantes.X));
        ControladorCasillas controlador = new ControladorCasillas();
        int contX = 0;
        int contY = 0;
        for (int i = 0; i < casillas.getSize(); i++) {

            if (i >= PRIMERA_CASILLA_POS && i < (PRIMERA_CASILLA_POS + ControladorConstantes.XD)) {
                contX++;
                if (contX == ControladorConstantes.XD && contY < ControladorConstantes.YD - 1) {
                    PRIMERA_CASILLA_POS += ControladorConstantes.X;
                    contY++;
                    contX = 0;
                }
            } else {
                controlador.bloquearCasillas((JComponent) casillas.get(i).getFigura());
            }
            panel.add(casillas.get(i).getFigura());
        }
    }

    public Lista<Casilla> getCasillas() {
        return casillas;
    }

}
