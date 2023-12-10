package com.example.binuspark;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class Register extends AppCompatActivity {

    EditText nameTextView, phonenumTextView;
     EditText emailTextView, passwordTextView;
     Button Btn;
     ProgressBar progressbar;
     FirebaseAuth mAuth;

    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // taking FirebaseAuth instance
        mAuth = FirebaseAuth.getInstance();

        // initialising all views through id defined above
        nameTextView = findViewById(R.id.nameET);
        emailTextView = findViewById(R.id.emailET);
        passwordTextView = findViewById(R.id.passwdET);
        phonenumTextView = findViewById(R.id.phonenumET);
        Btn = findViewById(R.id.btnregister);
        progressbar = findViewById(R.id.progressbar);


        dbHandler = new DBHandler(Register.this);

        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerNewUser();
            }



        });
    }
        private void registerNewUser() {

            // show the visibility of progress bar to show loading
            progressbar.setVisibility(View.VISIBLE);

            // Take the value of two edit texts in Strings
            String name, email, password;
            String phonenum;
            name = nameTextView.getText().toString();
            email = emailTextView.getText().toString();
            password = passwordTextView.getText().toString();
            phonenum = phonenumTextView.getText().toString();

            // Validations for input email and password
            if (TextUtils.isEmpty(email)) {
                Toast.makeText(getApplicationContext(),
                                "Please enter email!!",
                                Toast.LENGTH_LONG)
                        .show();
                return;
            }
            if (TextUtils.isEmpty(password)) {
                Toast.makeText(getApplicationContext(),
                                "Please enter password!!",
                                Toast.LENGTH_LONG)
                        .show();
                return;
            }

            dbHandler.addNewUser(name, email, password, Integer.parseInt(phonenum));

            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task)
                        {
                            if (task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), "Registration successful!", Toast.LENGTH_LONG).show();

                                progressbar.setVisibility(View.GONE);

                                Intent intent = new Intent(Register.this, MainActivity.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(getApplicationContext(),"Registration failed!!" + " Please try again later", Toast.LENGTH_LONG).show();

                                progressbar.setVisibility(View.GONE);
                            }
                        }
                    });


        }
}