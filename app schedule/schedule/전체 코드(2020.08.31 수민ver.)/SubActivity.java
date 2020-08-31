package com.example.newpro;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.content.Intent;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.app.DatePickerDialog;
import android.widget.Switch;
import android.app.TimePickerDialog;
import java.util.Calendar;
import java.util.GregorianCalendar;
import android.widget.Toast;
import android.widget.CompoundButton;





public class SubActivity extends AppCompatActivity { //이 클래스 이름이 SubActivity

    //하은코드 변수 추가
    private TextView tv;
    int rnum;
    private  String str;
    //하은코드

    //예현코드
    private EditText title;
    private EditText place;
    private EditText content;
    private String title1;
    private String place1;
    private String content1;
    //예현코드

    int Hour=0, Minute=0;
    int year, month, day ;
    int Hour1,Minute1,year1,month1,day1;
    TextView mTxtDate;
    TextView mTxtTime;
    TextView mTxtDate1;
    TextView mTxtTime1;
    Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        //텍스튜뷰 연결
        mTxtDate = (TextView)findViewById(R.id.txtdate);
        mTxtTime = (TextView)findViewById(R.id.txttime);
        mTxtDate1 = (TextView)findViewById(R.id.txtdate1);
        mTxtTime1 = (TextView)findViewById(R.id.txttime1);


        ImageView imageView = (ImageView) findViewById(R.id.imageview);

        // drawable에 있는 이미지를 지정합니다.
        imageView.setImageResource(R.drawable.page2);//page2는 그림 이름

        //aSwitch = (Switch) findViewById(R.id.switch1);


        //수민코드(08.31)- 스위치 ~
        Switch sw = (Switch) findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mTxtTime.setText(String.format("하루종일"));
                    mTxtTime1.setText(String.format("하루종일"));

