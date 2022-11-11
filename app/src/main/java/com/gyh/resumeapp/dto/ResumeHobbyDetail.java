package com.gyh.resumeapp.dto;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

public class ResumeHobbyDetail {
    public int id;

    public int user_id;

    public String hobby;


    ResumeHobbyDetail() {}


    // 从Json对象创建
    public ResumeHobbyDetail(JSONObject obj)
    {
        try
        {
            this.id = Integer.valueOf( obj.optString("id", ""));
            this.user_id = Integer.valueOf( obj.optString("user_id", ""));
            this.hobby = obj.optString("hobby", "");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    // 从Json数组解析数据
    public static ResumeHobbyDetail[] ToArray(JSONArray data)
    {
        ResumeHobbyDetail[] Array = new ResumeHobbyDetail[data.length()];

        for (int i = 0; i < data.length(); i++)
        {
            try
            {
                JSONObject obj = data.getJSONObject(i);
                Array[i] = new ResumeHobbyDetail(obj);
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
