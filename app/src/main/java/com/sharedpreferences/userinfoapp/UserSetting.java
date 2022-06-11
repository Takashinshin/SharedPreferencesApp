package com.sharedpreferences.userinfoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserSetting extends AppCompatActivity {
    private final String TAG = "UserSetting";
    private EditText mEditName;
    private EditText mEditAge;
    private EditText mEditHeight;
    private Button mClearBtn;
    private Button mEditBtn;
    private Context mContext;
    SharedPreferencesDataProcess mSharedPrefData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_setting);

        getViews();
        mContext = getApplicationContext();
        mSharedPrefData = new SharedPreferencesDataProcess(mContext);
        setEditHint();

        mEditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String inputUserName = mEditName.getText().toString();
                    int inputUserAeg = Integer.parseInt(mEditAge.getText().toString());
                    float inputUserHeight = Float.parseFloat(mEditHeight.getText().toString());
                    mSharedPrefData.registerPrefData(inputUserName, inputUserAeg, inputUserHeight);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                //MainActivityへ
                finish();
            }
        });

        //ClearButton押下
        mClearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSharedPrefData.ClearPrefData();
            }
        });
    }

    private void setEditHint() {
        mEditName.setText(mSharedPrefData.getUserName());
        mEditAge.setText(String.valueOf(mSharedPrefData.getUserAge()));
        mEditHeight.setText(String.valueOf(mSharedPrefData.getHeight()));
    }

    //Viewを取得するMethod
    private void getViews() {
        mEditName = findViewById(R.id.editUserName);
        mEditAge = findViewById(R.id.editUserAge);
        mEditHeight = findViewById(R.id.editUserHeight);
        mClearBtn = findViewById(R.id.clearBtn);
        mEditBtn = findViewById(R.id.editBtn);
    }
}