                    // The toggle is enabled
                }
                else {
                    mTxtTime.setText(String.format(""));
                    mTxtTime1.setText(String.format(""));
                    //Time
                    Button button6 = findViewById(R.id.btn6);
                    button6.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            TimePickerDialog timePickerDialog
                                    = new TimePickerDialog(SubActivity.this,
                                    android.R.style.Theme_Holo_Light_Dialog,new TimePickerDialog.OnTimeSetListener() {
                                @Override
                                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                    String apm = "";
                                    if (hourOfDay < 12){
                                        if(hourOfDay == 0) hourOfDay = 12;
                                        apm = "AM";
                                    }
                                    else {
                                        if (hourOfDay != 12) hourOfDay -=12;
                                        apm = "PM";
                                    }
                                    mTxtTime.setText(String.format("%d:%02d %s", hourOfDay, minute,apm)); //시,분 받아서 보내줌
                                }

                            },Hour, Minute, false);

                            timePickerDialog.show();
                        }
                    });

                    //date
                    GregorianCalendar calendar = new GregorianCalendar();
                    year = calendar.get(Calendar.YEAR);
                    month = calendar.get(Calendar.MONTH);
                    day= calendar.get(Calendar.DAY_OF_MONTH);

                    Button button5 = findViewById(R.id.btn5);
                    button5.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub
                            new DatePickerDialog(SubActivity.this, dateSetListener, year, month, day).show();
                        }
                    });
                    //Time1
                    Button button8 = findViewById(R.id.btn8);
                    button8.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            TimePickerDialog timePickerDialog1
                                    = new TimePickerDialog(SubActivity.this,
                                    android.R.style.Theme_Holo_Light_Dialog,new TimePickerDialog.OnTimeSetListener() {
                                @Override
                                public void onTimeSet(TimePicker view, int hourOfDay1, int minute1) {
                                    String apm1 = "";
                                    if (hourOfDay1 < 12){
                                        if(hourOfDay1 == 0) hourOfDay1 = 12;
                                        apm1 = "AM";
                                    }
                                    else {
                                        if (hourOfDay1 != 12) hourOfDay1 -=12;
                                        apm1 = "PM";
                                    }
                                    mTxtTime1.setText(String.format("%d:%02d %s", hourOfDay1, minute1,apm1)); //시,분 받아서 보내줌
                                }
                                {
                                }
                            },Hour1, Minute1, false);

                            timePickerDialog1.show();
                        }
                    });

                    //date1
                    GregorianCalendar calendar1 = new GregorianCalendar();
                    year1 = calendar1.get(Calendar.YEAR);
                    month1 = calendar1.get(Calendar.MONTH);
                    day1 = calendar1.get(Calendar.DAY_OF_MONTH);

                    Button button7 = findViewById(R.id.btn7);
                    button7.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub
                            new DatePickerDialog(SubActivity.this, dateSetListener1, year1, month1, day1).show();

                        }
                    });

                    // The toggle is disabled
                }
            }
        }); //~수민코드(08.31)-스위치





        /*
        //하은코드 //수민 코드(2020.08.29)-여기 주석처리
        Intent resultintent = getIntent();//받는다
        rnum = resultintent.getIntExtra("rnum",0);

        if(rnum==1)
        {
            str="없음";
        }
        else if(rnum==2)
        {
            str="일정 시작 시간";
        }
        else if(rnum==3)
        {
            str="5분 전";
        }
        else if(rnum==4)
        {
            str="15분 전";
        }
        else if(rnum==5)
        {
            str="30분 전";
        }
        else if(rnum==6)
        {
            str="1시간 전";
        }
        else if(rnum==7)
        {
            str="1일 전";
        }
        else if(rnum==8)
        {
            str="1주 전";
        }
*/
        //tv = findViewById(R.id.tv);//tv_second 아이디 찾기
        //tv.setText(str);//받아 온 데이터 tv_second 에 넣기
        //하은코드

        //예현코드
        title = findViewById(R.id.Edit_title);
        place = findViewById(R.id.Edit_place);
        content = findViewById(R.id.Edit_content);
        //예현코드




        //버튼 설정
        // sub2로 이동
        Button button2 = findViewById(R.id.btn2); //btn2라고 내가 생성한 거(activity_sub2에서 확인 가능)
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubActivity.this, Sub2Activity.class);
                startActivityForResult(intent,0);  //수민 코드(2020.08.29)



                //    finish();//초기 화면으로 이동
            }
        });



        //main으로 이동
        Button button3 = findViewById(R.id.btn4); //btn2라고 내가 생성한 거(activity_sub2에서 확인 가능)
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubActivity.this, MainActivity.class);


                //예현코드
                title1 = title.getText().toString();    //문자열 가져오기
                place1 = place.getText().toString();    //문자열 가져오기
                content1 = content.getText().toString();    //문자열 가져오기

                //       Intent intent = new Intent(SubActivity.this, MainActivity.class);
                intent.putExtra("title1",title1);//str에있는 값을 가져 가겠다
                Intent intent1 = new Intent(SubActivity.this, MainActivity.class);
                intent.putExtra("place1",place1);//str에있는 값을 가져 가겠다
                Intent intent2 = new Intent(SubActivity.this, MainActivity.class);
                intent.putExtra("content1",content1);//str에있는 값을 가져 가겠다
                //예현코드

                startActivity(intent);

                //    finish();//초기 화면으로 이동
            }
        });


    }

    //수민 코드(2020.08.29)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        {
            if (resultCode == 0) {
                int rnum = data.getIntExtra("rnum", 0);

                switch(rnum){
                    case 1:
                        str="없음";
                        tv = findViewById(R.id.tv);//tv_second 아이디 찾기
                        tv.setText(str);
                        break;
                    case 2:
                        str = "일정 시작 시간";
                        tv = findViewById(R.id.tv);//tv_second 아이디 찾기
                        tv.setText(str);
                        break;
                    case 3:
                        str = "5분 전";
                        tv = findViewById(R.id.tv);//tv_second 아이디 찾기
                        tv.setText(str);
                        break;
                    case 4:
                        str = "15분 전";
                        tv = findViewById(R.id.tv);//tv_second 아이디 찾기
                        tv.setText(str);
                        break;
                    case 5:
                        str = "30분 전";
                        tv = findViewById(R.id.tv);//tv_second 아이디 찾기
                        tv.setText(str);
                        break;
                    case 6:
                        str = "1시간 전";
                        tv = findViewById(R.id.tv);//tv_second 아이디 찾기
                        tv.setText(str);
                        break;
                    case 7:
                        str = "1일 전";
                        tv = findViewById(R.id.tv);//tv_second 아이디 찾기
                        tv.setText(str);
                        break;
                    case 8:
                        str = "1주 전";
                        tv = findViewById(R.id.tv);//tv_second 아이디 찾기
                        tv.setText(str);
                        break;

                }
            }
        }
    } // ~ 수민 코드(2020.08.29) ~
    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            String msg = String.format("%d / %d / %d", year,monthOfYear+1, dayOfMonth);
            Toast.makeText(SubActivity.this, msg, Toast.LENGTH_SHORT).show();
            mTxtDate.setText(String.format("%d/%d/%d", year, monthOfYear + 1, dayOfMonth));
        }
    };

    private DatePickerDialog.OnDateSetListener dateSetListener1 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year1, int monthOfYear1,
                              int dayOfMonth1) {
            // TODO Auto-generated method stub
            String msg1 = String.format("%d / %d / %d", year1,monthOfYear1+1, dayOfMonth1);
            Toast.makeText(SubActivity.this, msg1, Toast.LENGTH_SHORT).show();
            mTxtDate1.setText(String.format("%d/%d/%d", year1, monthOfYear1 + 1, dayOfMonth1));
        }
    };

}



