package com.example.qrcodegenerator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InsertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        final EditText nameText = (EditText) findViewById(R.id.nameText); //입력값을 불러와서 nameText 변수에 저장
        final EditText phoneText = (EditText) findViewById(R.id.phoneText); //핸드폰 입력 값을 불러와서 phoneText 변수에 저장

        Button okButton = (Button)findViewById(R.id.okButton); //확인 버튼 저장

        okButton.setOnClickListener(new View.OnClickListener() { //확인버튼 이벤트 처리
            @Override
            public void onClick(View v) {
                Intent createIntent = new Intent(InsertActivity.this,CreateActivity.class);//쉼표조심

               // 데이터 전달
                createIntent.putExtra("nameText",nameText.getText().toString());
                createIntent.putExtra("phoneText",phoneText.getText().toString());
                startActivity(createIntent); //액티비티 화면 전환 및 시작 함수


            }
        });
    }
}
