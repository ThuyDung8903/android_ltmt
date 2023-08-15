package com.example.baidk1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Event click Booking button
        ImageView btnBooking = (ImageView) findViewById(R.id.btnBooking);
        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BookingActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        //Event click Tickets booked button
        ImageView btnTicketsBooked = (ImageView) findViewById(R.id.btnService);
        btnTicketsBooked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TicketBookedActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }
}