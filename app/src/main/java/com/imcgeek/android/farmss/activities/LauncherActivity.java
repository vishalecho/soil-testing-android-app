package com.imcgeek.android.farmss.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.imcgeek.android.farmss.R;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<5;i++){
                    try{
                        Thread.sleep(350);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    if (i==4){
                        Intent intent;
                        LauncherActivity.this.finish();
                        intent = new Intent(LauncherActivity.this.getApplicationContext(),LoginActivity.class);
                        LauncherActivity.this.startActivity(intent);
                    }
                }
            }
        }).start();
    }
}
