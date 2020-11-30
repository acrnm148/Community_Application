package com.example.teamproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

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
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);


        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new MyAdapter();
        recyclerView.setAdapter(mAdapter);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Log.d("tag",snapshot.getValue().toString());

                productList item = snapshot.getValue(productList.class);
                String a = item.getTitle();
                String b = item.getDetail();
                String c = item.getLocate();
                String d = item.getPrice();

                Log.d("FirebaseData", "recieve Data - " + a + " , " + b + " , " + c + " , " + d);
                mAdapter.addItem(item);
                mAdapter.notifyDataSetChanged();
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



        Button button=findViewById(R.id.button_writepage);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Mainpage.this, Writepage.class);
                startActivity(intent);
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

    public void showDetailPage(View v) {
        int id = v.getId();
        LinearLayout layout = (LinearLayout) v.findViewById(id);
        String tag = (String) layout.getTag();
        //Toast.makeText(this, "hi", Toast.LENGTH_LONG).show();
        Intent it = new Intent(this, Detailpage.class);
        it.putExtra("it_tag",tag);
        startActivity(it);
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
}
//chatmain 화면
//       Toolbar tb = (Toolbar) findViewById(R.id.app_toolbar_chat) ;
//       setSupportActionBar(tb) ;
//      getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //뒤로가기 버튼
//    getSupportActionBar().setHomeAsUpIndicator(R.drawable.left_arrow);
//     //getSupportActionBar().setDisplayShowTitleEnabled(false); //?
//     tb.setTitleTextColor(Color.BLACK);


//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case android.R.id.home:{ //toolbar의 back키 눌렀을 때 동작
//                finish();
//                return true;
//            }
//        }
//        return super.onOptionsItemSelected(item);
//    }



//}