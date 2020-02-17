package com.example.shopcart;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

class Log extends AppCompatActivity implements View.OnClickListener {

    TextView tv;
    Button Take_Picture;
    Button Fill_Details;
    Context context = Log.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        tv = findViewById(R.id.tv);
        Take_Picture = findViewById(R.id.Take_Picture);
        Fill_Details = findViewById(R.id.Fill_Detalis);
        Take_Picture.setOnClickListener(this);
        Fill_Details.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent;
        switch (v.getId()) {
            case R.id.Fill_Detalis:
                intent = new Intent(context, Form.class);
                context.startActivity(intent);
                break;

            case R.id.Take_Picture:
                intent = new Intent(context, Picture.class);
                context.startActivity(intent);
                break;


        }
    }
}
