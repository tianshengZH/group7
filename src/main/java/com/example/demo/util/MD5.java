package com.example.demo.util;
import java.security.*;
public class MD5 {
    public static String MD5encoder(String passwords){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(passwords.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }

            // 输出MD5哈希值
            //System.out.println("MD5 Hash: " + sb.toString());
            return sb.toString();
        }catch(NoSuchAlgorithmException e){
            return "ERROR:"+e.toString();
        }
    };
}
