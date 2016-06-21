package com.juanjosegallego.lineasalud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class UsuariosSQLiteHelper3 extends SQLiteOpenHelper {

    private static final String DATA_BASE_NAME="UsuariosBD2";
    private static final int DATA_VERSION=1;

    String sqlCreate3="CREATE TABLE Usuarios3(codigo INTEGER PRIMARY KEY AUTOINCREMENT,dia TEXT,mes TEXT,año TEXT)";

    public UsuariosSQLiteHelper3(Context contexto) {
        super(contexto, DATA_BASE_NAME,null,DATA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(sqlCreate3);
        //db.execSQL(iniciales2);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISITS Usuarios2");
        db.execSQL(sqlCreate3);

    }
}

