package com.example.creatorpage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONArray;
import androidx.appcompat.app.AppCompatActivity;
import android.os.AsyncTask;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.internal.$Gson$Preconditions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class Workspace extends AppCompatActivity {

    EditText NomeSite, ContatoSite, EmailSite, TelefoneSite, DescricaoSite, EmailVinculo;
    RadioGroup PageSelected;
    Button btnEnviarAPI;
    //String str_NomeSite, str_ContatoSite, str_EmailSite, str_TelefoneSite, str_DescricaoSite, str_PageSelected;



    final StringBuilder response = new StringBuilder();
    final String[] jsonInputString = {null} ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_workspace);

        btnEnviarAPI = findViewById(R.id.btnEnviarDadosSite);

        btnEnviarAPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NomeSite = findViewById(R.id.edTxtNomeSite);
                ContatoSite = findViewById(R.id.edTxtContatoSite);
                EmailSite = findViewById(R.id.edTxtEmailSite);
                TelefoneSite = findViewById(R.id.edTxtTelefoneSite);
                DescricaoSite = findViewById(R.id.edTxtDescricaoSite);
                EmailVinculo = findViewById(R.id.edTxtEmailVinculo);

                DataClient datacliente = new DataClient(NomeSite.toString(), ContatoSite.toString(), EmailSite.toString(), TelefoneSite.toString(), DescricaoSite.toString(), EmailVinculo.toString());

                //DataClient.add(
                 //       new DataClient(
                 //               str_NomeSite = NomeSite.getText().toString(),
                 //               str_ContatoSite = ContatoSite.getText().toString(),
                 //               str_TelefoneSite = TelefoneSite.getText().toString(),
                 //               str_EmailSite = EmailSite.getText().toString(),
                 //               str_DescricaoSite = DescricaoSite.getText().toString(),
                 //               str_PageSelected = PageSelected.getTransitionName()
                  //      )
                //);
                //final JSONArray jsonArray = new JSONArray(Arrays.asList(DataClient));

                /**try {
                    Void alUser = new UserService(datacliente).execute().get();

                } catch (ExecutionException e) {
                    Alert("Pau aqui" + e);
                } catch (InterruptedException e) {
                    Alert("Pau logo abaixo" + e);
                }**/
                GoToFinalWindow();
            }
        });
    }


    public class UserService extends AsyncTask<Void, Void, Void> {
        // construtor da classe UserService
        public UserService(DataClient user) {
            // cria uma instância do objeto Gson
            Gson gson = new Gson();
            jsonInputString[0] = gson.toJson(user);
        }

        protected void onPreExecute() {
        }

        protected Void doInBackground(Void... voids) {
            try {
                // instanciar os objetos para se conectar na internet
                // na variável url informamos o nosso endPoint
                URL url = new URL("http://freeuni9.sa-east-1.elasticbeanstalk.com/");
                // abrir a conexão com o servidor
                HttpURLConnection serv = (HttpURLConnection) url.openConnection();
                // configurar a requisição para o servidor
                serv.setRequestMethod("POST");
                serv.setRequestProperty("Content-Type", "application/json; utf-8");
                serv.setRequestProperty("Accept", "application/json");
                serv.setConnectTimeout(5000); // 5 segundos para se conectar
                serv.setReadTimeout(5000);
                serv.setDoInput(true); // permite que os dados sejam retornados
                serv.setDoOutput(true); // permite que os dados sejam lidos do servidor

                // enviando dados ao servidor
                try (OutputStream os = serv.getOutputStream()) {
                    // informando para requisição o tipo de dados a ser enviado
                    byte[] input = jsonInputString[0].getBytes("utf-8");
                    // enviar os dados
                    os.write(input, 0, input.length);
                }

                // ler a resposta do servidor
                try (BufferedReader br = new BufferedReader(
                        new InputStreamReader(serv.getInputStream(), "utf-8"))) {

                    // variável para receber as linhas enviadas pelo servidor
                    String responseLine = null;

                    // percorre o retorno do servidor e coloca na variável
                    while ((responseLine = br.readLine()) != null) {
                        response.append(responseLine.trim());
                    }
                    // mostra no Logcat o que foi enviado pelo servidor
                    System.out.println(response.toString());
                }
            } catch (IOException ex) {
            }
            return null;
        }
    }

    public void Alert(String alert){
        Toast.makeText(this, alert, Toast.LENGTH_LONG).show();
    }

    public void GoToFinalWindow(){
        Intent FinalWindowPage = new Intent(
                Workspace.this,
                FinalWindow.class
        );
        startActivity(FinalWindowPage);
    }
}





//String[] DataClient = new String[]{str_NomeSite, str_ContatoSite, str_EmailSite,str_TelefoneSite,str_DescricaoSite,str_PageSelected};
//{,"Contato",str_ContatoSite,"Email",str_EmailSite,"Telefone",str_TelefoneSite,"Descrição",str_DescricaoSite,"PageSelected",str_PageSelected}
