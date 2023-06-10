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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class RemboursementActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout acceuil, rembous, profil, historique, reclamation, telecharge, notification, deconnect;

    CardView analyseCard, radioCard, hospitalCard, vignetCard, chifaCard, optiqCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remboursement);

        idElements();

        analyseCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RemboursementActivity.this, AnalyseActivity7.class);
                startActivity(i);
            }
        });

        radioCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RemboursementActivity.this, RadiographieActivity9.class);
                startActivity(i);
            }
        });

        optiqCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RemboursementActivity.this, OptiqueActivity10.class);
                startActivity(i);
            }
        });

        vignetCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RemboursementActivity.this, VignetteActivity8.class);
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
                redirectActivity(RemboursementActivity.this, Activity5.class);
            }
        });

        rembous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recreate();
            }
        });

        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(RemboursementActivity.this, ProfileActivity.class);
            }
        });

        historique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(RemboursementActivity.this, HistoriqueActivity.class);
            }
        });

        reclamation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(RemboursementActivity.this, ReclamationActivity.class);
            }
        });

        telecharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl("https://cnas.dz/2018/02/07/%d8%aa%d8%ad%d9%85%d9%8a%d9%84%d8%a7%d8%aa/");
                //redirectActivity(RemboursementActivity.this, TelechargeActivity.class);
            }
        });

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(RemboursementActivity.this, NotificationActivity.class);
            }
        });

        deconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
                Toast.makeText(RemboursementActivity.this, "Déconnecter", Toast.LENGTH_SHORT).show();

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
        analyseCard = findViewById(R.id.analyse6);
            radioCard = findViewById(R.id.radio6);
            hospitalCard = findViewById(R.id.hosoital6);
            vignetCard = findViewById(R.id.vignet6);
            chifaCard = findViewById(R.id.chifa6);
            optiqCard = findViewById(R.id.optic6);

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