/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import Animales.Animal;
import Animales.Herbívoro;
import Controladores.ControladorConstantes;
import Hilos.HiloAnimal;
import JuegoGUI.AnimalGUI;
import JuegoGUI.ParcelaGUI;
import Listas.Lista;
import Productos.ComidaAnimales;
import Productos.ComidaAnimalesHerbívoros;
import Productos.ComidaAnimalesOmnívoros;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author alex
 */
public class Parcela {
//atributos
    private Lista<Animal> animales;
    private Lista<AnimalGUI> animalesGUI;
    private Animal tipo;
    private int espacio, ancho = 5, alto;
    private ParcelaGUI figuraParcela;
    private JLabel figuraParcelaCasilla = new JLabel();
    private Bodega bodega;
    private Jugador Jug;
    private String productoTemp;
    private int cantidadTemp;

//constructor
    public Parcela(Animal tipo, Bodega bodega, Jugador jug) {
        this.figuraParcelaCasilla.setText("Parcela de " + tipo.getNombre() + "s");
        animales = new Lista<>();
        animalesGUI = new Lista<>();
        this.tipo = tipo;
        this.bodega = bodega;
        this.Jug = jug;
        espacio = ControladorConstantes.LIM_PARCELA;
        dimensionarParcelaAnimales((ControladorConstantes.LIM_PARCELA / tipo.getEspacio()));
        figuraParcela = new ParcelaGUI(this);
        figuraParcela.getPrecio().setText("Precio: ");
        verificarFiguraParcela();
        llenarListaAlimentos();
    }
//es el encargado de llenar la parcela segun la cantidad de animales que desee, verificando asi que posea la cantidad necesaria para su compra
    //verificar si aun queda espacio dentro de la parcela, y al acatar estas condiciones, se agrega un nuevo animal
    public void llenarParcela(int cAnimales) {
        if (Jug.getOro() >= cAnimales * tipo.getPrecio()) {
            if (tipo.getEspacio() * cAnimales <= espacio) {
                for (int i = 0; i < cAnimales; i++) {
                    Animal temp = new Animal(tipo.getNombre(), tipo.getEspacio(), tipo.getObtenerProducto(), tipo.getPrecio());
                    tipo.agregarCriasCompradas(cAnimales);
                    llenarProductosAnimal(temp);
                    AnimalGUI tempGUI = new AnimalGUI(tipo.getNombre(), this);
                    animales.add(temp);
                    animalesGUI.add(tempGUI);
                    Thread animal = new Thread(new HiloAnimal(temp, tempGUI));
                    animal.start();
                }
                Jug.restarOro(cAnimales );
                espacio -= tipo.getEspacio() * cAnimales;
            } else {
                JOptionPane.showMessageDialog(null, "La parcela no puede almacenar esa cantidad de animales");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No tiene la cantidad necesaria");
        }
        figuraParcela.getContenedorAnimalesParcela().removeAll();
        mostrarAnimales();
    }
//dimensiona las casillas de la parcela
    private void dimensionarParcelaAnimales(double cAnimales) {
        alto = (int) Math.ceil(cAnimales / ancho);
    }
//refresca la ventana con los animales que se posee actualmente
    private void mostrarAnimales() {
        figuraParcela.getContenedorAnimalesParcela().setLayout(new GridLayout(alto, ancho));
        for (int i = 0; i < animales.getSize(); i++) {
            figuraParcela.getContenedorAnimalesParcela().add(animalesGUI.get(i));
        }
    }
//muestra la figura de la paracela, en donde dentro se encuentran los animales
    public void mostrarParcela() {
        figuraParcela.setVisible(true);
    }
//manda un booleano a todos los animales para que esten preparados para dar productos generados sin destace
    public void prepararProductosSinDestace() {
        for (int i = 0; i < animalesGUI.getSize(); i++) {
            boolean temp = animalesGUI.get(i).isPrepararProductosSinDestace();
            animalesGUI.get(i).setPrepararProductosSinDestace(!temp);
        }
    }
//agrega los productos generados sin destace del animal, segun la edad que tenga
    public void agregarProductosSinDestace(AnimalGUI figuraAnimal) {
        String nombreProducto;
        if (animales.get(buscarAnimalGUI(figuraAnimal)).isMuerto() == false) {
            for (int i = 0; i < tipo.getSinDestace().getSize(); i++) {
                nombreProducto = tipo.getSinDestace().get(i).getNombre();
                bodega.getContenedor().get(buscarProducto(nombreProducto)).agregartExistencia(1 * animales.get(buscarAnimalGUI(figuraAnimal)).getEdad());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Este animal esta Muerto");
        }
    }
//manda un booleano a todos los animales para que esten preparados para dar productos generados con destace
    //para despues desaparecer de la parcela
    public void prepararProductosConDestace() {
        for (int i = 0; i < animalesGUI.getSize(); i++) {
            boolean temp = animalesGUI.get(i).isPrepararProductosConDestace();
            animalesGUI.get(i).setPrepararProductosConDestace(!temp);
        }
    }
//agrega los productos generados con destace del animal, segun la edad que tenga, y luego el animal es eliminado de la parcela
    public void agregarProductosConDestace(AnimalGUI figuraAnimal) {
        String nombreProducto;
        if (animales.get(buscarAnimalGUI(figuraAnimal)).isMuerto() == false) {
            for (int i = 0; i < tipo.getDestace().getSize(); i++) {
                nombreProducto = tipo.getDestace().get(i).getNombre();
                bodega.getContenedor().get(buscarProducto(nombreProducto)).agregartExistencia(1*animales.get(buscarAnimalGUI(figuraAnimal)).getEdad());
            }
            tipo.agregarAnimalesDestazados(1);
            animales.eliminar(buscarAnimalGUI(figuraAnimal));
            animalesGUI.eliminar(buscarAnimalGUI(figuraAnimal));
            figuraParcela.getContenedorAnimalesParcela().removeAll();
            mostrarAnimales();
        } else {
            JOptionPane.showMessageDialog(null, "Este animal esta Muerto");
        }

    }
//buscador de productos segun un nombre
    public int buscarProducto(String nombreProducto) {
        for (int i = 0; i < bodega.getContenedor().getSize(); i++) {
            if (nombreProducto.equals(bodega.getContenedor().get(i).getProducto().getNombre())) {
                return i;
            }
        }
        return 0;
    }
//busca el indice de un animal, por medio de su figura
    public int buscarAnimalGUI(AnimalGUI buscarAnimalGUI) {
        for (int i = 0; i < animalesGUI.getSize(); i++) {
            if (buscarAnimalGUI.equals(animalesGUI.get(i))) {
                return i;
            }
        }
        return 0;
    }
//manda un booleano a los animales para que se preparen para alimentarse, y asi incrementar su vida
    
    public void preparararAlimentar(String producto, int cantidad) {
        this.productoTemp = producto;
        this.cantidadTemp = cantidad;
        for (int i = 0; i < animalesGUI.getSize(); i++) {
            boolean temp = animalesGUI.get(i).isPrepararAlimentar();
            animalesGUI.get(i).setPrepararAlimentar(!temp);
        }
    }
//es el encargado de alimentar a los animales, indicando la cantidad que deseamos que coma, y el producto que deseamos ingiera
    //segun esto, el animal incrementa su vida
    public void alimentar(AnimalGUI figuraAnimal) {
        if (bodega.getContenedor().get(buscarProducto(productoTemp)).getExistencia() >= cantidadTemp) {
            bodega.getContenedor().get(buscarProducto(productoTemp)).restarExistencia(cantidadTemp);
            ComidaAnimales comida = (ComidaAnimales) bodega.getContenedor().get(buscarProducto(productoTemp)).getProducto();
            animales.get(buscarAnimalGUI(figuraAnimal)).sumarVida(comida.getCantidad());
            figuraParcela.getContenedorAnimalesParcela().removeAll();
            mostrarAnimales();
        } else {
            JOptionPane.showMessageDialog(null, "No posee esta cantidad dentro de su Bodega");
        }
    }
//llena la lista de alimientos segun el tipo de animal
    private void llenarListaAlimentos() {
        if (tipo instanceof Herbívoro) {
            for (int i = 0; i < bodega.getContenedor().getSize(); i++) {
                if (bodega.getContenedor().get(i).getProducto() instanceof ComidaAnimalesHerbívoros) {
                    figuraParcela.getAlimentosDisponibles().addItem(bodega.getContenedor().get(i).getProducto().getNombre());
                }
            }
        } else {
            for (int i = 0; i < bodega.getContenedor().getSize(); i++) {
                if (bodega.getContenedor().get(i).getProducto() instanceof ComidaAnimalesOmnívoros) {
                    figuraParcela.getAlimentosDisponibles().addItem(bodega.getContenedor().get(i).getProducto().getNombre());
                }
            }
        }
    }
//manda un booleano a todos los animales, verificando si el animal esta vivo o muerto
    public void prepararLimpiar() {
        for (int i = 0; i < animalesGUI.getSize(); i++) {
            boolean temp = animalesGUI.get(i).isPrepararLimpiar();
            animalesGUI.get(i).setPrepararLimpiar(!temp);
        }
    }
//al limpiar el terreno, se verifica que el animal este muerto, de lo contrario no se puede remover de la parcela
    public void limpiar(AnimalGUI figuraAnimalGUI) {
        if (animales.get(buscarAnimalGUI(figuraAnimalGUI)).isMuerto()) {
            animales.eliminar(buscarAnimalGUI(figuraAnimalGUI));
            animalesGUI.eliminar(buscarAnimalGUI(figuraAnimalGUI));
            figuraParcela.getContenedorAnimalesParcela().removeAll();
            mostrarAnimales();
        } else {
            JOptionPane.showMessageDialog(null, "Este animal no esta muerto");
        }
    }
//obtiene las existencias del alimento que se desea dar a los animales
    public String obtenerExistenciasAlimento(String nombre) {
        return "" + bodega.getContenedor().get(buscarProducto(nombre)).getExistencia();
    }
//verifica si las listas de productos del animal esten llenas, de lo contrario, ciertas funciones se bloquearán
    private void verificarFiguraParcela() {
        if (tipo.getDestace().esVacia()) {
            figuraParcela.getDestasar().setVisible(false);
        } else if (tipo.getSinDestace().esVacia()) {
            figuraParcela.getRecolectarProductos().setVisible(false);
        }
    }
//llena los productos de un nuevo animal, con los productos producidos por el tipo de animal que acepta la parcela
    private void llenarProductosAnimal(Animal animal) {
        for (int i = 0; i < tipo.getDestace().getSize(); i++) {
            animal.getDestace().add(tipo.getDestace().get(i));
        }
        for (int i = 0; i < tipo.getSinDestace().getSize(); i++) {
            animal.getSinDestace().add(tipo.getSinDestace().get(i));
        }
    }

    public Lista<Animal> getAnimales() {
        return animales;
    }

    public void setAnimales(Lista<Animal> animales) {
        this.animales = animales;
    }

    public Animal getTipo() {
        return tipo;
    }

    public JLabel getFiguraParcelaCasilla() {
        return figuraParcelaCasilla;
    }

}
