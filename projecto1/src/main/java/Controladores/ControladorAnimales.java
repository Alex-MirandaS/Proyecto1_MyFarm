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
import MenusGUI.AgregarProductoAnimalesGUI;
import Productos.Alimento;
import Productos.MateriaPrima;
import Productos.Producto;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;

/**
 *
 * @author alex
 */
public class ControladorAnimales{

    private Lista<Animal> animalesJuego;
    private Lista<Producto> temp;
    private Animal tempAnimal;
    private AgregarAnimalesGUI agregarAnimal;
    private AgregarProductoAnimalesGUI agregarProducto;
    private ControladorProductos productosJuego;

    public ControladorAnimales(ControladorProductos productosJuego) {
        animalesJuego = new Lista<>();
        this.productosJuego = productosJuego;
        llenadoInicial();
        agregarAnimal = new AgregarAnimalesGUI(this);
        agregarProducto = new AgregarProductoAnimalesGUI(this);
    }

    public void iniciar() {
        agregarAnimal.setVisible(true);
    }

    public void crearAnimal(String nombre, double espacio, String tipoProducto, String elección) {
        if (nombre == "") {
            JOptionPane.showMessageDialog(null, "No ha ingresado el nombre del Animal");
        } else {
            if (elección == "Herbívoro") {
                tempAnimal = new Herbívoro(nombre, (double) espacio, tipoProducto);
                animalesJuego.add(tempAnimal);
            } else {
                tempAnimal = new Herbívoro(nombre, (double) espacio, tipoProducto);
                animalesJuego.add(tempAnimal);
            }
            ingresarProductosAnimal(tipoProducto);
        }
    }

    public void mostrarListaAnimales(JTextArea pantalla) {
        for (int i = 0; i < animalesJuego.getSize(); i++) {
            pantalla.append(animalesJuego.get(i).getNombre());
            pantalla.append(System.getProperty("line.separator"));
        }
    }

    public void verificarDestace(String tipoProducto) {
        if (tipoProducto == "Destace") {
            agregarProducto.getAgregarProductosSinDestace().setVisible(false);
            agregarProducto.getAreaTextoPsinDestace().setVisible(false);
            agregarProducto.getTituloSinDestace().setVisible(false);
            agregarProducto.getProductosDisponibles2().setVisible(false);
        } else if (tipoProducto == "Sin Destace") {
            agregarProducto.getAgregarProductosConDestace().setVisible(false);
            agregarProducto.getAreaTextoPporDestace().setVisible(false);
            agregarProducto.getTituloDestace().setVisible(false);
            agregarProducto.getProductosDisponibles1().setVisible(false);
        } else {
            agregarProducto.getAgregarProductosSinDestace().setVisible(true);
            agregarProducto.getAreaTextoPsinDestace().setVisible(true);
            agregarProducto.getTituloSinDestace().setVisible(true);
            agregarProducto.getProductosDisponibles2().setVisible(true);
            agregarProducto.getAgregarProductosConDestace().setVisible(true);
            agregarProducto.getAreaTextoPporDestace().setVisible(true);
            agregarProducto.getTituloDestace().setVisible(true);
            agregarProducto.getProductosDisponibles1().setVisible(true);
        }
    }

    public void ingresarProductosAnimal(String tipoProducto) {
        agregarProducto.setVisible(true);
        temp = productosJuego.getProductosJuego();
        verificarDestace(tipoProducto);
        llenarOpciones();
    }

    private void llenarOpciones() {
        llenarListaOpciones(agregarProducto.getProductosDisponibles1());
        llenarListaOpciones(agregarProducto.getProductosDisponibles2());
    }

    private void llenarListaOpciones(JComboBox opciones) {
        for (int i = 0; i < temp.getSize(); i++) {
            opciones.addItem(temp.get(i).getNombre());
        }
    }
    
        public void llenarListaOp(JComboBox opciones) {
        for (int i = 0; i < animalesJuego.getSize(); i++) {
            opciones.addItem(animalesJuego.get(i).getNombre());
        }
    }

    public void agregarProductos(JTextArea pantalla) {
        pantalla.setText("");
        if (pantalla == agregarProducto.getAreaTextoPporDestace()) {
            tempAnimal.getDestace().add(temp.get(agregarProducto.getProductosDisponibles1().getSelectedIndex()));
            mostrarListaProductos(pantalla, tempAnimal.getDestace());
            temp.eliminar(agregarProducto.getProductosDisponibles1().getSelectedIndex());
        } else {
            tempAnimal.getSinDestace().add(temp.get(agregarProducto.getProductosDisponibles2().getSelectedIndex()));
            mostrarListaProductos(pantalla, tempAnimal.getSinDestace());
            temp.eliminar(agregarProducto.getProductosDisponibles2().getSelectedIndex());
        }
        
        agregarProducto.getProductosDisponibles1().removeAllItems();
        agregarProducto.getProductosDisponibles2().removeAllItems();
        llenarOpciones();
    }

    public void mostrarListaProductos(JTextArea pantalla, Lista<Producto> temp) {
        for (int i = 0; i < temp.getSize(); i++) {
            pantalla.append(temp.get(i).getNombre());
            pantalla.append(System.getProperty("line.separator"));
        }
    }

    private void llenadoInicial() {
        Animal vaca = new Herbívoro(ControladorConstantes.HERBÍVORO1, ControladorConstantes.ESPACIO_HERBÍVORO1, ControladorConstantes.AMBAS);
        vaca.getSinDestace().add(productosJuego.getProductosJuego().get(2));
        vaca.getDestace().add(productosJuego.getProductosJuego().get(5));
        vaca.getDestace().add(productosJuego.getProductosJuego().get(4));
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
