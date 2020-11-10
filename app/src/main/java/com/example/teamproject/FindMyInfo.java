package com.example.teamproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class FindMyInfo extends AppCompatActivity implements View.OnClickListener{
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.findmyinfo);

            Toolbar tb = (Toolbar) findViewById(R.id.app_toolbar_chat) ;
            setSupportActionBar(tb) ;
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //뒤로가기 버튼
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.back);
            tb.setTitleTextColor(Color.BLACK);

            Button findID = findViewById(R.id.findID);
            Button findPW = findViewById(R.id.findPW);

            findID.setOnClickListener(this);
            findPW.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.findID) {
                Intent it = new Intent(getApplicationContext(), CheckMyInfo.class);
                startActivity(it);
            } else if (v.getId() == R.id.findPW) {
                Intent it = new Intent(getApplicationContext(), CheckMyInfo.class);
                startActivity(it);
            }
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
