package com.example.pagethree;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageView;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        ImageView imageView = (ImageView)findViewById(R.id.imageview);
        // drawable에 있는 이미지를 지정합니다.
        imageView.setImageResource(R.drawable.page2);
        Button button2=findViewById(R.id.btn2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SubActivity.this,Sub3Activity.class);
                startActivity(intent);

            }
        });
    }
}