package info.youtaar.medicare;



import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Aboutus_fragment extends Fragment {

	public Aboutus_fragment() {
	}

	ImageView img, img2, img3;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.activity_aboutus_fragment, container, false);

		img = (ImageView) rootView.findViewById(R.id.imageView1);
		img2 = (ImageView) rootView.findViewById(R.id.imageView2);
		img3 = (ImageView) rootView.findViewById(R.id.imageView3);

		img.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					Intent intent = new Intent(Intent.ACTION_VIEW, Uri
							.parse("fb://profile/426253597411506"));
					startActivity(intent);
				} catch (Exception e) {
					startActivity(new Intent(
							Intent.ACTION_VIEW,
							Uri.parse("https://www.facebook.com/Medi-Tracker-2055399637848360/?modal=admin_todo_tour")));
				}

			}
		});
		img2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				String url = "https://api.whatsapp.com/send?phone="
						+ "7009571322";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);

			}
		});
		img3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					Intent intent = new Intent(Intent.ACTION_VIEW, Uri
							.parse("https://www.instagram.com/imeditracker/?hl=en"));
					startActivity(intent);
				} catch (Exception e) {
					startActivity(new Intent(
							Intent.ACTION_VIEW,
							Uri.parse("https://www.instagram.com/imeditracker/?hl=en")));
				}

			}
		});

		return rootView;

	}

}
