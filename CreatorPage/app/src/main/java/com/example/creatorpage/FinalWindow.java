package com.example.creatorpage;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Closeable;

public class FinalWindow extends AppCompatActivity {

    Button btnfinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_finalwindow);

        btnfinalizar = findViewById(R.id.btnFinalizar);

        btnfinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.os.Process.killProcess(android.os.Process.myPid());
                finish();
                System.exit(0);
            }
        });
    }
}
