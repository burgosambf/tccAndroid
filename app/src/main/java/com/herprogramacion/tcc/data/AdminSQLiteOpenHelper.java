package com.herprogramacion.tcc.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by TID01 on 04/05/2017.
 */
public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper(Context context, String nombre, SQLiteDatabase.CursorFactory factory, int version) {

        super(context, nombre, factory, version);

    }

    @Override

    public void onCreate(SQLiteDatabase db) {

        //aquí creamos la tabla de usuario (dni, nombre, ciudad, numero)
        db.execSQL("create table evento(id text)");

    }

    @Override

    public void onUpgrade(SQLiteDatabase db, int version1, int version2) {

        db.execSQL("drop table if exists evento");

        db.execSQL("create table evento(id text)");

    }

    public String consulta(String v) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.rawQuery(" SELECT * FROM evento = " + v, null);
        if (c.moveToFirst()) {
            return c.getString(0);
        } else{
            return null;
        }
    }

}