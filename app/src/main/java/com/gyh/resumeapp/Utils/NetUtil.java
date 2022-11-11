package com.gyh.resumeapp.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class NetUtil{

    public static String doGet(){
        BufferedReader reader = null;
        String bookJSONString = null;
        try{
            //1.HttpURLConnection建立连接
            HttpURLConnection httpURLConnection = null;
            String url="http://10.23.180.12:8001/user/listall";
            URL requestUrl = new URL(url);
            httpURLConnection = (HttpURLConnection)requestUrl.openConnection();//打开连接
            httpURLConnection.setRequestMethod("GET");//两种方法GET/POST
            httpURLConnection.setReadTimeout(5000);//设置超时连接时间
            httpURLConnection.connect();

            //2.InputStream获取二进制流
            InputStream inputStream = httpURLConnection.getInputStream();

            //3.InputStreamReader将二进制流进行包装成BufferedReader
            reader = new BufferedReader(new InputStreamReader(inputStream));

            //4.从BufferedReader中读取String字符串,用StringBulider接收
            StringBuilder bulider = new StringBuilder();
            String line;
            while((line=reader.readLine())!=null){
                bulider.append(line);
                bulider.append("\n");
            }

            if(bulider.length()==0)
            {
                return null;
            }

            //5.StringBulider将字符串进行拼接
            bookJSONString = bulider.toString();

        }catch(MalformedURLException e){
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookJSONString;
    }
}
