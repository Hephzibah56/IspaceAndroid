package com.ghecapsi.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class Activity2 : AppCompatActivity() {

    private val TAG = "Activity2"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
    }

    @Override
    override fun onStart() {
        super.onStart();
        Toast.makeText(this, "onStart Activity2", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStart Activity2");
    }

    @Override
    override fun onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart Activity2", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onRestart Activity2");
    }

    @Override
    override fun onResume() {
        super.onResume();
        Toast.makeText(this, "onResume Activity2", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onResume Activity2");
    }

    @Override
    override fun onPause() {
        super.onPause();
        Toast.makeText(this, "onPause Activity2", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onPause Activity2");
    }

    @Override
    override fun onStop() {
        super.onStop();
        Toast.makeText(this, "onStop Activity2", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStop Activity2");
    }

    @Override
    override fun onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy Activity2", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onDestroy Activity2");
    }
}
