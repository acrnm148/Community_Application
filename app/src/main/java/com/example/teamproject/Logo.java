package com.example.teamproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Logo extends AppCompatActivity {//나중에 애니메이션 추가하고나면 로그인파일로 변경!(합치기)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logo);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run(){
                Intent it = new Intent(getBaseContext(), Login.class);
                startActivity(it);
                finish();
            }
        }, 2000);
    }
}