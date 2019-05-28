package com.tiempo_procesos.tiempo_procesos;

import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConcatenarTask concatenarTask = new ConcatenarTask();
        concatenarTask.execute("A");
    }

    public static String Concatenar(String letra, int repeticiones) {
        String resultado = "";
        for (int i = 0; i < repeticiones; i++) {
            resultado += letra;
        }
        return resultado;
    }
    class ConcatenarTask extends AsyncTask<String, Void, String> {
        AlertDialog Mensaje;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(getApplicationContext(), "Inicio", Toast.LENGTH_SHORT).show();
            AlertDialog.Builder Alerta = new AlertDialog.Builder(MainActivity.this);
            Alerta.setMessage("Espere...").setTitle("Ok").create();
            Mensaje=Alerta.show();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(getApplicationContext(), "Final", Toast.LENGTH_SHORT).show();
            Mensaje.dismiss();
        }

        @Override
        protected String doInBackground(String... strings) {
            String resultado = Concatenar(strings[0], 30000);
            return resultado;
        }
    }
}