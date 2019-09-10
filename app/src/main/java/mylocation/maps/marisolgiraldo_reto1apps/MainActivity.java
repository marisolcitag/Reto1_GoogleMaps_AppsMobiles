package mylocation.maps.marisolgiraldo_reto1apps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnSitios, btnMapas, btnUbicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSitios = (Button) findViewById(R.id.btnSitios);
        btnMapas = (Button) findViewById(R.id.btnMapas);
        btnUbicacion = (Button) findViewById(R.id.btnUbicacion) ;

        btnSitios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MapsActivity1.class);
                startActivity(intent);
            }
        });
    }

    public void MapasSitios (View view){
        Intent intent = new Intent(getApplicationContext(),MapsActivity2.class);
        startActivity(intent);

    }

    public void MiUbicacion (View view){
        Intent intent = new Intent(getApplicationContext(),MapsActivity3.class);
        startActivity(intent);

    }
}
