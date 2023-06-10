package dz.bechar.univtahrimohamed.assurancemaladieapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


public class AnalyseActivity7 extends AppCompatActivity {

    Button ordonancebtn, resultatbtn, feuilebtn, valid, cancel;
    ImageView ordonanceimage, resultatimage, feuileimage;
    EditText datesoin;
    private final int GALLERY_REQ_CODE = 1000, GALLERY_REQ_CODE2 = 2000, GALLERY_REQ_CODE3 = 3000;

    Uri file1, file2, file3;
    String file1url = null, file2url = null, file3url = null;

    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyse7);

        idElements();

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

                datesoin.setText(sdf.format(calendar.getTime()));
            }
        };
        datesoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new DatePickerDialog(AnalyseActivity7.this, date, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        ordonancebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iGalley = new Intent(Intent.ACTION_PICK);
                iGalley.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(iGalley, GALLERY_REQ_CODE);
            }
        });

        resultatbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iGalley = new Intent(Intent.ACTION_PICK);
                iGalley.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(iGalley, GALLERY_REQ_CODE2);
            }
        });

        feuilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iGalley = new Intent(Intent.ACTION_PICK);
                iGalley.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(iGalley, GALLERY_REQ_CODE3);
            }
        });

        valid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseStorage storage = FirebaseStorage.getInstance();
                StorageReference storageRef = storage.getReference();

                StorageReference fileRef1 = storageRef.child("files/" + file1.getLastPathSegment());
                StorageReference fileRef2 = storageRef.child("files/" + file2.getLastPathSegment());
                StorageReference fileRef3 = storageRef.child("files/" + file3.getLastPathSegment());

                UploadTask uploadTask1 = fileRef1.putFile(file1);
                UploadTask uploadTask2 = fileRef2.putFile(file2);
                UploadTask uploadTask3 = fileRef3.putFile(file3);

                uploadTask2.addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        fileRef2.getDownloadUrl().addOnSuccessListener(uri -> {
                            file2url = uri.toString();
                            storeInfo();
                        });
                    } else { }
                });

                uploadTask1.addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        fileRef1.getDownloadUrl().addOnSuccessListener(uri -> {
                            file1url = uri.toString();
                            storeInfo();
                        });
                    } else { }
                });

                uploadTask3.addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        fileRef3.getDownloadUrl().addOnSuccessListener(uri -> {
                            file3url = uri.toString();
                            storeInfo();
                        });
                    } else { }
                });

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode==RESULT_OK){

            if (requestCode==GALLERY_REQ_CODE){
                ordonanceimage.setImageURI(data.getData());
                file1 = data.getData();
            }

            if (requestCode==GALLERY_REQ_CODE2){
                resultatimage.setImageURI(data.getData());
                file2 = data.getData();
            }

            if (requestCode==GALLERY_REQ_CODE3){
                feuileimage.setImageURI(data.getData());
                file3 = data.getData();
            }

        }

    }

    public void idElements(){
    ordonancebtn = findViewById(R.id.ordonancebtn7);
    ordonanceimage = findViewById(R.id.ordonanceimage7);

    resultatbtn = findViewById(R.id.resultatbtn7);
    resultatimage = findViewById(R.id.resultatimage7);

    feuilebtn = findViewById(R.id.feuilebtn7);
    feuileimage = findViewById(R.id.feuileimage7);

    datesoin = findViewById(R.id.datesoin7);

    valid = findViewById(R.id.validerbtn7);

    }

    public void storeInfo() {

        if(file1url != null && file2url != null && file3url != null){
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            Map<String, Object> analyse = new HashMap<>();
            analyse.put("date", datesoin.getText().toString());
            analyse.put("file1", file1url);
            analyse.put("file2", file2url);
            analyse.put("file3", file3url);
            analyse.put("type", "analyse");
            analyse.put("status", false);
            analyse.put("user_id", Static.userId);

            String collectionName = "rembourcement";

            db.collection(collectionName)
                    .add(analyse)
                    .addOnSuccessListener(documentReference -> {
                        // Data added successfully
                        String documentId = documentReference.getId();
                        // Handle the document ID, e.g., save it to a variable or use it as needed


                        Toast.makeText(this, "Data send succefully!", Toast.LENGTH_LONG).show();
                    })
                    .addOnFailureListener(e -> {
                        // Error occurred while adding data
                        // Handle the error
                    });

        }
    }

}