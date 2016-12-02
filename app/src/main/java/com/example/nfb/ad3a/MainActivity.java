package com.example.nfb.ad3a;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button Añadir;
    Button Mostrar;
    EditText datos;
    TextView caja;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Añadir = (Button) findViewById(R.id.Añadir);
        Mostrar = (Button) findViewById(R.id.Mostrar);
        datos = (EditText) findViewById(R.id.datos);
        caja = (TextView) findViewById(R.id.Caja);

        final String FILE_NAME =  "fichers.txt";

        Añadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream fos = openFileOutput(FILE_NAME, Context.MODE_APPEND);
                    String CadenaOutput = new String(datos.getText().toString());
                    DataOutputStream dos = new DataOutputStream(fos);
                    dos.writeBytes(CadenaOutput);
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

       Mostrar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               try{
                   FileInputStream fis = openFileInput(FILE_NAME);
                   DataInputStream dis = new DataInputStream(fis);
                   byte[] buff = new byte[10000];
                   dis.read(buff);
                   caja.setText(new String(buff));
                   fis.close();
               } catch (FileNotFoundException e) {
                   e.printStackTrace();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       });




    }
}
