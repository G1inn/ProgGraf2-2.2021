package com.grafica.game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.security.PublicKey;

public class Scoreboard {
    int nivel;
    int vidas;
    int puntos;

    Batch batchBitmap;
    BitmapFont bitmapFont;

    public Scoreboard() {
        bitmapFont = new BitmapFont();
        CrearBitmapBatch();
        this.puntos = 0;
        this.nivel = 0;
        this.vidas = 5;
    }

    void  CrearBitmapBatch(){
        batchBitmap = new SpriteBatch();
    }

    void MostrarScoreboard(){
        batchBitmap.begin();
        bitmapFont.setColor(0f, 0f, 0f, 1.0f);
        bitmapFont.draw(batchBitmap, "Puntos: " + Integer.toString(this.puntos), 25, 485);
        bitmapFont.draw(batchBitmap, "Vidas: " + Integer.toString(this.vidas), 100, 485);
        bitmapFont.draw(batchBitmap, "Nivel: " + Integer.toString(this.nivel), 170, 485);
        batchBitmap.end();
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
}
