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
import Productos.ComidaAnimales;
import Productos.Fertilizante;
import Productos.Producto;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author alex
 */
public class ControladorAnimales {
//atributos
    private Lista<Animal> animalesJuego;
    private Lista<Producto> temp;
    private Animal tempAnimal;
    private AgregarAnimalesGUI agregarAnimal;
    private AgregarProductoAnimalesGUI agregarProducto;
    private ControladorProductos productosJuego;
//constructor
    public ControladorAnimales(ControladorProductos productosJuego) {
        animalesJuego = new Lista<>();
        this.productosJuego = productosJuego;
        llenadoInicial();
        agregarAnimal = new AgregarAnimalesGUI(this);
        agregarProducto = new AgregarProductoAnimalesGUI(this);
    }
//muestra el menu para agregar animales al juego
    public void iniciar() {
        agregarAnimal.setVisible(true);
    }
//se encarga de crear un animal, segun su nombre, el espacio que ocupa, la manera en que se obtendra productos
    //la eleccion si es herbívoro o Omnívoro, y el coste del mismo
    public void crearAnimal(String nombre, double espacio, String tipoProducto, String elección, int precio) {
        if (nombre == "") {
            JOptionPane.showMessageDialog(null, "No ha ingresado el nombre del Animal");
        } else {
            if (elección == "Herbívoro") {
                tempAnimal = new Herbívoro(nombre, (double) espacio, tipoProducto, precio);
                animalesJuego.add(tempAnimal);
            } else {
                tempAnimal = new Herbívoro(nombre, (double) espacio, tipoProducto, precio);
                animalesJuego.add(tempAnimal);
            }
            ingresarProductosAnimal(tipoProducto);
        }
    }
//muestra la lista de animales reciente
    public void mostrarListaAnimales(JTextArea pantalla) {
        for (int i = 0; i < animalesJuego.getSize(); i++) {
            pantalla.append(animalesJuego.get(i).getNombre());
            pantalla.append(System.getProperty("line.separator"));
        }
    }
//verifica la elección del usuario, para asi bloquear las elecciones
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
//se encarga del ingreso de los productos que el animal vaya a producir, ya sea por destace, como sin destace
    public void ingresarProductosAnimal(String tipoProducto) {
        agregarProducto.setVisible(true);
        temp = productosJuego.getProductosJuego();
        verificarDestace(tipoProducto);
        llenarOpciones();
    }
//llena las opciones de las listas en donde se selecciona el producto que producira el animal
    private void llenarOpciones() {
        llenarListaOpciones(agregarProducto.getProductosDisponibles1());
        llenarListaOpciones(agregarProducto.getProductosDisponibles2());
    }
//llena cada lista de los posibles productos a producir, todos menos los fertilizantes y la comida de los animales
    private void llenarListaOpciones(JComboBox opciones) {
        for (int i = 0; i < temp.getSize(); i++) {
            if (temp.get(i) instanceof ComidaAnimales || temp.get(i) instanceof Fertilizante) {

            } else {
                opciones.addItem(temp.get(i).getNombre());
            }
        }
    }
//se encarga de llenar la lista de opciones de todos los animales creados
    public void llenarListaOp(JComboBox opciones) {
        for (int i = 0; i < animalesJuego.getSize(); i++) {
            opciones.addItem(animalesJuego.get(i).getNombre());
        }
    }
//Es el encargado de agregar productos seleccionados para un animal en especifico, mostrandolos en pantalla
    public void agregarProductos(JTextArea pantalla) {
        pantalla.setText("");
        if (pantalla == agregarProducto.getAreaTextoPporDestace()) {
            tempAnimal.getDestace().add(temp.get(buscarIndice((String)agregarProducto.getProductosDisponibles1().getSelectedItem())));
            mostrarListaProductos(pantalla, tempAnimal.getDestace());
            temp.eliminar(buscarIndice((String)agregarProducto.getProductosDisponibles1().getSelectedItem()));
        } else {
            tempAnimal.getSinDestace().add(temp.get(buscarIndice((String)agregarProducto.getProductosDisponibles2().getSelectedItem())));
            mostrarListaProductos(pantalla, tempAnimal.getSinDestace());
            temp.eliminar(buscarIndice((String)agregarProducto.getProductosDisponibles2().getSelectedItem()));
        }

        agregarProducto.getProductosDisponibles1().removeAllItems();
        agregarProducto.getProductosDisponibles2().removeAllItems();
        llenarOpciones();
    }
//muestra la lista de productos disponibles para agregar a los animales
    public void mostrarListaProductos(JTextArea pantalla, Lista<Producto> temp) {
        for (int i = 0; i < temp.getSize(); i++) {
            pantalla.append(temp.get(i).getNombre());
            pantalla.append(System.getProperty("line.separator"));
        }
    }
//es el llenado inicial de animales con sus respectivos productos y valores, son los animales predeterminados
    private void llenadoInicial() {
        Animal vaca = new Herbívoro(ControladorConstantes.HERBÍVORO1, ControladorConstantes.ESPACIO_HERBÍVORO1, ControladorConstantes.AMBAS, ControladorConstantes.PRECIO_HERBÍVORO1);
        vaca.getSinDestace().add(productosJuego.getProductosJuego().get(2));
        vaca.getDestace().add(productosJuego.getProductosJuego().get(5));
        vaca.getDestace().add(productosJuego.getProductosJuego().get(4));
        animalesJuego.add(vaca);
        Animal gallina = new Omnívoro(ControladorConstantes.OMNÍVORO1, ControladorConstantes.ESPACIO_OMNÍVORO1, ControladorConstantes.AMBAS, ControladorConstantes.PRECIO_OMNÍVORO1);
        gallina.getSinDestace().add(productosJuego.getProductosJuego().get(3));
        gallina.getDestace().add(productosJuego.getProductosJuego().get(6));
        animalesJuego.add(gallina);
    }
    //busca el indice dentro de una lista, para hallar el producto
        public int buscarIndice(String objetoSeleccionado) {
        for (int i = 0; i < temp.getSize(); i++) {
            if (objetoSeleccionado.equals(temp.get(i).getNombre())) {
                return i;
            }
        }
        return 0;
    }

    public Lista<Animal> getAnimalesJuego() {
        return animalesJuego;
    }

}
