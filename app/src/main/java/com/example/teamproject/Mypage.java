package com.example.teamproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Mypage extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar tb = (Toolbar) findViewById(R.id.app_toolbar_chat) ;
        setSupportActionBar(tb) ;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //뒤로가기 버튼
        //getSupportActionBar().setHomeAsUpIndicator(R.drawable.backspace);
        //getSupportActionBar().setDisplayShowTitleEnabled(false); //?
        tb.setTitleTextColor(Color.BLACK);

        Button imageButton = (Button) findViewById(R.id.공지사항);
        imageButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), Mypage_notice.class);
                startActivity(intent);
            }
        });
        Button Button = (Button) findViewById(R.id.판매내역);
        Button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), Mypage_sellList.class);
                startActivity(intent);
            }
        });
        Button bt1 = (Button) findViewById(R.id.구매내역);
        bt1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), Mypage_buyList.class);
                startActivity(intent);
            }
        });
        Button bt2 = (Button) findViewById(R.id.내게시글);
        bt2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), Mypage_myScripts.class);
                startActivity(intent);
            }
        });

    }



}