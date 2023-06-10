package dz.bechar.univtahrimohamed.assurancemaladieapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class ReclamationActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout acceuil, rembous, profil, historique, reclamation, telecharge, notification, deconnect;
    Button envoyerreclam, annulerreclam;
    EditText emailreclam, msgreclam;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reclamation);

        idElements();

        annulerreclam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emailreclam.setText("");
                msgreclam.setText("");
            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDrawer(drawerLayout);
            }
        });

        acceuil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(ReclamationActivity.this, Activity5.class);
            }
        });

        rembous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(ReclamationActivity.this, RemboursementActivity.class);
            }
        });

        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(ReclamationActivity.this, ProfileActivity.class);
            }
        });

        historique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(ReclamationActivity.this, HistoriqueActivity.class);
            }
        });

        reclamation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recreate();

            }
        });

        telecharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl("https://cnas.dz/2018/02/07/%d8%aa%d8%ad%d9%85%d9%8a%d9%84%d8%a7%d8%aa/");
                // redirectActivity(ReclamationActivity.this, TelechargeActivity.class);
            }
        });

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(ReclamationActivity.this, NotificationActivity.class);
            }
        });

        deconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
                Toast.makeText(ReclamationActivity.this, "Déconnecter", Toast.LENGTH_SHORT).show();

            }
        });

        envoyerreclam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                Map<String, Object> reclamation = new HashMap<>();
                reclamation.put("email", emailreclam.getText().toString());
                reclamation.put("message", msgreclam.getText().toString());

                String collectionName = "reclamation";

                db.collection(collectionName)
                        .add(reclamation)
                        .addOnSuccessListener(documentReference -> {
                            Toast.makeText(ReclamationActivity.this, "Réclamation Send Successfully", Toast.LENGTH_SHORT).show();
                        })
                        .addOnFailureListener(e -> {
                            // Error occurred while adding data
                            // Handle the error
                        });
            }
        });

    }

    private void goToUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    public void idElements(){
        drawerLayout = findViewById(R.id.drawerlayout5);
        menu = findViewById(R.id.menu);
        acceuil = findViewById(R.id.acceuil);
        historique = findViewById(R.id.historique);
        deconnect = findViewById(R.id.deconnect);
        rembous = findViewById(R.id.remboursement);
        profil = findViewById(R.id.profil);
        reclamation = findViewById(R.id.reclamation);
        telecharge = findViewById(R.id.telecharge);
        notification =findViewById(R.id.notification);
        envoyerreclam = findViewById(R.id.envoyerreclam);
        annulerreclam = findViewById(R.id.annulerreclam);
        emailreclam = findViewById(R.id.emailreclam);
        msgreclam = findViewById(R.id.msgreclam);
    }

    public static void  openDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public static void closeDrawer(DrawerLayout drawerLayout){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public static void redirectActivity(Activity activity, Class aClass){
        Intent i = new Intent(activity, aClass);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(i);
        activity.finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }
}