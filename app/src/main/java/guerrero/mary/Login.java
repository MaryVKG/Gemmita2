package guerrero.mary;

import androidx.annotation.NonNull;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    Button btnRegistro, btnInicio;

    ImageView image;
    TextView desc, titulo;
    TextInputLayout usuario, contra;

    Vibrator vibrator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);


        image = findViewById(R.id.chefInicioSesion);
        titulo = findViewById(R.id.txtAgain);
        desc = findViewById(R.id.txtHola);
        usuario = findViewById(R.id.username);
        contra = findViewById(R.id.password);

        btnRegistro = findViewById(R.id.callSignUp);
        btnInicio = findViewById(R.id.callLogin);

        /**
        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, UserProfile.class);
                startActivity(intent);
            }
        });
         **/

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Sign_Up.class);
                Pair[] pairs = new Pair[6];
                pairs[0] = new Pair<View, String>(image, "imagenAnimada");
                pairs[1] = new Pair<View, String>(titulo, "logo_text");
                pairs[2] = new Pair<View, String>(desc, "logo_desc");
                pairs[3] = new Pair<View, String>(usuario, "username_tran");
                pairs[4] = new Pair<View, String>(contra, "password_tran");
                pairs[5] = new Pair<View, String>(btnRegistro, "login_signup_tran");
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this, pairs);
                    startActivity(intent, options.toBundle());
                }
            }
        });
    }


    private Boolean validateUsername() {
        String val = usuario.getEditText().getText().toString();
        if (val.isEmpty()) {
            usuario.setError("Este campo no puede estar vacío.");
            return false;
        } else {
            usuario.setError(null);
            usuario.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePassword() {
        String val = contra.getEditText().getText().toString();
        if (val.isEmpty()) {
            contra.setError("Este campo no puede estar vacío.");
            return false;
        } else {
            contra.setError(null);
            contra.setErrorEnabled(false);
            return true;
        }
    }

    public void loginuser(View view) {
        //Validate Login Info
        if (!validateUsername() | !validatePassword()) {
            return;
        } else {
            isUser();
        }
    }

    private void isUser() {
        String userEnteredUsername = usuario.getEditText().getText().toString().trim();
        String userEnteredPassword = contra.getEditText().getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUser = reference.orderByChild("username").equalTo(userEnteredUsername);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()) {

                    usuario.setError(null);
                    usuario.setErrorEnabled(false);
                    String passwordFromDB = snapshot.child(userEnteredUsername).child("password").getValue(String.class);

                    if (passwordFromDB.equals(userEnteredPassword)) {

                        usuario.setError(null);
                        usuario.setErrorEnabled(false);


                        String nameFromDB = snapshot.child(userEnteredUsername).child("name").getValue(String.class);
                        String usernameFromDB = snapshot.child(userEnteredUsername).child("username").getValue(String.class);
                        String phoneFromDB = snapshot.child(userEnteredUsername).child("phoneNo").getValue(String.class);
                        String emailFromDB = snapshot.child(userEnteredUsername).child("email").getValue(String.class);

                        Intent intent = new Intent(getApplicationContext(), UserProfile.class);

                        intent.putExtra("name", nameFromDB);
                        intent.putExtra("username", usernameFromDB);
                        intent.putExtra("email", emailFromDB);
                        intent.putExtra("phoneNo", phoneFromDB);
                        intent.putExtra("password", passwordFromDB);
                        startActivity(intent);

                    }else{
                        contra.setError("Contraseña incorrecta");
                        contra.requestFocus();
                    }
                }else{
                    usuario.setError("Este usuario no se encuentra en nuestra base de datos");
                    usuario.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


}