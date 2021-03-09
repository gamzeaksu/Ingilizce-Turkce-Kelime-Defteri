package com.cansuayten.proje;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
//çalışmadı
public class VeriTabani extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "notes.db";
    private static final String TABLE_NAME ="Notes";
    private static String COL_ID = "Notes_ID";
    private static String COL_BASLIK = "Notes_Baslik";
    private static String COL_NOT = "Notes";


    public VeriTabani(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE IF NOT EXISTS "+ TABLE_NAME +"("+COL_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+ COL_BASLIK +" TEXT, "+ COL_NOT +" TEXT)";
        db.execSQL(createTable);
    }
    public void VeriEkle(String baslik,String not){
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues cv = new ContentValues();
            cv.put(COL_BASLIK, baslik);
            cv.put(COL_NOT,not);
            db.insert(TABLE_NAME, null,cv);
        }catch (Exception e){
        }
        db.close();
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public List<String> VeriListele(){
        List<String> veriler = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            //String[] stunlar = {COL_ID,COL_NAME,COL_SURNAME,COL_USERNAME,COL_PASSWORD};
            Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
            while (cursor.moveToNext()){
                veriler.add(cursor.getString(1) + "\n" + cursor.getString(2));
            }
        }catch (Exception e){

        }
        db.close();
        return veriler;
    }

}

