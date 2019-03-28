package com.example.ari.taanggi;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Reg_user extends AppCompatActivity {
    String[] negara = {"Laki-laki", "Perempuan"};
    Spinner spin;
    EditText txtNBM, txtNama, txtMAil;
    Button btnSimpan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_user);
        txtNBM = (EditText) findViewById(R.id.txtNBM);
        txtNama = (EditText) findViewById(R.id.txtNama);
        spin = (Spinner) findViewById(R.id.spinner);;
        txtMAil = (EditText) findViewById(R.id.txtMail);
        btnSimpan = (Button) findViewById(R.id.btnSimpan);

        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, negara);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
        spin.setOnItemSelectedListener(new CustomOnItemSelectedListener());

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpanGuru();
            }
        });
    }

    public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

        String firstItem = String.valueOf(spin.getSelectedItem());

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            if (firstItem.equals(String.valueOf(spin.getSelectedItem()))) {
                // ToDo when first item is selected
            } else {
                /*Toast.makeText(parent.getContext(),
                        "Kamu memilih : " + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_LONG).show();*/
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg) {

        }

    }


    void simpanGuru(){

        final String nbm_nis = txtNBM.getText().toString().trim();
        final String nama = txtNama.getText().toString().trim();
        final String jenkel = spin.getSelectedItem().toString().trim();
        final String email = txtMAil.getText().toString().trim();


        class AddEmployee2 extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Reg_user.this,"Mohon Tunggu","Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(Reg_user.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(KonekDB.KEY_NBM,nbm_nis);
                params.put(KonekDB.KEY_NAMA,nama);
                params.put(KonekDB.KEY_Kelamin,jenkel);
                params.put(KonekDB.KEY_Email,email);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest("http://pstiubl.com/saida/reg_guru.php", params);
                return res;
            }
        }

        AddEmployee2 ae = new AddEmployee2();
        ae.execute();
    }


    void simpanStaff(){

        final String npm = txtNBM.getText().toString().trim();
        final String username = txtNama.getText().toString().trim();
        final String mail = spin.getSelectedItem().toString().trim();
        final String password = txtMAil.getText().toString().trim();

        class AddEmployee2 extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Reg_user.this,"Mohon Tunggu","Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(Reg_user.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(KonekDB.KEY_EMP_NPM,npm);
                params.put(KonekDB.KEY_EMP_USER, username);
                params.put(KonekDB.KEY_EMP_MAIL, mail);
                params.put(KonekDB.KEY_EMP_PASS, password);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(KonekDB.URL_REG_GURU, params);
                return res;
            }
        }

        AddEmployee2 ae = new AddEmployee2();
        ae.execute();
    }


}

