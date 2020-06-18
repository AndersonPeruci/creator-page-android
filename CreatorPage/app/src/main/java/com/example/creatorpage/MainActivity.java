package com.example.creatorpage;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText email, password;
    TextView textDadosIncorretos;
    Button btnCheckLogin;
    String emailstr, passwordstr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        btnCheckLogin = (Button) findViewById(R.id.btnLogin);

        btnCheckLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = findViewById(R.id.edTxtEmail);
                password = findViewById(R.id.edTxtPassword);
                emailstr = email.getText().toString();
                passwordstr = password.getText().toString();

                if (emailstr.equals("a") && passwordstr.equals("1")){
                    Alert("Login realizado com sucesso");
                    GoToWorkspace();
                }else{
                    Alert("Login ou senha incorretos");
                    email.setText("");
                    password.setText("");
                    email.requestFocus();
                }
            }
        });
    }

    public void Alert(String alert){
        Toast.makeText(this, alert, Toast.LENGTH_LONG).show();
    }

    public void GoToWorkspace(){
        Intent WorkspacePage = new Intent(
                getApplicationContext(),
                Workspace.class
        );
        startActivity(WorkspacePage);
    }
}
