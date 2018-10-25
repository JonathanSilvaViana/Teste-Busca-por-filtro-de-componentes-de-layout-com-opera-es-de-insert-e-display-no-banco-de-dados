package com.example.testegigaservices.testegigaservices;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    //nome do banco de dados
    public static final String DATABASE_NAME = "banco.db";

    //tabelas referentes as seções de produtos
    public static final String TABLE_1 = "produto_1";
    public static final String TABLE_2 = "produto_2";
    public static final String TABLE_3 = "produto_3";
    public static final String TABLE_4 = "produto_4";
    public static final String TABLE_5 = "produto_5";


    //colunas da tabela de produto 1

    public static final String TABLE_1_C_ID = "id_produto_1";
    public static final String TABLE_1_C_QTD = "quantidade_produto_1";

    //colunas da tabela de produto 2

    public static final String TABLE_2_C_ID = "id_produto_2";
    public static final String TABLE_2_C_QTD = "quantidade_produto_2";

    //colunas da tabela de produto 3

    public static final String TABLE_3_C_ID = "id_produto_3";
    public static final String TABLE_3_C_QTD = "quantidade_produto_3";

    //colunas da tabela de produto 4

    public static final String TABLE_4_C_ID = "id_produto_4";
    public static final String TABLE_4_C_QTD = "quantidade_produto_4";

    //colunas da tabela de produto 5

    public static final String TABLE_5_C_ID = "id_produto_5";
    public static final String TABLE_5_C_QTD = "quantidade_produto_5";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(
                "create table "
                + TABLE_1
                + "(id_produto_1 INTEGER PRIMARY KEY AUTOINCREMENT, quantidade_produto_1 TEXT) "
        );

        db.execSQL(
                "create table "
                        + TABLE_2
                        + "(id_produto_2 INTEGER PRIMARY KEY AUTOINCREMENT, quantidade_produto_2 TEXT) "
        );

        db.execSQL(
                "create table "
                        + TABLE_3
                        + "(id_produto_3 INTEGER PRIMARY KEY AUTOINCREMENT, quantidade_produto_3 TEXT) "
        );

        db.execSQL(
                "create table "
                        + TABLE_4
                        + "(id_produto_4 INTEGER PRIMARY KEY AUTOINCREMENT, quantidade_produto_4 TEXT) "
        );

        db.execSQL(
                "create table "
                        + TABLE_5
                        + "(id_produto_5 INTEGER PRIMARY KEY AUTOINCREMENT, quantidade_produto_5 TEXT) "
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(
                "DROP TABLE IF EXISTS " + TABLE_1 + TABLE_2 + TABLE_3 + TABLE_4 + TABLE_5);
        onCreate(db);
    }


    //insere dados na tabela 1

    public boolean insereDados_na_TABLE_1(String quantidade_1)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValue = new ContentValues();
        contentValue.put(TABLE_1_C_QTD , quantidade_1);
        long resultado = db.insert(TABLE_1, null, contentValue);
        if(resultado == -1)
            return false;
        else
            return true;
    }

    //insere dados na tabela 2

    public boolean insereDados_na_TABLE_2(String quantidade_2)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValue = new ContentValues();
        contentValue.put(TABLE_2_C_QTD, quantidade_2);
        long resultado = db.insert(TABLE_2, null, contentValue);
        if(resultado == -1)
            return false;
        else
            return true;
    }

    //insere dados na table 3

    public boolean insereDados_na_TABLE_3(String quantidade_3)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValue = new ContentValues();
        contentValue.put(TABLE_3_C_QTD, quantidade_3);
        long resultado = db.insert(TABLE_3, null, contentValue);
        if(resultado == -1)
            return false;
        else
            return true;
    }

    //insere dados na table 4

    public boolean insereDados_na_TABLE_4(String quantidade_4)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValue = new ContentValues();
        contentValue.put(TABLE_4_C_QTD, quantidade_4);
        long resultado = db.insert(TABLE_4, null, contentValue);
        if(resultado == -1)
            return false;
        else
            return true;
    }

    //insere dados na table 5

    public boolean insereDados_na_TABLE_5(String quantidade_5)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValue = new ContentValues();
        contentValue.put(TABLE_5_C_QTD, quantidade_5);
        long resultado = db.insert(TABLE_5, null, contentValue);
        if(resultado == -1)
            return false;
        else
            return true;
    }

    //////////////para pegar todos os dados inseridos

    //table 1

    public Cursor pegaTodosDados_1(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res1 = db.rawQuery("select * from " + TABLE_1 + " ORDER BY " + TABLE_1_C_ID + " DESC LIMIT 1", null);
        return res1;
    }

    //table 2

    public Cursor pegaTodosDados_2(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res2 = db.rawQuery("SELECT * FROM "+ TABLE_2 + " ORDER BY " + TABLE_2_C_ID + " DESC LIMIT 1", null);
        return res2;
    }

    //table 3

    public Cursor pegaTodosDados_3(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res3 = db.rawQuery("SELECT * FROM "+ TABLE_3 + " ORDER BY " + TABLE_3_C_ID + " DESC LIMIT 1", null);
        return res3;
    }

    //table 4

    public Cursor pegaTodosDados_4(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res4 = db.rawQuery("SELECT * FROM "+ TABLE_4 + " ORDER BY " + TABLE_4_C_ID + " DESC LIMIT 1", null);
        return res4;
    }

    //table 5

    public Cursor pegaTodosDados_5(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res5 = db.rawQuery("SELECT * FROM "+ TABLE_5 + " ORDER BY " + TABLE_5_C_ID + " DESC LIMIT 1", null);
        return res5;
    }

}
