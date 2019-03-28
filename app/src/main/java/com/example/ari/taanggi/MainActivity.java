package com.example.ari.taanggi;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    private TextView inputSuara,txthafal,txtTepat,txtLancar,txtHidden;
    private Button tombolBicara,btn2;
    private final int REQ_CODE_SPEECH_INPUT = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Contoh Speech to Text");
        //getSupportActionBar().setSubtitle("Belajar di okedroid.com");

        inputSuara = (TextView) findViewById(R.id.inputSuara);
        txthafal = (TextView) findViewById(R.id.txtHafal);
        txtLancar = (TextView) findViewById(R.id.txtLancar);
        txtTepat = (TextView) findViewById(R.id.txtTepat);
        txtHidden = (TextView) findViewById(R.id.hidden);

        tombolBicara = (Button) findViewById(R.id.tombolBicara);
        btn2 = (Button) findViewById(R.id.button2);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Reg_user.class);
                startActivity(intent);
            }
        });


        tombolBicara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tanyaInputSuara();
            }
        });
    }

    public void tanyaInputSuara() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                "Hei Bicara sesuatu ");

        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);

        } catch (ActivityNotFoundException a) {

        }

    }

    //Untuk menerima inputan speech dan menampilkan text
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        Toast.makeText(this, "Hasil suara ditampilkan", Toast.LENGTH_SHORT).show();
        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    inputSuara.setText(result.get(0));
                    txtHidden.setText(inputSuara.getText().toString());

                    String isi = txtHidden.getText().toString().trim();
                    if(isi.equals("Ana")){
                        txtTepat.setText("35");
                        txtLancar.setText("35");
                        txthafal.setText("30");
                    }else{
                        txtTepat.setText("0");
                        txtLancar.setText("0");
                        txthafal.setText("0");
                    }
                }
                break;
            }

        }
    }

}