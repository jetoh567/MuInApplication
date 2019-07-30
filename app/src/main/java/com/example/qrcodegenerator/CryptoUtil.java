package com.example.qrcodegenerator;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CryptoUtil {
    public static String byteToHexString(byte[] data) {
        StringBuilder sb = new StringBuilder();
        for(byte b : data) {
            sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
    public static String md5(String ...text){ //MD5 암호화 함수
        String msg="";

        try {
            msg = text[0]+text[1]; //이름과 핸드폰 번호 합쳐서 평문 생성
            MessageDigest md = MessageDigest.getInstance("MD5"); //객체 생성
            md.update(msg.getBytes()); //byte값으로 얻어오기
            byte byteDate[] = md.digest();
            msg=CryptoUtil.byteToHexString(byteDate);
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
            msg=null;

        }

        return msg; //암호화한후에 hex값으로 리턴
    } //byte 배열을 HEX 문자열로 반환


}
