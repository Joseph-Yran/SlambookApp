package bsu.bsit3fg1.inksight_v4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.Calendar;

public class CreateSlam extends AppCompatActivity {

    ImageButton home, back, settings;
    EditText namef, nickn, bdayinp, address, socials, fav, hobbies, thoughts, advice;

    AppCompatButton save, discard;

    SQLiteDBHelper myDB;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_slam);

        myDB = new SQLiteDBHelper(context);
        home = (ImageButton) findViewById(R.id.homebttn);
        back = (ImageButton) findViewById(R.id.backbttn);
        settings = (ImageButton) findViewById(R.id.settingsbttn);

        save = (AppCompatButton) findViewById(R.id.savebutton);
        discard = (AppCompatButton) findViewById(R.id.discardbutton);

        bdayinp = findViewById(R.id.bdayfield);
        namef = findViewById(R.id.namefield);
        nickn = findViewById(R.id.nickfield);
        address = findViewById(R.id.addressfield);
        socials = findViewById(R.id.socialsfield);
        fav = findViewById(R.id.favfield);
        hobbies = findViewById(R.id.hobbiesfield);

        thoughts = findViewById(R.id.thoughtsfield);
        advice = findViewById(R.id.advicefield);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(getApplicationContext(), HomeScreen.class);
                startActivity(nextScreen);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(getApplicationContext(), Settings.class);
                startActivity(nextScreen);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //function ni save goes here
            }
        });

        discard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //function ni discard goes here
                //clearAllFields();
            }
        });

        bdayinp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //for bday field
                final Calendar c = Calendar.getInstance();

                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        CreateSlam.this,
                        new DatePickerDialog.OnDateSetListener(){
                            @Override
                            public  void onDateSet(DatePicker view,int year, int monthOfYear, int dayOfMonth){
                                bdayinp.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-"+ year);
                            }
                        },
                        month, day, year);
                datePickerDialog.show();
            }
        });
//here will take input from all the edittexts except the last two and put it on database
    }
}
