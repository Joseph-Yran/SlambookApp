package bsu.bsit3fg1.inksight_v4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class EditSlam extends AppCompatActivity {
    ImageButton home, back, settings;
    EditText namef, nickn, bdayinp, address, socials, fav, hobbies, thoughts, advice;

    AppCompatButton save, archive;

    SQLiteDBHelper myDB;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_slam);
        myDB = new SQLiteDBHelper(context);
        home = (ImageButton) findViewById(R.id.homebttn);
        back = (ImageButton) findViewById(R.id.backbttn);
        settings = (ImageButton) findViewById(R.id.settingsbttn);

        save = (AppCompatButton) findViewById(R.id.savebutton);
        archive = (AppCompatButton) findViewById(R.id.archivebutton);

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

        archive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //function ni archive
            }
        });

        //here will pull the data/display the data from database
        //data will be displayed on the edittexts once the database edit is done
    }
}