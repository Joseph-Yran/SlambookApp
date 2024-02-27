package bsu.bsit3fg1.inksight_v4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ResetPass extends AppCompatActivity {

    EditText unname, uemail;
    AppCompatButton proceed;
    private Loginregister_SQLiteDBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pass);

        dbHelper = new Loginregister_SQLiteDBHelper(this);

        unname = (EditText) findViewById(R.id.uname_input);
        uemail = (EditText) findViewById(R.id.email_input);
        proceed = (AppCompatButton) findViewById(R.id.resetpass);

        String uname = unname.getText().toString().trim();
        String email= uemail.getText().toString().trim();

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ConfirmPass.class);
                intent.putExtra("username", uname);
                intent.putExtra("email", email);

            }
        });
    }
}