package com.example.test_page;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private Button btn_first;//선언
    private TextView tv_second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();//받는다
        String str = intent.getStringExtra("str");//String 데이타 받기

        tv_second = findViewById(R.id.tv_second);//tv_second 아이디 찾기
        tv_second.setText(str);//받아 온 데이터 tv_second 에 넣기

        btn_first = findViewById(R.id.btn_first);//btn_first 아이디을 찾아라
        btn_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //버튼 클릭시 SecondActivity 에서 MainActivity 로 이동 경로
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);// 이동
            }
        });
    }
}