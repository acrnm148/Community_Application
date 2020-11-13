package com.example.teamproject;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class WriteCommunity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.writecommunity);

        //뒤로가기 버튼
        Toolbar tb = (Toolbar) findViewById(R.id.app_toolbar_chat) ;
        setSupportActionBar(tb) ;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back_arrow);
        tb.setTitleTextColor(Color.BLACK);

/*
        final CheckBox cb1 = (CheckBox)findViewById(R.id.ckFemale);
        final CheckBox cb2 = (CheckBox)findViewById(R.id.chMale);
        final CheckBox cb3 = (CheckBox)findViewById(R.id.ch10);
        final CheckBox cb4 = (CheckBox)findViewById(R.id.ch20);
        final CheckBox cb5 = (CheckBox)findViewById(R.id.ch30);
        final CheckBox cb6 = (CheckBox)findViewById(R.id.ch40);
        final CheckBox cb7 = (CheckBox)findViewById(R.id.chAddress);
*/
        /*Button reg = (Button) findViewById(R.id.register);
        reg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int id = v.getId();
                Intent it = new Intent(getApplicationContext(), .class);//커뮤니티 게시판으로!
                startActivity(it);
            }
        });*/
    }
    //toolbar의 back키 눌렀을 때 동작
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

}

