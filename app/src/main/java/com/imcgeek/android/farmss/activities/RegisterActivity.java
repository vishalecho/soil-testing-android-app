package com.imcgeek.android.farmss.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.imcgeek.android.farmss.R;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText name,mobile,password,village,pincode;
    Spinner state,district,tehsil;
    CheckBox checkBoxTermsAndConditions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = (EditText)findViewById(R.id.ET_NameRegister);
        mobile = (EditText)findViewById(R.id.ET_MobileRegister);
        password = (EditText)findViewById(R.id.ET_PasswordRegister);
        pincode = (EditText)findViewById(R.id.ET_Pincode);
        state = (Spinner)findViewById(R.id.SelectState);
        district = (Spinner)findViewById(R.id.SelectDistrict);
        tehsil = (Spinner)findViewById(R.id.SelectTehsil);
//        village = (Spinner)findViewById(R.id.SelectVillage);
        village = (EditText)findViewById(R.id.ET_Village);

        checkBoxTermsAndConditions = (CheckBox)findViewById(R.id.checkbox_Terms);

        district.setOnItemSelectedListener(this);

        /**
         * Setup the ActionBar title with center gravity
         */
        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.activity_register);
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
        if (view.getId() == R.id.Btn_SignUp) {
            if (ValidateRegisterForm()){
                Intent i = new Intent(RegisterActivity.this,PlotsizeActivity.class);
                startActivity(i);
            }
        }
    }

    private boolean ValidateRegisterForm() {
        boolean valid=true;
        if(name.getText().toString().trim().length()==0){
            name.setError(getString(R.string.EnterName));
            valid=false;
        }else{
            Pattern ps= Pattern.compile("^[a-zA-Z ]+$");
            Matcher ms= ps.matcher(name.getText().toString().trim());
            boolean bs =ms.matches();
            if(bs==false){
                name.setError(getString(R.string.Alphabetic_Only));
                valid=false;
            }
            else name.setError(null);
        }

        if(mobile.getText().toString().trim().length()<10){
            mobile.setError(getString(R.string.EnterMobNo));
            valid=false;
        }else{
            mobile.setError(null);
        }

        if (password.getText().toString().trim().length()==0){
            password.setError(getString(R.string.EnterPass));
            valid=false;
        }else {
            password.setError(null);
        }

        if(district.getSelectedItem().toString().trim() == "Select District"){
            Toast.makeText(RegisterActivity.this, getString(R.string.Select_District), Toast.LENGTH_LONG).show();
            valid=false;
        }

        if(tehsil.getSelectedItem().toString().trim() == "Select Tehsil"){
            Toast.makeText(RegisterActivity.this, getString(R.string.Select_Tehsil), Toast.LENGTH_LONG).show();
            valid=false;
        }

        if(village.getText().toString().trim().length()==0){
            village.setError(getString(R.string.EnterVillage));
            valid=false;
        }else{
            village.setError(null);
        }

        if(pincode.getText().toString().trim().length()<6){
            pincode.setError(getString(R.string.Enter_Valid_Pincode));
            valid=false;
        }else{
            pincode.setError(null);
        }

        if(checkBoxTermsAndConditions.isChecked()){
            checkBoxTermsAndConditions.setError(null);
        }else{
            checkBoxTermsAndConditions.setError("Accept Terms & Condition !");
            valid = false;
        }
        return valid;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String Selected_district = String.valueOf(district.getSelectedItem());
        String Selected_Tehsil = String.valueOf(tehsil.getSelectedItem());
//        String Selected_Village = String.valueOf(village.getSelectedItem());

        if(Selected_district.contentEquals("Select District")){
            List<String> list = new ArrayList<String>();
            list.add("Select Tehsil");

            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            tehsil.setAdapter(dataAdapter);

//            List<String> list2 = new ArrayList<String>();
//            list2.add("Select Village");
//
//            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
//                    android.R.layout.simple_spinner_item, list2);
//            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//            dataAdapter2.notifyDataSetChanged();
//            village.setAdapter(dataAdapter2);
        }
        if (Selected_district.contentEquals("Nashik")) {
            List<String> list = new ArrayList<String>();
            list.add("Select Tehsil");
            list.add("Baglan");
            list.add("Chandvad");
            list.add("Deola");
            list.add("Dindori");
            list.add("Igatpuri");
            list.add("Kalwan");
            list.add("Malegaon");
            list.add("Nandgaon");
            list.add("Nashik");
            list.add("Niphad");
            list.add("Peint");
            list.add("Sinnar");
            list.add("Surgana");
            list.add("Trimbakeshwar");
            list.add("Yevla");


            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            tehsil.setAdapter(dataAdapter2);
        }
//        if (Selected_Tehsil.contentEquals("Nashik")){
//            List<String> list2 = new ArrayList<String>();
//            list2.add("Select Village");
//            list2.add("Ambebahula");
//            list2.add("Babhaleshwar");
//            list2.add("Belatgavhan");
//            list2.add("Belgaon Dhaga");
//            list2.add("Bhagur Rural");
//            list2.add("Chandgiri");
//            list2.add("Chandshi");
//            list2.add("Dahegaon");
//            list2.add("Dari");
//            list2.add("Devargaon");
//            list2.add("Dhondegaon");
//            list2.add("Donwade");
//            list2.add("Dudgaon");
//            list2.add("Dugaon");
//            list2.add("Ganeshgaon Naik");
//            list2.add("Ganeshgaon Trimbak");
//            list2.add("Gangamhalungi");
//            list2.add("Gangapadali");
//            list2.add("Gangavhare");
//            list2.add("Gaulane");
//            list2.add("Girnare");
//            list2.add("Govardhan");
//            list2.add("Govindpuri");
//            list2.add("Hinganwedhe");
//            list2.add("Indiranagar");
//            list2.add("Jakhori");
//            list2.add("Jalalpur");
//            list2.add("Jategaon");
//            list2.add("Kalavi");
//            list2.add("Kashyapnagar");
//            list2.add("Kotamgaon");
//            list2.add("Ladachi");
//            list2.add("Lahvit");
//            list2.add("Lakhalgaon");
//            list2.add("Lohashingwe");
//            list2.add("Madsangavi");
//            list2.add("Mahadeopur");
//            list2.add("Mahirawani");
//            list2.add("Manoli");
//            list2.add("Matori");
//            list2.add("Mohagaon");
//            list2.add("Mungsare");
//            list2.add("Nagalwadi");
//            list2.add("Naikwadi");
//            list2.add("Nanegaon");
//            list2.add("Odha");
//            list2.add("Ozarkhede");
//            list2.add("Palashe");
//            list2.add("Pimpalgaon Garudeshwar");
//            list2.add("Pimplad Nasik");
//            list2.add("Pimpri Sayyad");
//            list2.add("Rahuri");
//            list2.add("Raigadnagar");
//            list2.add("Rajewadi");
//            list2.add("Rajur Bahula");
//            list2.add("Sapgaon");
//            list2.add("Sarul");
//            list2.add("Sawargaon");
//            list2.add("Shastrinagar");
//            list2.add("Shevgedarna");
//            list2.add("Shilapur");
//            list2.add("Shinde");
//            list2.add("Shivangaon");
//            list2.add("Subhashnagar");
//            list2.add("Sultanpur");
//            list2.add("Talegaon Anjaneri");
//            list2.add("Tiradshet");
//            list2.add("Vadgaon");
//            list2.add("Vaishnavnagar");
//            list2.add("Vanjarwadi");
//            list2.add("Vinchurgavali");
//            list2.add("Wasali");
//            list2.add("Yashawantnagar");
//
//            ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this,
//                    android.R.layout.simple_spinner_item, list2);
//            dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//            dataAdapter3.notifyDataSetChanged();
//            tehsil.setAdapter(dataAdapter3);
//        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
