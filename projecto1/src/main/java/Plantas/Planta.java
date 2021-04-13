/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Plantas;

import javax.swing.JLabel;



/**
 * 
 * @author alex
 */
public abstract class Planta {
//atributos
    protected int semillas, vida;
    protected String nombre;
    protected boolean plantaLista = false;
    protected JLabel figuraPlanta = new JLabel();
    protected Planta plantaCosechada;
    
//constructor
    public Planta(int semillas, String nombre) {
        this.semillas = semillas;
        this.nombre = nombre;
        this.figuraPlanta.setText(nombre);
    }
    //metodos abstractos
    public abstract void marchitar();
    
    public abstract void cosechar(JLabel img, JLabel imgCasilla);

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

    public JLabel getFiguraPlanta() {
        return figuraPlanta;
    }

    public Planta getPlantaCosechada() {
        return plantaCosechada;
    }
    
}
