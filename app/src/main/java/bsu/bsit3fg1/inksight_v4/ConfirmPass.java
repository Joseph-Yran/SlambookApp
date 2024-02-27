package bsu.bsit3fg1.inksight_v4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ConfirmPass extends AppCompatActivity {

    EditText newpass, confpass;
    AppCompatButton resetpassword;
    SQLiteDBHelper myDB;

    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_pass);

        myDB = new SQLiteDBHelper(context);

        newpass = (EditText) findViewById(R.id.newpass_input);
        confpass = (EditText) findViewById(R.id.conf_pass);
        resetpassword = (AppCompatButton) findViewById(R.id.resetpassc);
        Intent intent = getIntent();

        String username = intent.getStringExtra("username");
        String email = intent.getStringExtra("email");

        String newpassword = newpass.getText().toString();
        String confirmpass = confpass.getText().toString();

        resetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(!newpassword.isEmpty()&&!confirmpass.isEmpty()){
                   if(newpassword.equals(confirmpass)){


                   }else{
                       Toast.makeText(ConfirmPass.this, "Passwords does not match", Toast.LENGTH_SHORT).show();
                   }
               }else{
                   Toast.makeText(ConfirmPass.this, "Enter a new password", Toast.LENGTH_SHORT).show();
               }
            }
        });
    }
}