package com.example.loginwithvalidation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button login;
    TextView attempt;
    int count = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.buttonLogin);
        attempt = findViewById(R.id.attempt);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // convert value into String
                String USERNAME = username.getText().toString();
                String PASSWORD = password.getText().toString();

                if (USERNAME.equals("admin") && PASSWORD.equals("1234")) {

                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);

                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                } else {
                    count--;
                    attempt.setText(String.valueOf(count));
                    Toast.makeText(MainActivity.this, "Wrong user or pass, Attemp Left " + String.valueOf(count),Toast.LENGTH_LONG).show();

                    if(count==0){
                        login.setEnabled(false);
                    }
                }

            }
        });
    }
}
