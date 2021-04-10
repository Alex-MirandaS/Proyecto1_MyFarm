/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import Casillas.Agua;
import Casillas.Desierto;
import Casillas.Pasto;
import Controladores.ControladorAnimales;
import Controladores.ControladorPlantas;
import Controladores.ControladorProductos;
import JuegoGUI.JuegoGUI;
import MenusGUI.DatosJugador;

/**
 *
 * @author alex
 */
public class Juego {

    private Jugador jug;
    private Granja granja;
    private ControladorAnimales controlAnimales;
    private ControladorPlantas controlPlantas;
    private ControladorProductos controlProductos;
    private Bodega bodega;

    private JuegoGUI ventanaJuego;
    private DatosJugador datosJugador;

    public Juego() {
        controlPlantas = new ControladorPlantas();
        controlProductos = new ControladorProductos(controlPlantas);
        controlAnimales = new ControladorAnimales(controlProductos);
        bodega = new Bodega(controlProductos);
        datosJugador = new DatosJugador(this);
        //por mientras
        jug = new Jugador("Pepe", "fsddfs");
        granja = new Granja(jug, bodega, controlPlantas, controlAnimales);
        ventanaJuego = new JuegoGUI(this);
    }

    public void inicio() {
        //datosJugador.setVisible(true);
        //mientras
        ventanaJuego.setVisible(true);
    }

    public void iniciarJuego() {
        granja = new Granja(jug, bodega, controlPlantas, controlAnimales);
        ventanaJuego = new JuegoGUI(this);
        ventanaJuego.setVisible(true);
    }

    public void crearJugador(String nombre, String nick) {
        if (nombre == "") {
            jug = new Jugador("Jugador", nick);
        } else if (nick == "") {
            jug = new Jugador(nombre, "Jug-1");
        } else {
            jug = new Jugador(nombre, nick);
        }
    }

    public Granja getGranja() {
        return granja;
    }

    public void prepararDesbloqueo() {
        for (int i = 0; i < granja.getCasillas().getSize(); i++) {

            if (granja.getCasillas().get(i) instanceof Pasto) {
                Pasto pasto = (Pasto) granja.getCasillas().get(i);
                boolean temp = pasto.getFigura().isPrepararDesbloqueo();
                pasto.getFigura().setPrepararDesbloqueo(!temp);

            } else if (granja.getCasillas().get(i) instanceof Agua) {
                Agua agua = (Agua) granja.getCasillas().get(i);
                boolean temp = agua.getFigura().isPrepararDesbloqueo();
                agua.getFigura().setPrepararDesbloqueo(!temp);

            } else {
                Desierto desierto = (Desierto) granja.getCasillas().get(i);
                boolean temp = desierto.getFigura().isPrepararDesbloqueo();
                desierto.getFigura().setPrepararDesbloqueo(!temp);
            }
        }
    }

    public void prepararAñadirParcela() {
        for (int i = 0; i < granja.getCasillas().getSize(); i++) {

            if (granja.getCasillas().get(i) instanceof Pasto && granja.getCasillas().get(i).getFigura().isEnabled() == true) {
                Pasto pasto = (Pasto) granja.getCasillas().get(i);
                boolean temp = pasto.getFigura().isPrepararAñadirParcela();
                pasto.getFigura().setPrepararAñadirParcela(!temp);
            }
        }
    }

    public void prepararAñadirCultivo() {

        for (int i = 0; i < granja.getCasillas().getSize(); i++) {

            if (granja.getCasillas().get(i) instanceof Pasto && granja.getCasillas().get(i).getFigura().isEnabled() == true) {
                Pasto pasto = (Pasto) granja.getCasillas().get(i);
                boolean temp = pasto.getFigura().isPrepararAñadirCultivo();
                pasto.getFigura().setPrepararAñadirCultivo(!temp);
            }
        }
    }

    public void prepararAñadirBarco() {
        for (int i = 0; i < granja.getCasillas().getSize(); i++) {

            if (granja.getCasillas().get(i) instanceof Agua && granja.getCasillas().get(i).getFigura().isEnabled() == true) {
                Agua agua = (Agua) granja.getCasillas().get(i);
                boolean temp = agua.getFigura().isPrepararAñadirBarco();
                agua.getFigura().setPrepararAñadirBarco(!temp);
            }
        }
    }

    public void prepararCosechar() {
        for (int i = 0; i < granja.getCasillas().getSize(); i++) {

            if (granja.getCasillas().get(i) instanceof Pasto && granja.getCasillas().get(i).getFigura().isEnabled() == true) {
                Pasto pasto = (Pasto) granja.getCasillas().get(i);
                if (pasto.getPlanta() != null) {//linea de cosecha automatica,  quitar despues
                    pasto.getPlanta().setPlantaLista(true);
                }
            }
        }
    }

    public void mostrarBodega() {
        bodega.getFiguraBodega().getExistencias().setText("");
        bodega.llenarBodega();
        bodega.getFiguraBodega().setVisible(true);
    }

    public ControladorAnimales getControlAnimales() {
        return controlAnimales;
    }

    public ControladorPlantas getControlPlantas() {
        return controlPlantas;
    }

    public ControladorProductos getControlProductos() {
        return controlProductos;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public Jugador getJug() {
        return jug;
    }

}
