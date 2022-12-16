package com.util;

import com.enums.Origin;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    public static String criptografar(String senha) {
        MessageDigest algorithm = null;
        byte messageDigest[] = null;
        StringBuilder hexString = null;

        try {
            algorithm = MessageDigest.getInstance("SHA-256");
            messageDigest = algorithm.digest(senha.getBytes());
            hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02X", 0xFF & b));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return (String) hexString.toString();
    }

    public static String DateToString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    public static java.sql.Date dateUtiltoDateSql(Date date) {
        return new java.sql.Date(date.getTime());
    }

    public static Date StringToDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Date dateSqltoDateUtil(java.sql.Date birth) {
        return new Date(birth.getTime());
    }

    public static Origin getOrigin(int origin) {
        switch (origin) {
            case 0:
                return Origin.FACEBOOK;
            case 1:
                return Origin.INSTAGRAM;
            case 2:
                return Origin.GOOGLE;
            case 3:
                return Origin.SITE;
            case 4:
                return Origin.OTHER;
            default:
                return null;
        }
    }
}
