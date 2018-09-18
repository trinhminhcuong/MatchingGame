package com.example.cuong.trcxanh.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cuong.trcxanh.Dialogs.I_DSignUp;
import com.example.cuong.trcxanh.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static com.example.cuong.trcxanh.DataModels.Account.username;
import static com.example.cuong.trcxanh.DataModels.Account.password;
import static com.example.cuong.trcxanh.DataModels.Networks.IP;

public class I_Sign extends AppCompatActivity {

    private EditText edUserName10;
    private EditText edPassword10;
    private Button btnSignIn10;
    private TextView tvSignUp10;
    private TextView tvGuest10;
    private Dialog signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i__sign);
        I_mapping();
        signUp= new I_DSignUp(I_Sign.this);

        tvSignUp10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUp.show();
            }
        });


        btnSignIn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edUserName10.length()==0||edPassword10.length()==0){
                    Toast.makeText(I_Sign.this,"Xin mời nhập đầy đủ thông tin",Toast.LENGTH_SHORT).show();
                }
                else {
                    if(isConnected()==false){
                        Toast.makeText(I_Sign.this,"Không có kết nối mạng",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        String url = IP + "?username=" + edUserName10.getText().toString().trim()+"&password="
                                +edPassword10.getText().toString().trim();
                        new AsyncSignIn().execute(url);
                    }
                }
            }
        });

        tvGuest10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent10=new Intent(I_Sign.this,II_Menu.class);
                startActivity(intent10);
            }
        });

    }

    public boolean isConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }

    public void I_mapping(){
        edUserName10=findViewById(R.id.edUserName10);
        edPassword10=findViewById(R.id.edPassword10);
        btnSignIn10=findViewById(R.id.btnSignIn10);
        tvSignUp10=findViewById(R.id.tvSignUp10);
        tvGuest10=findViewById(R.id.tvGuest10);
    }

    private class AsyncSignIn extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            StringBuilder stringBuilder=new StringBuilder();
            try {
                URL url=new URL(strings[0]);
                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoInput(true);
                httpURLConnection.connect();
                InputStream inputStream=httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
                BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                String line="";
                while((line=bufferedReader.readLine())!=null){
                    stringBuilder.append(line + "\n");
                }
                bufferedReader.close();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return stringBuilder.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            String result=s.charAt(0)+"";
            if(result.equals("t")==true)
            {
                username=edUserName10.getText().toString();
                password=edPassword10.getText().toString();
                Intent intent11=new Intent(I_Sign.this,II_Menu.class);
                startActivity(intent11);
            }
            else {
                Toast.makeText(I_Sign.this,"Tài khoản không đúng", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

    }

}
