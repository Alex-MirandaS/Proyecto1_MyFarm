/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Casillas.Casilla;
import Listas.Lista;
import MenusGUI.AgregarPlantasGUI;
import MenusGUI.AgregarProductoGUI;
import Plantas.Fruta;
import Plantas.Grano;
import Plantas.Planta;
import Productos.Alimento;
import Productos.MateriaPrima;
import Productos.Producto;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author alex
 */
public class ControladorProductos {

    private Lista<Producto> productosJuego;
    private Lista<MateriaPrima> materiaPrimaJuego;
    private Lista<Alimento> AlimentoJuego;
    private ControladorPlantas plantasJuego;
    private AgregarProductoGUI agregarProducto;

    public ControladorProductos(ControladorPlantas plantasJuego) {
        productosJuego = new Lista<>();
        llenadoInicial();
        agregarProducto = new AgregarProductoGUI(this);
      
    }

    public void iniciar() {
        agregarProducto.setVisible(true);
    }

    public void crearProducto(String nombre, String tipo) {
        if (nombre == "") {
            JOptionPane.showMessageDialog(null, "No ha ingresado el nombre del Producto");
        } else {
            if (tipo == "Alimento") {
                productosJuego.add(new Alimento(nombre));
            } else {            
                productosJuego.add(new MateriaPrima(nombre));
            }
        }
    }

    public void mostrarListaProductosAnimales(JTextArea pantalla) {
        for (int i = 0; i < productosJuego.getSize(); i++) {
            pantalla.append(productosJuego.get(i).getNombre());
            pantalla.append(System.getProperty("line.separator"));
        }
    }

    private void llenadoInicial() {
        //Plantas
        productosJuego.add(new Alimento(ControladorConstantes.FRUTA1));
        productosJuego.add(new Alimento(ControladorConstantes.GRANO1));
        productosJuego.add(new Alimento("Leche"));
        productosJuego.add(new Alimento("Huevo"));

        //Animales
        productosJuego.add(new MateriaPrima("Cuero"));
        productosJuego.add(new MateriaPrima("Carne Vaca"));
        productosJuego.add(new MateriaPrima("Carne Gallina"));
        //Peces
        productosJuego.add(new Alimento("Pescado"));
    }

    public Lista<Producto> getProductosJuego() {
        return productosJuego;
    }

}
