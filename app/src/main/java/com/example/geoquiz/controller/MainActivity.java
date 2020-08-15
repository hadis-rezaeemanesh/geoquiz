package com.example.geoquiz.controller;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.geoquiz.R;
import com.example.geoquiz.model.Question;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();

        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);


        if (fragment == null){
            QuizFragment quizFragment = new QuizFragment();
            fragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_container, quizFragment)
                    .commit();
        }


        /*Log.d(TAG, "onCreate: " + mCurrentIndex);



        if (savedInstanceState != null){
            Log.d(TAG, "saveInstanceState: " + savedInstanceState);

            mCurrentIndex = savedInstanceState.getInt(BUNDLE_KEY_CURRENT_INDEX, 0);
        }*/


    }
/*

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "OnStart" + mCurrentIndex);
    }


    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, "onPaused");
    }
    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG, "onStopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "onDestroy");
    }
*/





}