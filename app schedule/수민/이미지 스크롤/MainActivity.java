package com.example.scrollexample; //이거는 내가 설정한 파일명이야

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView)findViewById(R.id.imageview);

        // drawable에 있는 이미지를 지정합니다.
        imageView.setImageResource(R.drawable.sch);

    }
}