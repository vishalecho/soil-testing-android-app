package com.imcgeek.android.farmss.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.imcgeek.android.farmss.R;

import java.util.HashMap;

public class PlotsizeActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    EditText et_plotSize;
    int selected_id;
    HashMap<String,String> convert = new HashMap<String, String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plotsize);
        
        et_plotSize = (EditText)findViewById(R.id.PlotSize);

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
    public void OnButtonClick(View view) {
        if (view.getId() == R.id.GoForSoilTesting) {
            if (Validation()){
                Intent i = new Intent(PlotsizeActivity.this,SoiltestingActivity.class);
                startActivity(i); 
            }
        }
    }

    private boolean Validation() {
        boolean valid=true;
        if(et_plotSize.getText().toString().length()==0){
            et_plotSize.setBackgroundResource(R.drawable.edittextstyle);
            et_plotSize.setError(getString(R.string.EnterValidPlotsize));
            valid = false;
        }else{
            et_plotSize.setError(null);
        }
        return valid;
    }
}
