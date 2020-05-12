package info.youtaar.medicare;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.gsm.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public class Contact_us_fragment extends Fragment {
	
	ImageView img, img2, img3, img4;

	public Contact_us_fragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.activity_contact_us_fragment, container, false);

		img = (ImageView) rootView.findViewById(R.id.call);
		img2 = (ImageView) rootView.findViewById(R.id.mail);
		img3 = (ImageView) rootView.findViewById(R.id.msg);
		img4 = (ImageView) rootView.findViewById(R.id.whatsapp);

		img.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_CALL);
				intent.setData(Uri.parse("tel:7009571322"));
				startActivity(intent);

			}
		});
		img2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				final Intent emailIntent = new Intent(
						android.content.Intent.ACTION_SEND);
				emailIntent.setType("text/plain");
				emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
						new String[] { "gursimratsingh1998@gmail.com" });
				emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
						"Medicine Tracker");
				emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,
						"Add Your Message Below:");

				emailIntent.setType("message/rfc822");

				try {
					startActivity(Intent.createChooser(emailIntent,
							"Send email using..."));
				} catch (android.content.ActivityNotFoundException ex) {

				}

			}
		});

		img3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				try {
					SmsManager smsManager = SmsManager.getDefault();
					smsManager.sendTextMessage("7009571322", null,
							"Need Your Assistance..!!!", null, null);
					Toast.makeText(getActivity().getApplicationContext(),
							"Message Sent", Toast.LENGTH_LONG).show();
				} catch (Exception ex) {
					Toast.makeText(getActivity().getApplicationContext(),
							ex.getMessage().toString(), Toast.LENGTH_LONG)
							.show();
					ex.printStackTrace();
				}
			}
		});
		img4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				Uri uri = Uri.parse("smsto:" + "7009571322");
				Intent i = new Intent(Intent.ACTION_SENDTO, uri);
				i.putExtra("sms_body", "Hello Kida");  
				i.setPackage("com.whatsapp");  
				startActivity(i);
			}
		});
		return rootView;
	}
}