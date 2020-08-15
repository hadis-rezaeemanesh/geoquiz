package com.example.geoquiz.controller;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.geoquiz.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CheatFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CheatFragment extends Fragment {

    private TextView mTextViewAnswer;
    private Button mButtonShowAnswer;
    public static final String EXTRA_IS_CHEAT = "com.example.geoquiz.isCheat";

    private boolean mIsAnswerTrue;

    public CheatFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cheat, container, false);

        findViews(view);
        setListeners();

        return view;
    }

    private void findViews(View view){
        mTextViewAnswer = view.findViewById(R.id.txtview_answer);
        mButtonShowAnswer = view.findViewById(R.id.btn_show_answer);
    }

    private void setListeners(){
        mButtonShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mIsAnswerTrue)
                    mTextViewAnswer.setText(R.string.button_true);
                else
                    mTextViewAnswer.setText(R.string.button_false);

                setShownAnswerResult(true);
            }
        });
    }


    private void setShownAnswerResult(boolean isCheat) {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_IS_CHEAT, isCheat);


    }
}