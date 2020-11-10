package com.example.teamproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;


public class Mainpage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.chatmain);
        setContentView(R.layout.mainpage);

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
//        Toolbar tb = (Toolbar) findViewById(R.id.app_toolbar_chat) ;
//        setSupportActionBar(tb) ;
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //뒤로가기 버튼
//        getSupportActionBar().setHomeAsUpIndicator(R.drawable.left_arrow);
//        //getSupportActionBar().setDisplayShowTitleEnabled(false); //?
//        tb.setTitleTextColor(Color.BLACK);


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