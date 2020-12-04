package com.example.teamproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.teamproject.chat.Chatroom;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Detailpage extends AppCompatActivity {
    private TextView title, detail, locate, price;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailpage);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
//
        title = (TextView) findViewById(R.id.title);
        price = (TextView) findViewById(R.id.price);
        price = (TextView) findViewById(R.id.price);
        detail = (TextView) findViewById(R.id.item_contents);

/*        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                ProductList item = dataSnapshot.getValue(ProductList.class);
                title = item.getTitle();
                item.getDetail();
                item.getLocate();
                item.getPrice();

                myRef.child("itemlist").setValue(item);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                //Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }

        };
        myRef.addValueEventListener(postListener);*/
/*
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Log.d("tag", snapshot.getValue().toString());

                ProductList item = snapshot.getValue(ProductList.class);
                String a = item.getTitle();
                String b = item.getDetail();
                String c = item.getLocate();
                String d = item.getPrice();

                Log.d("FirebaseData", "recieve Data - " + a + " , " + b + " , " + c + " , " + d);
                mAdapter.addItem(item);
                mAdapter.notifyDataSetChanged();//어댑터에서 받아온 데이터를 리스트뷰로 update
            }
            });
*/

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
