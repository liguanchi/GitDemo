package com.example.gitdemo;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gitdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_SAVE = "key_save";
    private int number = 0;
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());


        if (savedInstanceState != null) {
            number = savedInstanceState.getInt(KEY_SAVE);
            mBinding.textView.setText(String.valueOf(number));
        }

        mBinding.buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.textView.setText(String.valueOf(++number));
            }
        });

        mBinding.buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.textView.setText(String.valueOf(--number));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.item_zero) {//只有一个，改为if
            number = 0;
            mBinding.textView.setText(String.valueOf(number));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SAVE, number);
    }

}
