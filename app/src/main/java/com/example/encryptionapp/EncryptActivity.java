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

public class EncryptActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encrypt);

        TextView phraseToEncryptOutput = findViewById(R.id.Encrypt_EncryptedPhraseOutput);
        EditText phraseToEncryptInput = findViewById(R.id.Encrypt_PhraseToEncrypt_Input);
        Button encryptButton = findViewById(R.id.Encrypt_EncryptPhraseButton);
        Button backButton = findViewById(R.id.Encrypt_Real_BackButton);

        String keyForEncryption = getIntent().getStringExtra("KEY_FOR_ENCRYPTION");
        KeyTable newKeyTable = KeyTable.buildFromString(keyForEncryption);

        encryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!phraseToEncryptInput.getText().toString().isEmpty()){
                    String phraseToEncrypt = phraseToEncryptInput.getText().toString().replaceAll("[^a-zA-Z]", "");

                    Phrase newPhrase = Phrase.buildPhraseFromStringforEnc(phraseToEncrypt);
                    newPhrase = newPhrase.encrypt(newKeyTable);
                    String printoutPhrase = newPhrase.toString();

                    phraseToEncryptOutput.setText(printoutPhrase);
                } else{
                    phraseToEncryptInput.setHint("Please Enter a Phrase to Encrypt!");
                }
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backIntent = new Intent(EncryptActivity.this, MenuActivity.class);
                backIntent.putExtra("KEY_FOR_USE", getIntent().getStringExtra("KEY_FOR_ENCRYPTION"));
                startActivity(backIntent);
            }
        });
    }
}