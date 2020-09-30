package com.example.serverpro;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.content.Intent;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import android.widget.EditText;

//import okhttp3.OkHttpClient;


public class MainActivity extends AppCompatActivity {

    EditText title1, content1, place1;
    TextView tv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();//받는다

        tv=findViewById(R.id.tv);

        //Get 방식
        String serverUrl = "http://15.164.218.79:8080/test_table/testtable_2.jsp";



        //String getUrl = serverUrl + "?title1=" + title1 + "&place1=" + place1 + "&content1=" + content1  ;
        String getUrl = serverUrl;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, getUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //while문으로 line해서 읽어오는 작업과 UI에 업데이트하는 runOnUiThread도 안만들어도 된다.

                String[] arr = response.split("/");


                String arr2 = "";
                for(int i=0;i<arr.length;i++) {
                    arr2 += arr[i];
                }
                tv.setText(arr2);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();

            }
        });
        //서버와 데이터를 주고 받는 요청 객체를
        //서버로 보내줄 우체통 같은 역할의 객체
        //요청큐(RequestQueue)
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //우체통에 요청 편지 넣기
        //요청큐에 요청 객체 추가..
        requestQueue.add(stringRequest);


        //버튼 생성(activity_main)에서 확인 가능
        Button button=findViewById(R.id.btn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인텐트를 통해 main-sub 연결
                Intent intent=new Intent(MainActivity.this,SubActivity.class);


                startActivity(intent);
            }
        });
        ImageView imageView = (ImageView)findViewById(R.id.imageview);


        // drawable에 있는 이미지를 지정합니다.
        imageView.setImageResource(R.drawable.page1); //page1은 그림 이름이야 drawable 안에 넣어줘야 함

        Button bnt_back_main=findViewById(R.id.btn_back_main);
        bnt_back_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인텐트를 통해 main-sub 연결
                Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
        Button bnt_menu_main=findViewById(R.id.btn_menu_main);
        bnt_menu_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인텐트를 통해 main-sub 연결
                Intent intent=new Intent(MainActivity.this,MenuActivity.class);
                startActivity(intent);
            }
        });
        //Toast 메세지 : 서비스 준비 중 (수민 수정 09.12)
        Button button44 = (Button)findViewById(R.id.btntosearch4);
        button44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "서비스 준비 중입니다.", Toast.LENGTH_LONG).show();
            }
        });





    }
}
