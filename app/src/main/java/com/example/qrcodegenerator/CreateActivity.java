package com.example.qrcodegenerator;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;


public class CreateActivity extends AppCompatActivity {
    private ImageView iv; //QR코드 이미지 저장
    private String enc; //암호화 저장

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create); //여기가 문제? 아닌듯

        Intent createactivity = getIntent(); //데이터 받기
        String nameText = createactivity.getExtras().getString("nameText"); //nameText로 전달된 값 받기 //여기가 문제?
        String phoneText = createactivity.getExtras().getString("phoneText"); //phoneText로 전달된 값 받기
        String enc=CryptoUtil.md5(nameText,phoneText); //해시값으로 잘 나옴 //헷갈렸던 이유는 데이터 입력을 안했기 떄문임

       // 큐알코드 생성 코드

        iv = (ImageView)findViewById(R.id.qrcode);
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try{
            BitMatrix bitMatrix = multiFormatWriter.encode(enc, BarcodeFormat.QR_CODE,200,200);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix); //큐알코드 비트맵으로 생성
            iv.setImageBitmap(bitmap); //이미지에 큐알코드 저장

        }catch(Exception e){}


    }

}
