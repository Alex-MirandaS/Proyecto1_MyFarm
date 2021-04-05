/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import Controladores.ControladorPlantas;
import Listas.Lista;

/**
 *
 * @author alex
 */
public class Bodega {

    private ControladorPlantas controlPlantas;
    private Lista<Caja> contenedor = new Lista<>();
//tambien productos

    public Bodega(ControladorPlantas controlPlantas) {
        this.controlPlantas = controlPlantas;
        crearCajas();
    }

    private void crearCajas() {
        for (int i = 0; i < controlPlantas.getPlantasJuego().getSize(); i++) {
            contenedor.add(new Caja(controlPlantas.getPlantasJuego().get(i)));
        }
    }

    public Lista<Caja> getContenedor() {
        return contenedor;
    }

}
