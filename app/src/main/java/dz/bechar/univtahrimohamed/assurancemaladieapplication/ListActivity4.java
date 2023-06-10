package dz.bechar.univtahrimohamed.assurancemaladieapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ListActivity4 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list4);

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Task<QuerySnapshot> collectionRef = db.collection("users").get();



        collectionRef.addOnCompleteListener(
                new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            QuerySnapshot snapshot = task.getResult();
                            System.out.println("size: " + snapshot.size());
                            if (snapshot.size() > 0) {
                                // Documents found based on the key and value


                                Task<QuerySnapshot> collectionRef2 = db.collection("rembourcement")
                                        .get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                                            @Override
                                            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                                                System.out.println("size2: " + queryDocumentSnapshots.size());
                                                if(queryDocumentSnapshots.size() > 0){


                                                    List<Item> items = new ArrayList<Item>();

                                                    for(int i=0; i<snapshot.size(); i++){
                                                        DocumentSnapshot document = snapshot.getDocuments().get(i);
                                                        items.add(
                                                                new Item(
                                                                        document.get("nom").toString() + " " + document.get("prenom").toString(),
                                                                        document.get("email").toString(),
                                                                        R.drawable.profile,
                                                                        queryDocumentSnapshots.getDocuments().get(0).get("date").toString(),
                                                                        queryDocumentSnapshots.getDocuments().get(0).get("file1").toString(),
                                                                        queryDocumentSnapshots.getDocuments().get(0).get("file2").toString(),
                                                                        queryDocumentSnapshots.getDocuments().get(0).get("file3").toString()
                                                                )
                                                        );
                                                    }

                                                    RecyclerView recyclerView = findViewById(R.id.recycleview4);


                                                    recyclerView.setLayoutManager(new LinearLayoutManager(ListActivity4.this));
                                                    recyclerView.setAdapter(new MyAdapter(getApplicationContext(),items));


                                                }

                                            }
                                        });




                            } else {

                            }
                        } else {

                        }
                    }
                }
        );



    }

}