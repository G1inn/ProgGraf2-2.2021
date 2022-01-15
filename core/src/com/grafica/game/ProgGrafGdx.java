package com.grafica.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

public class ProgGrafGdx extends ApplicationAdapter {
	private OrthographicCamera camera;

	Vibora vibora; Comida comida; Scoreboard scoreboard;

	Nivel nivel = new Nivel();

	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 500, 500);

		scoreboard = new Scoreboard();

		nivel.CrearBatch(); nivel.CargarNivel(scoreboard.nivel);

		vibora = new Vibora();

		comida = new Comida();
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 1, 1, 1);
		camera.update();
		vibora.batchVibora.setProjectionMatrix(camera.combined);
		comida.batchComida.setProjectionMatrix(camera.combined);

		nivel.dibujarNivel();

		vibora.DibujarVibora();

		comida.dibujarComida();

		scoreboard.MostrarScoreboard();

		if ((scoreboard.vidas == 0)){
			dispose();
		}
		if ((scoreboard.puntos == 5 && scoreboard.nivel == 1)){
			dispose();
		}
		vibora.update(Gdx.graphics.getDeltaTime(), nivel);
		vibora.input();
		vibora.colisionCola(comida, scoreboard);
		vibora.comioComida(comida, scoreboard, nivel);
		vibora.colisionMuro(nivel, comida, scoreboard);
	}
	
	@Override
	public void dispose () {
		//batch.dispose();
		vibora.batchVibora.dispose();
		//cabeza.dispose();
		comida.comida.dispose();
	}
}
