package com.example.parcial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.parcial.Controller.Viewl;
import  com.example.parcial.Data_Acces.ConectionDB;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
EditText np,nc,nq;
    private RecyclerView recyclerView;
    private Viewl pro;
    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        np= findViewById(R.id.np);
        nc= findViewById(R.id.nc);
        nq= findViewById(R.id.nq);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ConectionDB db = new ConectionDB(getApplicationContext());

        pro = new Viewl(db.showListPro());
        recyclerView.setAdapter(pro);
    }

    public void Register (View view){

        ConectionDB con = new ConectionDB(this);
        SQLiteDatabase db = con.getWritableDatabase();
        ContentValues values = new ContentValues();
            if (!np.getText().toString().isEmpty() && !nc.getText().toString().isEmpty() && !nq.getText().toString().isEmpty()){

                values.put("product", np.getText().toString());
                values.put("category", nc.getText().toString());
                values.put("quantity", nq.getText().toString());

                long noRegistro =db.insert("products", null, values);

                Toast.makeText(this, "Registro No "+noRegistro, Toast.LENGTH_SHORT).show();
                db.close();

                Intent lo= new Intent(this, MainActivity.class);
                startActivity(lo);

            }else{
                Toast.makeText(this, "there are empty fields", Toast.LENGTH_SHORT).show();
            }

    }





}
