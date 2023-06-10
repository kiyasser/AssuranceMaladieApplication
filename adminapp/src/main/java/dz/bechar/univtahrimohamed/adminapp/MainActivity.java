package dz.bechar.univtahrimohamed.adminapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity {

    Button connectbtn;
    EditText editemail, editpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idElements();

        connectbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AcceuilActivity2.class);
                startActivity(i);
            }
        });

    }

    public void idElements(){
        connectbtn = findViewById(R.id.connecterbtn);
        editemail = findViewById(R.id.email);
        editpassword = findViewById(R.id.password);
    }

}