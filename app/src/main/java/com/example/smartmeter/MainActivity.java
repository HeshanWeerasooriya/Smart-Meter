package com.example.smartmeter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    TextView voltage;
    TextView current;


    String valueVoltage;
    String valueCurrent;

    DatabaseReference dref;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        voltage = (TextView) findViewById(R.id.voltage);
        current = (TextView) findViewById(R.id.current);


        dref = FirebaseDatabase.getInstance().getReference();
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                valueVoltage = dataSnapshot.child("Sensor2/Voltage").getValue().toString();
                voltage.setText("Voltage : "+valueVoltage);

                valueCurrent = dataSnapshot.child("Sensor2/current").getValue().toString();
                current.setText("Current : "+valueCurrent);




            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}