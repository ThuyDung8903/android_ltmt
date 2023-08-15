package com.example.baidk1;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BookingActivity extends AppCompatActivity {
    private Spinner spinner_departure_station;
    private Spinner spinner_arrival_station;
    private String[] departure_station = {"Hà Nội", "Hải Phòng", "Đà Nẵng", "Nha Trang", "TP Hồ Chí Minh"};
    private String[] arrival_station = {"Hà Nội", "Hải Phòng", "Đà Nẵng", "Nha Trang", "TP Hồ Chí Minh"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        spinner_departure_station = (Spinner) findViewById(R.id.spinner_departure_station);
        ArrayAdapter<String> adapter_departure_station = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, departure_station);
        adapter_departure_station.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_departure_station.setAdapter(adapter_departure_station);

        spinner_arrival_station = (Spinner) findViewById(R.id.spinner_arrival_station);
        ArrayAdapter<String> adapter_arrival_station = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrival_station);
        adapter_arrival_station.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_arrival_station.setAdapter(adapter_arrival_station);

        //Event click Home button
        ImageView btnHome = (ImageView) findViewById(R.id.btnHome);
        btnHome.setOnClickListener(v -> {
            Intent intent = new Intent(BookingActivity.this, MainActivity.class);
            BookingActivity.this.startActivity(intent);
        });

        //Event click Tickets booked button
        ImageView btnTicketsBooked = (ImageView) findViewById(R.id.btnService);
        btnTicketsBooked.setOnClickListener(v -> {
            Intent intent = new Intent(BookingActivity.this, TicketBookedActivity.class);
            BookingActivity.this.startActivity(intent);
        });

        Button btnBookingTicket = (Button) findViewById(R.id.btnBookingTicket);

        btnBookingTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog(Gravity.CENTER);
            }
        });
    }

    public void openDepartureDatePickerDialog(View v) {
        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, day);
                String strDepartureDate = sdf.format(calendar.getTime());
                EditText txtDepartureDate = (EditText) findViewById(R.id.text_departure_date);
                txtDepartureDate.setText(strDepartureDate);
            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, listener, year, month, dayOfMonth);
        datePickerDialog.show();
    }

    public void openReturnPickerDialog(View v) {
        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, day);
                String strReturnDate = sdf.format(calendar.getTime());
                EditText txtReturnDate = (EditText) findViewById(R.id.text_return_date);
                txtReturnDate.setText(strReturnDate);
            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, listener, year, month, dayOfMonth);
        datePickerDialog.show();
    }

    private void openDialog(int gravity) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog);
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }

        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = gravity;
        window.setAttributes(windowAttributes);

        dialog.setCancelable(false);
        Button btnOK = dialog.findViewById(R.id.btnOK);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookingActivity.this, MainActivity.class);
                BookingActivity.this.startActivity(intent);
            }
        });
        dialog.show();
    }
}