package com.example.teamproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity implements View.OnClickListener{
    private EditText loginID, loginPW;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        firebaseAuth = FirebaseAuth.getInstance();
        //Login editText
        loginID = (EditText) findViewById(R.id.username);
        loginPW = (EditText) findViewById(R.id.password);
        Button loginB = findViewById(R.id.loginB);

        TextView joinFinB = findViewById(R.id.membership);



        loginID.setOnClickListener(this);
        loginPW.setOnClickListener(this);
        loginB.setOnClickListener(this);

        joinFinB.setOnClickListener(this);

    }

    private void login(){
        String id = loginID.getText().toString().trim();
        String pwd = loginPW.getText().toString().trim();

        firebaseAuth.signInWithEmailAndPassword(id, pwd)
                .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Login.this, "로그인 성공", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Login.this, Mainpage.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(Login.this, "로그인 오류", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginB:
                login();
                break;
            case R.id.membership://회원가입
                Intent it_ = new Intent(getApplicationContext(), Join.class);
                startActivity(it_);
                break;
              case R.id.btn_custom_login:  //카카오 로그인
                  Intent it__ =new Intent(getApplicationContext(), KakaoLogin.class);
                  startActivity(it__);
                break;
            default:
                break;
        }
    }

}