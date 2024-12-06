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

public class DecryptActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decrypt);

        EditText decryptionInput = findViewById(R.id.Decrypt_PhraseToDecryptInput);
        TextView decryptionOutput = findViewById(R.id.Decrypt_DecryptionOutput);
        Button decryptButton = findViewById(R.id.Decrypt_DecryptButton);
        Button backButton = findViewById(R.id.Decrypt_BackButton);

        String decryptionKey = getIntent().getStringExtra("KEY_FOR_DECRYPTION");
        KeyTable newKeyTable = KeyTable.buildFromString(decryptionKey);

        decryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!decryptionInput.getText().toString().isEmpty()) {
                    String phraseToDecrypt = decryptionInput.getText().toString().toUpperCase().replaceAll("[^a-zA-Z]", "");

                    Phrase decryptionPhrase = new Phrase();
                    for (int i = 0; i < phraseToDecrypt.length() - 1; i += 2) {
                        Bigram decryptionBigram = new Bigram(phraseToDecrypt.charAt(i), phraseToDecrypt.charAt(i + 1));
                        decryptionPhrase.enqueue(decryptionBigram);
                    }
                    decryptionPhrase = decryptionPhrase.decrypt(newKeyTable);

                    String decryptionPrintout = decryptionPhrase.toString();
                    decryptionOutput.setText(decryptionPrintout);
                } else{
                    decryptionInput.setHint("Please Enter a Phrase to Decrypt!");
                }
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backIntent = new Intent(DecryptActivity.this, MenuActivity.class);
                backIntent.putExtra("KEY_FOR_USE", getIntent().getStringExtra("KEY_FOR_DECRYPTION"));
                startActivity(backIntent);
            }
        });
    }
}