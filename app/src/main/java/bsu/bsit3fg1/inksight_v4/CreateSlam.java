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
    EditText bdayinp;

    AppCompatButton save, discard;

    EditText namef, nickn, birthdate, igh, fbh, twh, oth, food, bev, ani, song, artist, celebrity, activity, game, show;

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
        birthdate = findViewById(R.id.bdayfield);
        igh = findViewById(R.id.ighandlefield);
        fbh = findViewById(R.id.FBhandlefield);
        twh = findViewById(R.id.Xhandlefield);
        oth =  findViewById(R.id.Otherhandlefield);
        food = findViewById(R.id.foodfield);
        bev = findViewById(R.id.beveragefield);
        ani = findViewById(R.id.animalfield);
        song = findViewById(R.id.Songfield);
        artist = findViewById(R.id.Artistfield);
        celebrity = findViewById(R.id.Celebfield);
        activity = findViewById(R.id.Activityfield);
        game = findViewById(R.id.Gamefield);
        show = findViewById(R.id.Showsfield);


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

    }

    //private void clearAllFields() {
        //edtID.setText("");
        //edtName.setText("");
        //edtUname.setText("");
        //edtPassword.setText("");
        //edtBirthday.setText("");
        //edtAddress.setText("");
    //}
}
