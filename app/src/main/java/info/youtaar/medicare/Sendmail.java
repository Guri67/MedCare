package info.youtaar.medicare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Sendmail extends Activity {
	Button b1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sendmail);
		b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				final Intent emailIntent = new Intent(
						android.content.Intent.ACTION_SEND);
				emailIntent.setType("text/plain");
				emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
						new String[] { "gursimratsingh1998@gmail.com" });
				emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
						"Hello There");
				emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,
						"Add Message here");

				emailIntent.setType("message/rfc822");

				try {
					startActivity(Intent.createChooser(emailIntent,
							"Send email using..."));
				} catch (android.content.ActivityNotFoundException ex) {
					Toast.makeText(Sendmail.this,
							"No email clients installed.", Toast.LENGTH_SHORT)
							.show();
				}

			}
		});

	}
}
