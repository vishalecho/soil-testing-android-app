package com.imcgeek.android.farmss.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.imcgeek.android.farmss.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /**
         * Setup the ActionBar title with center gravity
         */
        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.activity_login);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        TextView tv = new TextView(getApplicationContext());
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                ActionBar.LayoutParams.FILL_PARENT, // Width of TextView
                ActionBar.LayoutParams.FILL_PARENT); // Height of TextView
        // Apply the layout parameters to TextView widget
        tv.setLayoutParams(lp);
        // Set text to display in TextView
        tv.setText(ab.getTitle());
        tv.setTextSize(20);
        tv.setTextColor(getResources().getColor(R.color.btnTextColor));
        // Set TextView text alignment to center
        tv.setGravity(Gravity.CENTER);// Set the ActionBar display option
        ab.setDisplayOptions(ab.DISPLAY_SHOW_CUSTOM);
        // Finally, set the newly created TextView as ActionBar custom view
        ab.setCustomView(tv);
    }

    public void OnButtonClick(View view){
        if (view.getId()==R.id.Btn_Login){
//            if(Validate()){
//                FindUser();
//            }else {
//                editTextMobile.setText("");
//                editTextPassword.setText("");
//                //Toast t = Toast.makeText(LoginActivity.this,getString(R.string.EnterMobPass),Toast.LENGTH_SHORT);
//                //t.show();
//            }
            Intent i = new Intent(LoginActivity.this,PlotsizeActivity.class);
            startActivity(i);
        }
        if (view.getId()==R.id.Btn_Register){
            Intent i = new Intent(LoginActivity.this,RegisterActivity.class);
            startActivity(i);
        }
    }
}
