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
import Productos.ComidaAnimalesHerbívoros;
import Productos.ComidaAnimalesOmnívoros;
import Productos.Fertilizante;
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

    public void crearProducto(String nombre, String tipo, int precio) {
        if (nombre == "") {
            JOptionPane.showMessageDialog(null, "No ha ingresado el nombre del Producto");
        } else {
            if (tipo == "Alimento") {
                productosJuego.add(new Alimento(nombre, precio));
            } else {
                productosJuego.add(new MateriaPrima(nombre, precio));
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
        productosJuego.add(new Alimento(ControladorConstantes.FRUTA1, 5));
        productosJuego.add(new Alimento(ControladorConstantes.GRANO1, 6));
        productosJuego.add(new Alimento("Leche", 7));
        productosJuego.add(new Alimento("Huevo", 12));

        //Animales
        productosJuego.add(new MateriaPrima("Cuero", 25));
        productosJuego.add(new MateriaPrima("Carne Vaca", 30));
        productosJuego.add(new MateriaPrima("Carne Gallina", 28));
        //Peces
        productosJuego.add(new Alimento("Pescado", 10));

        //Fertilizante
        productosJuego.add(new Fertilizante("Gallinaza", 0, 0));
        productosJuego.add(new Fertilizante("Yara", 0, 0));
        productosJuego.add(new Fertilizante("PastoClean", 0, 0));

        //AlimentoAnimales
        productosJuego.add(new ComidaAnimalesOmnívoros("Abejas", 10));
        productosJuego.add(new ComidaAnimalesOmnívoros("Cebada", 20));
        productosJuego.add(new ComidaAnimalesOmnívoros("Avena", 30));
        productosJuego.add(new ComidaAnimalesHerbívoros("Hierba", 5));
        productosJuego.add(new ComidaAnimalesHerbívoros("Heno", 15));
        productosJuego.add(new ComidaAnimalesHerbívoros("Grano", 20));

    }

    public Lista<Producto> getProductosJuego() {
        return productosJuego;
    }

}
