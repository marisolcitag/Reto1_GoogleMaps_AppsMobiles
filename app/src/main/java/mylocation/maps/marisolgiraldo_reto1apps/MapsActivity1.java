package mylocation.maps.marisolgiraldo_reto1apps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Locale;

public class MapsActivity1 extends AppCompatActivity implements GoogleMap.OnMarkerDragListener,OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private Marker markerOption, markerDrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps1);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in ICESI UNIVERSITY and move the camera
        LatLng icesi = new LatLng(3.3409037, -76.5289024);
        mMap.addMarker(new MarkerOptions().position(icesi).title("Universidad ICESI")).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));

        // Add a marker in Unicentro CALI
        LatLng unicentro = new LatLng(3.3771819, -76.5394418);
        mMap.addMarker(new MarkerOptions().position(unicentro).draggable(true).title("Centro Comercial Unicentro Cali")).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));

        // Add a marker in Zoologico de Cali
        LatLng zoologico = new LatLng(3.448548, -76.5591623);
        mMap.addMarker(new MarkerOptions().position(zoologico).title("Zoologico de Cali")).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));

        // Add a marker in Acuaparque de la Caña
        LatLng acuaparque = new LatLng(3.455683, -76.5079507);
        mMap.addMarker(new MarkerOptions().position(acuaparque).title("Acuaparque de la Caña")).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));

        LatLng intercontinental = new LatLng(3.4492352, -76.5391762);
        markerOption = googleMap.addMarker(new MarkerOptions().position(intercontinental).title("Hotel Intercontinental Cali"));

        LatLng gatoTejada = new LatLng(3.4512905, -76.5436357);
        markerDrag = googleMap.addMarker(new MarkerOptions().position(gatoTejada).title("El Gato de Tejada").draggable(true));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(icesi,10));

        googleMap.setOnMarkerClickListener(this);
        googleMap.setOnMarkerDragListener(this);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        if(marker.equals(markerOption)){
            String lat,lng;
            lat=Double.toString(marker.getPosition().latitude);
            lng=Double.toString(marker.getPosition().longitude);
            Toast.makeText(this,lat + ", " + lng, Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    @Override
    public void onMarkerDragStart(Marker marker) {
        if(marker.equals(markerDrag)){
            Toast.makeText(this,"Start",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onMarkerDrag(Marker marker) {
        if(marker.equals(markerDrag)){
            String newTitle=String.format(Locale.getDefault(),
                    getString(R.string.marker_detail_latlng),
                    marker.getPosition().latitude,
                    marker.getPosition().longitude);
            setTitle(newTitle);
        }
    }

    @Override
    public void onMarkerDragEnd(Marker marker) {
        if(marker.equals(markerDrag)){
            Toast.makeText(this,"Finish",Toast.LENGTH_LONG).show();
            setTitle(R.string.app_sitios);
        }

    }
}
