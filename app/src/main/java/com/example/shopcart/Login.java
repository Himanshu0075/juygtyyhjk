package com.example.shopcart;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText ed1;
    EditText ed2;
    TextView tv;
    Button btn;
    Button btn1;
    Intent intent;
    Context context=Login.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ed1 = findViewById(R.id.email);
        ed2 = findViewById(R.id.password);
        tv = findViewById(R.id.tv);
        btn = findViewById(R.id.Login);
        btn1 = findViewById(R.id.Signup);
        btn.setOnClickListener(this);
        btn1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Login:
                createuser();
                break;
            case R.id.Signup:
                login();
                break;

        }
    }

    public void login(){
        String emailstr= ed1.getText().toString();
        String passwordStr=ed1.getText().toString();

        FirebaseAuth Authuser = FirebaseAuth.getInstance();
        Authuser.signInWithEmailAndPassword(emailstr,passwordStr).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Login.this,"Wrong password",Toast.LENGTH_LONG).show();
            }
        });
    }
    public void createuser(){
        String email= ed1.getText().toString();
        final String passwordstr=ed2.getText().toString();

        FirebaseAuth Authuser=FirebaseAuth.getInstance();
        Authuser.createUserWithEmailAndPassword(email,passwordstr).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Toast.makeText(Login.this,"Success",Toast.LENGTH_LONG).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                if(passwordstr!=null){
                    Toast.makeText(Login.this,e.getMessage(),Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(Login.this,e.getMessage(),Toast.LENGTH_LONG).show();

                }
            }
        });

    }

}
