package guerrero.mary;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class UserProfile extends AppCompatActivity {


    Button clearInformation;
    TextInputLayout fullname, email, phoneNo, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);



        fullname = findViewById(R.id.full_name_profile);
        email = findViewById(R.id.email_profile);
        phoneNo = findViewById(R.id.phone_profile);
        password = findViewById(R.id.pass_profile);


        showAllUserData();



        clearInformation = findViewById(R.id.clearTextt);
        clearInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fullname.getEditText().setText("");
                email.getEditText().setText("");
                phoneNo.getEditText().setText("");
                password.getEditText().setText("");
            }
        });

    }



    private void showAllUserData(){
        Intent intent = getIntent();
        String user_username = intent.getStringExtra("username");
        String user_name = intent.getStringExtra("name");
        String user_email = intent.getStringExtra("email");
        String user_phoneNo = intent.getStringExtra("phoneNo");
        String user_password = intent.getStringExtra("password");


        fullname.getEditText().setText(user_name);
        email.getEditText().setText(user_email);
        phoneNo.getEditText().setText(user_phoneNo);
        password.getEditText().setText(user_password);


    }

    public void intentClient(View view){
        Intent intent = new Intent(getApplicationContext(),  VistaUsuario.class);
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.perrsonal), "transitionTrabajador");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(UserProfile.this, pairs);
            startActivity(intent,options.toBundle());
        }else {
            startActivity(intent);
        }
    }


    public void intentTrabajador(View view){
        Intent intent = new Intent(getApplicationContext(),  Crud_Empanadas.class);
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.perrsonal), "transitionTrabajador");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(UserProfile.this, pairs);
            startActivity(intent,options.toBundle());
        }else {
            startActivity(intent);
        }
    }



}