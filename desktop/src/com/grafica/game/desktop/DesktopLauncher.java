package com.grafica.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.grafica.game.ProgGrafGdx;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "ProgGraf2";
		config.width = 800;
		config.height = 480;
		new LwjglApplication(new ProgGrafGdx(), config);
	}
}
