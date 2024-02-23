package bsu.bsit3fg1.inksight_v4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class Login extends AppCompatActivity {

    private EditText email_input, password_input;
    private Button reset_pass, sign_in_button, sign_up_button;

    private Loginregister_SQLiteDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        dbHelper = new Loginregister_SQLiteDBHelper(this);
        email_input = (EditText) findViewById(R.id.email_input);
        password_input = (EditText) findViewById(R.id.pass_input);
        reset_pass = (Button) findViewById(R.id.resetpass);
        sign_in_button = (AppCompatButton) findViewById(R.id.login);
        sign_up_button = (AppCompatButton) findViewById(R.id.register);

        sign_in_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String email = email_input.getText().toString();
                String password = password_input.getText().toString();
                boolean isAuthenticated = dbHelper.authenticateUser(email, password);
                //to check if there is a email and password inputted.
                if(!email.isEmpty()&&!password.isEmpty()){
                    if(isAuthenticated){
                        // Login successful, show a toast message
                        Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();

                        // Start the AccountActivity
                        Intent nextScreen = new Intent(getApplicationContext(), HomeScreen.class);
                        startActivity(nextScreen);
                    }else{
                        Toast.makeText(Login.this, "User not registered", Toast.LENGTH_SHORT).show();
                    }
                }else {
                        Toast.makeText(Login.this, "Enter Email and Password", Toast.LENGTH_SHORT).show();
                }



            }
        });

        sign_up_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(getApplicationContext(), Register.class);
                startActivity(nextScreen);
            }
        });

        reset_pass.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent nextScreen = new Intent(getApplicationContext(), ResetPass.class);
                startActivity(nextScreen);


            }
        });
    }
}