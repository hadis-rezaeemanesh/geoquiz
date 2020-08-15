package com.example.geoquiz.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.example.geoquiz.R;

public class SettingActivity extends AppCompatActivity {

    private RadioButton mSmallSize;
    private RadioButton mMediumSize;
    private RadioButton mLargeSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }

    private void findViews(){
        mSmallSize = findViewById(R.id.radio_btn_small);
        mMediumSize = findViewById(R.id.radio_btn_medium);
        mLargeSize = findViewById(R.id.radio_btn_large);
    }

    private void setListeners(){
        mSmallSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mMediumSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mLargeSize .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}