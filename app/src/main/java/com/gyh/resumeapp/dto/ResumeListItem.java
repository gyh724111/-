package com.gyh.resumeapp.dto;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

public class ResumeListItem {
    public int id;

    public String name;

    public int sex;

    public String job;

    ResumeListItem() {}


    // 从Json对象创建
    public ResumeListItem(JSONObject obj)
    {
        try
        {
            this.id = Integer.valueOf( obj.optString("id", ""));
            this.sex = Integer.valueOf( obj.optString("sex", ""));
            this.name = obj.optString("name", "");
            this.job = obj.optString("job", "");

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    // 从Json数组解析数据
    public static ResumeListItem[] ToArray(JSONArray data)
    {
        ResumeListItem[] Array = new ResumeListItem[data.length()];

        for (int i = 0; i < data.length(); i++)
        {
            try
            {
                JSONObject obj = data.getJSONObject(i);
                Array[i] = new ResumeListItem(obj);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
                Log.e("ResumeListItem.java", "ResumeListItem!");
            }
        }
        return Array;
    }
}
