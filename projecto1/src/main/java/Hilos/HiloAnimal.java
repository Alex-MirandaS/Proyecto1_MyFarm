/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import Animales.Animal;
import JuegoGUI.AnimalGUI;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex
 */
public class HiloAnimal implements Runnable{
//atributos
    private Animal animal;
    private AnimalGUI animalGUI;
    private int segundos = 2;
    private int vidaRestadaSeg = 1;
    private int contEdad = 0;
//constructor
    public HiloAnimal(Animal animal, AnimalGUI animalGUI) {
        this.animal = animal;
        this.animalGUI = animalGUI;
    }
//este metodo es el encargado de restar la vida de un animal, a cada cierto tiempo especifico, y al llegar su vida a 0, el animal 
    //esta muerto, durante la disminución de vida, tambien se incrementa la edad, y con esto, se incrementa la cantidad de objetos que brinda
    private void restarVida() throws InterruptedException {
        do {
            sleep(segundos * 1000);
            animal.restarVida(vidaRestadaSeg);
            animalGUI.getVidaAnimal().setText(animal.getVida() + "%");
            animalGUI.getEdadAnimal().setText("Edad: Bebé ");
            if (contEdad == 10) {
                animal.setEdad(2);
                animalGUI.getEdadAnimal().setText("Edad: Joven ");
            } else if (contEdad > 15) {
                animal.setEdad(3);
                animalGUI.getEdadAnimal().setText("Edad: Adulto ");
            }
            contEdad++;
        } while (animal.getVida() > 0);
        animal.setMuerto(true);
        animalGUI.getNombreAnimal().setText(" MUERTO");
        animalGUI.getVidaAnimal().setText("0 %");
        animalGUI.getEdadAnimal().setText("Edad: Anciano");
    }

    @Override
    public void run() {
        try {
            restarVida();
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloAnimal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
