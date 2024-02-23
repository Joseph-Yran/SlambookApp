package bsu.bsit3fg1.inksight_v4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    private EditText name_input, email_input, password_input, confirm_pass;
    private Button sign_in_button, sign_up_button;

    private Loginregister_SQLiteDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dbHelper = new Loginregister_SQLiteDBHelper(this);

        name_input = findViewById(R.id.name_input);
        email_input = findViewById(R.id.email_input);
        password_input = findViewById(R.id.pass_input);
        confirm_pass = findViewById(R.id.conf_pass_input);
        sign_in_button = findViewById(R.id.login);
        sign_up_button= findViewById(R.id.register);

        sign_up_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = name_input.getText().toString().trim();
                String email = email_input.getText().toString().trim();
                String password = password_input.getText().toString().trim();
                String rePassword= confirm_pass.getText().toString().trim();

                if (!password.equals(rePassword)) {
                    // Passwords don't match, display an error message
                    Toast.makeText(Register.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                }else if (email.isEmpty()&&username.isEmpty()) {
                    // Username and Email can't be empty.
                    Toast.makeText(Register.this, "Email and Username can not be empty", Toast.LENGTH_SHORT).show();
                }else {
                    // Passwords match, proceed with registration
                    long result = dbHelper.insertUser(email, username, password);
                    if (result != -1) {
                        // Registration successful
                        Toast.makeText(Register.this, "Registration successful for user: " + username, Toast.LENGTH_SHORT).show();

                        // Redirect to login activity
                        Intent intent = new Intent(Register.this, Login.class);
                        startActivity(intent);
                        finish();
                    } else {
                        // Registration failed
                        Toast.makeText(Register.this, "Registration failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        sign_in_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}