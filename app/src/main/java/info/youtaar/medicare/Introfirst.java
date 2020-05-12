package info.youtaar.medicare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Introfirst extends Activity {
	Button b1, b2;
	ImageView i;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_introfirst);
		b1 = (Button) findViewById(R.id.button1);
		i = (ImageView) findViewById(R.id.imageView1);
		// Intent obj1 = new Intent(Introfirst.this, Introsecond.class);
		// startActivity(obj1);
		b2 = (Button) findViewById(R.id.button2);
		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(Introfirst.this, "Going to next page",
						Toast.LENGTH_LONG).show();
				// TODO Auto-generated method stub
				Intent obj = new Intent(Introfirst.this, Introsecond.class);
				startActivity(obj);
				// two types of Intent... explicit and implicit intent

			}
		});
		b2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(Introfirst.this, "Going to Login page",
						Toast.LENGTH_LONG).show();
				// TODO Auto-generated method stub
				Intent obj = new Intent(Introfirst.this, Login.class);
				startActivity(obj);
				// two types of Intent... explicit and implicit intent

			}
		});
		// Intent obj2 = new Intent(Introfirst.this, Login.class);
		// startActivity(obj1);
		

		Animation animation = new TranslateAnimation(0, 300, 0, 0);

		animation.setDuration(2000);
		animation.setFillAfter(true);
		i.startAnimation(animation);
	}

}
