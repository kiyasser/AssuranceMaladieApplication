package dz.bechar.univtahrimohamed.assurancemaladieapplication;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;


public class MainActivity1 extends AppCompatActivity {

    Button connexionbtn, sincrirebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_main);
        FirebaseApp.initializeApp(this);
        connexionbtn = findViewById(R.id.connexionbtn);
        sincrirebtn = findViewById(R.id.sincrirebtn1);


    }

    public void connexion0(View view) {
        Intent i = new Intent(this, LoginActivity2.class);
        startActivity(i);
    }
    public void sincrire0(View view) {
        Intent ii = new Intent(MainActivity1.this, InscriptionActivity3.class);
        startActivity(ii);
    }

}