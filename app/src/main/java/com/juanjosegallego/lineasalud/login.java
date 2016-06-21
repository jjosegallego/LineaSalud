package com.juanjosegallego.lineasalud;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class login extends AppCompatActivity {

    Button inicio,registro;
    SQLiteDatabase db;
    String identificador1,identificador2;
    EditText correo,contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inicio=(Button) findViewById(R.id.inicio);
        registro=(Button) findViewById(R.id.registro);
        correo=(EditText)findViewById(R.id.correo);
        contraseña=(EditText)findViewById(R.id.contraseña);

        UsuariosSQLiteHelper usuario = new UsuariosSQLiteHelper(this);
        db=usuario.getWritableDatabase();

        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                identificador1= correo.getText().toString();
                identificador2= contraseña.getText().toString();

                String[] campos = new String[]{"codigo","correo","contrasena"};
                String[] args = new String[]{identificador1};
                String[] args2 = new String[]{identificador2};

                Cursor c = db.query("Usuarios", campos, "correo=?", args, null, null, null);
                if (c.moveToFirst()) {
                    do {

                    } while (c.moveToNext());
                }else{
                    Toast.makeText(login.this, "email del usuario no encontrado ", Toast.LENGTH_SHORT).show();
                }
                Cursor c2 = db.query("Usuarios", campos, "contrasena=?", args2, null, null, null);
                if (c2.moveToFirst()) {
                    do {

                        Intent contenido = new Intent(login.this,MainActivity.class);
                        contenido.putExtra("user", identificador1);
                        startActivity(contenido);
                        finish();

                    } while (c.moveToNext());
                }else{
                    Toast.makeText(login.this, "contraseña del usuario no encontrada ", Toast.LENGTH_SHORT).show();
                }

            }

        });

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contenido = new Intent(login.this, registro.class);
                startActivity(contenido);
                finish();
            }
        });
    }
}
