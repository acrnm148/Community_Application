package com.example.teamproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class Mainpage extends AppCompatActivity {
    private ListView mListView;
    List fileList = new ArrayList<>();
    ArrayAdapter adapter;
    static boolean calledAlready = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.chatmain);
        setContentView(R.layout.mainpage);

        if(!calledAlready){
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);

            calledAlready = true;
        }

        mListView = (ListView)findViewById(R.id.itemlist);
        adapter = new ArrayAdapter<String>(this, R.layout.mainpage_ct, fileList);
        mListView.setAdapter(adapter);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseRef = database.getReference("itemlist");
        databaseRef.child("item").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot fileSnapshot : snapshot.getChildren()){
                    String str = fileSnapshot.child("").getValue(String.class);
                    Log.i("TAG: value is ", str);
                    fileList.add(str);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("TAG: ", "Failed to read value", error.toException());

            }
        });

        /*mListView = (ListView)findViewById(R.id.listView);

        DatabaseReference peopleRefernece = FirebaseDatabase.getInstance().getReference().child("title");
        mListView.setAdapter(new FirebaseListAdapter<MyItem>(this, MyItem.class, android.R.layout.one_line_list_item, peopleRefernece){
            protected void popoularView(View view, )
        });*/



        /*dataSetting();*/


        Button button=findViewById(R.id.button_writepage);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Mainpage.this, Writepage.class);
                startActivity(intent);
            }
        });
    }
   /* private void dataSetting(){
        MyAdapter mMyAdapter = new MyAdapter();

        for(int i=0;i<10;i++){
            mMyAdapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.apple), "name_" + i, "date_"+i, "contents_"+i);
        }
        mListView.setAdapter(mMyAdapter);
    }*/

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


}
