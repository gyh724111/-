package com.gyh.resumeapp.Adapter;


import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.gyh.resumeapp.ListViewCommonAdapter;
import com.gyh.resumeapp.dto.ResumeExpDetail;
import com.gyh.resumeapp.dto.ResumeListItem;


public class ResumeExpAdapter extends ListViewCommonAdapter<ResumeExpDetail> {
    /**
     * 1、继承方法 ListViewCommonAdapter(), 通过该接口指定单个列表项的布局文件名、设置所有列表项数据；
     *
     * @param context
     * @param listIteam_LayoutName 布局文件名
     * @param IteamDatas           所有列表项数据
     */
    public ResumeExpAdapter(Context context, String listIteam_LayoutName, ResumeExpDetail[] IteamDatas) {
        super(context, listIteam_LayoutName, IteamDatas);
    }

    /**
     * 2、setIteamView(TE iteamData)， 设置每个列表项的显示；
     *
     * @param iteamData 将显示的列表项的对应数据
     */
    @Override
    public void setIteamView(ResumeExpDetail iteamData) {
        // TODO 根据列表项数据iteamData，设置列表项的显示

        TextView tv_org = (TextView) IteamView("resume_exp_org");
        tv_org.setText(iteamData.org_name);

        TextView tv_title = (TextView) IteamView("resume_exp_title");
        tv_title.setText(iteamData.title);

        TextView tv_duration = (TextView) IteamView("resume_exp_duration");
        tv_duration.setText(iteamData.duration);

        TextView tv_exp = (TextView) IteamView("resume_exp_exp");
        tv_exp.setText(iteamData.exp);


    }


    /**
     * 3、setIteamClick(Context iteamContext, TE iteamData)， 设置每个列表项的点击响应；
     *
     * @param iteamContext 列表项对应的context
     * @param iteamData    待设置点击逻辑的列表项的对应数据
     */
    @Override
    public void setIteamClick(Context iteamContext, ResumeExpDetail iteamData) {
        // TODO 根据列表项数据iteamData，设置列表项的点击处理逻辑
        // View view = IteamView("name"); //获取列表项中，指定名称的view
        Log.e("ResumeExpAdapter","点击列表的id:"+iteamData.id);

    }

}