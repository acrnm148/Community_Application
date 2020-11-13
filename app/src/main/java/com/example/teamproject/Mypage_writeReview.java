package com.example.teamproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Mypage_writeReview extends AppCompatActivity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.Mypage_WriteReview); //*** xml 파일명 수정 ***
        Toolbar tb = (Toolbar) findViewById(R.id.app_toolbar_chat) ;
        setSupportActionBar(tb) ;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //뒤로가기 버튼
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.backspace);
        //getSupportActionBar().setDisplayShowTitleEnabled(false); //?
        tb.setTitleTextColor(Color.BLACK);

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
