package com.uy.uy_practicalexamno2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText input;
    EditText messageEditText;
    Button changePage;
    CheckBox course1, course2, course3, course4, course5, course6, course7, course8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        course1 = findViewById(R.id.checkbox);
        course2 = findViewById(R.id.checkBox9);
        course3 = findViewById(R.id.checkBox10);
        course4 = findViewById(R.id.checkBox11);
        course5 = findViewById(R.id.checkBox12);
        course6 = findViewById(R.id.checkBox13);
        course7 = findViewById(R.id.checkBox14);
        course8 = findViewById(R.id.checkBox15);
        messageEditText = findViewById(R.id.etMessage);
        changePage = findViewById(R.id.button2);
        input = findViewById(R.id.etMessage);
        changePage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, secondpage.class);
                String message = messageEditText.getText().toString();
                intent.putExtra("message_key",message);
                startActivity(intent);
            }
        });
    }

    public void writeData(View v)
    {
        String c1 = course1.getText().toString();
        String c2 = course2.getText().toString();
        String c3 = course3.getText().toString();
        String c4 = course4.getText().toString();
        String c5 = course5.getText().toString();
        String c6 = course6.getText().toString();
        String c7 = course7.getText().toString();
        String c8 = course8.getText().toString();
        String data = input.getText().toString();
        FileOutputStream writer = null;
        try
        {
            writer = openFileOutput("data1.txt", MODE_PRIVATE);
            writer.write(data.getBytes());
            writer.write(c1.getBytes());
            writer.write(c2.getBytes());
            writer.write(c3.getBytes());
            writer.write(c4.getBytes());
            writer.write(c5.getBytes());
            writer.write(c6.getBytes());
            writer.write(c7.getBytes());
            writer.write(c8.getBytes());
        }
        catch (FileNotFoundException e)
        {
            Log.d("error", "File not Found");
        }
        catch (IOException e)
        {
            Log.d("error", "IO Error");
        }
        finally
        {
            try
            {
                writer.close();
            } catch (IOException e)
            {
                Log.d("error", "File not Found");
            }
        }
        Toast.makeText(this, "Data Saved", Toast.LENGTH_LONG).show();
    }

    public void nextPage(View v)
    {
        Intent intent = new Intent(this, secondpage.class);
        startActivity(intent);
    }
}
