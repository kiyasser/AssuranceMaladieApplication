package dz.bechar.univtahrimohamed.assurancemaladieapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class AcceuilActivity2 extends AppCompatActivity {

    CardView infoCard, demandeCard, maintenancehCard, histoCard, listCard, deconnectCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil2);

        idElements();

        listCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AcceuilActivity2.this, ListActivity4.class);
                startActivity(i);
            }
        });

        infoCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AcceuilActivity2.this, InformationActivity3.class);
                startActivity(i);
            }
        });

    }

    public void idElements(){
        infoCard = findViewById(R.id.infocard2);
        demandeCard = findViewById(R.id.demandcard2);
        maintenancehCard = findViewById(R.id.maintenircard2);
        histoCard = findViewById(R.id.histocard2);
        listCard = findViewById(R.id.listcard2);
        deconnectCard = findViewById(R.id.deconnectcard2);
    }

}