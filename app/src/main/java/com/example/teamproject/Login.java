package com.example.teamproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        Button loginB = findViewById(R.id.loginB);
        TextView findIDB = findViewById(R.id.findmyinfo);
        TextView joinFinB = findViewById(R.id.membership);
        Button testWriteB = findViewById(R.id.testButton);

        loginB.setOnClickListener(this);
        findIDB.setOnClickListener(this);
        joinFinB.setOnClickListener(this);
        testWriteB.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.loginB://로그인버튼
                Intent it = new Intent(getApplicationContext(), Address.class);
                startActivity(it);
                break;
            case R.id.findmyinfo://아이디/비밀번호 찾기
                Intent it2 = new Intent(getApplicationContext(), FindMyInfo.class);
                startActivity(it2);
                break;
            case R.id.membership://회원가입
                Intent it3 = new Intent(getApplicationContext(), Join.class);
                startActivity(it3);
                break;
            case R.id.testButton://커뮤니티 글쓰기 -> 나중에 지우기(테스트용)
                Intent it4 = new Intent(getApplicationContext(), WriteCommunity.class);
                startActivity(it4);
                break;
            default:
                break;
        }
    }
}