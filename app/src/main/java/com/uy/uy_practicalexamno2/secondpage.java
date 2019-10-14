package com.uy.uy_practicalexamno2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class secondpage extends AppCompatActivity {

    TextView messageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondpage);
    }

    public void sendData(View v)
    {
        Toast.makeText(this, "Request Sent", Toast.LENGTH_LONG).show();
    }

    public void showData(View v)
    {
        String message = getIntent().getStringExtra("message_key");
        messageTextView = findViewById(R.id.showComment);
        messageTextView.setText(message);
    }

    public void subjectsData(View v)
    {

    }

    public void previous(View v)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
