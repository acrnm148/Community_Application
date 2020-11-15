package com.example.teamproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Join extends AppCompatActivity {
    public EditText join_Name;
    public EditText join_resnum;
    public EditText join_Number;
    public EditText join_ID;
    public EditText join_PW;
    public EditText join_PwCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join);

        Toolbar tb = (Toolbar) findViewById(R.id.app_toolbar_chat) ;
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //뒤로가기 버튼
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.left_arrow);
        tb.setTitleTextColor(Color.BLACK);

        join_Name = (EditText) findViewById(R.id.joinName);
        join_resnum = (EditText) findViewById(R.id.joinresnum);
        join_Number = (EditText) findViewById(R.id.joinNumber);
        join_ID = (EditText) findViewById(R.id.joinID);
        join_PW = (EditText) findViewById(R.id.joinPW);
        join_PwCheck = (EditText) findViewById(R.id.joinPwCheck);
        Button join = (Button) findViewById(R.id.joinFin);

        join.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference();
                myRef.child("user").push().setValue(join_Name.getText().toString());
                myRef.child("user").push().setValue(join_resnum.getText().toString());
                myRef.child("user").push().setValue(join_Number.getText().toString());
                myRef.child("user").push().setValue(join_ID.getText().toString());
                myRef.child("user").push().setValue(join_PW.getText().toString());
                myRef.child("user").push().setValue(join_PwCheck.getText().toString());
                int id = v.getId();
                Intent it = new Intent(getApplicationContext(), Address.class);
                startActivity(it);
            }
        });
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ //toolbar의 back키 눌렀을 때 동작
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

}