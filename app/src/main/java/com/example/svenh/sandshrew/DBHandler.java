package com.example.svenh.sandshrew;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;



public class DBHandler extends SQLiteOpenHelper {
    String DB_PATH = null;
    private static String DB_NAME = "pkedb.db";
    private SQLiteDatabase myDataBase;
    private final Context myContext;
    private int DATABASE_VERSION = 1;
    private Cursor c;
    private String sql;




    public DBHandler(Context context) {
        super(context, DB_NAME, null, 10);
        this.myContext = context;
        this.DB_PATH = "/data/data/" + context.getPackageName() + "/" + "databases/";
        Log.e("Path 1", DB_PATH);
    }



    public void createDataBase() throws IOException {
        boolean dbExist = checkDataBase();
        if (dbExist) {
        } else {

            this.getReadableDatabase();
            try {
                copyDataBase();
            } catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }

    private boolean checkDataBase() {
        SQLiteDatabase checkDB = null;
        try {
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {
        }
        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null ? true : false;
    }

    private void copyDataBase() throws IOException {
        InputStream myInput = myContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[10];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    public void openDataBase() throws SQLException {
        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

    }

    @Override
    public synchronized void close() {
        if (myDataBase != null)
            myDataBase.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion)
            try {
                copyDataBase();
            } catch (IOException e) {
                e.printStackTrace();

            }
    }


    //RETREIVE DATA METHODS BELOW

    public void addPokemon(Pokemon pokemon){

        SQLiteDatabase db = this.getWritableDatabase();
        try{
        ContentValues values = new ContentValues();
        values.put("pke_id", pokemon.get_id());
        values.put("pke_name", pokemon.getName());
        values.put("pke_type1", pokemon.getType1());
        values.put("pke_type2", pokemon.getType2());
        values.put("pke_ability", pokemon.getAbility());
        values.put("pke_nature", pokemon.getNature());
        values.put("pke_stat", pokemon.getStat());
        db.insert("Pke_Test",null, values);
        db.close();}
        catch (Exception e){

        }
    }

    public String getRandomType(){
        myDataBase = getWritableDatabase();
        c = myDataBase.query("Type", null, null, null, null, null, "Random()", "1");
        if (c.moveToFirst()) {
            do {
                sql = c.getString(1).toUpperCase();
            } while (c.moveToNext());
        }
        return sql;
    }


    public String getRandomId(){
        myDataBase = getWritableDatabase();
        c = myDataBase.query("Pke_Main", null, null, null, null, null, "Random()", "1");
        if (c.moveToFirst()) {
            do {
                sql = c.getString(0).toUpperCase();
            } while (c.moveToNext());
        }
        return sql;
    }


        public String getRandomAbility(){
        myDataBase = getWritableDatabase();
        c = myDataBase.query("Ability",null, null,null,null,null,"Random()","1");
        if (c.moveToFirst()) {
            do {
                sql = c.getString(1).toUpperCase();
            } while (c.moveToNext());
        }
            return sql;
    }

    public String getRandomNature(){
        String sql = new String();
        myDataBase = getWritableDatabase();
        /*d = queryAb("Ability",null,null,null,null,null,null);*/
        c = myDataBase.query("Nature",null, null,null,null,null,"Random()","1");
        if (c.moveToFirst()) {
            do {
                sql = c.getString(1).toUpperCase();
            } while (c.moveToNext());
        }
        return sql;
    }

    public String getRandomName(){
        String sql = new String();
        myDataBase = getWritableDatabase();
        /*d = queryAb("Ability",null,null,null,null,null,null);*/
        c = myDataBase.query("Pke_Main",null, null,null,null,null,"Random()","1");
        if (c.moveToFirst()) {
            do {
                sql = c.getString(1).toUpperCase();
            } while (c.moveToNext());
        }
        return sql;
    }

    public String getRandomStat(){
        String sql = new String();
        myDataBase = getWritableDatabase();
        /*d = queryAb("Ability",null,null,null,null,null,null);*/
        c = myDataBase.query("Pke_Main",null, null,null,null,null,"Random()","1");
        if (c.moveToFirst()) {
            do {
                sql = c.getString(7).toUpperCase();
            } while (c.moveToNext());
        }
        return sql;
    }





}
