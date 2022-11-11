package com.gyh.resumeapp.dto;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

public class ResumeCertDetail {
    public int id;

    public int user_id;

    public String cert;


    ResumeCertDetail() {}


    // 从Json对象创建
    public ResumeCertDetail(JSONObject obj)
    {
        try
        {
            this.id = Integer.valueOf( obj.optString("id", ""));
            this.user_id = Integer.valueOf( obj.optString("user_id", ""));
            this.cert = obj.optString("cert_name", "");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    // 从Json数组解析数据
    public static ResumeCertDetail[] ToArray(JSONArray data)
    {
        ResumeCertDetail[] Array = new ResumeCertDetail[data.length()];

        for (int i = 0; i < data.length(); i++)
        {
            try
            {
                JSONObject obj = data.getJSONObject(i);
                Array[i] = new ResumeCertDetail(obj);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
                Log.e("ResumeHobbyDetail.java", "ResumeHobbyDetail!");
            }
        }
        return Array;
    }
}
