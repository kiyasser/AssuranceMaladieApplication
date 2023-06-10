package dz.bechar.univtahrimohamed.assurancemaladieapplication;

import android.content.Intent;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class ShowupActivity extends AppCompatActivity {

    Timer timer ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showup);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(ShowupActivity.this, MainActivity1.class);
                startActivity(intent);
            }
        },1000);

    }
}