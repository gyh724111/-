package com.gyh.resumeapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;


//import org.json.JSONArray;
import org.json.JSONArray;


import android.widget.LinearLayout;

import com.gyh.resumeapp.Adapter.ListAdapter;
import com.gyh.resumeapp.Utils.ActivityComponent;
import com.gyh.resumeapp.Utils.Data;
import com.gyh.resumeapp.Utils.ThreadUtil;
import com.gyh.resumeapp.Utils.WebUtil;
import com.gyh.resumeapp.dto.ResumeListItem;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class AllResumeActivity extends ActivityComponent {

    @Override
    public void Init(Bundle savedInstanceState) {
        // 设置Activity页面布局
        setContentView("activity_all_resume");
        final Data app = (Data)getApplication();
        final String hostPort = "http://" + app.getIpPortData();
        Toast.makeText(this, "获取ip:port为"+hostPort, Toast.LENGTH_SHORT).show();

        ThreadUtil.getMainHandler().postDelayed(new Runnable() {
            @Override
            public void run() {

                String dataUrl = hostPort + "/user/listall";
                System.out.println("dataUrl:"+dataUrl);

                JSONArray webData = WebUtil.GetJSONArray(dataUrl);

                if (webData != null) {

                    {
                        JSONArray data = webData;

                        ResumeListItem[] datas = ResumeListItem.ToArray(data);
                        ListAdapter adapter = new ListAdapter(AllResumeActivity.this, "all_resume_item", datas/* , call */);

                        LinearLayout content = LinearLayout("all_resume_content");
                        adapter.ShowListViewIn(content);
                    }
                }
            }
        }, 1000);
    }


    /* 设置View点击响应事件 */
    @Override
    public void Click(String viewId) {
        String text = "点击了View -> " + viewId;
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();

        // TODO View点击响应逻辑


    }


}
