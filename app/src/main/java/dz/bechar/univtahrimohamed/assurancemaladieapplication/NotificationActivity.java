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

public class NotificationActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout acceuil, rembous, profil, historique, reclamation, telecharge, notification, deconnect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        idElements();


        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDrawer(drawerLayout);
            }
        });

        acceuil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(NotificationActivity.this, Activity5.class);
            }
        });

        rembous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(NotificationActivity.this, RemboursementActivity.class);
            }
        });

        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(NotificationActivity.this, ProfileActivity.class);
            }
        });

        historique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(NotificationActivity.this, HistoriqueActivity.class);
            }
        });

        reclamation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(NotificationActivity.this, ReclamationActivity.class);
            }
        });

        telecharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl("https://cnas.dz/2018/02/07/%d8%aa%d8%ad%d9%85%d9%8a%d9%84%d8%a7%d8%aa/");
                //redirectActivity(NotificationActivity.this, TelechargeActivity.class);
            }
        });

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recreate();
            }
        });

        deconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
                Toast.makeText(NotificationActivity.this, "Déconnecter", Toast.LENGTH_SHORT).show();
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