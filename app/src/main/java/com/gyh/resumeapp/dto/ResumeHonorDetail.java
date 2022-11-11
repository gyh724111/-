package com.gyh.resumeapp.dto;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

public class ResumeHonorDetail {
    public int id;

    public int user_id;

    public String honor;


    ResumeHonorDetail() {}


    // 从Json对象创建
    public ResumeHonorDetail(JSONObject obj)
    {
        try
        {
            this.id = Integer.valueOf( obj.optString("id", ""));
            this.user_id = Integer.valueOf( obj.optString("user_id", ""));
            this.honor = obj.optString("honor", "");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    // 从Json数组解析数据
    public static ResumeHonorDetail[] ToArray(JSONArray data)
    {
        ResumeHonorDetail[] Array = new ResumeHonorDetail[data.length()];

        for (int i = 0; i < data.length(); i++)
        {
            try
            {
                JSONObject obj = data.getJSONObject(i);
                Array[i] = new ResumeHonorDetail(obj);
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
