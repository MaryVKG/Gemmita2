package guerrero.mary;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import guerrero.mary.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;




        LatLng quiscoNorte = new LatLng(-33.3804906661052, -71.68648150292526);
        LatLng quiscoCentro = new LatLng( -33.395434187956454,  -71.69494864603585);

        mMap.addMarker(new MarkerOptions().position(quiscoNorte).title("Local Quisco Norte"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(quiscoNorte));

        mMap.addMarker(new MarkerOptions().position(quiscoCentro).title("Local Quisco Centro"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(quiscoCentro));
    }
}