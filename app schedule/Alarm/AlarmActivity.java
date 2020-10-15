package com.example.newpro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class AlarmActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        findViewById(R.id.btn1).setOnClickListener(this);
            }

            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn1:
                        new AlertDialog.Builder(this)
                                .setTitle("오늘의 알림")
                                .setMessage("오늘의 알림은 반복알림으로 사용자님께서 .\n\n TEST!!")
                                .setNeutralButton("닫기", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dlg, int sumthin) {
                                    }
                                })
                                .show(); // 팝업창 보여줌
                        break;
                }
            }
}