package bsu.bsit3fg1.inksight_v4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
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
    EditText bdayinp;

    Button save, discard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_slam);

        home = (ImageButton) findViewById(R.id.homebttn);
        back = (ImageButton) findViewById(R.id.backbttn);
        settings = (ImageButton) findViewById(R.id.settingsbttn);
        bdayinp = findViewById(R.id.bdayfield);

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
    }
}