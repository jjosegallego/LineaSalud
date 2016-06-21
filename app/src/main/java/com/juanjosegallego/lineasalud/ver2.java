package com.juanjosegallego.lineasalud;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ver2 extends AppCompatActivity {

    SQLiteDatabase db,db2;
    TextView resultado;
    Button insertar;
    CalendarView calendario;
    String dd,mm,aa;
    int numero;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver2);

        UsuariosSQLiteHelper3 usuario = new UsuariosSQLiteHelper3(this);
        db=usuario.getWritableDatabase();
        resultado=(TextView)findViewById(R.id.resultado2);
        numero=db.rawQuery("SELECT codigo FROM Usuarios3", null).getCount();
        Cursor c = db.rawQuery("SELECT codigo,dia,mes,año FROM Usuarios3",null);
        resultado.setText("");
        if(c.moveToFirst())
            do {
                String codigo = c.getString(0);
                dd = c.getString(1);
                mm= c.getString(2);
                aa= c.getString(3);
                resultado.append(" ");
                resultado.append("MNW0J2"+codigo+" Dia despacho:"+dd+"/:"+ mm+"/"+aa+"\n ");
                resultado.append(" ");
            }while(c.moveToNext());

    }

}


