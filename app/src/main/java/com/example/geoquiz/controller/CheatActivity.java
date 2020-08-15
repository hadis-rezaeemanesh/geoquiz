package com.example.geoquiz.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.geoquiz.R;

public class CheatActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container_cheat);


        if (fragment == null){
            CheatFragment cheatFragment = new CheatFragment();
            fragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_container_cheat, cheatFragment)
                    .commit();
        }





        /*mIsAnswerTrue = getIntent().getBooleanExtra(MainActivity.EXTRA_QUESTION_ANSWER, false);*/



    }


}