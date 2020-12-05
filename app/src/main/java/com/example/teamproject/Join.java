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
    private EditText joinName;
    private EditText joinJumin;
    private EditText joinCallnum;
    private EditText joinPW_check;
    private Button join;
    public String email_ = "acrnm148@gmail.com";
    public String name_ = "강수나";
//    private File tempFile;
//    private FirebaseAuth mAuth;

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
        joinName = (EditText) findViewById(R.id.joinName);
        joinJumin = (EditText) findViewById(R.id.joinresnum);
        joinCallnum = (EditText) findViewById(R.id.joinNumber);
        joinPW_check = (EditText) findViewById(R.id.joinPwCheck);
        join = (Button) findViewById(R.id.joinFin);

        firebaseAuth = FirebaseAuth.getInstance();
        //mDatabase = FirebaseDatabase.getInstance().getReference();

        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //공백인 부분을 제거하고 보여주는 trim();
                final String name = joinName.getText().toString().trim();
                final String jumin = joinJumin.getText().toString().trim();
                final String callnum = joinCallnum.getText().toString().trim();
                final String email = joinID.getText().toString().trim();
                final String pwd = joinPW.getText().toString().trim();
                final String pwcheck = joinPW_check.getText().toString().trim();
                setEmail_(email);
                setName_(name);

                firebaseAuth.createUserWithEmailAndPassword(email, pwd)
                        .addOnCompleteListener(Join.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {
                                    //add
//                                    userModel.userName = name;
//                                    userModel.uid = email;
                                    //userModel.profileImageUrl = imageUrl.getResult().toString();

                                    UserModel userModel = new UserModel();

                                    // database에 저장 - add=================
//                                    UserModel userModel = new UserModel(name, email);
//                                    mDatabase.getReference("users").child(name).setValue(userModel);
                                    //======================================

                                    Toast.makeText(Join.this, "등록 성공 : "+ email_ + "  "+ name_, Toast.LENGTH_SHORT).show();
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