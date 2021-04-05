/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Plantas;

import JuegoGUI.PlantaGUI;

/**
 * 
 * @author alex
 */
public abstract class Planta {

    protected int semillas, vida;
    protected String nombre;
    protected boolean plantaLista = false;
    protected PlantaGUI figuraPlanta = new PlantaGUI();

    public Planta(int semillas, String nombre) {
        this.semillas = semillas;
        this.nombre = nombre;
    }
    
    public abstract void marchitar();

    public int getSemillas() {
        return semillas;
    }

    public int getVida() {
        return vida;
    }

    public String getNombre() {
        return nombre;
    }   

    public boolean isPlantaLista() {
        return plantaLista;
    }

    public void setPlantaLista(boolean plantaLista) {
        this.plantaLista = plantaLista;
    }
    
    
}
