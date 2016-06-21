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

public class citas extends Fragment {

    Button confirmar,ver;
    DatePicker selectorfecha;
    SQLiteDatabase db,db2;

    public citas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View root= inflater.inflate(R.layout.fragment_citas, container, false);

        confirmar= (Button) root.findViewById(R.id.agendaconfirma);
        ver= (Button) root.findViewById(R.id.agendaver);
        selectorfecha = (DatePicker) root.findViewById(R.id.datep);



        UsuariosSQLiteHelper2 usuario = new UsuariosSQLiteHelper2(getActivity());
        UsuariosSQLiteHelper usuario1 = new UsuariosSQLiteHelper(getActivity());
        db=usuario.getWritableDatabase();
        db2=usuario1.getWritableDatabase();

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
                db.insert("Usuarios2", null, nuevoRegistro);

                Toast.makeText(getActivity(), "cita guardada con éxito", Toast.LENGTH_SHORT).show();


            }
        });


        ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent mapa3 = new Intent(getActivity(),ver.class);
                startActivity(mapa3);

            }
        });

        return root;
    }



}
