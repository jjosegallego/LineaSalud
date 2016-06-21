package com.juanjosegallego.lineasalud;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class registro extends AppCompatActivity {

    SQLiteDatabase db;
    Button registro;
    EditText correo,contrasena22,contrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        registro=(Button)findViewById(R.id.registro2);

        correo=(EditText)findViewById(R.id.correo2);
        contrasena=(EditText)findViewById(R.id.contraseña2);
        contrasena22=(EditText)findViewById(R.id.contraseña22);

        UsuariosSQLiteHelper usuario = new UsuariosSQLiteHelper(this);
        db=usuario.getWritableDatabase();

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String correo2 = correo.getText().toString();
                String contrasena2a = contrasena.getText().toString();
                String contrasena22a = contrasena22.getText().toString();

                if (contrasena2a.equals(contrasena22a)) {
                    ContentValues nuevoRegistro = new ContentValues();
                    nuevoRegistro.put("correo", correo2);
                    nuevoRegistro.put("contrasena", contrasena2a);
                    db.insert("Usuarios", null, nuevoRegistro);
                    Intent contenido = new Intent(registro.this,MainActivity.class);
                    contenido.putExtra("user", correo2);
                    startActivity(contenido);
                    finish();

                }else{
                    Toast.makeText(registro.this, "Rectifique las contraseñas ingresadas", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }
}
