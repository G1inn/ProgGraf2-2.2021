package com.grafica.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;

public class Vibora {
    SpriteBatch batchVibora;
    Texture cabeza;
    ArrayList<Vector2> posicion;
    int num = 3; int tam = 3;
    boolean arriba, abajo, derecha = true, izquierda;

    public Vibora (){
        batchVibora = new SpriteBatch();
        cabeza = new Texture("cabeza.png");
        posicion = new ArrayList<Vector2>();
        for (int i = 0; i < num; i++){
            posicion.add(new Vector2(50 + i*10, 50));
        }
    }

    void  DibujarVibora(){
        batchVibora.begin();
        for (int i = 0; i < posicion.size(); i++){
            batchVibora.draw(cabeza, posicion.get(i).x, posicion.get(i).y);
        }
        batchVibora.end();
    }

    void mover(){
        for (int i = posicion.size()-1; i>0; i--){
            posicion.get(i).x = posicion.get(i-1).x;
            posicion.get(i).y = posicion.get(i-1).y;
        }
        if (arriba){
            posicion.get(0).y+=10;
        }
        if (abajo){
            posicion.get(0).y-=10;
        }
        if (derecha){
            posicion.get(0).x+=10;
        }
        if (izquierda){
            posicion.get(0).x-=10;
        }
    }
    void input(){
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)){
            arriba = true;
            abajo = false;
            derecha = false;
            izquierda = false;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
            arriba = false;
            abajo = true;
            derecha = false;
            izquierda = false;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
            arriba = false;
            abajo = false;
            derecha = true;
            izquierda = false;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
            arriba = false;
            abajo = false;
            derecha = false;
            izquierda = true;
        }
    }

    void colisionMuro(Nivel nivel, Comida comida, Scoreboard scoreboard){
        if (nivel.posicionesMuro.contains(new Vector2(posicion.get(0).x, posicion.get(0).y))){
            posicion = new ArrayList<Vector2>();
            for (int i = 0; i < num; i++){
                posicion.add(new Vector2(50 + i*10, 50));
            }
            comida.comidaPos = new Vector2(100, 100);
            arriba = false;		abajo = false;		derecha = true;		izquierda = false;  tam=3;
            scoreboard.vidas--; scoreboard.puntos=0;
        }
    }

    void colisionCola(Comida comida, Scoreboard scoreboard){
        for (int a = 0; a < posicion.size()-2; a++){
            if (posicion.get(0).x == posicion.get(a+1).x && posicion.get(0).y == posicion.get(a+1).y){
                posicion = new ArrayList<Vector2>();
                for (int i = 0; i < num; i++){
                    posicion.add(new Vector2(50 + i*10, 50));
                }
                comida.comidaPos = new Vector2(100, 100);
                arriba = false;		abajo = false;		derecha = true;		izquierda = false; tam=3;
                scoreboard.vidas--; scoreboard.puntos=0;
            }
        }

    }

    void comioComida(Comida comida, Scoreboard scoreboard, Nivel nivel){
        if (posicion.get(0).x == comida.comidaPos.x && posicion.get(0).y == comida.comidaPos.y){
            int x = (int)(Math.random()*45)*10 ;
            int y = (int)(Math.random()*45)*10;
            comida.comidaPos.x = x + 10;
            comida.comidaPos.y = y + 10;
            posicion.add(new Vector2(posicion.get(posicion.size()-1).x, posicion.get(posicion.size()-1).y));
            scoreboard.puntos = scoreboard.puntos + 1; tam++;
        }
        if (scoreboard.puntos == 5 && scoreboard.nivel == 0){
            scoreboard.nivel = 1;
            nivel.CargarNivel(1);
            scoreboard.puntos = 0;
            reiniciar(comida);
        }
    }

    void update(float delta, Nivel nivel){
        nivel.tiempo -= delta;
        if (nivel.tiempo <= 0){
            if (nivel.nivel == 0){
                nivel.tiempo = 0.1f;
            }
            if (nivel.nivel == 1){
                nivel.tiempo = 0.06f;
            }
            mover();
        }
    }

    void reiniciar(Comida comida){
        posicion = new ArrayList<Vector2>();
        for (int i = 0; i < num; i++){
            posicion.add(new Vector2(50 + i*10, 50));
        }
        comida.comidaPos = new Vector2(100, 100);
        arriba = false;		abajo = false;		derecha = true;		izquierda = false;  tam=3;
    }
}
