package com.example.teamproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Writepage extends AppCompatActivity {

    private EditText pname, detail, price, locate;

    /*private CheckBox male, female;*/



    FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.writepage);

        firebaseAuth = FirebaseAuth.getInstance();

        pname =(EditText)findViewById(R.id.editTextTextPersonName);
        detail=(EditText)findViewById(R.id.editTextTextPersonName3);
        price=(EditText)findViewById(R.id.editTextTextPersonName4);
        locate=(EditText)findViewById(R.id.editTextTextPersonName5);
      /*  female = (CheckBox)findViewById(R.id.cb_female);
        male=(CheckBox)findViewById(R.id.cb_male);

        female.setText("female");
        male.setText("male");*/

        //뒤로가기 버튼
        Toolbar tb = (Toolbar) findViewById(R.id.app_toolbar_chat);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.left_arrow);
        tb.setTitleTextColor(Color.BLACK);

        Button button=findViewById(R.id.button_add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String title = pname.getText().toString();
                String detail1 = detail.getText().toString();
                String locate1 = locate.getText().toString();
                String price1 = price.getText().toString();
             /*   String male1 = male.getText().toString();
                String female2 = female.getText().toString();

                if(male1.isChecked() == true){

                }*/

                ProductList item = new ProductList();
                item.setTitle(title);
                item.setDetail(detail1);
                item.setLocate(locate1);
                item.setPrice(price1);

                databaseReference.child("itemlist").push().setValue(item);

                Toast.makeText(Writepage.this, "등록되었습니다.", Toast.LENGTH_SHORT).show();
                Intent it4 = new Intent(getApplicationContext(), Mainpage.class);
                startActivity(it4);
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
