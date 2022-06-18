package com.example.autouzupelnianie;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String[] wojewodztwa = {
            "dolnośląskie",
            "wielkopolskie",
            "opolskie",
            "lubuskie",
            "łódzkie"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_dropdown_item_1line,wojewodztwa);

        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.textView1);
        autoCompleteTextView.setAdapter(adapter);

        MultiAutoCompleteTextView multiAutoCompleteTextView = findViewById(R.id.textView2);
        multiAutoCompleteTextView.setAdapter(adapter);
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, wojewodztwa);

        ListView listView = findViewById(R.id.listView);

        // nagłowek
        TextView header = new TextView(this);
        header.setTextSize(25);
        header.setTextColor(Color.parseColor("#975A5A"));
        header.setText("Województwa:");
        listView.addHeaderView(header);

        listView.setAdapter(adapter1);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // pobieram klikniety element
                Object listItem = adapterView.getItemAtPosition(i);
                if(listItem != null){
                    Toast.makeText(getBaseContext(), l+1 +"."+ listItem.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}