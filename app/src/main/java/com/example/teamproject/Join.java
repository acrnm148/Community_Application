package com.example.teamproject;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.loader.content.CursorLoader;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.io.File;


public class Join extends AppCompatActivity {
    private EditText joinID;
    private EditText joinPW;
    private Button join;
    public String email_ = "acrnm148@gmail.com";
    public String name_ = "강수나";

    private FirebaseDatabase mDatabase;

    FirebaseAuth firebaseAuth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join);

        mDatabase = FirebaseDatabase.getInstance();

        //뒤로가기 버튼
        Toolbar tb = (Toolbar) findViewById(R.id.app_toolbar_chat);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.left_arrow);
        tb.setTitleTextColor(Color.BLACK);

        joinID = (EditText) findViewById(R.id.joinID);
        joinPW = (EditText) findViewById(R.id.joinPW);
        join = (Button) findViewById(R.id.joinFin);

        firebaseAuth = FirebaseAuth.getInstance();

        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //xml파일에서 받아온 텍스트를 정의
                //공백인 부분을 제거하고 보여주는 trim();
                final String email = joinID.getText().toString().trim();
                final String pwd = joinPW.getText().toString().trim();

                firebaseAuth.createUserWithEmailAndPassword(email, pwd)
                        .addOnCompleteListener(Join.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {
                                    UserModel userModel = new UserModel();
                                    Toast.makeText(Join.this, "등록 성공", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Join.this, Address.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(Join.this, "등록 에러", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                            }
                        });
            }//onClick
        });
    }//Oncreate
    public void setEmail_(String email_){
        this.email_ = email_;
    }
    public void setName_(String name_){
        this.name_ = name_;
    }
    public String getEmail_(){
        Log.e("LOG", "이메일, 이름:"+email_);
        return email_;
    }
    public String getName_(){
        Log.e("LOG", "이메일, 이름:"+name_);
        return name_;
    }
}