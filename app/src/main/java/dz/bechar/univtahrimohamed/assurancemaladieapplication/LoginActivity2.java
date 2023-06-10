package dz.bechar.univtahrimohamed.assurancemaladieapplication;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class LoginActivity2 extends AppCompatActivity {

    Button seconnecterbtn, seconnecterbtnadmin;
    EditText EditEmail, EditMotdepasse;
    TextView TextMdpsOublie, TextSincrire;
    String nomutilisateur, motdepasse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        idElements();

        seconnecterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validateEmail() | !validatePassword()){

                } else {
                    checkUser();
                }
            }
        });

        seconnecterbtnadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validateEmail() | !validatePassword()){

                } else {
                    checkUserAdmin();
                }
            }
        });

    }

    public boolean validateEmail(){
        String val = EditEmail.getText().toString();
        if (val.isEmpty()){
            EditEmail.setError("ENTREZ VOTRE EMAIL");
            return false;
        } else {
            EditEmail.setError(null);
            return true;
        }
    }

    public boolean validatePassword(){
        String val = EditMotdepasse.getText().toString();
        if (val.isEmpty()){
            EditMotdepasse.setError("ENTREZ VOTRE MOT DE PASSE");
            return false;
        } else {
            EditMotdepasse.setError(null);
            return true;
        }
    }

    public void checkUser(){
        String email = EditEmail.getText().toString().trim();
        String password = EditMotdepasse.getText().toString().trim();

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Task<QuerySnapshot> collectionRef = db.collection("users")
                .whereEqualTo("email", email)
                .whereEqualTo("password", password)
                .get();

        collectionRef.addOnCompleteListener(
                new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            QuerySnapshot snapshot = task.getResult();
                            if (snapshot != null && !snapshot.isEmpty()) {
                                // Documents found based on the key and value
                                DocumentSnapshot document = snapshot.getDocuments().get(0);
                                Static.userId = document.getId();
                                EditEmail.setError(null);
                                Intent intent = new Intent(LoginActivity2.this, Activity5.class);
                                startActivity(intent);
                            } else {
                                EditMotdepasse.setError("LES INFORMATIONS D'IDENTIFICATION INVALIDES");
                                EditMotdepasse.requestFocus();
                            }
                        } else {
                            EditEmail.setError("L'utilisateur n'existe pas");
                            EditEmail.requestFocus();
                        }
                    }
                }
        );

    }

    public void checkUserAdmin(){
        String email = EditEmail.getText().toString().trim();
        String password = EditMotdepasse.getText().toString().trim();

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Task<QuerySnapshot> collectionRef = db.collection("admins")
                .whereEqualTo("email", email)
                .whereEqualTo("password", password)
                .get();

        collectionRef.addOnCompleteListener(
                new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            QuerySnapshot snapshot = task.getResult();
                            if (snapshot != null && !snapshot.isEmpty()) {
                                // Documents found based on the key and value
                                DocumentSnapshot document = snapshot.getDocuments().get(0);
                                Static.userId = document.getId();
                                EditEmail.setError(null);
                                Intent intent = new Intent(LoginActivity2.this, AcceuilActivity2.class);
                                startActivity(intent);
                            } else {
                                EditMotdepasse.setError("LES INFORMATIONS D'IDENTIFICATION INVALIDES");
                                EditMotdepasse.requestFocus();
                            }
                        } else {
                            EditEmail.setError("L'utilisateur n'existe pas");
                            EditEmail.requestFocus();
                        }
                    }
                }
        );

    }

   public void goToActivity5(View view){
       Intent i = new Intent(this, Activity5.class);
       startActivity(i);
   }

    public void goToInscription3(View view) {
        Intent i = new Intent(this, InscriptionActivity3.class);
        startActivity(i);
    }

    public void idElements(){
        seconnecterbtn = findViewById(R.id.seconnecterbtn2);
        seconnecterbtnadmin = findViewById(R.id.seconnecterbtnadmin);
        EditEmail = findViewById(R.id.email3);
        EditMotdepasse = findViewById(R.id.motpasse2);
        TextMdpsOublie = findViewById(R.id.motpasseoublie2);
        TextSincrire = findViewById(R.id.sincrire2);
    }
}