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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ChangeKeyActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_key);

        EditText changeKeyInput = findViewById(R.id.ChangeKey_New_Key_Input);
        Button changeKeyConfirmButton = findViewById(R.id.ChangeKey_Confirm_Key_Button);
        Button changeKeyBackButton = findViewById(R.id.ChangeKey_Back_Button);

        changeKeyConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!changeKeyInput.getText().toString().isEmpty()){
                    Intent newIntent = new Intent(ChangeKeyActivity.this, MenuActivity.class);
                    newIntent.putExtra("KEY_FOR_USE", changeKeyInput.getText().toString().replaceAll("[^a-zA-Z]", ""));
                    startActivity(newIntent);
                } else{
                    changeKeyInput.setHint("Please Enter A New Key!");
                }
            }
        });
        changeKeyBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backIntent = new Intent(ChangeKeyActivity.this, MenuActivity.class);
                backIntent.putExtra("KEY_FOR_USE", getIntent().getStringExtra("KEY_TO_CHANGE"));
                startActivity(backIntent);
            }
        });
    }
}