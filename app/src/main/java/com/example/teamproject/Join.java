package com.example.teamproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Join extends AppCompatActivity {
    private EditText joinID;
    private EditText joinPW;
    private EditText joinName;
    private EditText joinJumin;
    private EditText joinCallnum;
    private EditText joinPW_check;
    private Button join;

   // private DatabaseReference mDatabase;
    FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join);
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
       // mDatabase = FirebaseDatabase.getInstance().getReference();

        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = joinName.getText().toString().trim();
                final String jumin = joinJumin.getText().toString().trim();
                final String callnum = joinCallnum.getText().toString().trim();
                final String email = joinID.getText().toString().trim();
                final String pwd = joinPW.getText().toString().trim();
                final String pwcheck = joinPW_check.getText().toString().trim();
                //공백인 부분을 제거하고 보여주는 trim();


                firebaseAuth.createUserWithEmailAndPassword(email, pwd)
                        .addOnCompleteListener(Join.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {
                                    Toast.makeText(Join.this, "등록 성공", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Join.this, Login.class);
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
    }
}//Oncreate