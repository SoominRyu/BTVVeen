package com.example.newpro;



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
    private TextView tv1;//일정제목
    private TextView tv2;//장소
    private TextView tv3;//추가 메시지

    private TextView tv1_2;//일정제목
    private TextView tv2_2;//장소
    private TextView tv3_2;//추가 메시지

    private TextView tv1_3;//일정제목
    private TextView tv2_3;//장소
    private TextView tv3_3;//추가 메시지

    private TextView ck;//추가 메시지
    int ck_main=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();//받는다

        tv1=findViewById(R.id.tv1);


        //Get 방식
        String serverUrl = "http://15.164.218.79:8080/test_table/testtable_2.jsp";



        //String getUrl = serverUrl + "?title1=" + title1 + "&place1=" + place1 + "&content1=" + content1  ;
        String getUrl = serverUrl;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, getUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //while문으로 line해서 읽어오는 작업과 UI에 업데이트하는 runOnUiThread도 안만들어도 된다.

                String[] arr = response.split("/");

                int i =0;
                String Array[][] = new String[20][8];

                for(int j=0; j<8; j++)
                    Array[0][j] = "";

                for(i=1; i<= (arr.length)/8;i++){
                    for(int j=0; j<8 ; j++)
                        Array[i][j] = arr[j+(i-1)*8];
                }

                ///////////////////////////////
                if(ck_main==1)
                {

                    tv1 = findViewById(R.id.TextView_title);//tv1(일정제목)
                    tv1.setText(Array[0][3]);//받아 온 데이터 tv1 에 넣기

                    tv2 = findViewById(R.id.TextView_place);//tv2(장소)
                    tv2.setText(Array[0][4]);//받아 온 데이터 tv2 에 넣기

                    tv3 = findViewById(R.id.TextView_content);//tv3(메세지)
                    tv3.setText(Array[0][5]);//받아 온 데이터 tv3 에 넣기




             }
                else if(ck_main==2)
                {
                    tv1 = findViewById(R.id.TextView_title);//tv1(일정제목)
                    tv1.setText(Array[1][3]);//받아 온 데이터 tv1 에 넣기

                    tv2 = findViewById(R.id.TextView_place);//tv2(장소)
                    tv2.setText(Array[1][4]);//받아 온 데이터 tv2 에 넣기

                    tv3 = findViewById(R.id.TextView_content);//tv3(메세지)
                    tv3.setText(Array[1][5]);//받아 온 데이터 tv3 에 넣기

                    tv1_2 = findViewById(R.id.TextView_title2);//tv1(일정제목)
                    tv1_2.setText(Array[2][3]);//받아 온 데이터 tv1 에 넣기

                    tv2_2 = findViewById(R.id.TextView_place2);//tv2(장소)
                    tv2_2.setText(Array[2][4]);//받아 온 데이터 tv2 에 넣기

                    tv3_2 = findViewById(R.id.TextView_content2);//tv3(메세지)
                    tv3_2.setText(Array[2][5]);//받아 온 데이터 tv3 에 넣기
                }
                else if(ck_main==3) {
                    tv1 = findViewById(R.id.TextView_title);//tv1(일정제목)
                    tv1.setText(Array[1][3]);//받아 온 데이터 tv1 에 넣기

                    tv2 = findViewById(R.id.TextView_place);//tv2(장소)
                    tv2.setText(Array[1][4]);//받아 온 데이터 tv2 에 넣기

                    tv3 = findViewById(R.id.TextView_content);//tv3(메세지)
                    tv3.setText(Array[1][5]);//받아 온 데이터 tv3 에 넣기
                    // /*------------------------------------------------------------------------*/
                    tv1_2 = findViewById(R.id.TextView_title2);//tv1(일정제목)
                    tv1_2.setText(Array[2][3]);//받아 온 데이터 tv1 에 넣기

                    tv2_2 = findViewById(R.id.TextView_place2);//tv2(장소)
                    tv2_2.setText(Array[2][4]);//받아 온 데이터 tv2 에 넣기

                    tv3_2 = findViewById(R.id.TextView_content2);//tv3(메세지)
                    tv3_2.setText(Array[2][5]);//받아 온 데이터 tv3 에 넣기
                    /*------------------------------------------------------------------------*/
                    tv1_3 = findViewById(R.id.TextView_title3);//tv1(일정제목)
                    tv1_3.setText(Array[3][3]);//받아 온 데이터 tv1 에 넣기

                    tv2_3 = findViewById(R.id.TextView_place3);//tv2(장소)
                    tv2_3.setText(Array[3][4]);//받아 온 데이터 tv2 에 넣기

                    tv3_3 = findViewById(R.id.TextView_content3);//tv3(메세지)
                    tv3_3.setText(Array[3][5]);//받아 온 데이터 tv3 에 넣기

                }








                ///////////////////////////////////////

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
