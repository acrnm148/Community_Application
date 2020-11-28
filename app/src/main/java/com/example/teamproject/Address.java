package com.example.teamproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

public class Address extends AppCompatActivity {
    EditText edit;
    TextView text;

    //listview - add
    ListView listview ;
    Address_ListViewAdapter adapter;
    String zipNo_;
    String rnAdres_;
    String lnAdres_;

    XmlPullParser xpp;

    //도로명주소 우편번호 조회서비스 일반 인증키
    //자신의 서비스키
    String key="owGlKRH%2BurSUIAKgmagxf1UdbeXzHed3aORvozUAydm6cl%2BTwHq1aKDsvMd0Er5VURSuU%2ByuryVphWC9vhbQDg%3D%3D";

    String data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.address);

        edit= (EditText)findViewById(R.id.edit);
        text= (TextView)findViewById(R.id.result);

        //listview - add
        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.lv_address);
        listview.setAdapter(adapter);

        //뒤로가기 버튼
        Toolbar tb = (Toolbar) findViewById(R.id.app_toolbar_chat) ;
        setSupportActionBar(tb) ;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.left_arrow);
        tb.setTitleTextColor(Color.BLACK);

        //메인페이지로 이동
        Button logo = (Button) findViewById(R.id.joinFin);
        logo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int id = v.getId();
                Intent it = new Intent(getApplicationContext(), Mainpage.class);
                startActivity(it);
            }
        });

        //listview - add
        //리스트뷰 클릭
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                // get item
                Address_ListViewItem item = (Address_ListViewItem) parent.getItemAtPosition(position) ;

                String zipNo = item.getzipNo() ;
                String rnAdres = item.getrnAdres() ;
                String lnAdres = item.getlnAdres() ;
                String info = "저장되었습니다 : "+ zipNo +" & "+ rnAdres +" & "+ lnAdres;

                Toast.makeText(getApplicationContext(), info, Toast.LENGTH_LONG).show();
            }
        }) ;
    }
    public void mOnClick(View a){

        //listview - add
        // Adapter 생성
        adapter = new Address_ListViewAdapter() ;
        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.lv_address);
        listview.setAdapter(adapter);


        switch( a.getId() ){
            case R.id.button:

                //Android 4.0 이상 부터는 네트워크를 이용할 때 반드시 Thread 사용해야 함
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        try {
                            data= getXmlData();//아래 메소드를 호출하여 XML data를 파싱해서 String 객체로 얻어오기
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }

                        //UI Thread(Main Thread)를 제외한 어떤 Thread도 화면을 변경할 수 없기때문에
                        //runOnUiThread()를 이용하여 UI Thread가 TextView 글씨 변경하도록 함
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                text.setText(data); //TextView에 문자열  data 출력
                            }
                        });
                    }
                }).start();
                break;
        }
    }//mOnClick method..


    //XmlPullParser를 이용하여 Naver 에서 제공하는 OpenAPI XML 파일 파싱하기(parsing)
    private String getXmlData() throws UnsupportedEncodingException {

        StringBuffer buffer=new StringBuffer();

        String str= edit.getText().toString();//EditText에 작성된 Text얻어오기
        String location = URLEncoder.encode(str,"UTF-8");//한글의 경우 인식이 안되기에 utf-8 방식으로 encoding..

        //String queryUrl="http://openapi.epost.go.kr/postal/retrieveNewAdressAreaCdService/retrieveNewAdressAreaCdService/getNewAddressListAreaCd?ServiceKey=cQUBpAa38YT1HC3BX0G9HeM0GhdmzVb3xEW9vTTRytKWEeMJXbGZCdUsQElWj8IxaOOYSEAVWTwbh%2B%2BUoxL%2FZg%3D%3D&searchSe=road&srchwrd=%EB%8C%80%ED%8F%AC%EA%B8%B874";
        String queryUrl="http://openapi.epost.go.kr/postal/retrieveNewAdressAreaCdService/retrieveNewAdressAreaCdService/getNewAddressListAreaCd"  //요청 URL
                + "?searchSe=road"
                + "&srchwrd=" + location
                + "&ServiceKey=" + key;

        Log.d("token", queryUrl);

        try {
            URL url= new URL(queryUrl);//문자열로 된 요청 url을 URL 객체로 생성.
            InputStream is= url.openStream(); //url위치로 입력스트림 연결

            XmlPullParserFactory factory= XmlPullParserFactory.newInstance();
            XmlPullParser xpp= factory.newPullParser();
            xpp.setInput( new InputStreamReader(is, "UTF-8") ); //inputstream 으로부터 xml 입력받기

            String tag;

            xpp.next();
            int eventType= xpp.getEventType();

            while( eventType != XmlPullParser.END_DOCUMENT ){
                switch( eventType ){
                    case XmlPullParser.START_DOCUMENT:
                        buffer.append("파싱 시작...\n\n");
                        break;

                    case XmlPullParser.START_TAG:
                        tag= xpp.getName();//테그 이름 얻어오기

                        if(tag.equals("newAddressListAreaCd")) ;// 첫번째 검색결과
                        else if(tag.equals("zipNo")){
                            buffer.append("우편번호 : ");
                            xpp.next();
                            buffer.append(xpp.getText());//title 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            zipNo_ = xpp.getText();  //listview - add
                            buffer.append("\n"); //줄바꿈 문자 추가
                        }
                        else if(tag.equals("rnAdres")){
                            buffer.append("도로명주소 : ");
                            xpp.next();
                            buffer.append(xpp.getText());//category 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            rnAdres_ = xpp.getText();  //listview - add
                            buffer.append("\n");//줄바꿈 문자 추가
                        }
                        else if(tag.equals("lnmAdres")){
                            buffer.append("지번주소 :");
                            xpp.next();
                            buffer.append(xpp.getText());//description 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            lnAdres_ = xpp.getText();  //listview - add
                            buffer.append("\n");//줄바꿈 문자 추가
                        }
                        break;

                    case XmlPullParser.TEXT:
                        break;

                    case XmlPullParser.END_TAG:
                        tag= xpp.getName(); //테그 이름 얻어오기

                        if(tag.equals("newAddressListAreaCd")) {

                            //listview - add
                            buffer.append("test: "+zipNo_+" & "+rnAdres_+" & "+lnAdres_+"\n\n");// 첫번째 검색결과종료..줄바꿈
                            adapter.addItem(zipNo_, rnAdres_, lnAdres_); //adapter에게 값 전달
                            //adapter.notifyDataSetChanged();
                        }
                        break;
                }
                eventType= xpp.next();
            }

        } catch (Exception e) {
            // TODO Auto-generated catch blocke.printStackTrace();
        }

        //buffer.append("파싱 끝\n");
        return buffer.toString();//StringBuffer 문자열 객체 반환

    }//getXmlData method....

//MainActivity class..

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
