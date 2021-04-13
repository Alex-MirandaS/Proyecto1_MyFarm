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
//atributos

    private String nombre, nickname;
    private int vida = 100, oro, semillas = 50, oroGeneradoGranja;
    private int alimentoConsumido = 0;
    private int casillasCompradas = 0;
    private int tiempoVida = 0;
//constructor

    public Jugador(String nombre, String nickname) {
        this.nombre = nombre;
        this.nickname = nickname;
        this.vida = ControladorConstantes.VIDA;
        this.oro = ControladorConstantes.ORO;

    }
//agrega y resta tanto semillas como el oro y vida del jugador

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

    public void agregarVida(int vida) {
        alimentoConsumido += 1;
        this.vida += vida;
    }

    public void restarVida(int vida) {
        this.vida -= vida;
    }

    public void agregarCasillasCompradas(int casillas) {
        casillasCompradas += 1;
        this.vida += vida;
    }

    public void agregarOroGeneradoGranja(int i) {
        this.oroGeneradoGranja+= i;
    }

    public int getOro() {
        return oro;
    }

    public int getSemillas() {
        return semillas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNickname() {
        return nickname;
    }

    public int getVida() {
        return vida;
    }

    public int getCasillasCompradas() {
        return casillasCompradas;
    }

    public int getTiempoVida() {
        return tiempoVida;
    }

    public void agregarTiempoVida(int tiempoVida) {
        this.tiempoVida += tiempoVida;
    }

    public int getAlimentoConsumido() {
        return alimentoConsumido;
    }

    public int getOroGeneradoGranja() {
        return oroGeneradoGranja;
    }

}
