package com.gyh.resumeapp.dto;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

public class ResumeExpDetail {
    public int id;

    public int user_id;

    public String org_name;

    public String exp;

    public int type;

    public String title;

    public String duration;


    ResumeExpDetail() {}


    // 从Json对象创建
    public ResumeExpDetail(JSONObject obj)
    {
        try
        {
            this.id = Integer.valueOf( obj.optString("id", ""));
            this.user_id = Integer.valueOf( obj.optString("user_id", ""));
            this.org_name = obj.optString("org_name", "unknown");
            this.exp = obj.optString("exp", "");
            this.type =  Integer.valueOf( obj.optString("type", ""));
            this.title = obj.optString("title", "");
            this.duration = obj.optString("duration", "");

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    // 从Json数组解析数据
    public static ResumeExpDetail[] ToArray(JSONArray data)
    {
        ResumeExpDetail[] Array = new ResumeExpDetail[data.length()];

        for (int i = 0; i < data.length(); i++)
        {
            try
            {
                JSONObject obj = data.getJSONObject(i);
                Array[i] = new ResumeExpDetail(obj);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
                Log.e("ResumeExpDetail.java", "ResumeExpDetail!");
            }
        }
        return Array;
    }
}
