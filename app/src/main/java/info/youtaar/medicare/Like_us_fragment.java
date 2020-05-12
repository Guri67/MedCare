package info.youtaar.medicare;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Like_us_fragment extends Fragment {
	Button img;

	public Like_us_fragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.activity_like_us_fragment, container,
				false);

		img = (Button) rootView.findViewById(R.id.button1);

		img.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				final Intent emailIntent = new Intent(
						android.content.Intent.ACTION_SEND);
				emailIntent.setType("text/plain");
				emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
						new String[] { "gursimratsingh1998@gmail.com" });
				emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
						"Med Talks");
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
		return rootView;
	}
}
