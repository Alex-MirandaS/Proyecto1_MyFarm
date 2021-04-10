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

    private ControladorProductos controlProductos;
    private Lista<Caja> contenedor = new Lista<>();
    private BodegaGUI figuraBodega;

    public Bodega(ControladorProductos controlProductos) {
        this.controlProductos = controlProductos;
        figuraBodega = new BodegaGUI();
        crearCajas();
        llenarBodega();
    }

    private void crearCajas() {
        for (int i = 0; i < controlProductos.getProductosJuego().getSize(); i++) {
            contenedor.add(new Caja(controlProductos.getProductosJuego().get(i)));
        }
    }

    public void llenarBodega() {
        
        for (int i = 0; i < controlProductos.getProductosJuego().getSize(); i++) {
            figuraBodega.getProductos().append(contenedor.get(i).getProducto().getNombre());
            figuraBodega.getProductos().append(System.getProperty("line.separator"));
            figuraBodega.getExistencias().append(Integer.toString(contenedor.get(i).getExistencia()));
            figuraBodega.getExistencias().append(System.getProperty("line.separator"));

        }
    }

    public Lista<Caja> getContenedor() {
        return contenedor;
    }

    public BodegaGUI getFiguraBodega() {
        return figuraBodega;
    }

}
