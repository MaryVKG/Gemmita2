package guerrero.mary;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class VistaUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_usuario);
    }



    //esto es para nosotros, rrss, ubicacion

    public void intentNosotros(View view){
        Intent intent = new Intent(getApplicationContext(),  Personal.class);
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.nosotros), "transitionNosotros");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(VistaUsuario.this, pairs);
            startActivity(intent,options.toBundle());
        }else {
            startActivity(intent);
        }
    }

    public void intentUbicacion(View view){
        Intent intent = new Intent(getApplicationContext(),  MapsTest.class);
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.ubicacion), "transitionUbicacion");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(VistaUsuario.this, pairs);
            startActivity(intent,options.toBundle());
        }else {
            startActivity(intent);
        }
    }




    //esto es para los icons de abajo
    public void intentEmpanada(View view){
        Intent intent = new Intent(getApplicationContext(),  Producto_Empanadas.class);
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.empanada), "transitionEmpanadas");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(VistaUsuario.this, pairs);
            startActivity(intent,options.toBundle());
        }else {
            startActivity(intent);
        }
    }


    public void intentPostres(View view){
        Intent intent = new Intent(getApplicationContext(),  Producto_Postres.class);
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.postre), "transitionPostres");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(VistaUsuario.this, pairs);
            startActivity(intent,options.toBundle());
        }else {
            startActivity(intent);
        }
    }

}