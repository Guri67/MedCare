package info.youtaar.medicare;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends Activity {
	Animation sequentialAnimation;

	ImageView iv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		// imageView = (ImageView) findViewById(R.id.imageView1);
		// sequentialAnimation = AnimationUtils.loadAnimation(
		// getApplicationContext(), R.anim.sequential_animation);
		// imageView.startAnimation(sequentialAnimation);
		iv = (ImageView) findViewById(R.id.imageView1);
		Animation fade1 = AnimationUtils.loadAnimation(this, R.anim.rotate);
		iv.startAnimation(fade1);
		TextView tx = (TextView) findViewById(R.id.textView1);
		//
		Typeface custom_font = Typeface.createFromAsset(getAssets(),
				"pacifico.ttf");
		//
		tx.setTypeface(custom_font);
		final SharedPreferences settings = getSharedPreferences("prefs", 0);
		final boolean firstRun = settings.getBoolean("firstRun", false);
		Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		v.vibrate(500);
		new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (firstRun == false)// if running for first time
				// Splash will load for first time
				{
					SharedPreferences.Editor editor = settings.edit();
					editor.putBoolean("firstRun", true);
					editor.commit();
					Intent i = new Intent(Splash.this, Introfirst.class);
					startActivity(i);
					finish();
				} else {

					Intent a = new Intent(Splash.this, Login.class);
					startActivity(a);
					finish();
				}
				finish();
			}
		}).start();
		// ImageView image = (ImageView) findViewById(R.id.imageView1);
		// Animation hyperspaceJump = AnimationUtils.loadAnimation(this,
		// R.anim.hyperspace_jump);
		// image.startAnimation(hyperspaceJump);

	}
}
