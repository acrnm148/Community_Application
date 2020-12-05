package com.example.teamproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Detailpage extends AppCompatActivity {
    private TextView title, detail, locate, price;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailpage);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("itemtest");

        title = (TextView) findViewById(R.id.title);
        price = (TextView) findViewById(R.id.price);
        locate = (TextView) findViewById(R.id.place);
        detail = (TextView) findViewById(R.id.item_contents);

        /*myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String titleValue = snapshot.getValue(String.class);
                String priceValue = snapshot.getValue(String.class);
                String locateValue = snapshot.getValue(String.class);
                String detailValue = snapshot.getValue(String.class);
                title.setText(titleValue);
                price.setText(priceValue);
                locate.setText(locateValue);
                detail.setText(detailValue);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            } 텍스트뷰로 파이어베이스 연결
        });*/


            //뒤로가기 버튼
            Toolbar tb = (Toolbar) findViewById(R.id.app_toolbar_chat);
            setSupportActionBar(tb);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.left_arrow);
            tb.setTitleTextColor(Color.BLACK);

            //채팅으로 넘어가기
            Button button = findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick (View view){
                Intent intent = new Intent(Detailpage.this, Chatroom.class);
                startActivity(intent);
            }
            });
        }//onCreate()


    //뒤로가기 버튼 - toolbar의 back키 눌렀을 때 동작
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
/*
    public void showDetailPage(View v) {
        int id = v.getId();
        LinearLayout layout = (LinearLayout) v.findViewById(id);
        String tag = (String) layout.getTag();
        //Toast.makeText(this, "hi", Toast.LENGTH_LONG).show();
        Intent it = new Intent(this, Detailpage.class);
        it.putExtra("it_tag",tag);
        startActivity(it);
    }*/

}
