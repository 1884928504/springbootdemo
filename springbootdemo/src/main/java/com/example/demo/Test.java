package com.example.demo;

import javax.servlet.http.HttpServlet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test extends HttpServlet {

    public static void main(String []args){
        long time=System.currentTimeMillis();
        Date date=new Date(time);
        String mat="yyyy-MM-dd";
        String ma="yyyyMMdd";
        SimpleDateFormat format=new SimpleDateFormat(mat);
        SimpleDateFormat forma=new SimpleDateFormat(ma);
        String nowdate=format.format(date);
        String nwdate=forma.format(date);
        int x=Integer.parseInt(nwdate);
        System.out.println(time);
        System.out.println(nowdate);
        //System.out.println(nwdate);
        //System.out.println(x);
    }

}
