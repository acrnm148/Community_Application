package com.example.teamproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Join extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join);

        Toolbar tb = (Toolbar) findViewById(R.id.app_toolbar_chat) ;
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //뒤로가기 버튼
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.left_arrow);
        tb.setTitleTextColor(Color.BLACK);

        Button join = (Button) findViewById(R.id.joinFin);
        join.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int id = v.getId();
                Intent it = new Intent(getApplicationContext(), Address.class);
                startActivity(it);
            }
        });
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


