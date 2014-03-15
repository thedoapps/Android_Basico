package com.doapps.me.sesion01;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;

public class Splash extends Activity {
	// Set the duration of the splash screen
	private static final long SPLASH_SCREEN_DELAY = 1500;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Set portrait orientation
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		// Hide title bar
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.splash_layout);

		//lo que se hace cuando el timer termina
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				// Close the activity so the user won't able to go back this
				// activity pressing Back button
				finish();
				// Start the next activity
				Intent mainIntent = new Intent().setClass(
						Splash.this, Register.class);
				startActivity(mainIntent);
			}
		};

		// Simulate a long loading process on application startup.
		//creamos el timer
		Timer timer = new Timer();
		timer.schedule(task, SPLASH_SCREEN_DELAY);
	}

}
