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

    private TextView tv, ck;
    int rnum, ck_main=0;
    private int ck_sub=0;
    private  String str;
    int sub_num=0;
    //하은코드

    //예현코드 : 자리 위치
    private EditText title;
    private EditText place;
    private EditText content;

    private String title1;
    private String place1;
    private String content1;

    private String title1_2;
    private String place1_2;
    private String content1_2;

    private String title1_3;
    private String place1_3;
    private String content1_3;

    String year_1;
    String month_1;
    String day_1;
    String date1;

    String year_2;
    String month_2;
    String day_2;
    String date2;

    String year_3;
    String month_3;
    String day_3;
    String date3;








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

        Button bnt_back_sub=findViewById(R.id.btn_back_sub);
        bnt_back_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인텐트를 통해 main-sub 연결
                Intent intent=new Intent(SubActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

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
        //수민코드(08.31)- 스위치 ~
        Switch sw = (Switch) findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mTxtTime.setText(String.format("하루종일"));
                    mTxtTime1.setText(String.format("하루종일"));

                    // The toggle is enabled
                }
                else
                {
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






        //예현코드
        title = findViewById(R.id.Edit_title);
        place = findViewById(R.id.Edit_place);
        content = findViewById(R.id.Edit_content);

        //예현코드


        Intent intent = getIntent();
        title1_2 = intent.getStringExtra("next_title");
        place1_2 = intent.getStringExtra("next_place");
        content1_2 = intent.getStringExtra("next_content");


        //얘가 왜 디폴트 값을 가져오냐? 이유: 못받아오니까!!!
        Intent tomain = getIntent();
        ck_sub= tomain.getIntExtra("ck_main", 5);



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
                Intent intent1 = getIntent();

                title1 = title.getText().toString();    //문자열 가져오기
                place1 = place.getText().toString();    //문자열 가져오기
                content1 = content.getText().toString();


                title1_2 = intent1.getStringExtra("next_title");
                place1_2 = intent1.getStringExtra("next_place");
                content1_2 = intent1.getStringExtra("next_content");

                title1_3 = intent1.getStringExtra("next_title_2");
                place1_3 = intent1.getStringExtra("next_place_2");
                content1_3 = intent1.getStringExtra("next_content_2");

                if(ck_sub==1)
                {

                    intent.putExtra("title1",title1);//str에있는 값을 가져 가겠다
                    intent.putExtra("place1",place1);//str에있는 값을 가져 가겠다
                    intent.putExtra("content1",content1);//str에있는 값을 가져 가겠다
                    //예현코드
                }
                else if(ck_sub==2)
                {

                    intent.putExtra("title1_2",title1_2);//str에있는 값을 가져 가겠다
                    intent.putExtra("place1_2",place1_2);//str에있는 값을 가져 가겠다
                    intent.putExtra("content1_2",content1_2);//str에있는 값을 가져 가겠다

                    intent.putExtra("title1",title1);//str에있는 값을 가져 가겠다
                    intent.putExtra("place1",place1);//str에있는 값을 가져 가겠다
                    intent.putExtra("content1",content1);//str에있는 값을 가져 가겠다

                }
                else if(ck_sub==3)
                {
                    intent.putExtra("title1_3",title1_3);//str에있는 값을 가져 가겠다
                    intent.putExtra("place1_3",place1_3);//str에있는 값을 가져 가겠다
                    intent.putExtra("content1_3",content1_3);//str에있는 값을 가져 가겠다

                    intent.putExtra("title1_2",title1_2);//str에있는 값을 가져 가겠다
                    intent.putExtra("place1_2",place1_2);//str에있는 값을 가져 가겠다
                    intent.putExtra("content1_2",content1_2);//str에있는 값을 가져 가겠다

                    intent.putExtra("title1",title1);//str에있는 값을 가져 가겠다
                    intent.putExtra("place1",place1);//str에있는 값을 가져 가겠다
                    intent.putExtra("content1",content1);//str에있는 값을 가져 가겠다
                }


                intent.putExtra("ck_sub",ck_sub);


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



