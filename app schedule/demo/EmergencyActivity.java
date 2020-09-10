package com.example.newpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EmergencyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);

        Button bnt_back_emergency=findViewById(R.id.btn_back_emergency);
        bnt_back_emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인텐트를 통해 main-sub 연결
                Intent intent=new Intent(EmergencyActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
        Button bnt_menu_emergency=findViewById(R.id.btn_menu_emergency);
        bnt_menu_emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인텐트를 통해 main-sub 연결
                Intent intent=new Intent(EmergencyActivity.this,MenuActivity.class);
                startActivity(intent);
            }
        });

    }
}