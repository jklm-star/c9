package com.example.c9;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // Ensure this matches your XML filename

        listView = findViewById(R.id.listView);
        textView = findViewById(R.id.textView);  // Update XML to have id="textView"

        // Sample data for the ListView
        String[] fruits = {"Apple", "Banana", "Cherry", "Date", "Grapes"};

        // Adapter to bind data to ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, fruits);
        listView.setAdapter(adapter);

        // Set item click listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = fruits[position];
                // Display selected item in TextView
                textView.setText("Selected: " + selectedItem);
                // Optional: Show Toast
                Toast.makeText(MainActivity.this, "You clicked: " + selectedItem, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
