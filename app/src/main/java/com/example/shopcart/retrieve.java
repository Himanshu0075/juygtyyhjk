package com.example.shopcart;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

class Retrieve extends AppCompatActivity {

    private static final String TAG = "";
    TextView t1;
    private static ArrayList<Type> mArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);
        t1 = findViewById(R.id.Display);
        getData();
    }
    public void getData() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        final String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        db.collection(date).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        String BSL = document.getString("Blood Sugar Level");
                        String Medication = document.getString("Medication");
                        String Tags = document.getString("Tags");
                        String Bp1 = document.getString("Sistolic");
                        String Bp2 = document.getString("Diastolic");
                        String Bp3 = document.getString("Pulse");
                        //t1.setText(document.getData().toString());

                        t1.setText("Product name".toUpperCase() + ":" + BSL + "\n" +
                                "Price Added".toUpperCase() + ":" + Medication + "\n" +
                                "Tags".toUpperCase() + ":" + Tags + "\n" +
                                "Availble in stock".toUpperCase() + ":" + Bp1 + "\n" +
                                "Items left".toUpperCase() + ":" + Bp2 + "\n" +
                                "Delivery charges".toUpperCase() + ":" + Bp3 + "\n");
                    }

                } else {
                    Toast.makeText(Retrieve.this, "failed", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Retrieve.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
