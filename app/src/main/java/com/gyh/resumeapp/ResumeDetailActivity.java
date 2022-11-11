package com.gyh.resumeapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


//import org.json.JSONArray;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.widget.LinearLayout;

import com.gyh.resumeapp.Adapter.ResumeCertAdapter;
import com.gyh.resumeapp.Adapter.ResumeExpAdapter;
import com.gyh.resumeapp.Adapter.ResumeHobbyAdapter;
import com.gyh.resumeapp.Adapter.ResumeHonorAdapter;
import com.gyh.resumeapp.Utils.ActivityComponent;
import com.gyh.resumeapp.Utils.Data;
import com.gyh.resumeapp.Utils.ThreadUtil;
import com.gyh.resumeapp.Utils.WebUtil;
import com.gyh.resumeapp.dto.ResumeCertDetail;
import com.gyh.resumeapp.dto.ResumeExpDetail;
import com.gyh.resumeapp.dto.ResumeHobbyDetail;
import com.gyh.resumeapp.dto.ResumeHonorDetail;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class ResumeDetailActivity extends ActivityComponent {

    TextView tv_name;
    TextView tv_sex;
    TextView tv_job;
    TextView tv_desc;




    @Override
    public void Init(Bundle savedInstanceState) {
        Intent intent = getIntent();
        final Integer userId = intent.getIntExtra("intent_user_id",-1);
        // 设置Activity页面布局
        setContentView("activity_resume_detail");
        Data app = (Data) getApplication();
        final String hostPort = "http://" + app.getIpPortData();

        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_sex = (TextView) findViewById(R.id.tv_sex);
        tv_job = (TextView) findViewById(R.id.tv_job);
        tv_desc = (TextView) findViewById(R.id.tv_desc);

        ThreadUtil.getMainHandler().postDelayed(new Runnable() {
            @Override
            public void run() {

//                String hostPort = "http://10.23.180.18:8001";
//                String hostPort = "http://192.168.1.4:8001";
//                String hostPort = "http://192.168.31.10:8001";
//                String userUrl = hostPort + "/user/getuser/" + userId;
//                String descUrl = hostPort + "/user/getdesc/" + userId;
//                String workExpUrl = hostPort + "/user/getexp/0/" + userId;
//                String projectExpUrl = hostPort + "/user/getexp/1/" + userId;
//                String practiceExpUrl = hostPort + "/user/getexp/2/" + userId;
//                String studyExpUrl = hostPort + "/user/getexp/3/" + userId;
//                String honorUrl = hostPort + "/user/gethonor/" + userId;
//                String hobbyUrl = hostPort + "/user/gethobby/" + userId;
//                String certUrl = hostPort + "/user/getcert/" + userId;
//
                String userDetailUrl = hostPort + "/user/getuserdetail/" + userId;

//                JSONObject userData = WebUtil.GetJSONObject(userUrl);
//                JSONObject descData = WebUtil.GetJSONObject(descUrl);
//                JSONArray workExpData = WebUtil.GetJSONArray(workExpUrl);
//                JSONArray projectExpData = WebUtil.GetJSONArray(projectExpUrl);
//                JSONArray practiceExpData= WebUtil.GetJSONArray(practiceExpUrl);
//                JSONArray studyExpData = WebUtil.GetJSONArray(studyExpUrl);
//                JSONArray honorData = WebUtil.GetJSONArray(honorUrl);
//                JSONArray hobbyData = WebUtil.GetJSONArray(hobbyUrl);
//                JSONArray certData = WebUtil.GetJSONArray(certUrl);

                JSONObject userDetailData = WebUtil.GetJSONObject(userDetailUrl);

                JSONObject userData = null;
                JSONObject descData = null;
                JSONArray workExpData = null;
                JSONArray projectExpData = null;
                JSONArray practiceExpData = null;
                JSONArray studyExpData = null;
                JSONArray honorData = null;
                JSONArray hobbyData = null;
                JSONArray certData = null;
                try {
                    userData = userDetailData.getJSONObject("user");
                    descData = userDetailData.getJSONObject("desc");
                    workExpData = userDetailData.getJSONArray("workExp");
                    projectExpData = userDetailData.getJSONArray("projectExp");
                    studyExpData = userDetailData.getJSONArray("studyExp");
                    practiceExpData = userDetailData.getJSONArray("practiceExp");
                    honorData = userDetailData.getJSONArray("honor");
                    hobbyData = userDetailData.getJSONArray("hobby");
                    certData = userDetailData.getJSONArray("cert");
                } catch (JSONException e) {
                    e.printStackTrace();
                }


                if (userData != null) {
                    try {
                        String userName = userData.getString("name");
                        String userSex = "未知";
                        String userJob = userData.getString("job");
                        switch (userData.getInt("sex")) {
                            case 1:
                                userSex = "男";
                                tv_sex.setTextColor(Color.parseColor("#33b5e5"));
                                break;
                            case 2:
                                userSex = "女";
                                tv_sex.setTextColor(Color.parseColor("#c13533"));
                                break;
                        }
                        tv_name.setText(userName);
                        tv_sex.setText(userSex);
                        tv_job.setText(userJob);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                if (descData != null) {
                    try {
                        String userDesc = descData.getString("desc_detail");
                        tv_desc.setText(userDesc);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                if (workExpData != null) {

                    {
                        ResumeExpDetail[] workExpAdapterDatas = ResumeExpDetail.ToArray(workExpData);
                        ResumeExpAdapter adapter = new ResumeExpAdapter(ResumeDetailActivity.this, "resume_exp_item", workExpAdapterDatas/* , call */);

                        LinearLayout content = LinearLayout("work_exp_content");
                        adapter.ShowListViewIn(content);
                    }
                }

                if (projectExpData != null) {

                    {
                        ResumeExpDetail[] projectExpAdapterDatas = ResumeExpDetail.ToArray(projectExpData);
                        ResumeExpAdapter adapter = new ResumeExpAdapter(ResumeDetailActivity.this, "resume_exp_item", projectExpAdapterDatas/* , call */);

                        LinearLayout content = LinearLayout("project_exp_content");
                        adapter.ShowListViewIn(content);

                    }
                }

                if (practiceExpData != null) {

                    {
                        ResumeExpDetail[] practiceExpAdapterDatas = ResumeExpDetail.ToArray(practiceExpData);
                        ResumeExpAdapter adapter = new ResumeExpAdapter(ResumeDetailActivity.this, "resume_exp_item", practiceExpAdapterDatas/* , call */);

                        LinearLayout content = LinearLayout("practice_exp_content");
                        adapter.ShowListViewIn(content);
                    }
                }

                if (studyExpData != null) {

                    {
                        ResumeExpDetail[] studyExpAdapterDatas = ResumeExpDetail.ToArray(studyExpData);
                        ResumeExpAdapter adapter = new ResumeExpAdapter(ResumeDetailActivity.this, "resume_exp_item", studyExpAdapterDatas/* , call */);

                        LinearLayout content = LinearLayout("study_exp_content");
                        adapter.ShowListViewIn(content);
                    }
                }
                if (hobbyData != null) {

                    {
                        JSONArray data = hobbyData;

                        ResumeHobbyDetail[] datas = ResumeHobbyDetail.ToArray(data);
                        ResumeHobbyAdapter adapter = new ResumeHobbyAdapter(ResumeDetailActivity.this, "resume_hobby_item", datas/* , call */);

                        LinearLayout content = LinearLayout("hobby_content");
                        adapter.ShowListViewIn(content);
                    }
                }

                if (honorData != null) {

                    {
                        JSONArray data = honorData;

                        ResumeHonorDetail[] datas = ResumeHonorDetail.ToArray(data);
                        ResumeHonorAdapter adapter = new ResumeHonorAdapter(ResumeDetailActivity.this, "resume_honor_item", datas/* , call */);

                        LinearLayout content = LinearLayout("honor_content");
                        adapter.ShowListViewIn(content);
                    }
                }
                if (certData != null) {

                    {
                        JSONArray data = certData;

                        ResumeCertDetail[] datas = ResumeCertDetail.ToArray(data);
                        ResumeCertAdapter adapter = new ResumeCertAdapter(ResumeDetailActivity.this, "resume_cert_item", datas/* , call */);

                        LinearLayout content = LinearLayout("cert_content");
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
