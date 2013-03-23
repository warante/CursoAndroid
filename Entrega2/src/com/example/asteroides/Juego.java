package com.example.asteroides;

import android.app.Activity;
import android.hardware.SensorManager;
import android.os.Bundle;

public class Juego extends Activity {

	private VistaJuego vistaJuego;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.juego);
		vistaJuego = (VistaJuego) findViewById(R.id.VistaJuego);
	}


	@Override
	protected void onPause() {
		vistaJuego.getThread().pausar(); 
		vistaJuego.mSensorManager.unregisterListener(vistaJuego);
		super.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
		vistaJuego.getThread().reanudar(); 
		vistaJuego.mSensorManager.registerListener(vistaJuego, vistaJuego.mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
	}

	@Override
	protected void onDestroy() {
		vistaJuego.getThread().detener();
		super.onDestroy();
	}
}
