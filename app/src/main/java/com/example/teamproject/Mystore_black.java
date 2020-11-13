package com.example.teamproject;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Mystore_black extends AppCompatActivity {
    Button but_1;
    Button but_2;
    Button but_3;
    Button but_4;
    Button but_5;
    Button but_6;
    Button but_7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report);

        Toolbar tb = (Toolbar) findViewById(R.id.toolbar5) ;
        setSupportActionBar(tb) ;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //뒤로가기 버튼
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.left_arrow);

        tb.setTitleTextColor(Color.BLACK);

        but_1 = (Button)findViewById(R.id.button);

        but_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"상점 차단이 완료되었습니다.",Toast.LENGTH_LONG).show();

            }
        });

        but_2 = (Button)findViewById(R.id.button2);

        but_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"신고가 완료되었습니다.",Toast.LENGTH_LONG).show();

            }
        });


        but_3 = (Button)findViewById(R.id.button3);

        but_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"신고가 완료되었습니다.",Toast.LENGTH_LONG).show();

            }
        });



        but_4 = (Button)findViewById(R.id.button4);

        but_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"신고가 완료되었습니다.",Toast.LENGTH_LONG).show();

            }
        });

        but_5 = (Button)findViewById(R.id.button5);

        but_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"신고가 완료되었습니다.",Toast.LENGTH_LONG).show();

            }
        });

        but_6 = (Button)findViewById(R.id.button6);

        but_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"신고가 완료되었습니다.",Toast.LENGTH_LONG).show();

            }
        });



        but_7 = (Button)findViewById(R.id.button7);

        but_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"1:1 상담으로 넘어갑니다.",Toast.LENGTH_LONG).show();

            }
        });



    }
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){

            case android.R.id.home:{
                finish();
                return true;
            }

        }
        return super.onOptionsItemSelected(item);

    }
}
