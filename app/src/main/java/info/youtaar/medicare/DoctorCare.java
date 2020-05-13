package info.youtaar.medicare;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DoctorCare extends Fragment {
	
	public DoctorCare(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_find_people, container, false);
         rootView.findViewById(R.id.map_btn).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 openMap();
             }
         });
        return rootView;
    }


    public void openMap(){
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("google.navigation:q=an+restaurant+Lagos"));
        startActivity(intent);
    }
}
