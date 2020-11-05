package com.example.eva2bancobpm_franciscofernandes_igorllancapan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progress;
    private EditText userId, passwordId;
    private String user, pass;
    private TextView txt_V;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progress = (ProgressBar)findViewById(R.id.pb);
        btn = (Button)findViewById(R.id.btn);

        txt_V = (TextView)findViewById(R.id.txt_error);

        userId = (EditText)findViewById(R.id.userId);
        passwordId = (EditText)findViewById(R.id.passId);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                user = userId.getText().toString();
                pass = passwordId.getText().toString();

                if (user.equalsIgnoreCase("android") && pass.equals("123"))
                {


                new Task().execute();

                }

                else
                {
                    txt_V.setText("Error al ingresar sus datos");
                }
            }
        });


        progress.setVisibility(View.INVISIBLE);
    }

    class Task extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {

            progress.setVisibility(View.VISIBLE);
        }


        @Override
        protected String doInBackground(String... strings) {

            for(int i = 1; i < 10; i++)
            {
                try {
                    Thread.sleep(1000);

                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            return null;
        }


        @Override
        protected void onPostExecute(String s) {

            progress.setVisibility(View.INVISIBLE);

            Intent i = new Intent(getBaseContext(), Home_act.class);
            startActivity(i);

        }

    }

}