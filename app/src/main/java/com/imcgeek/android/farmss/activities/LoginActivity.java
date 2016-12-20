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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.imcgeek.android.farmss.R;

public class LoginActivity extends AppCompatActivity {

    EditText etMobile_Login,etpassword_Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etMobile_Login = (EditText)findViewById(R.id.ET_mobileLogin);
        etpassword_Login = (EditText)findViewById(R.id.ET_passwordLogin);

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
            if(ValidateLoginForm()){
//                FindUser();
                Intent i = new Intent(LoginActivity.this,PlotsizeActivity.class);
                startActivity(i);
            }else {
                etMobile_Login.setText("");
                etpassword_Login.setText("");
                //Toast t = Toast.makeText(LoginActivity.this,getString(R.string.EnterMobPass),Toast.LENGTH_SHORT);
                //t.show();
            }

        }
        if (view.getId()==R.id.Btn_Register){
            Intent i = new Intent(LoginActivity.this,RegisterActivity.class);
            startActivity(i);
        }
    }

    private boolean ValidateLoginForm() {
        boolean valid=true;
        if(etMobile_Login.getText().toString().trim().length()<10){
            etMobile_Login.setError(getString(R.string.EnterValidMob));
            valid = false;
        }else{
            etMobile_Login.setError(null);
        }

        if(etpassword_Login.getText().toString().trim().length()==0){
            etpassword_Login.setError(getString(R.string.EnterValidPass));
            valid = false;
        }else{
            etpassword_Login.setError(null);
        }
        return valid;
    }
}
