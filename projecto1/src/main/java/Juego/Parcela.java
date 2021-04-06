/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import Animales.Animal;
import Controladores.ControladorAnimales;
import Controladores.ControladorConstantes;
import JuegoGUI.ParcelaGUI;
import Listas.Lista;
import java.awt.GridLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author alex
 */
public class Parcela {

    private Lista<Animal> animales;
    private ControladorAnimales animalesJuego;
    private Animal tipo;
    private static int cParcelas = 0;
    private int espacio, ancho, alto;
    private ParcelaGUI figuraParcela;

//GUI
    public Parcela(Animal tipo, ControladorAnimales animalesJuego) {
        animales = new Lista<>();
        this.animalesJuego = animalesJuego;
        this.tipo = tipo;
        espacio = ControladorConstantes.LIM_PARCELA;
        dimensionarParcelaAnimales((int) (espacio / tipo.getEspacio()));

        figuraParcela = new ParcelaGUI(this);
        GridLayout animalLayout = new GridLayout(ancho, alto);
        figuraParcela.getContenedorAnimalesParcela().setLayout(animalLayout);
        cParcelas++;
    }

    public void llenarParcela(int cAnimales, Animal animal) {
        if (tipo == animal) {
            if (tipo.getEspacio() * cAnimales <= espacio) {
                for (int i = 0; i < cAnimales; i++) {
                    animales.add(tipo);
                }
                espacio -= tipo.getEspacio() * cAnimales;
            } else {
                JOptionPane.showMessageDialog(null, "La parcela no puede almacenar esa cantidad de animales");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Esta parcela no acepta este tipo de animal");
        }
        figuraParcela.getContenedorAnimalesParcela().removeAll();
        mostrarAnimales();
    }

    private void dimensionarParcelaAnimales(int cAnimales) {

        int division = (cAnimales / 2);

        if (division % 2 != 0.0) {
            double divisionDouble = division;

            alto = (int) Math.ceil(divisionDouble / 2);
            ancho = ((division - 1) / 2);

        } else {
            int cuadrado = (division / 2);
            ancho = cuadrado;
            alto = cuadrado;
        }

    }

    private void mostrarAnimales() {
        for (int i = 0; i < animales.getSize(); i++) {
            figuraParcela.getContenedorAnimalesParcela().add(animales.get(i).getFiguraAnimal(i));
        }
    }

    public void mostrarParcela() {
        figuraParcela.setVisible(true);//poner boton recolectar
    }

    public Lista<Animal> getAnimales() {
        return animales;
    }

    public void setAnimales(Lista<Animal> animales) {
        this.animales = animales;
    }

    public static int getCParcelas() {
        return cParcelas;
    }

    public ControladorAnimales getAnimalesJuego() {
        return animalesJuego;
    }
    
    

}
