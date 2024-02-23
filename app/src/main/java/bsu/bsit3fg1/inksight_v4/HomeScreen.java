package bsu.bsit3fg1.inksight_v4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class HomeScreen extends AppCompatActivity implements SelectInterface{

    ArrayList<preview_data> slamprevdata = new ArrayList<>();
    ImageButton home, settings, friends, addslam, archives;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        //buttons
        home = (ImageButton) findViewById(R.id.homebttn);
        settings = (ImageButton) findViewById(R.id.settingsbttn);
        friends = (ImageButton) findViewById(R.id.friendsbttn);
        addslam = (ImageButton) findViewById(R.id.addslambttn);
        archives = (ImageButton) findViewById(R.id.archivesbttn);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(getApplicationContext(), HomeScreen.class);
                startActivity(nextScreen);
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(getApplicationContext(), Settings.class);
                startActivity(nextScreen);
            }
        });

        friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(getApplicationContext(), Friends.class);
                startActivity(nextScreen);
            }
        });

        addslam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(getApplicationContext(), CreateSlam.class);
                startActivity(nextScreen);
            }
        });

        archives.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(getApplicationContext(), Archives.class);
                startActivity(nextScreen);
            }
        });

        //recycler view parts

        //the recycler view sa xml.
        RecyclerView recyclerView = findViewById(R.id.previews);

        //this is the part that pulls data from database, hopefully
        setupSlamprevdata();

        //this adds data from array to adapter class
        preview_adapter adapter = new preview_adapter(this, slamprevdata, this);

        //para grid look niya, spancount ay kung ilang columns
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);

        //setting adapter to recycler view.
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


    }
        private void setupSlamprevdata () {
            String[] friendname = getResources().getStringArray(R.array.friend_name);

            for (int i = 0; i < friendname.length; i++) {
                slamprevdata.add(new preview_data(friendname[i]));
            }
        }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getApplicationContext(), PreviewSlam.class);

        //this allows the data to be magically added to the preview slam interface
        //intent.putExtra("Username", preview_data.get(position).getName());

        startActivity(intent);
    }
}