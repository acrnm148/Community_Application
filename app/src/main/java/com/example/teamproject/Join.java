package com.example.teamproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class Join extends AppCompatActivity {
    private EditText joinID;
    private EditText joinPW;
    private EditText joinName;
    private EditText joinJumin;
    private EditText joinCallnum;
    private EditText joinPW_check;

    private DatabaseReference mDatabase;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join);

        Toolbar tb = (Toolbar) findViewById(R.id.app_toolbar_chat) ;
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //뒤로가기 버튼
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.left_arrow);
        tb.setTitleTextColor(Color.BLACK);




        joinID = (EditText) findViewById(R.id.joinID);
        joinPW = (EditText) findViewById(R.id.joinPW);
        joinName = (EditText) findViewById(R.id.joinName);
        joinJumin = (EditText) findViewById(R.id.joinresnum);
        joinCallnum = (EditText) findViewById(R.id.joinNumber);
        joinPW_check = (EditText) findViewById(R.id.joinPwCheck);


        mDatabase = FirebaseDatabase.getInstance().getReference();

        readUser();

        Button join = (Button) findViewById(R.id.joinFin);
        join.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String getUserID = joinID.getText().toString();
                String getUserPw = joinPW.getText().toString();
                String getUserName = joinName.getText().toString();
                String getUserJumin = joinJumin.getText().toString();
                String getUserCallnum = joinCallnum.getText().toString();
                String getUserPw_check = joinPW_check.getText().toString();

                HashMap result = new HashMap<>();
                result.put("ID",getUserID);
                result.put("PW",getUserPw);
                result.put("NAME",getUserName);
                result.put("JUMIN",getUserJumin);
                result.put("CALLNUM",getUserCallnum);
                result.put("PW_CHECK",getUserPw_check);
                writeNewUser("1",getUserID,getUserPw, getUserName, getUserJumin, getUserCallnum, getUserPw_check);

                int id = v.getId();
                Intent it = new Intent(getApplicationContext(), Address.class);
                startActivity(it);
            }
        });
    }
    private void writeNewUser(String num,String id, String pw, String name, String jumin, String callnum, String pw_check){
        User user = new User(id, pw, name, jumin, callnum, pw_check);

        mDatabase.child("users").child(name).setValue(user) //!!!!!!!!!
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Join.this, "저장완료", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Join.this, "저장실패", Toast.LENGTH_SHORT).show();
                    }
                });

    }
    private void readUser(){
        mDatabase.child("users").child("1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.getValue(User.class) != null){
                    User post = snapshot.getValue(User.class);
                    Log.w("FireBaseData", "getData"+post.toString());
                }else{
                    Toast.makeText(Join.this, "데이터 없음...", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("FireBaseData", "loadPost:onCancelled", error.toException());
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

