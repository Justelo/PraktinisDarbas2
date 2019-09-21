package com.example.praktinisdarbas2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

//Komponentu aprasymas

    TextView resultText;
    EditText inputText;
    Button startApp;
    Spinner chooseTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //komponentu priskyrimas

        resultText = findViewById(R.id.textAts);
        inputText = findViewById(R.id.editText);
        startApp =  findViewById(R.id.bStart);
        chooseTask = findViewById(R.id.sChoose);

        //spinneris

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.choice, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        chooseTask.setAdapter(adapter);
        chooseTask.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();

        startApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!inputText.getText().toString().matches("")) {

                    if (chooseTask.getSelectedItem().toString().trim().equals("Words")) {
                        String text = inputText.getText().toString();
                        text = text.replace("\n", " ");
                        String[] textArray = text.split(" ");
                        resultText.setText("Words: " + textArray.length);

                    } else {
                        String text = inputText.getText().toString();
                        text = text.replace(" ", "");
                        resultText.setText("Chars: " + String.valueOf(text.length()));
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Field is empty", Toast.LENGTH_SHORT).show();
                    resultText.setText("Error");
                }
            }
        });
    }
        @Override
        public void onNothingSelected (AdapterView < ? > parent){
        //kai spinneris tuscias(nereikalinga)
        }
    }