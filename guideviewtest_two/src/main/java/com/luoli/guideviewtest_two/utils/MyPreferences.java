package com.luoli.guideviewtest_two.utils;

import android.content.Context;

/**
 * Created by LUOLI on 2017/6/27.
 */
public class MyPreferences {
    //偏好文件名
    public static final String SHAREDPREFERENCES_NAME = "my_pref";
    //引导界面KEY
    private static final String KEY_GUIDE_ACTIVITY = "guide_activity";

    /**
     * 判断activity是否引导过
     *
     * @param context
     * @return  是否已经引导过 true引导过了 false未引导
     */
    public static boolean activityIsGuided(Context context, String className){
        if(context==null || className==null||"".equalsIgnoreCase(className))return false;
        String[] classNames = context.getSharedPreferences(SHAREDPREFERENCES_NAME, Context.MODE_WORLD_READABLE)
                .getString(KEY_GUIDE_ACTIVITY, "").split("\\|");//取得所有类名 如 com.my.MainActivity
        for (String string : classNames) {
            if(className.equalsIgnoreCase(string)){
                return true;
            }
        }
        return false;
    }

    /**设置该activity被引导过了。 将类名已  |a|b|c这种形式保存为value，因为偏好中只能保存键值对
     * @param context
     * @param className
     */
    public static void setIsGuided(Context context,String className){
        if(context==null || className==null||"".equalsIgnoreCase(className))return;
        String classNames = context.getSharedPreferences(SHAREDPREFERENCES_NAME, Context.MODE_WORLD_READABLE)
                .getString(KEY_GUIDE_ACTIVITY, "");
        StringBuilder sb = new StringBuilder(classNames).append("|").append(className);//添加值
        context.getSharedPreferences(SHAREDPREFERENCES_NAME, Context.MODE_WORLD_READABLE)//保存修改后的值
                .edit()
                .putString(KEY_GUIDE_ACTIVITY, sb.toString())
                .commit();
    }
}
