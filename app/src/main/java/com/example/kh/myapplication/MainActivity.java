package com.example.kh.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.kh.myapplication.View.MyFragment;

public class MainActivity extends AppCompatActivity {

    private MyFragment myFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(myFragment==null){
            myFragment = new MyFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.line, myFragment, "MyFragment").commit();
        }else myFragment = (MyFragment) getSupportFragmentManager().findFragmentByTag("MyFragment");
    }
}
