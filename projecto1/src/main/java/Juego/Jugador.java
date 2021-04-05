/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import Controladores.ControladorConstantes;

/**
 *
 * @author alex
 */
public class Jugador {

    private String nombre, nickname;
    private int vida, oro, semillas = 50;

    public Jugador(String nombre, String nickname) {
        this.nombre = nombre;
        this.nickname = nickname;
        this.vida = ControladorConstantes.VIDA;
        this.oro = ControladorConstantes.ORO;

    }

    public void agregarSemillas(int sem) {
        semillas += sem;
    }

    public void restarSemillas(int sem) {
        semillas -= sem;
    }

    public void agregarOro(int oro) {
        this.oro += oro;
    }

    public void restarOro(int oro) {
        this.oro -= oro;
    }

    public int getOro() {
        return oro;
    }

    public int getSemillas() {
        return semillas;
    }

}
