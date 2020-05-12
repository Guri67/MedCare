package info.youtaar.medicare;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity {
	Intent i = null;
	Button b1, b2;
	ImageView im = null;
	EditText tv1, tv2;
	boolean flag = false;
	SQLiteDatabase db = null;
	ImageView iv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		iv = (ImageView) findViewById(R.id.medi);
		ObjectAnimator anim = (ObjectAnimator) AnimatorInflater.loadAnimator(
				this, R.anim.flip);
		anim.setTarget(iv);
		anim.setDuration(3000);
		anim.start();
		TextView tx = (TextView) findViewById(R.id.textView1);

		Typeface custom_font = Typeface.createFromAsset(getAssets(),
				"pacifico.ttf");

		tx.setTypeface(custom_font);
		// b2 = (Button) findViewById(R.id.button2);
		// Intent obj = new Intent(Login.this, Signup.class);
		// startActivity(obj);
		//
		// b1 = (Button) findViewById(R.id.button1);
		// Intent obj1 = new Intent(Login.this, Signup.class);
		// startActivity(obj1);

		tv1 = (EditText) findViewById(R.id.editText1);
		tv2 = (EditText) findViewById(R.id.editText2);
		db = openOrCreateDatabase("newdb", MODE_PRIVATE, null);

	}

	public void action(View v) {
		switch (v.getId()) {
		case R.id.button2:
			i = new Intent(this, Signup.class);
			startActivity(i);

			finish();
			break;
		case R.id.button3:
			i = new Intent(this, Sendmail.class);
			startActivity(i);

			finish();
			break;
		case R.id.button1:
			String mobile_no = tv1.getText().toString();
			String password = tv2.getText().toString();
			if (mobile_no == null || mobile_no == "" || mobile_no.length() < 10) {
				show("Please Enter Correct mobile number.");
			} else if (password == null || password == ""
					|| password.length() < 6) {
				show("Please Enter Correct Password.");
			} else {
				Cursor c = db.rawQuery(
						"select * from medtalks where mobile_no='" + mobile_no
								+ "' and password='" + password + "'", null);
				c.moveToFirst();
				if (c.getCount() > 0) {
					i = new Intent(this, MainActivity.class);
					startActivity(i);

					db.close();
					finish();
				} else
					show("Wrong Password or Mobile number.");

			}
			break;
		}
	}

	public void show(String str) {
		Toast.makeText(this, str, Toast.LENGTH_LONG).show();
	}

	public void didTapButton(View view) {
		Button button = (Button) findViewById(R.id.button1);
		final Animation myAnim = AnimationUtils.loadAnimation(this,
				R.anim.bounce);
		button.startAnimation(myAnim);
	}

	@Override
	public void onBackPressed() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		builder.setTitle("Login");
		builder.setMessage("Do you want to exit? ");
		builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				System.exit(0);
			}
		});
		builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {

			}
		});
		builder.show();
	}
}
