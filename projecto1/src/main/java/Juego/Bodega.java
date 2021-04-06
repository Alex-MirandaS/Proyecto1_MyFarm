/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import Controladores.ControladorPlantas;
import Controladores.ControladorProductos;
import Listas.Lista;

/**
 *
 * @author alex
 */
public class Bodega {

    private ControladorProductos controlProductos;
    private Lista<Caja> contenedor = new Lista<>();
//tambien productos

    public Bodega(ControladorProductos controlProductos) {
        this.controlProductos = controlProductos;
        crearCajas();
    }

    private void crearCajas() {
        for (int i = 0; i < controlProductos.getProductosJuego().getSize(); i++) {
            contenedor.add(new Caja(controlProductos.getProductosJuego().get(i)));
        }
    }

    public Lista<Caja> getContenedor() {
        return contenedor;
    }

}
