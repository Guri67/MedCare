package info.youtaar.medicare;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Home extends Fragment {
    Button btn;

    public Home() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container,
                false);
        btn = (Button) rootView.findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            	openHospitals();
            }
        });

        return rootView;
    }

	public void openHospitals(){
		Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
				Uri.parse("google.navigation:q=an+hospital+India"));
		startActivity(intent);
	}
}
