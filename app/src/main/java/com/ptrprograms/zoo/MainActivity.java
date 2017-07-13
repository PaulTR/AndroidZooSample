package com.ptrprograms.zoo;

import android.arch.lifecycle.LifecycleActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends LifecycleActivity {

    //TODO Handle navigation here
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
