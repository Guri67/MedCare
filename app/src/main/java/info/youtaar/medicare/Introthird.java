package info.youtaar.medicare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Introthird extends Activity {
	Button b1, b2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_introthird);
		b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(Introthird.this, "Going to next page",
						Toast.LENGTH_LONG).show();
				// TODO Auto-generated method stub
				Intent obj = new Intent(Introthird.this, Login.class);
				startActivity(obj);
				// two types of Intent... explicit and implicit intent

			}
		});

		b2 = (Button) findViewById(R.id.button2);

		b2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(Introthird.this, "Going to Login page",
						Toast.LENGTH_LONG).show();
				// TODO Auto-generated method stub
				Intent obj = new Intent(Introthird.this, Introsecond.class);
				startActivity(obj);
				// two types of Intent... explicit and implicit intent

			}
		});

	}

}