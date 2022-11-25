package guerrero.mary;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsTest extends AppCompatActivity implements OnMapReadyCallback {


    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MapsTest.this, MapsActivity.class);
                startActivity(intent);
                finish();
            }
        },2500);

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        mMap = googleMap;




        LatLng quiscoNorte = new LatLng(-33, 72);
        LatLng quiscoCentro = new LatLng(-33, 73);

        mMap.addMarker(new MarkerOptions().position(quiscoNorte).title("Local Quisco Norte"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(quiscoNorte));

        mMap.addMarker(new MarkerOptions().position(quiscoCentro).title("Local Quisco Centro"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(quiscoCentro));
    }
}