package com.grafica.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;

public class Nivel {
    SpriteBatch muroBatch;
    Texture muro;
    float tiempo;
    int nivel;
    ArrayList<Vector2> posicionesMuro;

    public  Nivel(){
        posicionesMuro = new ArrayList<Vector2>();
    }

    void CargarNivel(int nivel){
        this.nivel = nivel;
        muro = new Texture("muro.png");
        switch(nivel)
        {
            case 0 :
                this.tiempo = 0.1f;
                for (int i = 0; i<=49; i++){
                    posicionesMuro.add(new Vector2(i * 10, 0));
                    posicionesMuro.add(new Vector2(i * 10, 490));
                    posicionesMuro.add(new Vector2(0, i * 10));
                    posicionesMuro.add(new Vector2(490, i * 10));
                }
                break;
            case 1 :
                this.tiempo = 0.9f;
                for (int i = 0; i<=49; i++){
                    posicionesMuro.add(new Vector2(i * 10, 0));
                    posicionesMuro.add(new Vector2(i * 10, 490));
                    posicionesMuro.add(new Vector2(0, i * 10));
                    posicionesMuro.add(new Vector2(490, i * 10));
                }
                for (int i = 0; i<=20; i++){
                    int x = (int)(Math.random()*49)*10 ;
                    int y = (int)(Math.random()*49)*10;
                    posicionesMuro.add(new Vector2(x, y));
                }
                break;
        }
    }

    void  CrearBatch(){
        muroBatch = new SpriteBatch();
    }

    void dibujarNivel(){
        muroBatch.begin();
        for (int i = 0; i < posicionesMuro.size(); i++){
            muroBatch.draw(muro, posicionesMuro.get(i).x,posicionesMuro.get(i).y);
        }
        muroBatch.end();
    }
}
