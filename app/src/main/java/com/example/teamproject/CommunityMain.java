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
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import org.w3c.dom.Text;

public class CommunityMain extends AppCompatActivity /*implements NavigationView.OnNavigationItemSelectedListener*/{

    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.community_main);
        Toolbar tb = (Toolbar) findViewById(R.id.app_toolbar_chat) ;
        setSupportActionBar(tb) ;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //뒤로가기 버튼
        //getSupportActionBar().setHomeAsUpIndicator(R.drawable.backspace);
        //getSupportActionBar().setDisplayShowTitleEnabled(false); //?
        tb.setTitleTextColor(Color.BLACK);

        Button btn = (Button) findViewById(R.id.community_write);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), WriteCommunity.class);
                startActivity(intent);
            }
        });
        Button btn1 = (Button) findViewById(R.id.community_sangse);
        btn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), CommunityDetail.class);
                startActivity(intent);
            }
        });
}
   /* public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.action_home) {
            // Handle the camera action
        } else if (id == R.id.action_chat) {

        } else if (id == R.id.action_community) {

        } else if (id == R.id.action_mypage) {

        } else if (id == R.id.action_wirte) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.navigation);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }*/


}
