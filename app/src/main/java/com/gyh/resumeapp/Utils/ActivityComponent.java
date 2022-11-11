package com.gyh.resumeapp.Utils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;


/** Componet.java: 创建Componet后可按控件字符串名称进行检索调用 ----- 2018-6-7 上午11:00:03 scimence */
public abstract class ActivityComponent extends Activity
{
    /** 显示当前页面 */
    public static void Show(Context context, Class<?> cls)
    {
        Intent intent = new Intent(context, cls);        	// 新的支付调用逻辑

        // intent.putExtra("appId", PackageName);
        // intent.putExtra("uid", ClientId);

        context.startActivity(intent);
    }

    /** 根据资源类型、名称，获取资源id */
    public static int getId(Context context, String name, String defType)
    {
        return context.getResources().getIdentifier(name, defType, context.getPackageName());
    }

    /** 根据资源id，获取资源名称 club.scimence.www.app_second:id/thumbsup_tittle_bg */
    public String getResourceName(int resid)
    {
        if (resid == -1) return "";
        return context.getResources().getResourceName(resid);
    }

    /** 获取View对应的id字符串不含包名前缀，如：thumbsup_tittle_bg */
    public String getViewId(View view)
    {
        int resId = view.getId();
        String pageResName = getResourceName(resId);
        // if(pageResName.startsWith("club.scimence")) pageResName = pageResName + "";
        String packagePerfix = context.getPackageName() + ":id/";

        String Id = "";
        if (pageResName.startsWith(packagePerfix)) Id = pageResName.substring(packagePerfix.length());

        return Id;
    }

    /** 根据资源名称，获取Drawable */
    @SuppressWarnings("deprecation")
    public static Drawable getDrawable(Context context, String drawableName)
    {
        int id = getId(context, drawableName, "drawable");
        // Drawable pic = context.getResources().getDrawable(id); 		// 从Resources直接获取图像尺寸会被修改

        InputStream in = context.getResources().openRawResource(id);	// 直接解析未处理过的图像资源保持原有尺寸
        Bitmap bitmap = BitmapFactory.decodeStream(in);
        BitmapDrawable pic = new BitmapDrawable(bitmap);

        return pic;
    }

    Activity context;
    OnClickListener clickListener;

    HashMap<String, View> Views = new HashMap<String, View>();

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        context = this;

