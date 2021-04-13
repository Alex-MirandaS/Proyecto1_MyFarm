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
import MenusGUI.ComerGUI;
import MenusGUI.DatosJugador;
import Productos.Alimento;
import javax.swing.JOptionPane;

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
    private Mercado mercado;

    private JuegoGUI ventanaJuego;
    private DatosJugador datosJugador;
    private ComerGUI comer;

    public Juego() {
        controlPlantas = new ControladorPlantas();
        controlProductos = new ControladorProductos(controlPlantas);
        controlAnimales = new ControladorAnimales(controlProductos);
        bodega = new Bodega(controlProductos);
        datosJugador = new DatosJugador(this);
        //por mientras
        jug = new Jugador("Pepe", "fsddfs");
        granja = new Granja(jug, bodega, controlPlantas, controlAnimales);
        mercado = new Mercado(jug, bodega);
        ventanaJuego = new JuegoGUI(this);
        comer = new ComerGUI(this);
        llenarAlimentos();
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

    public void mostrarComer() {
        comer.setVisible(true);
    }

    public void comer(int indiceAlimento, int cantidad) {
        if (cantidad < 0 || cantidad * bodega.getContenedor().get(indiceAlimento).getExistencia() > bodega.getContenedor().get(indiceAlimento).getExistencia()) {
            JOptionPane.showMessageDialog(null, "Cantidad invalida");
        } else {
            bodega.getContenedor().get(indiceAlimento).restarExistencia(cantidad * bodega.getContenedor().get(indiceAlimento).getProducto().getPrecio());
            Alimento alimento = (Alimento) bodega.getContenedor().get(indiceAlimento).getProducto();
            jug.agregarVida(alimento.getVidaAgregada());
        }
    }

    public int obtenerIndiceProducto(String nombreAlimento) {
        for (int i = 0; i < bodega.getContenedor().getSize(); i++) {
            if (nombreAlimento.equals(bodega.getContenedor().get(i).getProducto().getNombre())) {
                return i;
            }
        }
        return 0;
    }

    private void llenarAlimentos() {
        for (int i = 0; i < bodega.getContenedor().getSize(); i++) {
            if (bodega.getContenedor().get(i).getProducto() instanceof Alimento) {
                comer.getAlimentos().addItem(bodega.getContenedor().get(i).getProducto().getNombre());
            }
        }
    }

    public void mostrarMercado() {
        mercado.iniciar();
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
