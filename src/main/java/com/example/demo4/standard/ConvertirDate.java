package com.example.demo4.standard;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertirDate {
    public static Date convertirEnDate(String dateStr) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

}
