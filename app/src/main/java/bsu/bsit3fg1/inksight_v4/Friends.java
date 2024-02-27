package bsu.bsit3fg1.inksight_v4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class Friends extends AppCompatActivity implements FriendInterface{
    ImageButton home, settings, friends, addslam, archives;
    ArrayList<friend_data> slamprevdata = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

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
        RecyclerView recyclerView = findViewById(R.id.friendslist);

        //this is the part that pulls data from database, hopefully
        setupSlamprevdata();

        //this adds data from array to adapter class
        friend_adapter adapter = new friend_adapter(this, slamprevdata, this);

        //linearlayout para vertical siya
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        //setting adapter to recycler view.
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


    }
    private void setupSlamprevdata () {
        String[] friendname = getResources().getStringArray(R.array.friend_name);

        for (int i = 0; i < friendname.length; i++) {
            slamprevdata.add(new friend_data(friendname[i]));
        }
    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onEditClick(int position) {
        Intent edit = new Intent(getApplicationContext(), EditSlam.class);
        startActivity(edit);
    }

    @Override
    public void onArchiveClick(int position) {
        Toast.makeText(Friends.this, "User's Slam Archived", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDeleteClick(int position) {
        //slamprevdata.remove(position);
        Toast.makeText(Friends.this, "User Deleted", Toast.LENGTH_SHORT).show();
    }
}