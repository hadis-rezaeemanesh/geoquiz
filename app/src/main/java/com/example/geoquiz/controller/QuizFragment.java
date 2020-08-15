package com.example.geoquiz.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.geoquiz.R;
import com.example.geoquiz.model.Question;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuizFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuizFragment extends Fragment {


    private static final String TAG = "QuizActivity";
    private static final String BUNDLE_KEY_CURRENT_INDEX = "currentIndex";
    public static final String EXTRA_QUESTION_ANSWER = "questionAnswer";
    public static final int REQUEST_CODE_CHEAT = 0;
    public static final int REQUEST_CODE_SETTING =0;

    private Button mButtonTrue;
    private Button mButtonFalse;
    private TextView mTextViewQuestion;
    private ImageButton mButtonNext;
    private ImageButton mButtonPrev;
    private  Button mButtonCheat;
    private Button mButtonSetting;


    private boolean mIsCheater;
    private int mCurrentIndex = 0;
    private Question[] mQuestionBank = {
            new Question(R.string.question_australia, false),
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, true),
            new Question(R.string.question_americas, false),
            new Question(R.string.question_asia, false)
    };

    public QuizFragment() {
        // Required empty public constructor
    }

    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        Log.d(TAG, "onAttach");
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quize, container, false);

        findViews(view);
        setListeners();
        updateQuestion();

        return view;
    }

    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: " + mCurrentIndex);

        outState.putInt(BUNDLE_KEY_CURRENT_INDEX, mCurrentIndex);  // add something in bundle for save
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != Activity.RESULT_OK || data == null)
            return;

        //this means if the result if backed from CheatActivity
        if (requestCode == REQUEST_CODE_CHEAT) {
            mIsCheater = data.getBooleanExtra(CheatFragment.EXTRA_IS_CHEAT, false);
        }
    }

    private void findViews(View view) {
        mTextViewQuestion = view.findViewById(R.id.txtview_question_text);
        mButtonTrue = view.findViewById(R.id.btn_true);
        mButtonFalse = view.findViewById(R.id.btn_false);
        mButtonNext = view.findViewById(R.id.btn_next);
        mButtonPrev = view.findViewById(R.id.btn_prev);
        mButtonCheat = view.findViewById(R.id.btn_cheat);
        mButtonSetting = view.findViewById(R.id.btn_setting);
    }


    private void setListeners() {
        mButtonTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
                mButtonFalse.setEnabled(false);
                mButtonTrue.setEnabled(false);

            }

        });

        mButtonFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
                mButtonFalse.setEnabled(false);
                mButtonTrue.setEnabled(false);
            }

        });

        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();

                mIsCheater = false;

            }

        });

        mButtonPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex = (mCurrentIndex - 1 + mQuestionBank.length) % mQuestionBank.length;
                updateQuestion();
                mButtonFalse.setEnabled(true);
                mButtonTrue.setEnabled(true);

                mIsCheater = false;
            }
        });

        mButtonCheat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CheatActivity.class);
                intent.putExtra(EXTRA_QUESTION_ANSWER, mQuestionBank[mCurrentIndex].isAnswerTrue());

                startActivityForResult(intent, REQUEST_CODE_CHEAT);
            }
        });

        mButtonSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SettingActivity.class);

                startActivityForResult(intent, REQUEST_CODE_SETTING);

            }
        });
    }

    private void updateQuestion() {
        int questionTextResId = mQuestionBank[mCurrentIndex].getQuestionTextResId();
        mTextViewQuestion.setText(questionTextResId);
    }

    private void checkAnswer(boolean userPressed) {
        if (mIsCheater){
            Toast.makeText(getActivity(),R.string.toast_judgment, Toast.LENGTH_LONG).show();
        }
        else {
            if (mQuestionBank[mCurrentIndex].isAnswerTrue() == userPressed) {
                Toast.makeText(getActivity(), R.string.toast_correct, Toast.LENGTH_LONG)
                        .show();

            } else {
                Toast.makeText(getActivity(), R.string.toast_incorrect, Toast.LENGTH_SHORT)
                        .show();
            }
        }
    }

    private void cheat(){
        for (int i = 0; i<= mQuestionBank.length; i++){
            if (mIsCheater){

            }
        }
    }


}