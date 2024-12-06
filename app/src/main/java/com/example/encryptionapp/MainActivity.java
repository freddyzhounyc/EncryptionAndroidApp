/**
 * This Encryption App turns HW #4 into an android application that is accessible on mobile devices.
 *
 * @author Freddy Zhou
 *      Email: freddy.zhou@stonybrook.edu
 *      Stony Brook ID: 116580337
 *      Extra Credit Assignment - Encryption App
 *      CSE 214
 *      Recitation Number: R04 | TA Names: Veronica Oreshko, Anuj Sureshbhai, Alex Zuzow
 */
package com.example.encryptionapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button confirmKeyButton = findViewById(R.id.Main_Confirm_Key_Button);
        EditText enterKeyInput = findViewById(R.id.Enter_Key_EditText_Input);

        confirmKeyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!enterKeyInput.getText().toString().isEmpty()) {
                    Intent newIntent = new Intent(MainActivity.this, MenuActivity.class);
                    newIntent.putExtra("KEY_FOR_USE", enterKeyInput.getText().toString().replaceAll("[^a-zA-Z]", ""));
                    startActivity(newIntent);
                } else{
                    enterKeyInput.setHint("Please Enter A Key!");
                }
            }
        });
    }
}