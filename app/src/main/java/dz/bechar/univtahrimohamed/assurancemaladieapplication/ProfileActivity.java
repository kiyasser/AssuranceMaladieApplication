package dz.bechar.univtahrimohamed.assurancemaladieapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class ProfileActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout acceuil, rembous, profil, historique, reclamation, telecharge, notification, deconnect;

    TextView full_name, date, phone, address, email, pass, status;
    Button updatebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

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
                redirectActivity(ProfileActivity.this, Activity5.class);
            }
        });

        rembous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(ProfileActivity.this, RemboursementActivity.class);

            }
        });

        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recreate();
            }
        });

        historique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(ProfileActivity.this, HistoriqueActivity.class);
            }
        });

        reclamation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(ProfileActivity.this, ReclamationActivity.class);
            }
        });

        telecharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl("https://cnas.dz/2018/02/07/%d8%aa%d8%ad%d9%85%d9%8a%d9%84%d8%a7%d8%aa/");
                //redirectActivity(ProfileActivity.this, TelechargeActivity.class);
            }
        });

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(ProfileActivity.this, NotificationActivity.class);
            }
        });

        deconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
                Toast.makeText(ProfileActivity.this, "Déconnecter", Toast.LENGTH_SHORT).show();

            }
        });




        String collectionName = "users";
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection(collectionName).document(Static.userId).get().addOnSuccessListener(documentReference -> {

            //TextView full_name, date, phone, address, email, pass, status;
            full_name.setText(documentReference.get("nom").toString() + " - " + documentReference.get("prenom").toString());
            date.setText(documentReference.get("naissance").toString());
            phone.setText(documentReference.get("phone").toString());
            address.setText(documentReference.get("addresse").toString());
            email.setText(documentReference.get("email").toString());
            pass.setText(documentReference.get("password").toString());
            status.setText(documentReference.get("etatsoc").toString());

        });


        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Map<String, Object> updates = new HashMap<>();
                updates.put("nom", full_name.getText().toString().trim().split("-")[0]);
                updates.put("prenom", full_name.getText().toString().trim().split("-")[1]);
                updates.put("naissance", date.getText().toString());
                updates.put("phone", phone.getText().toString());
                updates.put("addresse", address.getText().toString());
                updates.put("email", email.getText().toString());
                updates.put("password", pass.getText().toString());
                updates.put("etatsoc", status.getText().toString());

                DocumentReference documentRef = db.collection("users").document(Static.userId);

                documentRef.update(updates)
                        .addOnSuccessListener(aVoid -> {

                            Toast.makeText(ProfileActivity.this, "Data Updated Successfully", Toast.LENGTH_SHORT).show();


                        })
                        .addOnFailureListener(e -> {
                            // Error occurred while updating
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


        full_name =findViewById(R.id.full_name);
        date =findViewById(R.id.birth);
        phone =findViewById(R.id.phone);
        address =findViewById(R.id.address);
        email =findViewById(R.id.email);
        pass =findViewById(R.id.pass);
        status =findViewById(R.id.status);

        updatebtn =findViewById(R.id.updatebtn);
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