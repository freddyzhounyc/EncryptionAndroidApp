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
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button changeKeyButton = findViewById(R.id.Change_Key_Button);
        Button printKeyButton = findViewById(R.id.Print_Key_Button);
        Button encryptButton = findViewById(R.id.Encrypt_Button);
        Button decryptButton = findViewById(R.id.Decrypt_Button);
        String keyForUse = getIntent().getStringExtra("KEY_FOR_USE");

        changeKeyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newChangeKeyIntent = new Intent(MenuActivity.this, ChangeKeyActivity.class);
                newChangeKeyIntent.putExtra("KEY_TO_CHANGE", keyForUse);
                startActivity(newChangeKeyIntent);
            }
        });
        printKeyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newPrintKeyIntent = new Intent(MenuActivity.this, PrintKeyActivity.class);
                newPrintKeyIntent.putExtra("KEY_TO_PRINT", keyForUse);
                startActivity(newPrintKeyIntent);
            }
        });
        encryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newEncryptPhraseIntent = new Intent(MenuActivity.this, EncryptActivity.class);
                newEncryptPhraseIntent.putExtra("KEY_FOR_ENCRYPTION", keyForUse);
                startActivity(newEncryptPhraseIntent);
            }
        });
        decryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newDecrptPhraseIntent = new Intent(MenuActivity.this, DecryptActivity.class);
                newDecrptPhraseIntent.putExtra("KEY_FOR_DECRYPTION", keyForUse);
                startActivity(newDecrptPhraseIntent);
            }
        });
    }
}