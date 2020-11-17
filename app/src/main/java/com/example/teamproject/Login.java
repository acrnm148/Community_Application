package com.example.teamproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Login extends AppCompatActivity {
    EditText loginID, loginPW;
    private FirebaseAuth firebaseAuth;
/*    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        firebaseAuth = FirebaseAuth.getInstance();
        //Login editText
        loginID = (EditText) findViewById(R.id.username);
        loginPW = (EditText) findViewById(R.id.password);

        Button loginB = findViewById(R.id.loginB);
        TextView findIDB = findViewById(R.id.findmyinfo);
        TextView joinFinB = findViewById(R.id.membership);
        Button testWriteB = findViewById(R.id.testButton);

/*        loginB.setOnClickListener(this);
        findIDB.setOnClickListener(this);
        joinFinB.setOnClickListener(this);
        testWriteB.setOnClickListener(this);*/

        loginB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = loginID.getText().toString().trim();
                String pwd = loginPW.getText().toString().trim();

                firebaseAuth.signInWithEmailAndPassword(id, pwd)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Login.this, "로그인 성공", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Login.this, Address.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(Login.this, "로그인 오류", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                switch (v.getId()) {
                    case R.id.findmyinfo://아이디/비밀번호 찾기
                        Intent it2 = new Intent(getApplicationContext(), FindMyInfo.class);
                        startActivity(it2);
                        break;
                    case R.id.membership://회원가입
                        Intent it3 = new Intent(getApplicationContext(), Join.class);
                        startActivity(it3);
                        break;
                    case R.id.testButton://커뮤니티 글쓰기 -> 나중에 지우기(테스트용)
                        Intent it4 = new Intent(getApplicationContext(), CommunityMain.class);
                        startActivity(it4);
                        break;
                    default:
                        break;
                }
            }
        });
    }
}