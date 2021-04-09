/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import Animales.Animal;
import Controladores.ControladorConstantes;
import JuegoGUI.AnimalGUI;
import JuegoGUI.ParcelaGUI;
import Listas.Lista;
import Productos.Producto;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author alex
 */
public class Parcela {

    private Lista<Animal> animales;
    private Lista<AnimalGUI> animalesGUI;
    private Animal tipo;
    private static int cParcelas = 0;
    private int espacio, ancho = 5, alto;
    private ParcelaGUI figuraParcela;
    private JLabel figuraParcelaCasilla = new JLabel();
    private Bodega bodega;

//GUI
    public Parcela(Animal tipo, Bodega bodega) {
        this.figuraParcelaCasilla.setText("Parcela de " + tipo.getNombre() + "s");
        animales = new Lista<>();
        animalesGUI = new Lista<>();
        this.tipo = tipo;
        this.bodega = bodega;
        espacio = ControladorConstantes.LIM_PARCELA;
        dimensionarParcelaAnimales((ControladorConstantes.LIM_PARCELA / tipo.getEspacio()));
        figuraParcela = new ParcelaGUI(this);
        verificarFiguraParcela();
        cParcelas++;
    }

    public void llenarParcela(int cAnimales) {

        if (tipo.getEspacio() * cAnimales <= espacio) {
            for (int i = 0; i < cAnimales; i++) {
                animales.add(tipo);
            }
            espacio -= tipo.getEspacio() * cAnimales;
        } else {
            JOptionPane.showMessageDialog(null, "La parcela no puede almacenar esa cantidad de animales");
        }
        figuraParcela.getContenedorAnimalesParcela().removeAll();
        mostrarAnimales();
    }

    private void dimensionarParcelaAnimales(double cAnimales) {
        alto = (int) Math.ceil(cAnimales / ancho);
    }

    private void mostrarAnimales() {
        figuraParcela.getContenedorAnimalesParcela().setLayout(new GridLayout(alto, ancho));
        for (int i = 0; i < animales.getSize(); i++) {
            animalesGUI.add(new AnimalGUI(tipo.getNombre(), this));
            figuraParcela.getContenedorAnimalesParcela().add(animalesGUI.get(i));
        }
    }

    public void mostrarParcela() {
        figuraParcela.setVisible(true);//poner boton recolectar
    }

    public void prepararProductosSinDestace() {
        for (int i = 0; i < animalesGUI.getSize(); i++) {
            boolean temp = animalesGUI.get(i).isPrepararProductosSinDestace();
            animalesGUI.get(i).setPrepararProductosSinDestace(!temp);
        }
    }

    public void agregarProductosSinDestace() {
        String nombreProducto;
        for (int i = 0; i < tipo.getSinDestace().getSize(); i++) {
            nombreProducto = tipo.getSinDestace().get(i).getNombre();
            bodega.getContenedor().get(buscarProducto(nombreProducto)).agregartExistencia(1);
        }
    }

    public void prepararProductosConDestace() {
        for (int i = 0; i < animalesGUI.getSize(); i++) {
            boolean temp = animalesGUI.get(i).isPrepararProductosConDestace();
            animalesGUI.get(i).setPrepararProductosConDestace(!temp);
        }
    }

    public void agregarProductosConDestace(AnimalGUI figuraAnimal) {
        String nombreProducto;
        for (int i = 0; i < tipo.getDestace().getSize(); i++) {
            nombreProducto = tipo.getDestace().get(i).getNombre();
            bodega.getContenedor().get(buscarProducto(nombreProducto)).agregartExistencia(1);
        }
        animales.eliminar(buscarAnimalGUI(figuraAnimal));
        animalesGUI.eliminar(buscarAnimalGUI(figuraAnimal));
        figuraParcela.getContenedorAnimalesParcela().removeAll();
        mostrarAnimales();
    }

    public int buscarProducto(String nombreProducto) {
        for (int i = 0; i < bodega.getContenedor().getSize(); i++) {
            if (nombreProducto.equals(bodega.getContenedor().get(i).getProducto().getNombre())) {
                return i;
            }
        }
        return 0;
    }

    public int buscarAnimalGUI(AnimalGUI buscarAnimalGUI) {
        for (int i = 0; i < animalesGUI.getSize(); i++) {
            if (buscarAnimalGUI.equals(animalesGUI.get(i))) {
                return i;
            }
        }
        return 0;
    }

    public void verificarFiguraParcela() {
        if (tipo.getDestace().esVacia()) {
            figuraParcela.getDestasar().setVisible(false);
        } else if (tipo.getSinDestace().esVacia()) {
            figuraParcela.getRecolectarProductos().setVisible(false);
        }
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

    public Animal getTipo() {
        return tipo;
    }

    public JLabel getFiguraParcelaCasilla() {
        return figuraParcelaCasilla;
    }

}
