package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    Button b1;
    EditText uid,pass;
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        b1=findViewById(R.id.sign);
        uid=findViewById(R.id.su);
        pass=findViewById(R.id.sp);
        db=openOrCreateDatabase("register",MODE_PRIVATE,null);
        db.execSQL ("create table if not exists register (uid varchar (300),pass varchar (300))");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = uid.getText().toString();
                String s0 = pass.getText().toString();

                ContentValues cv=new ContentValues();
                cv.put("uid",s);
                cv.put("pass",s0);
                db.insert("register",null,cv);


                if (s.equals("") && s0.equals("")) {
                    Toast.makeText(MainActivity3.this, "Invalid registration", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(MainActivity3.this, MainActivity3.class);
                    startActivity(i);

                } else if (s.equals(s) && s0.equals("") || s.equals("") && s0.equals(s0)) {

                    Toast.makeText(MainActivity3.this, "Invalid registration", Toast.LENGTH_SHORT).show();
                    Intent i0 = new Intent(MainActivity3.this, MainActivity3.class);
                    startActivity(i0);
                }
                else {
                    Toast.makeText(MainActivity3.this, "Registration", Toast.LENGTH_SHORT).show();
                    Intent i1 = new Intent(MainActivity3.this, MainActivity4.class);
                    startActivity(i1);
                }

            }
        });
    }
}