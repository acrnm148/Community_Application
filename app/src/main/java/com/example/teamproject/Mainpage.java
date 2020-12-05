package com.example.teamproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Mainpage extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Mainpage_ListViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);


        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new Mainpage_ListViewAdapter();//어댑터 객체 선언
        recyclerView.setAdapter(mAdapter);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        myRef.child("itemlist").addChildEventListener(new ChildEventListener() {//리사이클러뷰에 데이터추가
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Log.d("tag", snapshot.getValue().toString());

                ProductList item = snapshot.getValue(ProductList.class);
                String a = item.getTitle();
                String b = item.getPrice();
                String c = item.getLocate();
                String d = item.getDetail();

                Log.d("FirebaseData", "recieve Data - " + a + " , " + b + " , " + c + " , " + d);

                mAdapter.addItem(item);
                mAdapter.notifyDataSetChanged();//어댑터에서 받아온 데이터를 리스트뷰로 update
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //상품 등록 임시버튼
        Button button = findViewById(R.id.button_writepage);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mainpage.this, Writepage.class);
                startActivity(intent);
            }
        });

        //커뮤니티버튼
        Button cbutton = findViewById(R.id.bcommunity);
        cbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mainpage.this, CommunityMain.class);
                startActivity(intent);
            }
        });

        //리스트뷰 클릭이벤트
        mAdapter.setOnItemClicklistener(new Mainpage_ListViewAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(View view, int position){
                Intent intent = new Intent(Mainpage.this, Detailpage.class);
                startActivity(intent);
            }

        });
    }//Oncreate


    //toolbar의 back키 눌렀을 때 동작
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
    //private class Holder {
    //}
}



//    public void chatRoom(View v) {
//        int id = v.getId();
//        LinearLayout layout = (LinearLayout) v.findViewById(id);
//        String tag = (String) layout.getTag();
//        //Toast.makeText(this, "hi", Toast.LENGTH_LONG).show();
//        Intent it = new Intent(this, Chatroom.class);
//        it.putExtra("it_tag",tag);
//        startActivity(it);
//    }

