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
//atributos
    private Lista<Casilla> casillas = new Lista<>();
    private int PRIMERA_CASILLA_POS = 36;
    private int contPasto = 1, contAgua = 1, contDesierto = 1;
    private Jugador jug;
    private Bodega bodega;
    private ControladorPlantas plantas;
    private ControladorAnimales animales;
//constructos
    public Granja(Jugador jug, Bodega bodega, ControladorPlantas plantas, ControladorAnimales animales) {
        this.jug = jug;
        this.bodega = bodega;
        this.plantas = plantas;
        this.animales = animales;
        LlenarCasillasAleatorias();
    }
//es el metodo encargado de llenar una lista de casillas, de manera aleatoria y siguiendo la distribución de todas las casillas creadas
    //en el tablero
    private void LlenarCasillasAleatorias() {
        int numAleatorio;
        for (int i = 0; i < (ControladorConstantes.X * ControladorConstantes.Y); i++) {
            numAleatorio = (int) (Math.random() * 3 + 1);

            if (numAleatorio == 1 && contPasto <= ((0.40) * (ControladorConstantes.X * ControladorConstantes.Y))) {
                casillas.add(new Pasto(jug, plantas, animales, bodega));
                contPasto++;
            } else if (numAleatorio == 1 && contPasto > ((0.40) * (ControladorConstantes.X * ControladorConstantes.Y))) {
                numAleatorio = 2;
            }
            if (numAleatorio == 2 && contAgua <= ((0.35) * (ControladorConstantes.X * ControladorConstantes.Y))) {
                casillas.add(new Agua(jug, bodega));
                contAgua++;
            } else if (numAleatorio == 1 && contAgua > ((0.40) * (ControladorConstantes.X * ControladorConstantes.Y))) {
                numAleatorio = 3;
            }
            if (numAleatorio == 3 && contDesierto < ((0.25) * (ControladorConstantes.X * ControladorConstantes.Y))) {
                casillas.add(new Desierto(jug));
            }
        }
    }
//se encarga de llenar el tablero, dejando a la vista un pequeño terreno inicial
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
