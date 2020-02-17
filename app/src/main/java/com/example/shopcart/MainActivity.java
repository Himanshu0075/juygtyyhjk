package com.example.shopcart;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button login, signup;
    Intent intent;
    Context context=MainActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (Button) findViewById(R.id.Login);
        signup = (Button) findViewById(R.id.Signup);
        login.setOnClickListener(this);
        signup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Login:
                intent=new Intent(context,Login.class);
                context.startActivity(intent);
                break;
            case R.id.Signup:
                intent= new Intent(context,Login.class);
                context.startActivity(intent);
                break;

        }
    }
}
