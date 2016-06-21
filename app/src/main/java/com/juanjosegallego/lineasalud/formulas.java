package com.juanjosegallego.lineasalud;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class formulas extends Fragment {

    Button confirmar,ver;
    DatePicker selectorfecha;
    SQLiteDatabase db,db2;

    public formulas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View root= inflater.inflate(R.layout.fragment_formulas, container, false);

        confirmar= (Button) root.findViewById(R.id.agendaconfirma2);
        ver= (Button) root.findViewById(R.id.agendaver2);
        selectorfecha = (DatePicker) root.findViewById(R.id.datep2);



        UsuariosSQLiteHelper3 usuario = new UsuariosSQLiteHelper3(getActivity());
        db=usuario.getWritableDatabase();


        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer mes = selectorfecha.getMonth()+1;
                Integer dia = selectorfecha.getDayOfMonth();
                Integer año = selectorfecha.getYear();

                String month = String.valueOf(mes);
                String day = String.valueOf(dia);
                String year = String.valueOf(año);

                ContentValues nuevoRegistro = new ContentValues();
                nuevoRegistro.put("dia", day);
                nuevoRegistro.put("mes", month);
                nuevoRegistro.put("año", year);
                db.insert("Usuarios3", null, nuevoRegistro);

                Toast.makeText(getActivity(), "Formula agendada con éxito", Toast.LENGTH_SHORT).show();


            }
        });


        ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent mapa3 = new Intent(getActivity(),ver2.class);
                startActivity(mapa3);

            }
        });

        return root;
    }



}
