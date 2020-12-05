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
        Button testWriteB = findViewById(R.id.testButton);


        loginID.setOnClickListener(this);
        loginPW.setOnClickListener(this);
        loginB.setOnClickListener(this);

        joinFinB.setOnClickListener(this);
        testWriteB.setOnClickListener(this);
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
                Intent it3 = new Intent(getApplicationContext(), Join.class);
                startActivity(it3);
                break;
            case R.id.testButton://커뮤니티 글쓰기 -> 나중에 지우기(테스트용)
                Intent it4 = new Intent(getApplicationContext(), WriteCommunity.class);
                startActivity(it4);
                break;
            case R.id.address://주소인증 -> 나중에 지우기(테스트용)
                Intent it5 = new Intent(getApplicationContext(), Address.class);
                startActivity(it5);
                break;
            case R.id.mainpage://메인페이지 -> 나중에 지우기(테스트용)
                Intent it6 = new Intent(getApplicationContext(), Mainpage.class);
                startActivity(it6);
                break;
            case R.id.chat://채팅-> 나중에 지우기(테스트용)
                Intent it7 = new Intent(getApplicationContext(), Chatmain.class);
                startActivity(it7);
                break;

//              case R.id.btn_custom_login:  //카카오 로그인
//                  Intent it8 =new Intent(getApplicationContext(),KakaoLogin.class);
//                  startActivity(it8);
//                break;


//            case R.id.btn_custom_login_out:  //카카오 로그아웃
//                Intent it9 =new Intent(getApplicationContext(),KakaoLogin.class);
//                startActivity(it9);
//                break;

            default:
                break;
        }
    }

}