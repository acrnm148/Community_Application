package com.example.teamproject;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Mystore_sellList extends AppCompatActivity {

//    Button but_1;
//    Button but_2;
//    Button but_3;
//    Button but_4;
//    Button but_5;
//    Button but_6;
//    Button but_7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sell);
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar4);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //뒤로가기 버튼
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.left_arrow);
        //getSupportActionBar().setDisplayShowTitleEnabled(false); //?
        tb.setTitleTextColor(Color.BLACK);


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
