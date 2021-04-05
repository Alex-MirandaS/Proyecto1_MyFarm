/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import Plantas.Planta;

/**
 *
 * @author alex
 */
public class Caja {

    private Planta planta;
    private int existencia;

    public Caja(Planta planta) {
        this.planta = planta;
    }
    
    public void mientras(){
        System.out.println("Caja que contiene: "+planta.getNombre()+" con existencias de: "+existencia);
    }

    public Planta getPlanta() {
        return planta;
    }

    public void setPlanta(Planta planta) {
        this.planta = planta;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public void agregartExistencia(int existencia) {
        this.existencia += existencia;
    }

    public void restarExistencia(int existencia) {
        this.existencia -= existencia;
    }

}
