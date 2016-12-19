package com.imcgeek.android.farmss.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.imcgeek.android.farmss.R;

public class CropSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_selection);

        /**
         * Setup the ActionBar title with center gravity
         */
        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.activity_crop_selection);
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
        if (view.getId() == R.id.btn_cabbage) {
            Intent i = new Intent(CropSelectionActivity.this,RecommendedFurtilizerActivity.class);
            startActivity(i);
        }
        if (view.getId() == R.id.btn_onion) {
            Intent i = new Intent(CropSelectionActivity.this,RecommendedFurtilizerActivity.class);
            startActivity(i);
        }
        if (view.getId() == R.id.btn_tomato) {
            Intent i = new Intent(CropSelectionActivity.this,RecommendedFurtilizerActivity.class);
            startActivity(i);
        }
        if (view.getId() == R.id.btn_chilli) {
            Intent i = new Intent(CropSelectionActivity.this,RecommendedFurtilizerActivity.class);
            startActivity(i);
        }
        if (view.getId() == R.id.btn_grapes) {
            Intent i = new Intent(CropSelectionActivity.this,RecommendedFurtilizerActivity.class);
            startActivity(i);
        }
        if (view.getId() == R.id.btn_other) {
            Intent i = new Intent(CropSelectionActivity.this,RecommendedFurtilizerActivity.class);
            startActivity(i);
        }
    }
}
