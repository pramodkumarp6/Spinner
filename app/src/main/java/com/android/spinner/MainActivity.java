package com.android.spinner;


import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Member;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] country = {"Select Country", "India", "USA", "China", "Japan", "Other"};
    private Spinner spin;
    private String actualPositionOfspin;
    Member member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button b1 =(Button)findViewById(R.id.bottom);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();

            }
        });
         spin = (Spinner) findViewById(R.id.countryid);
        spin.setOnItemSelectedListener(this);


        
        
        ArrayAdapter aa = new ArrayAdapter(this,R.layout.spinner_item,country);

        aa.setDropDownViewResource(R.layout.spinner_dropdown_item);
        //spin.getBackground().setColorFilter(Color.parseColor("#dfff"), PorterDuff.Mode.SRC_ATOP);
        spin.setAdapter(aa);
    }

    public void register(){
        String con = spin.getSelectedItem().toString().trim();

        Log.d("spin",con);

    }

    private String getString(String s) {
        return  null;
    }

    boolean validateSpinner(Spinner spinner, String error){

        View selectedView = spinner.getSelectedView();
        if (selectedView != null && selectedView instanceof TextView) {
            TextView selectedTextView = (TextView) selectedView;
            if (selectedTextView.getText().equals("Select Academic Year")) {
                selectedTextView.setError(error);
                Toast.makeText(this, error, Toast.LENGTH_LONG).show();
                return false;
            }
        }
        return true;
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}