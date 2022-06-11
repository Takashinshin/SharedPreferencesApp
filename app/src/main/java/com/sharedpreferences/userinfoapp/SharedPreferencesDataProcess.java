package com.sharedpreferences.userinfoapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class SharedPreferencesDataProcess {
    private final String FILENAME = "userInfo";
    private final String DEF_UserName = "taro";
    private final int DEF_UserAge = 20;
    private final float DEF_UserHeight = 175.0F;
    private final String key_name = "userName";
    private final String key_age = "userAge";
    private final String key_height = "useHeight";
    SharedPreferences mPref;
    SharedPreferences.Editor mEditor;


    public SharedPreferencesDataProcess(Context context) {
        mPref = context.getSharedPreferences(FILENAME, Context.MODE_PRIVATE);
        mEditor = mPref.edit();
    }

    //登録
    public void registerPrefData(String userName, int userAge, float userHeight) {
        mEditor.putString(key_name, userName);
        mEditor.putInt(key_age, userAge);
        mEditor.putFloat(key_height, userHeight);
        mEditor.apply();
    }

    //userName読み取り
    public String getUserName() {
        return mPref.getString(key_name, "");
    }

    //userAge読み取り
    public int getUserAge() {
        return mPref.getInt(key_age, 0);
    }

    //userHeight読み取り
    public float getHeight() {
        return mPref.getFloat(key_height, 0F);
    }

    //削除
    public void ClearPrefData() {
        mEditor.clear().apply();
    }
}
