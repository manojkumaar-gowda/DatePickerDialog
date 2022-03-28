package com.example.datepickerdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
    //creating a public object for dateOfBirth textView
    public TextView dateOfBirth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //creating button object
        Button pickDate = findViewById(R.id.pickDate);
        dateOfBirth = findViewById(R.id.DateOfBirth);
        //set listener on button click
        pickDate.setOnClickListener(view -> showDatePickerDialog());
    }
    private void showDatePickerDialog(){
        //create a new DatePickerDialog object and set the default selected date to present dat
        DatePickerDialog datePicker = new DatePickerDialog(
          this,
          this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        //display the datePicker
        datePicker.show();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int date){
        //set the date
        String text = "Your Date of Birth is : "+date+"/"+(month+1)+"/"+year;
        dateOfBirth.setText(text);
    }
}