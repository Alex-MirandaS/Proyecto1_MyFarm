/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Animales.Animal;
import Animales.Herbívoro;
import Animales.Omnívoro;
import Listas.Lista;
import MenusGUI.AgregarAnimalesGUI;
import Productos.Alimento;
import Productos.MateriaPrima;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author alex
 */
public class ControladorAnimales {

    private Lista<Animal> animalesJuego;
    private AgregarAnimalesGUI agregarAnimal;
    //private AgregarProductoGeneradoGUI agregarProducto;
    private ControladorProductos productosJuego;

    public ControladorAnimales(ControladorProductos productosJuego) {
        animalesJuego = new Lista<>();
        this.productosJuego = productosJuego;
        llenadoInicial();
        agregarAnimal = new AgregarAnimalesGUI(this);
    }

    public void iniciar() {
        agregarAnimal.setVisible(true);
    }

    public void crearAnimal(String nombre, double espacio, String tipoProducto, String elección) {
        if (nombre == "") {
            JOptionPane.showMessageDialog(null, "No ha ingresado el nombre del Animal");
        } else {
            Animal temp;
            if (elección == "Herbívoro") {
                temp = new Herbívoro(nombre, (double) espacio, tipoProducto);
                animalesJuego.add(temp);
            } else {
                temp = new Herbívoro(nombre, (double) espacio, tipoProducto);
                animalesJuego.add(temp);
            }
            productosAnimal(temp);
        }
    }

    public void mostrarListaAnimales(JTextArea pantalla) {
        for (int i = 0; i < animalesJuego.getSize(); i++) {
            pantalla.append(animalesJuego.get(i).getNombre());
            pantalla.append(System.getProperty("line.separator"));
        }
    }

    private void productosAnimal(Animal animal) {
        if (animal.getObtenerProducto() == "Ambas") {
            animal.getDestace().add( productosJuego.getProductosJuego().get(2));
            animal.getSinDestace().add(productosJuego.getProductosJuego().get(0));
        } else if (animal.getObtenerProducto() == "Destace") {
            animal.getDestace().add((MateriaPrima) productosJuego.getProductosJuego().get(2));
        } else {
            animal.getSinDestace().add((Alimento) productosJuego.getProductosJuego().get(0));
        }
    }

    private void llenadoInicial() {
        Animal vaca = new Herbívoro(ControladorConstantes.HERBÍVORO1, ControladorConstantes.ESPACIO_HERBÍVORO1, ControladorConstantes.AMBAS);
        vaca.getSinDestace().add(productosJuego.getProductosJuego().get(2));
        vaca.getDestace().add(productosJuego.getProductosJuego().get(5));
        vaca.getDestace().add( productosJuego.getProductosJuego().get(4));
        animalesJuego.add(vaca);
        Animal gallina = new Omnívoro(ControladorConstantes.OMNÍVORO1, ControladorConstantes.ESPACIO_OMNÍVORO1, ControladorConstantes.AMBAS);
        gallina.getSinDestace().add(productosJuego.getProductosJuego().get(3));
        gallina.getDestace().add(productosJuego.getProductosJuego().get(6));
        animalesJuego.add(gallina);
    }

    public Lista<Animal> getAnimalesJuego() {
        return animalesJuego;
    }

}
