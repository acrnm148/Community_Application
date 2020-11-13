package com.example.teamproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class mystore extends AppCompatActivity {

    ImageView intent_image;
    ImageView intent_review;
    ImageView intent_report;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mystore_main);

        Toolbar tb = (Toolbar) findViewById(R.id.toolbar) ;
        setSupportActionBar(tb) ;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //뒤로가기 버튼
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.left_arrow);

        tb.setTitleTextColor(Color.BLACK);

        intent_image=(ImageView)findViewById(R.id.Receipt_image);
        intent_image.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            //Toast.makeText(getApplicationContext(),"액티비티 전환",Toast.LENGTH_LONG).show();
            Intent intent= new Intent(com.example.teamproject.mystore.this,sellActivity.class);


        startActivity(intent);
        }
    });

        intent_review=(ImageView)findViewById(R.id.Review_image);
        intent_review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"액티비티 전환",Toast.LENGTH_LONG).show();
                Intent intent= new Intent(com.example.teamproject.mystore.this,reviewActivity.class);

                startActivity(intent);
            }
        });


        intent_report=(ImageView)findViewById(R.id.Report_image);
        intent_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"액티비티 전환",Toast.LENGTH_LONG).show();
                Intent intent= new Intent(com.example.teamproject.mystore.this,reportActivity.class);

                startActivity(intent);
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

//    public void displayToast(String message){
//        Toast.makeText(getApplication(),message,Toast.LENGTH_SHORT).show();
//
//    }
//
//
//    public void showsell(View view){
//
//        displayToast(getString(R.string.Receipt));
//    }
////
//    public void showreview(View view){
//
//        displayToast(getString(R.string.Review));
//    }
//
//    public void showreport(View view){
//
//        displayToast(getString(R.string.Report));
//    }
}