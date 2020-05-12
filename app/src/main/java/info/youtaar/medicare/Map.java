package info.youtaar.medicare;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Map extends FragmentActivity implements OnMapReadyCallback {
	private GoogleMap mMap;
	static final LatLng JALANDHAR = new LatLng(31.3260, 75.5762);
	static final LatLng AMRITSAR = new LatLng(31.6340, 75.8723);
	static final LatLng GURDASPUR = new LatLng(32.0419, 75.0453);
	private Marker doctor_Marker, doctor_Marker1, doctor_Marker2;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		if (mMap == null) {
			SupportMapFragment mapFrag = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
			mapFrag.getMapAsync(this);
			mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(JALANDHAR, 12));
			mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(AMRITSAR, 12));
			mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(GURDASPUR, 12));
			mMap.animateCamera(CameraUpdateFactory.zoomTo(8), 200, null);
			mMap.setMyLocationEnabled(true);
			// setUpMapIfNeeded();
			mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
			doctor_Marker = mMap.addMarker(new MarkerOptions().position(JALANDHAR)
					.title("Jaura Dental Clinic").snippet("this is my test app")
					.icon(BitmapDescriptorFactory.fromResource(R.drawable.abc)));
			doctor_Marker1 = mMap.addMarker(new MarkerOptions().position(AMRITSAR)
					.title("SAJNN Dental Clinic").snippet("this is IT")
					.icon(BitmapDescriptorFactory.fromResource(R.drawable.abc)));
			doctor_Marker2 = mMap.addMarker(new MarkerOptions().position(GURDASPUR)
					.title("BUDHA Dental Clinic").snippet("this IS IT YO")
					.icon(BitmapDescriptorFactory.fromResource(R.drawable.abc)));
		}


		mMap.setOnMarkerClickListener(new OnMarkerClickListener() {

			@Override
			public boolean onMarkerClick(Marker marker) {
				check_Which_Marker_Is_Clicked(marker);
				// TODO Auto-generated method stub
				return false;
			}
		});
	}

	private void check_Which_Marker_Is_Clicked(Marker marker) {
		if (marker.equals(doctor_Marker)) {
			Toast.makeText(Map.this, "dO YOU WANT AN appointment",
					Toast.LENGTH_LONG).show();
			Intent obj = new Intent(Map.this, Contact_us_fragment.class);
			startActivity(obj);
		}
		if (marker.equals(doctor_Marker1)) {
			Toast.makeText(Map.this, "dO YOU WANT AN appointment",
					Toast.LENGTH_LONG).show();
		}
		if (marker.equals(doctor_Marker2)) {
			Toast.makeText(Map.this, "dO YOU WANT AN appointment",
					Toast.LENGTH_LONG).show();
		}
	}

	@Override
	public void onMapReady(GoogleMap googleMap) {

	}
}
