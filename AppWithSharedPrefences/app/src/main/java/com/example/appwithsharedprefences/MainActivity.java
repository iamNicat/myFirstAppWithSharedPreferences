package com.example.appwithsharedprefences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public TextView textView;
    public EditText editText;
    public Button enterTextButton, saveButton;
    public static final String SHARED_PREFERENCES = "sharedPreferences";
    public static final String TEXT = "text";
    private String text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textview);

        editText = findViewById(R.id.edittext);
        enterTextButton = findViewById(R.id.enter_text_button);
        saveButton = findViewById(R.id.save_button);


        enterTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(editText.getText().toString());
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveMyData();


            }
        });
        loadData();
        upDateViews();
    }

    private void saveMyData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TEXT, textView.getText().toString());

        editor.apply();
        Toast.makeText(this, "Your date is saved", Toast.LENGTH_SHORT).show();
    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        text = sharedPreferences.getString(TEXT, "");
    }

    public void upDateViews() {
        textView.setText(text);

    }

}
