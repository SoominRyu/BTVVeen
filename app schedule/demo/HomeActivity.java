package com.example.newpro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.content.Intent;

import android.view.View;
import android.widget.Button;
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

        Button button32=findViewById(R.id.btntoemergency);
        button32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인텐트를 통해 main-sub 연결
                Intent intent=new Intent(HomeActivity.this,EmergencyActivity.class);
                startActivity(intent);
            }
        });
    }
}
