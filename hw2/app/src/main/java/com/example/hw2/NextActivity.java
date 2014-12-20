package com.example.hw2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class NextActivity extends Activity implements OnClickListener {

    TextView topicText;
    String[] currentData;
    String data1[] = {"사과","배","수박","딸기","귤"};
    String data2[] = {"상추","배추","부추","파프리카","당근"};
    String data3[] = {"티모","직스","하이머딩거","트리스타나","베이가"};
    String data4[] = {"박진우","박우진","문일경","홍성필","이재욱"};
    String data5[] = {"ㄱㅇㅈ","ㄱㅅㅈ","ㄱㄷㄱ","ㄱㅌㅇ","ㅇㅅㅈ"};

    Button resultButton;
    Button backButton;
    ListView list;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        Intent intent = getIntent();
        String topic = intent.getStringExtra("topic");

        topicText = (TextView)findViewById(R.id.topicText);
        topicText.setText(topic);

        list = (ListView) findViewById(R.id.listView);
        list.setItemsCanFocus(false);
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        if(topic.equals("과일")) {
            ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice,data1);
            list.setAdapter(adapter);
            currentData = data1;
        }
        if(topic.equals("채소")) {
            ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, data2);
            list.setAdapter(adapter);
            currentData = data2;
        }
        if(topic.equals("롤챔프")) {
            ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, data3);
            list.setAdapter(adapter);
            currentData = data3;
        }
        if(topic.equals("산공")) {
            ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, data4);
            list.setAdapter(adapter);
            currentData = data4;
        }
        if(topic.equals("비롶")) {
            ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, data5);
            list.setAdapter(adapter);
            currentData = data5;
        }
        resultButton = (Button)findViewById(R.id.resultButton);
        resultButton.setOnClickListener(this);
        backButton = (Button)findViewById(R.id.backbutton);
        backButton.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        if(viewId == R.id.resultButton){
            SparseBooleanArray checkedItemPositions = list.getCheckedItemPositions();
            AlertDialog dialog = createDialogBox(checkedItemPositions);
            dialog.show();
        }
        if(viewId == R.id.backbutton) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
    private AlertDialog createDialogBox(SparseBooleanArray checkedItemPositions){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        StringBuilder sb = new StringBuilder();
        sb.append("당신이 좋아하시는 "+topicText.getText()+"은(는) ");
        for (int cnt = 0; cnt < 5; cnt++) {
            if(checkedItemPositions.get(cnt)==true) {
                sb.append(currentData[cnt] + ",");
            }
        }
        sb.append("입니다");
        builder.setTitle("결과");
        builder.setMessage(sb.toString());
        builder.setNeutralButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        AlertDialog dialog = builder.create();
        return dialog;

    }
}