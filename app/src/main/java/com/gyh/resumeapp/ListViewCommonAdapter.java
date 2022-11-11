package com.gyh.resumeapp;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public abstract class ListViewCommonAdapter<TE> extends ArrayAdapter<TE>
{
    LayoutInflater layoutInflater;
    int resourceId;

    Context context;


    public static int getId(Context context, String name, String defType)
    {
        return context.getResources().getIdentifier(name, defType, context.getPackageName());
    }

    public ListViewCommonAdapter(Context context, String listIteam_LayoutName, TE[] IteamDatas)
    {
        super(context, 0, IteamDatas); 				// 调用数组适配器，进行初始化

        this.context = context;

        this.resourceId = getId(context, listIteam_LayoutName, "layout");	// listView项布局资源id
        layoutInflater = LayoutInflater.from(context);  				// 获取LayoutInflater服务
    }

    /** 获取指定postion位置的列表项对应视图，list列表项view生成 */
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // 从预定义的xml布局创建新的view视图
        if (convertView == null) convertView = layoutInflater.inflate(resourceId, null);

        // 修改视图中的信息
        TE iteam = getItem(position);   			// 获取position个位置的列表项数据


        curIteamView = convertView;
        setIteamView(iteam); // 调用虚方法，设置list列表项内容
        curIteamView = null;

        return convertView;   								// 返回按给定数据显示视图
    }

    /** 临时记录当前操作的ListView项 */
    private View curIteamView = null;

    /** 获取list列表项指定id对应的View, 若未指定viewId则获取对应Iteam项对应View */
    public View IteamView(String viewId)
    {
        if (viewId == null || viewId.equals("")) return curIteamView;

        int id = getId(curIteamView.getContext(), viewId, "id"); // 获取ListIteam列表项中指定名称的View的id
        View view = curIteamView.findViewById(id); // 根据id获取对应的View

        return view;
    }

    /** 获取list列表项指定id对应的View, 若未指定viewId则获取对应Iteam项对应View */
    public View IteamView(View iteamView, String viewId)
    {
        int id = getId(iteamView.getContext(), viewId, "id");     // 获取ListIteam列表项中指定名称的View的id
        View view = iteamView.findViewById(id);                              // 根据id获取对应的View

        return view;
    }

    /** 设置list列表项内容。
     *
     *  TE iteamData为：待显示的单个列表项的对应数据
     *  列表项的子控件，通过 IteamView(String viewId)获取指定名称的View;
     *   */
    public abstract void setIteamView(TE iteamData);

    // list的事件响应
    OnItemClickListener listenList = new OnItemClickListener()
    {
        @Override
        public void onItemClick(AdapterView<?> arg0, View iteamView, int postion, long arg3)
        {
            curIteamView = iteamView;
            setIteamClick(context, getItem(postion));
            curIteamView = null;
            Log.e("listviewcommonadapter:", String.valueOf(postion));
        }
    };

    /** 设置list列表项点击响应逻辑。
     *
     * TE iteamData为：待显示的单个列表项的对应数据
     * iteamContext为：单个列表项的Context
     * 列表项的子控件，通过 IteamView(String viewId)获取指定名称的View;
     *  */
    public abstract void setIteamClick(Context iteamContext, TE iteamData);

    // ------------

    /** 生成listView */
    public ListView getListView()
    {
        ListView list = new ListView(context);				// 创建listView
        list.setDivider(new ColorDrawable(Color.GRAY));  	// 设置分割线颜色
        list.setDividerHeight(1);							// 设置分割线尺寸

        list.setAdapter(this);					// 为列表添加显示数据
        list.setOnItemClickListener(this.listenList);
        list.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    //通知父控件不要干扰
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                }
                if(motionEvent.getAction()==MotionEvent.ACTION_MOVE){
                    //通知父控件不要干扰
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                }
                if(motionEvent.getAction()==MotionEvent.ACTION_UP){
                    view.getParent().requestDisallowInterceptTouchEvent(false);
                }
                return false;
            }
        });


        return list;
    }

    /** 生成listView, 并显示在ViewGroup中 */
    public void ShowListViewIn(ViewGroup group)
    {
        ListView list = this.getListView();    // 生成listView
        list.setDividerHeight(1);                // 设置分割线尺寸

        // 在content中显示ListView信息
        group.removeAllViews();
        group.addView(list);// 添加listView为显示内容页

        ListAdapter listAdapter = list.getAdapter();

        int totalHeight = 0;
        for (int i = 0, len = listAdapter.getCount(); i < len; i++) { // listAdapter.getCount()返回数据项的数目
            View listItem = listAdapter.getView(i, null, list);
            listItem.measure(0, 3); // 计算子项View 的宽高
            totalHeight += listItem.getMeasuredHeight(); // 统计所有子项的总高度
        }
        ViewGroup.LayoutParams params = list.getLayoutParams();
        params.height = totalHeight
                + (list.getDividerHeight() * (listAdapter.getCount() - 1));

        list.setLayoutParams(params);

    }
}
