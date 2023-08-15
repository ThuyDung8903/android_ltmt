package com.example.baidk1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TicketBookedActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Message> messages;
    private MessageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_booked);

        //Event click Home button
        ImageView btnHome = (ImageView) findViewById(R.id.btnHome);
        btnHome.setOnClickListener(v -> {
            Intent intent = new Intent(TicketBookedActivity.this, MainActivity.class);
            TicketBookedActivity.this.startActivity(intent);
        });

        //Event click Booking button
        ImageView btnBooking = (ImageView) findViewById(R.id.btnBooking);
        btnBooking.setOnClickListener(v -> {
            Intent intent = new Intent(TicketBookedActivity.this, BookingActivity.class);
            TicketBookedActivity.this.startActivity(intent);
        });

        listView = (ListView) findViewById(R.id.listView);
        messages = new ArrayList<>();
        adapter = new MessageAdapter(this, messages);
        listView.setAdapter(adapter);

        // Add some sample data
        messages.add(new Message("DSVN12345678", "29/02/2017 ", "18:55:00"));
        messages.add(new Message("DSVN12345678", "29/02/2017 ", "18:55:00"));
        messages.add(new Message("DSVN12345678", "29/02/2017 ", "18:55:00"));
        messages.add(new Message("DSVN12345678", "29/02/2017 ", "18:55:00"));
        messages.add(new Message("DSVN12345678", "29/02/2017 ", "18:55:00"));
        adapter.notifyDataSetChanged();
    }
}