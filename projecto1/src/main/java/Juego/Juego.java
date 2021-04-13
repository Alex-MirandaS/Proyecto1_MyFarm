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
import Hilos.HiloJugador;
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
//atributos

    private Jugador jug;
    private Granja granja;
    private ControladorAnimales controlAnimales;
    private ControladorPlantas controlPlantas;
    private ControladorProductos controlProductos;
    private Bodega bodega;
    private Mercado mercado;
    private Reporte reporte;
//atributosGUI
    private JuegoGUI ventanaJuego;
    private DatosJugador datosJugador;
    private ComerGUI comer;
//constructor

    public Juego() {
        controlPlantas = new ControladorPlantas();
        controlProductos = new ControladorProductos(controlPlantas);
        controlAnimales = new ControladorAnimales(controlProductos);
        bodega = new Bodega(controlProductos);
        datosJugador = new DatosJugador(this);
        comer = new ComerGUI(this);
    }
//es el encargado del inicio de la partida

    public void inicio() {
        datosJugador.setVisible(true);
    }
//es el encargado del inicio del juego

    public void iniciarJuego() {
        granja = new Granja(jug, bodega, controlPlantas, controlAnimales);
        mercado = new Mercado(jug, bodega);
        reporte = new Reporte(jug, bodega, controlAnimales.getAnimalesJuego());
        llenarAlimentos();
        ventanaJuego = new JuegoGUI(this);
        ventanaJuego.setVisible(true);
        Thread hiloJugador = new Thread(new HiloJugador(jug, ventanaJuego));
        hiloJugador.start();
    }
//es el metodo encargado de crear a jugador

    public void crearJugador(String nombre, String nick) {
        if (nombre == "") {
            jug = new Jugador("Jugador", nick);
        } else if (nick == "") {
            jug = new Jugador(nombre, "Jug-1");
        } else {
            jug = new Jugador(nombre, nick);
        }
    }
//obteiene la granja

    public Granja getGranja() {
        return granja;
    }
//manda un boolean a todas las casillas dentro de la granja para estar preparadas para un posible desbloque de casilla

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
//manda un boolean a todas las casillas dentro de la granja para estar preparadas para una posible añadidura de parcela

    public void prepararAñadirParcela() {
        for (int i = 0; i < granja.getCasillas().getSize(); i++) {

            if (granja.getCasillas().get(i) instanceof Pasto && granja.getCasillas().get(i).getFigura().isEnabled() == true) {
                Pasto pasto = (Pasto) granja.getCasillas().get(i);
                boolean temp = pasto.getFigura().isPrepararAñadirParcela();
                pasto.getFigura().setPrepararAñadirParcela(!temp);
            }
        }
    }
//manda un boolean a todas las casillas dentro de la granja para estar preparadas para una posible añadidura de cultivo

    public void prepararAñadirCultivo() {

        for (int i = 0; i < granja.getCasillas().getSize(); i++) {

            if (granja.getCasillas().get(i) instanceof Pasto && granja.getCasillas().get(i).getFigura().isEnabled() == true) {
                Pasto pasto = (Pasto) granja.getCasillas().get(i);
                boolean temp = pasto.getFigura().isPrepararAñadirCultivo();
                pasto.getFigura().setPrepararAñadirCultivo(!temp);
            }
        }
    }
//manda un boolean a todas las casillas dentro de la granja para estar preparadas para una posible añadidura de barco en el agua

    public void prepararAñadirBarco() {
        for (int i = 0; i < granja.getCasillas().getSize(); i++) {

            if (granja.getCasillas().get(i) instanceof Agua && granja.getCasillas().get(i).getFigura().isEnabled() == true) {
                Agua agua = (Agua) granja.getCasillas().get(i);
                boolean temp = agua.getFigura().isPrepararAñadirBarco();
                agua.getFigura().setPrepararAñadirBarco(!temp);
            }
        }
    }
//se encarga de cosechar la siembra cuando ya este lista

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
//se encarga de mostrar la ventana de la bodega

    public void mostrarBodega() {
        bodega.getFiguraBodega().getExistencias().setText("");
        bodega.llenarBodega();
        bodega.getFiguraBodega().setVisible(true);
    }
//se encarga de mostrar el menu para ingerir alimentos y regenerar la vida del jugador

    public void mostrarComer() {
        comer.setVisible(true);
    }
//consume un alimento y la cantidad del mismo para añadirla a su vida, y asi durar mas tiempo dentro del juego

    public void comer(int indiceAlimento, int cantidad) {
        if (cantidad < 0 || cantidad * bodega.getContenedor().get(indiceAlimento).getExistencia() > bodega.getContenedor().get(indiceAlimento).getExistencia()) {
            JOptionPane.showMessageDialog(null, "Cantidad invalida");
        } else {
            bodega.getContenedor().get(indiceAlimento).restarExistencia(cantidad * bodega.getContenedor().get(indiceAlimento).getProducto().getPrecio());
            Alimento alimento = (Alimento) bodega.getContenedor().get(indiceAlimento).getProducto();
            jug.agregarVida(alimento.getVidaAgregada());
        }
    }
//obtiene el indice de un producto, por medio del nombre del mismo

    public int obtenerIndiceProducto(String nombreAlimento) {
        for (int i = 0; i < bodega.getContenedor().getSize(); i++) {
            if (nombreAlimento.equals(bodega.getContenedor().get(i).getProducto().getNombre())) {
                return i;
            }
        }
        return 0;
    }
//se encarga de obtener los nombres existentes de los alimentos dentro de los productos

    private void llenarAlimentos() {
        for (int i = 0; i < bodega.getContenedor().getSize(); i++) {
            if (bodega.getContenedor().get(i).getProducto() instanceof Alimento) {
                comer.getAlimentos().addItem(bodega.getContenedor().get(i).getProducto().getNombre());
            }
        }
    }
//se encarga de mostrar la ventana del mercado

    public void mostrarMercado() {
        mercado.iniciar();
    }

    public void accederReportes() {
        reporte.iniciar();
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
