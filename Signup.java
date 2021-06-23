package com.example.app7311task3;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class Signup extends AppCompatActivity {

    private EditText emailEt, passwordEt1, passwordEt2;
    private Button SignUpButton;
    private TextView SignInTv;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        firebaseAuth = FirebaseAuth.getInstance();
        emailEt = findViewById(R.id.email);
        passwordEt1 = findViewById(R.id.password);
        passwordEt2 = findViewById(R.id.password2);
        SignUpButton = findViewById(R.id.register);
        progressDialog = new ProgressDialog(this);
        SignInTv = findViewById(R.id.singInTv);

        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();
            }
        });
            SignInTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Signup.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            });

    }
    private void Register(){
        String email = emailEt.getText().toString();
        String password = passwordEt1.getText().toString();
        String password2 = passwordEt2.getText().toString();
        if (TextUtils.isEmpty(email))
        {
            emailEt.setError("Email Here!");
            return;
        }
        else if (TextUtils.isEmpty(password))
        {
            passwordEt1.setError("Password Here!");
            return;
        }
        else if (TextUtils.isEmpty(password2))
        {
            passwordEt2.setError("Confirm Password Here!");
            return;
        }
        else if (!password.equals(password2))
        {
            passwordEt2.setError("Password Don't Match!");
            return;
        }
        else if (password.length()<4)
        {
            passwordEt2.setError("Password Too Short!");
            return;
        }
        else if (!isVallidEmail(email))
        {
            emailEt.setError("Invalid Email");
            return;
        }
        progressDialog.setMessage("Please Wait!");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(Signup.this,"Successfully Registered!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Signup.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast.makeText(Signup.this,"Registration Fail!", Toast.LENGTH_LONG).show();
                }
                progressDialog.dismiss();
            }
        });
    }
    private Boolean isVallidEmail(CharSequence target){
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
}
