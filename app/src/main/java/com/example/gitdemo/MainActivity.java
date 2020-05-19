package com.example.gitdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button mButtonAdd;
    private Button mButtonSub;
    private TextView mTextView;
    private static final String KEY_SAVE = "key_save";
    private int number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButtonAdd = findViewById(R.id.button_add);
        mButtonSub = findViewById(R.id.button_sub);
        mTextView = findViewById(R.id.text_view);

        if (savedInstanceState !=null){
            number = savedInstanceState.getInt(KEY_SAVE);
            mTextView.setText(String.valueOf(number));
        }

        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText(String.valueOf(++number));
            }
        });

        mButtonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText(String.valueOf(--number));
            }
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SAVE,number);
    }

}
