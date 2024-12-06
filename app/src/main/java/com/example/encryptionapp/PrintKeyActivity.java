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
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class PrintKeyActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_key);

        KeyTable newKeyTable = KeyTable.buildFromString(getIntent().getStringExtra("KEY_TO_PRINT"));
        String keyPrintOutValue = "";
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                keyPrintOutValue += newKeyTable.getKeyTable()[i][j] + " ";
            }
            keyPrintOutValue += "\n";
        }

        TextView printKeyKeyPrintout = findViewById(R.id.PrintKey_Key_Printout);
        printKeyKeyPrintout.setText(keyPrintOutValue);

        Button printKeyBackButton = findViewById(R.id.PrintKey_Back_ButtonReal);
        printKeyBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backIntent = new Intent(PrintKeyActivity.this, MenuActivity.class);
                backIntent.putExtra("KEY_FOR_USE", getIntent().getStringExtra("KEY_TO_PRINT"));
                startActivity(backIntent);
            }
        });
    }
}