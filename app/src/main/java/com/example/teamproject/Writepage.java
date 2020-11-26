package com.example.teamproject;

import android.content.ClipData;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Writepage extends AppCompatActivity {

    private EditText pname, detail, price, locate;
    String ppname, pdetail, pprice, plocate;


    FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

  /* FirebaseDatabase database;
    DatabaseReference databaseReference;*/

    /*FirebaseDatabase database;
    DatabaseReference ref;
    List<ClipData.Item> itemList = new ArrayList<>();
    ListView listView;
    ListAdapter adapter;*/

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.writepage);

        firebaseAuth = FirebaseAuth.getInstance();

        pname =(EditText)findViewById(R.id.editTextTextPersonName);
        detail=(EditText)findViewById(R.id.editTextTextPersonName3);
        price=(EditText)findViewById(R.id.editTextTextPersonName4);
        locate=(EditText)findViewById(R.id.editTextTextPersonName5);





        /*database = FirebaseDatabase.getInstance();
        Log.i("start", "start");*/

        Toolbar tb = (Toolbar) findViewById(R.id.app_toolbar_chat) ;
        setSupportActionBar(tb) ;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //뒤로가기 버튼
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.left_arrow);
        //getSupportActionBar().setDisplayShowTitleEnabled(false); //?
        tb.setTitleTextColor(Color.BLACK);

        Button button=findViewById(R.id.button_add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               /* ppname = pname.getText().toString().trim();
                pdetail = detail.getText().toString().trim();
                pprice = price.getText().toString().trim();
                plocate = locate.getText().toString().trim();*/
                //기존 데이터베이스

                ItemExample itemExample = new ItemExample(pname.getText().toString().trim(), detail.getText().toString().trim(),price.getText().toString().trim(),locate.getText().toString().trim());
                databaseReference.child("itemlist").setValue(itemExample);

                /*databaseReference.child("itemlist").child("item").push().setValue(ppname);
                databaseReference.child("itemlist").child("item").push().setValue(pdetail);
                databaseReference.child("itemlist").child("item").push().setValue(pprice);
                databaseReference.child("itemlist").child("item").push().setValue(plocate);*/
                //기존 데이터베이스
                Toast.makeText(Writepage.this, "등록되었습니다.", Toast.LENGTH_SHORT).show();
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
