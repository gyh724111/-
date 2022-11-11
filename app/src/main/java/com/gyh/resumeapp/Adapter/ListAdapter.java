package com.gyh.resumeapp.Adapter;


import com.gyh.resumeapp.AllResumeActivity;
import com.gyh.resumeapp.ListViewCommonAdapter;
import com.gyh.resumeapp.ResumeDetailActivity;
import com.gyh.resumeapp.Utils.Data;
import com.gyh.resumeapp.dto.ResumeListItem;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class ListAdapter extends ListViewCommonAdapter<ResumeListItem> {
    /**
     * 1、继承方法 ListViewCommonAdapter(), 通过该接口指定单个列表项的布局文件名、设置所有列表项数据；
     *
     * @param context
     * @param listIteam_LayoutName 布局文件名
     * @param IteamDatas           所有列表项数据
     */
    public ListAdapter(Context context, String listIteam_LayoutName, ResumeListItem[] IteamDatas) {
        super(context, listIteam_LayoutName, IteamDatas);
    }

    /**
     * 2、setIteamView(TE iteamData)， 设置每个列表项的显示；
     *
     * @param iteamData 将显示的列表项的对应数据
     */
    @Override
    public void setIteamView(ResumeListItem iteamData) {
        // TODO 根据列表项数据iteamData，设置列表项的显示

        TextView name = (TextView) IteamView("all_resume_item_name");
        name.setText(iteamData.name);

        TextView sex = (TextView) IteamView("all_resume_item_sex");
        String sexStr = "未知";
        if(iteamData.sex == 1){
            sexStr = "男";
        }else if (iteamData.sex == 2){
            sexStr = "女";
        }
        sex.setText(sexStr);

        TextView job = (TextView) IteamView("all_resume_item_job");
        job.setText(iteamData.job);

    }


    /**
     * 3、setIteamClick(Context iteamContext, TE iteamData)， 设置每个列表项的点击响应；
     *
     * @param iteamContext 列表项对应的context
     * @param iteamData    待设置点击逻辑的列表项的对应数据
     */
    @Override
    public void setIteamClick(Context iteamContext, ResumeListItem iteamData) {
        // TODO 根据列表项数据iteamData，设置列表项的点击处理逻辑
        // View view = IteamView("name"); //获取列表项中，指定名称的view
        Log.e("ListAdapter","点击列表的id:"+iteamData.id);
        Intent intent = new Intent(iteamContext, ResumeDetailActivity.class);
        intent.putExtra("intent_user_id", iteamData.id);
        iteamContext.startActivity(intent);

    }

}