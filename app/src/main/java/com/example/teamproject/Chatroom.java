package com.example.teamproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Chatroom extends AppCompatActivity {
    //private TextView textView;
    private String CHAT_NAME;
    private String USER_NAME;

    private EditText editText;
    private Button button;
    private Button bt_chatmain;
    private ListView chat_view;

    private String userID;
    private String userPWD;

    DatabaseReference firebaseDatabase = FirebaseDatabase.getInstance().getReference("chat");
    DatabaseReference databaseReference = firebaseDatabase.child("임도연");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatroom);

        //Toolbar
        Toolbar tb = (Toolbar) findViewById(R.id.app_toolbar_chat) ;
        setSupportActionBar(tb) ;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //뒤로가기 버튼
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.left_arrow);
        tb.setTitleTextColor(Color.BLACK);

        //textView = (TextView) findViewById(R.id.tv_sent);
        editText = (EditText) findViewById(R.id.editText_send);
        button = (Button) findViewById(R.id.btn_send);
        chat_view = (ListView) findViewById(R.id.chat_view);

        // 메인화면/목록 에서 받아온 채팅방 이름, 유저 이름 저장
        CHAT_NAME = "임도연";
        USER_NAME = "강수나";
        //Intent intent = getIntent();
        //CHAT_NAME = intent.getStringExtra("chatName");
        //USER_NAME = userID;

        openChat(CHAT_NAME);

        //전송버튼
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChatDTO chat = new ChatDTO(USER_NAME, editText.getText().toString()); //ChatDTO를 이용하여 데이터를 묶는다.
                databaseReference.child("chat").child(CHAT_NAME).push().setValue(chat);
                editText.setText(""); //입력창 초기화
            }
        });
        //목록버튼
        Button bt_chatmain = findViewById(R.id.bt_chatmain);
        bt_chatmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chatroom.this, Chatmain.class);
                startActivity(intent);
            }
        });
    }


    private void addMessage(DataSnapshot dataSnapshot, ArrayAdapter<String> adapter) {
        ChatDTO chatDTO = dataSnapshot.getValue(ChatDTO.class);
        adapter.add(chatDTO.getUserName() + " : " + chatDTO.getMessage());
    }

    private void removeMessage(DataSnapshot dataSnapshot, ArrayAdapter<String> adapter) {
        ChatDTO chatDTO = dataSnapshot.getValue(ChatDTO.class);
        adapter.remove(chatDTO.getUserName() + " : " + chatDTO.getMessage());
    }

    private void openChat(String chatName) {
        // 리스트 어댑터 생성 및 세팅
        final ArrayAdapter<String> adapter
                = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1);
        chat_view.setAdapter(adapter);

        // 데이터 받아오기 및 어댑터 데이터 추가 및 삭제 등..리스너 관리
        databaseReference.child("chat").child(chatName).addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                addMessage(snapshot, adapter);
                Log.e("LOG", "s:"+previousChildName);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                removeMessage(snapshot, adapter);
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

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
