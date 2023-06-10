package dz.bechar.univtahrimohamed.assurancemaladieapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class Activity5 extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout acceuil, rembous, profil, historique, reclamation, telecharge, notification, deconnect;

    CardView infoCard, rembCard, telechCard, histoCard, notiCard, reclamCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        idElements();

        notiCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity5.this, NotificationActivity.class);
                startActivity(i);
            }
        });

        telechCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl("https://cnas.dz/2018/02/07/%d8%aa%d8%ad%d9%85%d9%8a%d9%84%d8%a7%d8%aa/");
            }
        });

        reclamCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity5.this, ReclamationActivity.class);
                startActivity(i);
            }
        });

        infoCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity5.this, ProfileActivity.class);
                startActivity(i);
            }
        });

        reclamCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity5.this, ReclamationActivity.class);
                startActivity(i);
            }
        });

        histoCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity5.this, HistoriqueActivity.class);
                startActivity(i);
            }
        });

        rembCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity5.this, RemboursementActivity.class);
                startActivity(i);
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
                recreate();
            }
        });

        rembous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(Activity5.this, RemboursementActivity.class);
            }
        });

        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(Activity5.this, ProfileActivity.class);
            }
        });

        historique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(Activity5.this, HistoriqueActivity.class);
            }
        });

        reclamation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(Activity5.this, ReclamationActivity.class);
            }
        });

        telecharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl("https://cnas.dz/2018/02/07/%d8%aa%d8%ad%d9%85%d9%8a%d9%84%d8%a7%d8%aa/");
                //redirectActivity(Activity5.this, TelechargeActivity.class);
            }
        });

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(Activity5.this, NotificationActivity.class);
            }
        });

        deconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
                Toast.makeText(Activity5.this, "Déconnecter", Toast.LENGTH_SHORT).show();

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
        infoCard = findViewById(R.id.infocardfa);
        rembCard = findViewById(R.id.rembouscardfa);
        telechCard = findViewById(R.id.telechacardfa);
        histoCard = findViewById(R.id.histocardfa);
        notiCard = findViewById(R.id.notifcardfa);
        reclamCard = findViewById(R.id.reclamcardfa);
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