        Init(savedInstanceState);
        setClickAble();
    }

    /** 设置页面布局layout文件名称（不含后缀） */
    public void setContentView(String layoutName)
    {
        int layoutId = ActivityComponent.getId(this, layoutName, "layout");     // 获取页面布局id
        setContentView(layoutId);												// 设置布局
    }

    /** 初始化子类界面 */
    public abstract void Init(Bundle savedInstanceState);

    /** 为所有设置android:id="@+id/**"属性的View，添加点击处理逻辑对象 */
    public void setClickAble()
    {
        // 点击响应处理逻辑
        clickListener = new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                // String key = getViewId(v);
                // Click(key);

                // 从已存在的控件中进行检索
                for (String key : Views.keySet())
                {
                    if (Views.get(key) == v)
                    {
                        // if (listener0 != null) listener0.Click(key);
                        Click(key);
                    }
                }
            }
        };

        // 设置可点击的按钮
        List<View> list = Childs(this);
        for (View V : list)
        {
            String key = getViewId(V);  // 获取View的Id名称
            if (!key.equals(""))
            {                           // 设置了android:id属性的View，为其添加点击响应
                if (!Views.containsKey(key)) Views.put(key, V); // 记录View的Id属性
                V.setOnClickListener(clickListener);
            }
        }
    }

    /** 记录Id对应控件 */
    public void AddView(String... Id)
    {
        for (String id : Id)
        {
            if (!id.equals("") && !Views.containsKey(id))
            {
                try
                {
                    View view = context.findViewById(getId(context, id, "id"));
                    Views.put(id, view);

                    view.setOnClickListener(clickListener);
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        }
    }

    /** 获取Id对应控件 */
    public View GetView(String Id)
    {
        if (!Views.containsKey(Id)) AddView(Id);
        return Views.get(Id);
    }

    public TextView TextView(String Id)
    {
        return (TextView) GetView(Id);
    }

    public EditText EditText(String Id)
    {
        return (EditText) GetView(Id);
    }

    public Button Button(String Id)
    {
        return (Button) GetView(Id);
    }

    public RadioButton RadioButton(String Id)
    {
        return (RadioButton) GetView(Id);
    }

    public LinearLayout LinearLayout(String Id)
    {
        return (LinearLayout) GetView(Id);
    }

    public RelativeLayout RelativeLayout(String Id)
    {
        return (RelativeLayout) GetView(Id);
    }

    public ImageView ImageView(String Id)
    {
        return (ImageView) GetView(Id);
    }

    public ToggleButton ToggleButton(String Id)
    {
        return (ToggleButton) GetView(Id);
    }

    // /** View控件点击回调处理逻辑 */
    // public abstract static interface ClickListener
    // {
    // public abstract void Click(String viewId);
    // }
    //
    // public ClickListener listener = new ClickListener()
    // {
    // @Override
    // public void Click(String viewId)
    // {
    // if (viewId.equals("thumbsup_close")) // 关闭界面按钮
    // {
    //
    // }
    // else if (viewId.equals("ltpay_text_unuseable"))
    // {
    //
    // }
    // }
    // };

    /** 子类继承自此实现点击响应 */
    public abstract void Click(String viewId);

    // -----------------

    /** 获取 activity中的所有view */
    public static List<View> Childs(Activity act)
    {
        View activityRoot = act.getWindow().getDecorView();
        List<View> list = Childs(activityRoot, false);

        return list;
    }

    /** 获取当前View的所有子view */
    public static List<View> Childs(View view, boolean ContainsThis)
    {
        List<View> viewList = new ArrayList<View>();

        if (!viewList.contains(view)) viewList.add(view);
        if (view instanceof ViewGroup)
        {
            ViewGroup group = (ViewGroup) view;
            for (int i = 0; i < group.getChildCount(); i++)
            {
                View child = group.getChildAt(i);
                if (!viewList.contains(child)) viewList.add(child);

                // 添加child的子节点
                List<View> subList = Childs(child, true);
                for (View v : subList)
                {
                    if (!viewList.contains(v)) viewList.addAll(subList);
                }
            }
        }

        if (!ContainsThis) viewList.remove(view);

        return viewList;
    }


    // --------------
    // View尺寸自动适配

    // 图像资源应与设计宽高匹配
    public static int SCREEN_DESIGN_WIDTH = 720;	// 设计界面时，界面整体宽度
    public static int SCREEN_DESIGN_HEIGHT = 1280;	// 设计界面时，界面整体高度

    /** 将View以Drawable相对于 DesignW,DesignH的比例显示 */
    public static void AutoSize(View view, Drawable drawable, int DesignW, int DesignH)
    {
        Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();

        AutoSize(view, w, h, DesignW, DesignH);
    }


    /** 将View以 w,h 相对于  DesignW,DesignH的比例显示。
     *
     * 适配原理：1、先计算宽高在设计屏幕中的尺寸比例值；
     * 2、取占比值较大的宽度比例值，或占比值较大的高度比例值，为缩放比例值。
     * 3、按比例值缩放图像尺寸至待适配屏幕的最适尺寸
     *  */
    public static void AutoSize(View view, int w, int h, int DesignW, int DesignH)
    {
        Context context = view.getContext();
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        int screenWidth = dm.widthPixels;
        int screenHeight = dm.heightPixels;

        boolean portrait = (screenHeight > screenWidth);

        // 先计算宽高在设计屏幕中的尺寸比例值；
        float skW = w / (float) (portrait ? DesignW : DesignH);
        float skH = h / (float) (portrait ? DesignH : DesignW);
        // float sk = skW > skH ? skW : skH; // 以宽高较大的比例值进行尺寸适配

        // 生成相对于屏幕的尺寸，以宽高较大比例值充满屏幕
        int width = w, height = h;
        if (skW >= skH)							// 宽度比例值大于高度比例值时，已宽度比例值为基准
        {
            width = (int) (skW * screenWidth);	// 按比例值，缩放至屏幕对应尺寸
            height = (int) (width * h / w);		// 按原图像宽高比例，获取高度尺寸，图像不会拉伸变形
        }
        else									// 高度比例值大于宽度比例值时，已高度比例值为基准
        {
            height = (int) (skH * screenHeight);
            width = (int) (height * w / h);
        }

        // 设置显示尺寸
        ViewGroup.LayoutParams params = view.getLayoutParams();
        // RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(width, height);
        params.width = width;
        params.height = height;
        view.setLayoutParams(params);
    }

    /** 为viewt添加自动适配尺寸的背景图drawableName */
    public static void setAutofitBackground(View view, String drawableName)
    {
        Drawable drawablePic = getDrawable(view.getContext(), drawableName);	// 从context获取drawableName对应的图像
        view.setBackground(drawablePic);										// 为view添加背景图像

        AutoSize(view, drawablePic, SCREEN_DESIGN_WIDTH, SCREEN_DESIGN_HEIGHT);	// 为view自动适配尺寸
    }
    // --------------

}
