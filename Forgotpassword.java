package com.example.app7311task3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Forgotpassword extends AppCompatActivity {

    private EditText emailEditText;
    private Button resetPasswordButton;
    private ProgressBar progressBar;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);

        emailEditText = findViewById(R.id.editTextEmail);
        resetPasswordButton = findViewById(R.id.resetPassword);
        progressBar = findViewById(R.id.progressBar);

        auth = FirebaseAuth.getInstance();

        resetPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetPassword();

            }
        });
    }
       private void resetPassword()
       {
           String email = emailEditText.getText().toString().trim();
           if(email.isEmpty())
           {
               emailEditText.setError("Email is required!");
               emailEditText.requestFocus();
               return;
           }
           if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
           {
               emailEditText.setError("Please provide valid email");
               emailEditText.requestFocus();
               return;
           }
           progressBar.setVisibility(View.VISIBLE);
           auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
               @Override
               public void onComplete(@NonNull Task<Void> task) {
                   if (task.isSuccessful())
                   {
                       Toast.makeText(Forgotpassword.this,"Check email to reset password!",Toast.LENGTH_LONG).show();
                   }
                   else
                       {
                           Toast.makeText(Forgotpassword.this,"Lets try again something wrong happened!",Toast.LENGTH_LONG).show();
                       }
               }
           });
       }
}