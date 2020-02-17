package com.example.shopcart;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class Form extends AppCompatActivity implements View.OnClickListener {

    EditText _productName, _sistolic, _diastolic, _pulse,_price, _tags;
    Button _submit, _showLogs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        _productName = findViewById(R.id.BSLEt);
        _sistolic = findViewById(R.id.systolicEt);
        _diastolic = findViewById(R.id.diastolicEt);
        _pulse = findViewById(R.id.pulseEt);
        _price = findViewById(R.id.AddPrice);
        _tags = findViewById(R.id.AddTags);

        _submit = findViewById(R.id.submit);
        _showLogs = findViewById(R.id.showLogs);

        _submit.setOnClickListener(this);
        _showLogs.setOnClickListener(this);

    }

    @Override
    public <retrieve> void onClick(View v) {
        switch (v.getId()) {
            case R.id.submit: {
                sendData();
 /*_bsl.setText("");
 _sistolic.setText("");
 _diastolic.setText("");
 _pulse.setText("");
 _medicine.setText("");
 _tags.setText("");*/
                break;
            }


            }
        }
    }
    public void sendData() {

        FirebaseFirestore db = FirebaseFirestore.getInstance();


        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        final String productName = _productName.getText().toString();
        String Price = _price.getText().toString();
        String Tags = _tags.getText().toString();
        String Sistolic = _sistolic.getText().toString();
        String Diastolic = _diastolic.getText().toString();
        String Pulse = _pulse.getText().toString();


        HashMap<String, String> inputs = new HashMap<String, String>();


        inputs.put("Product Name", productName);

        inputs.put("Price", Price);

        inputs.put("Added Tags", Tags);

        inputs.put("Sistolic", Sistolic);
        inputs.put("Diastolic", Diastolic);
        inputs.put("Pulse", Pulse);

        db.collection(date).add(inputs).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(Form.this, "Sucess", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Toast.makeText(Form.this, "Failed", Toast.LENGTH_SHORT).show();

            }
        });
    }
}