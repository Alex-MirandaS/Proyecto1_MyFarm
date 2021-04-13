/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import Animales.Animal;
import Controladores.ControladorConstantes;
import JuegoGUI.ReporteGUI;
import Listas.Lista;

/**
 *
 * @author alex
 */
public class Reporte {

    private Jugador jug;
    private Bodega bodega;
    private Lista<Animal> listaAnimalesJuego;

    private ReporteGUI reporteGUI;

    public Reporte(Jugador jug, Bodega bodega, Lista<Animal> listaAnimalesJuego) {
        this.jug = jug;
        this.bodega = bodega;
        this.listaAnimalesJuego = listaAnimalesJuego;
        reporteGUI = new ReporteGUI();
    }
//inicia llenando todos los datos del reporte
    public void iniciar() {
        //Datos Jugador
        reporteGUI.getNombreJug().setText(jug.getNombre());
        reporteGUI.getDuraciónPartida().setText((jug.getTiempoVida() / 1000) + " segundos aproximandamente");
        reporteGUI.getOroGeneradoGranja().setText(jug.getOroGeneradoGranja() + ControladorConstantes.SIMBOLO_ORO);
        reporteGUI.getAlimentoGeneradoGranja().setText("" + bodega.alimentoGeneradoPartida());
        reporteGUI.getAlimentosConsumidos().setText(jug.getAlimentoConsumido() + " Alimentos Consumidos");
        reporteGUI.getCantidadCeldasCompradas().setText(jug.getCasillasCompradas() + " Casillas");
        //Datos Animales
        llenarDatosAnimales();
        //Datos Plantas
        
        reporteGUI.setVisible(true);
    }
//llena la casilla del reporte de los animales
    private void llenarDatosAnimales() {
        for (int i = 0; i < listaAnimalesJuego.getSize(); i++) {
            reporteGUI.getReporteAnimales().append(listaAnimalesJuego.get(i).getNombre()+": Crias Compradas: "+listaAnimalesJuego.get(i).getCriasCompradas()+"  Unidades Destazadas: "+listaAnimalesJuego.get(i).getAnimalesDestazados());
            reporteGUI.getReporteAnimales().append(System.getProperty("line.separator"));
        }
    }

}
