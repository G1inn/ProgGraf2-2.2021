package com.grafica.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.math.Rectangle;

public class ProgGrafGdx extends ApplicationAdapter {
	private OrthographicCamera camera;
	SpriteBatch batch;
	Texture img;
	private Rectangle bucket;

	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);

		batch = new SpriteBatch();
		img = new Texture("download.png");

		bucket = new Rectangle();
		bucket.x = 800 / 2 - 64 / 2;
		bucket.y = 20;
		bucket.width = 64;
		bucket.height = 64;
	}

	@Override
	public void render () {
		camera.update();
		batch.setProjectionMatrix(camera.combined);

		ScreenUtils.clear(0, 1, 0, 1);
		batch.begin();
		batch.draw(img, bucket.x, bucket.y);
		batch.end();

		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) bucket.x -= 200 * Gdx.graphics.getDeltaTime();
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) bucket.x += 200 * Gdx.graphics.getDeltaTime();
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) bucket.y -= 200 * Gdx.graphics.getDeltaTime();
		if(Gdx.input.isKeyPressed(Input.Keys.UP)) bucket.y += 200 * Gdx.graphics.getDeltaTime();
		if(bucket.x < 0) bucket.x = 0;
		if(bucket.x > 800 - 64) bucket.x = 800 - 64;
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
