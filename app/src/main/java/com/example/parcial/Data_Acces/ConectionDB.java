package com.example.parcial.Data_Acces;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.parcial.Model.Products;

import java.util.ArrayList;
import java.util.List;

public class ConectionDB extends SQLiteOpenHelper {

    public ConectionDB(@Nullable Context context) {
        super(context, "CRUD", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase CRUD) {
        CRUD.execSQL("Create Table products ("+"Id integer primary key autoincrement  not null,"+
                "product text not null,"+
                "category text not null,"+
                "quantity text not null )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public List<Products> showListPro(){

        SQLiteDatabase db= getReadableDatabase();
        Cursor cursor= db.rawQuery("SELECT * FROM products", null);

        List<Products>  listProducts = new ArrayList<>();

        if(cursor.moveToFirst()){
            do {
                listProducts.add(new Products(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3)));
            }while (cursor.moveToNext());
        }
        return listProducts;
    }
}
