package com.example.hw2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{
    String temp = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioButton rb1 = (RadioButton)findViewById(R.id.radioButton);
        RadioButton rb2 = (RadioButton)findViewById(R.id.radioButton2);
        RadioButton rb3 = (RadioButton)findViewById(R.id.radioButton3);
        RadioButton rb4 = (RadioButton)findViewById(R.id.radioButton4);
        RadioButton rb5 = (RadioButton)findViewById(R.id.radioButton5);
        Button btn = (Button)findViewById(R.id.button);

        rb1.setOnClickListener(this);
        rb2.setOnClickListener(this);
        rb3.setOnClickListener(this);
        rb4.setOnClickListener(this);
        rb5.setOnClickListener(this);
        btn.setOnClickListener(this);
    }

    public void onClick(View view){
        int viewId = view.getId();
        if(viewId == R.id.radioButton){
            temp = "과일";
        }
        if(viewId == R.id.radioButton2){
            temp = "채소";
        }
        if(viewId == R.id.radioButton3){
            temp = "롤챔프";
        }
        if(viewId == R.id.radioButton4){
            temp = "산공";
        }
        if(viewId == R.id.radioButton5){
            temp = "비롶";
        }
        if(viewId == R.id.button){
            if(!temp.equals("")){
                Intent intent = new Intent(this, NextActivity.class);
                intent.putExtra("topic",temp);
                startActivity(intent);
                finish();
            }
            else{
                Toast.makeText(this, "최소한 하나는 선택하세요", Toast.LENGTH_SHORT).show();
            }
        }
    }

}