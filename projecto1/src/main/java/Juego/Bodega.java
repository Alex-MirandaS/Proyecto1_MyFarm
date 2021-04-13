/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import Controladores.ControladorProductos;
import JuegoGUI.BodegaGUI;
import Listas.Lista;

/**
 *
 * @author alex
 */
public class Bodega {
//atributos
    private ControladorProductos controlProductos;
    private Lista<Caja> contenedor = new Lista<>();
    private BodegaGUI figuraBodega;
//cosntructor
    public Bodega(ControladorProductos controlProductos) {
        this.controlProductos = controlProductos;
        figuraBodega = new BodegaGUI();
        crearCajas();
        llenarBodega();
    }
//crea las cajas en donde se almacena un tipo especifico de producto, con sus respectivas existencias
    private void crearCajas() {
        for (int i = 0; i < controlProductos.getProductosJuego().getSize(); i++) {
            contenedor.add(new Caja(controlProductos.getProductosJuego().get(i)));
        }
    }
//llena la pantalla con los productos junto con sus existencias
    public void llenarBodega() {
        figuraBodega.getProductos().setText("");
        for (int i = 0; i < controlProductos.getProductosJuego().getSize(); i++) {
            figuraBodega.getProductos().append(contenedor.get(i).getProducto().getNombre());
            figuraBodega.getProductos().append(System.getProperty("line.separator"));
            figuraBodega.getExistencias().append(Integer.toString(contenedor.get(i).getExistencia()));
            figuraBodega.getExistencias().append(System.getProperty("line.separator"));

        }
    }
    
    //obtiene todo el alimento generado durante la partida
    public int alimentoGeneradoPartida(){
        int alimentoGenerado = 0;
        for (int i = 0; i < contenedor.getSize(); i++) {
            alimentoGenerado += contenedor.get(i).getAlimentoGenerado();
        }
        return alimentoGenerado;
    }

    public Lista<Caja> getContenedor() {
        return contenedor;
    }

    public BodegaGUI getFiguraBodega() {
        return figuraBodega;
    }

}
