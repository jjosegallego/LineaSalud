package com.juanjosegallego.lineasalud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class UsuariosSQLiteHelper extends SQLiteOpenHelper {

    private static final String DATA_BASE_NAME="UsuariosBD";
    private static final int DATA_VERSION=1;

    String sqlCreate="CREATE TABLE Usuarios(codigo INTEGER PRIMARY KEY AUTOINCREMENT,correo TEXT,contrasena TEXT)";
    //String iniciales="INSERT INTO Usuarios(nombre,cantidad,valor)VALUES('Ironman','10','15000'),('Viuda Negra','10','12000'),('Capitan America','10','15000'),('Hulk','10','12000'),('Bruja Escarlata','10','15000'),('Spiderman','10','10000')";
    //String sqlCreate2="CREATE TABLE Usuarios2(codigo INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT,cantidad INTEGER,valor INTEGER,ganancia INTEGER)";


    public UsuariosSQLiteHelper(Context contexto) {
        super(contexto, DATA_BASE_NAME,null,DATA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
        //db.execSQL(iniciales);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISITS Usuarios");
        db.execSQL(sqlCreate);



    }
}

