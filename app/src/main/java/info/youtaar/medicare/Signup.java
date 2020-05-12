package info.youtaar.medicare;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Signup extends Activity {

    Intent i = null;
    EditText tv1, tv2, tv3, tv4, tv5;
    boolean flag = false;
    SQLiteDatabase db = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        TextView tx = (TextView) findViewById(R.id.textView1);

        Typeface custom_font = Typeface.createFromAsset(getAssets(),
                "pacifico.ttf");

        tx.setTypeface(custom_font);
        tv1 = (EditText) findViewById(R.id.name);
        tv2 = (EditText) findViewById(R.id.password);
        tv3 = (EditText) findViewById(R.id.cpassword);
        tv4 = (EditText) findViewById(R.id.mobileno);
        tv5 = (EditText) findViewById(R.id.email);
        db = openOrCreateDatabase("newdb", MODE_PRIVATE, null);
        db.execSQL("create table if not exists medtalks(name varchar,password varchar,cpassword varchar,mobile_no varchar,email varchar ,flag varchar)");

    }

    public void action(View v) {
        switch (v.getId()) {
            case R.id.button2:
                i = new Intent(this, Login.class);
                startActivity(i);

                finish();
                break;
            case R.id.button1:
                String name = tv1.getText().toString();

                String password = tv2.getText().toString();
                String cpassword = tv3.getText().toString();
                String mobile_no = tv4.getText().toString();
                String email = tv5.getText().toString();
                if (name == null || name == "" || name.length() < 3) {
                    show("Please Enter Correct Name.");
                } else if (mobile_no == null || mobile_no == ""
                        || mobile_no.length() < 10) {
                    show("Please Enter Correct mobile number.");
                } else if (password == null || password == ""
                        || password.length() < 8) {
                    show("Please Enter Correct Email id.");
                } else if (cpassword == null || cpassword == ""
                        || cpassword.length() < 8) {
                    show("Please Enter Strong Password.");

                } else {
                    db.execSQL("insert into medtalks values('" + name + "','"
                            + password + "','" + cpassword + "','" + mobile_no
                            + "','" + email + "','nothing')");
                    i = new Intent(Signup.this, Login.class);
                    startActivityForResult(i, 500);

                    db.close();
                    finish();
                }
                break;

        }
    }

    public void show(String str) {
        Toast.makeText(this, str, Toast.LENGTH_LONG).show();
    }
}
