package com.example.newpro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.content.Intent;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;


public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        ImageView imageView = (ImageView)findViewById(R.id.imageview);

        // drawable에 있는 이미지를 지정합니다.
        imageView.setImageResource(R.drawable.home);

        Button button5=findViewById(R.id.btntomain);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인텐트를 통해 main-sub 연결
                Intent intent=new Intent(HomeActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        Button button30=findViewById(R.id.btntomed);
        button30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인텐트를 통해 main-sub 연결
                Intent intent=new Intent(HomeActivity.this,MedActivity.class);
                startActivity(intent);
            }
        });
        Button button31=findViewById(R.id.btntohi);
        button31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인텐트를 통해 main-sub 연결
                Intent intent=new Intent(HomeActivity.this,HiActivity.class);
                startActivity(intent);
            }
        });

        Button clock=findViewById(R.id.btntomypage3);
        clock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인텐트를 통해 main-sub 연결
                Intent intent=new Intent(HomeActivity.this,AlarmActivity.class);
                startActivity(intent);
            }
        });

        Button button32=findViewById(R.id.btntoemergency);
        button32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인텐트를 통해 main-sub 연결
                Intent intent=new Intent(HomeActivity.this,EmergencyActivity.class);
                startActivity(intent);
            }
        });

        //Toast 메세지 : 서비스 준비 중 (수민 수정 09.12)
        Button button40 = (Button)findViewById(R.id.btntosearch);
        button40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "서비스 준비 중입니다.", Toast.LENGTH_LONG).show();
            }
        });
        //Toast 메세지 : 서비스 준비 중 (수민 수정 09.12)
        Button button42 = (Button)findViewById(R.id.btntoout);
        button42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "서비스 준비 중입니다.", Toast.LENGTH_LONG).show();
            }
        });

        //Toast 메세지 : 서비스 준비 중 (수민 수정 09.12)
        Button button47 = (Button)findViewById(R.id.btntomypage2);
        button47.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "서비스 준비 중입니다.", Toast.LENGTH_LONG).show();
            }
        });



    }
}
