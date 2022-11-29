package guerrero.mary;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ContactUs extends AppCompatActivity {

    ImageView insta, whatsapp, face, backbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);


    backbtn = findViewById(R.id.back);

    insta = findViewById(R.id.iv_instagram);
    whatsapp = findViewById(R.id.iv_whatsapp);
    face = findViewById(R.id.iv_facebook);


    face.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sAppLink = "  https://www.facebook.com/profile.php?id=100063692191473&mibextid=LQQJ4d";
                String sPackage = "https://www.facebook.com/profile.php?id=100063692191473";
                String sWebLink = "https://m.facebook.com/search/top/?q=Empanadas+gemma";
                openLink(sAppLink, sPackage, sWebLink);
            }
        });


    whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Aca lo inicializamos
                String number = "+56923823323";
                Uri uri = Uri.parse(String.format(
                        "https://api.whatsapp.com/send/?phone=56923823323&text&type=phone_number&app_absent=0",number
                ));
                //
                //Aquí llamamos al intent
                Intent intent = new Intent(Intent.ACTION_VIEW);

                intent.setData(uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }

        });

    insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sAppLink = "https://www.instagram.com/empanadasgemma2/";
                String sPackage = "https://instagram.com/empanadasgemma2?igshid=YmMyMTA2M2Y=";
            }
        });


        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContactUs.super.onBackPressed();
            }
        });
    }

    private void openLink(String sAppLink, String sPackage, String sWebLink) {
        try{
            Uri uri = Uri.parse(sAppLink);

            Intent intent = new Intent(Intent.ACTION_VIEW);

            intent.setData(uri);
            intent.setPackage(sPackage);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }catch (ActivityNotFoundException activityNotFoundException){
            Uri uri = Uri.parse(sWebLink);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(uri);

            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}