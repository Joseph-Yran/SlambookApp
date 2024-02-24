package bsu.bsit3fg1.inksight_v4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Archives_Prev extends AppCompatActivity {

    ImageButton back;
    AppCompatButton unarchive, delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archives_prev);
        back = (ImageButton) findViewById(R.id.backbttn);
        unarchive = (AppCompatButton) findViewById(R.id.unarchivebutton);
        delete = (AppCompatButton) findViewById(R.id.deletebutton);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        unarchive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //function ni unarchive goes here
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //function ni delete archived slam goes here
            }
        });
    }
}