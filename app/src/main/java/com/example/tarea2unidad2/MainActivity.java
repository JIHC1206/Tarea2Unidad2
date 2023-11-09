package com.example.tarea2unidad2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private Button Iniciar;
    private TextView Usuario, Contraseña;
    private ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Iniciar = findViewById(R.id.btn_iniciar);
        Usuario = findViewById(R.id.et_usuario);
        Contraseña = findViewById(R.id.et_contraseña);
        pb = findViewById(R.id.progressBar2);

        Iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Task().execute(Usuario.getText().toString());
            }
        });
    }
    class Task extends AsyncTask<String, Void, String>{
        @Override
        protected void onPreExecute(){
            pb.setVisibility(View.VISIBLE);
            Iniciar.setEnabled(true);
        }
        @Override
        protected String doInBackground(String... strings) {
            try {
                Thread.sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return strings[0];
        }
        @Override
        protected void onPostExecute(String s){
            pb.setVisibility(View.VISIBLE);
            Iniciar.setEnabled(true);
                Intent intent = new Intent(MainActivity.this, Resultado.class);
                intent.putExtra("Usuario", Usuario.getText().toString());
                startActivity(intent);
        }

    }

}