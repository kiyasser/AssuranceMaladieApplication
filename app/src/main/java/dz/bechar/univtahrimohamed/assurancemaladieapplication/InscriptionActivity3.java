package dz.bechar.univtahrimohamed.assurancemaladieapplication;

import android.app.DatePickerDialog;
import android.content.Intent;

import android.os.Bundle;

import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.ktx.Firebase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class InscriptionActivity3 extends AppCompatActivity {

    EditText EditNom, EditPrenom, EditDateNaissance, EditEmail, EditTelephone, EditAddress, EditMotpasse, EditEtatSociale;
    Button sincrirebtn, annulerbtn;
    RadioGroup radioGroupSexe;
    RadioButton radioButtonHomme, radioButtonFemme, radio;
    Calendar calendar;
    String nom, prenom, naissance, email, phone, addresse, password, etatsoc, sexe;

    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription3);

        idElements();

        sincrirebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseFirestore db = FirebaseFirestore.getInstance();

                String nom = EditNom.getText().toString();
                String prenom = EditPrenom.getText().toString();
                String naissance = EditDateNaissance.getText().toString();
                String email = EditEmail.getText().toString();
                String phone = EditTelephone.getText().toString();
                String addresse = EditAddress.getText().toString();
                String password = EditMotpasse.getText().toString();
                String etatsoc = EditEtatSociale.getText().toString();

                HelperClass helperClass = new HelperClass(nom, prenom, naissance, email, phone, addresse, password, etatsoc);
                CollectionReference usersRef = db.collection("users");

                usersRef.add(helperClass)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(InscriptionActivity3.this, "SUCCÈS", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(InscriptionActivity3.this, LoginActivity2.class);
                                startActivity(i);
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                // Failed to add data
                            }
                        });




            }
        });

        annulerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditNom.setText("");
                EditPrenom.setText("");
                EditDateNaissance.setText("");
                EditEmail.setText("");
                EditTelephone.setText("");
                EditAddress.setText("");
                EditMotpasse.setText("");
                EditEtatSociale.setText("");
            }
        });

        Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                updateCalendar();

            }

            private void  updateCalendar(){
                String Format = "MM/dd/yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(Format, Locale.US);

                EditDateNaissance.setText(sdf.format(calendar.getTime()));
            }
        };
        EditDateNaissance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new DatePickerDialog(InscriptionActivity3.this, date, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }

    public void ToActivity5(View view){
        Intent i = new Intent(this, Activity5.class);
        startActivity(i);
    }

    public void idElements(){
        EditNom = findViewById(R.id.nom3);
        EditPrenom = findViewById(R.id.prenom3);
        EditDateNaissance = findViewById(R.id.datenaiss3);
        EditEmail = findViewById(R.id.email3);
        EditTelephone = findViewById(R.id.phone3);
        EditAddress = findViewById(R.id.address3);
        EditMotpasse = findViewById(R.id.motdepasse3);
        EditEtatSociale = findViewById(R.id.etatsociale3);
        sincrirebtn = findViewById(R.id.sincrirebtn3);
        radioButtonFemme = findViewById(R.id.femme3);
        radioButtonHomme = findViewById(R.id.homme3);
        radioGroupSexe = findViewById(R.id.groupsexe3);
        annulerbtn = findViewById(R.id.annulerbtn3);
    }

}