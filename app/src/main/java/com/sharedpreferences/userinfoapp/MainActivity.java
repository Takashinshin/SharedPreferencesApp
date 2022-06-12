package com.sharedpreferences.userinfoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    private final String DEF_UserName = "taro";
    private final int DEF_UserAge = 20;
    private final float DEF_UserHeight = 175.0F;
    private final String key_name = "userName";
    private final String key_age = "userAge";
    private final String key_height = "useHeight";
    private Button mSettingBtn;
    private TextView mUserName;
    private TextView mUserAge;
    private TextView mUserHeight;
    SharedPreferencesDataProcess mSharedPref;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate start test");

        getViews();
        mContext = getApplicationContext();
        //一度もデーターが保存されてない場合、ディフォルト値を保存する
        if (mSharedPref == null) {
            mSharedPref = new SharedPreferencesDataProcess(mContext);
            mSharedPref.registerPrefData(DEF_UserName, DEF_UserAge, DEF_UserHeight);
        }

        //取得したデータ表示
        setPrefData(mSharedPref);

        //settingButton押下
        mSettingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, UserSetting.class);
                startActivity(intent);
            }
        });
        Log.d(TAG, "onCreate end");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
        setPrefData(mSharedPref);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    //sharedPreferencesで格納されたデーターを表示するMethod
    private void setPrefData(SharedPreferencesDataProcess prefData) {
        mUserName.setText(prefData.getUserName());
        mUserAge.setText(String.valueOf(prefData.getUserAge()));
        mUserHeight.setText(String.valueOf(prefData.getHeight()));
    }

    //Viewを取得するMethod
    private void getViews() {
        Log.d(TAG, "getViews Start");
        mSettingBtn = findViewById(R.id.btnSetting);
        mUserName = findViewById(R.id.userName);
        mUserAge = findViewById(R.id.userAge);
        mUserHeight = findViewById(R.id.userHeight);
    }
}