package com.grafica.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Comida {
    Texture comida;
    Vector2 comidaPos;
    SpriteBatch batchComida;

    public Comida(){
        batchComida = new SpriteBatch();
        comida = new Texture("comida.png");
        comidaPos = new Vector2(100, 100);
    }

    void dibujarComida(){
        batchComida.begin();
        batchComida.draw(comida, comidaPos.x, comidaPos.y);
        batchComida.end();
    }

}
