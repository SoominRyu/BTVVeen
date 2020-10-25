package com.example.newpro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.content.Intent;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.CompoundButton;

import org.w3c.dom.Text;

public class MedActivity extends AppCompatActivity  {
    private TextView tv;
    TextView medTxtDate;
    TextView medTxtTime;
    TextView medTxtAlaram;
    int Hour=0, Minute=0;
    int year, month, day ;
    Spinner spinner;
    String str6;
    private TextView med_date;
    private TextView med_time;
    private TextView med_content;
    private EditText med_content1;
    private TextView med_alarm;

    private String date = null;
    private String time = null;
    private String alarm = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med);

        medTxtDate = (TextView)findViewById(R.id.medtxtdate);
        medTxtTime = (TextView)findViewById(R.id.medtxttime);
        medTxtAlaram = (TextView)findViewById(R.id.medtxtalaram);

        med_date = (TextView)findViewById(R.id.med_Date1);
        med_time = (TextView)findViewById(R.id.med_Time1);

        med_content = (TextView)findViewById(R.id.med_Content1);
        med_content1 = (EditText)findViewById(R.id.Edit_medmsg);
        med_alarm = (TextView)findViewById(R.id.med_Alarm1);


        ImageView imageView = (ImageView)findViewById(R.id.imageview);
        // drawable에 있는 이미지를 지정합니다.
        imageView.setImageResource(R.drawable.pagemed);
        medTxtTime.setText(String.format(""));

        //spinner1
        spinner = findViewById(R.id.spinner6);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.numbers6, android.R.layout.simple_spinner_item); //item 배열로 가져옴 --> 배열로 선택한 값을 알아야해
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter); //어뎁터 수상해
        //spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        //Time
        Button button35 = findViewById(R.id.btn35);
        button35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog
                        = new TimePickerDialog(MedActivity.this,
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
                        time = String.format("%d:%02d %s", hourOfDay, minute,apm);
                        medTxtTime.setText(String.format("%d:%02d %s", hourOfDay, minute,apm)); //시,분 받아서 보내줌
                    }

                },Hour, Minute, false);

                timePickerDialog.show();



            }
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();

                //spinner 값을 str로 받아옴
                str6 = (String) spinner.getSelectedItem();
                // tv.setText(str6);
                //String str7 = str6;
                medTxtAlaram.setText(str6);
                alarm =(String) spinner.getSelectedItem().toString();

            }


        });

        //date
        GregorianCalendar calendar = new GregorianCalendar();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day= calendar.get(Calendar.DAY_OF_MONTH);

        Button button36 = findViewById(R.id.btn36);
        button36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(MedActivity.this, dateSetListener, year, month, day).show();
            }


        });

        Button bnt_back_med=findViewById(R.id.btn_back_med);
        bnt_back_med.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인텐트를 통해 main-sub 연결
                Intent intent=new Intent(MedActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
        Button bnt_menu_med=findViewById(R.id.btn_menu_med);
        bnt_menu_med.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인텐트를 통해 main-sub 연결
                Intent intent=new Intent(MedActivity.this,MenuActivity.class);
                startActivity(intent);
            }
        });

        Button bnt_ok=findViewById(R.id.btn_medok);
        bnt_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                med_date.setText(date);
                med_time.setText(time);
                med_content.setText(med_content1.getText());
                med_alarm.setText("반복일: "+(String) spinner.getSelectedItem().toString());
               // med_alarm.setText("반복: "+alarm);
                med_content1.setText(null);
                medTxtTime.setText(null);
                medTxtDate.setText(null);
                spinner.setSelection(0);

            }
        });





    }
    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            String msg = String.format("%d / %d / %d", year,monthOfYear+1, dayOfMonth);
            Toast.makeText(MedActivity.this, msg, Toast.LENGTH_SHORT).show();
            date = String.format("%d/%d/%d", year, monthOfYear + 1, dayOfMonth);
            medTxtDate.setText(String.format("%d/%d/%d", year, monthOfYear + 1, dayOfMonth));
        }
    };






}
