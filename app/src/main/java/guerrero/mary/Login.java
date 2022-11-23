package guerrero.mary;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    Button btnRegistro, btnInicio;

    ImageView image;
    TextView desc, titulo;
    TextInputLayout correo, contra;

    Vibrator vibrator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);


        image = findViewById(R.id.chefInicioSesion);
        titulo = findViewById(R.id.txtAgain);
        desc = findViewById(R.id.txtHola);
        correo = findViewById(R.id.username);
        contra = findViewById(R.id.password);

        btnRegistro = findViewById(R.id.callSignUp);
        btnInicio = findViewById(R.id.callLogin);
        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, UserProfile.class);
                startActivity(intent);
            }
        });


        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Sign_Up.class);
                Pair[] pairs = new Pair[6];
                pairs[0] = new Pair<View, String>(image, "imagenAnimada");
                pairs[1] = new Pair<View, String>(titulo, "logo_text");
                pairs[2] = new Pair<View, String>(desc, "logo_desc");
                pairs[3] = new Pair<View, String>(correo, "username_tran");
                pairs[4] = new Pair<View, String>(contra, "password_tran");
                pairs[5] = new Pair<View, String>(btnRegistro, "login_signup_tran");
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this, pairs);
                    startActivity(intent, options.toBundle());
                }
            }
        });
    }
}