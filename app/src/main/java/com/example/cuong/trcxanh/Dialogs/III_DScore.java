package com.example.cuong.trcxanh.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cuong.trcxanh.Activities.III_Test;
import com.example.cuong.trcxanh.Activities.II_Menu;
import com.example.cuong.trcxanh.Activities.V_EndlessMode;
import com.example.cuong.trcxanh.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import static com.example.cuong.trcxanh.Activities.II_Menu.gameMode;
import static com.example.cuong.trcxanh.DataModels.Account.username;
import static com.example.cuong.trcxanh.DataModels.Networks.IP;

/**
 * Created by Cuong on 8/5/2018.
 */

public class III_DScore extends Dialog {

    private TextView tvShowD301;
    private Button btnBackD301, btnPlayD301;
    private Context context;
    private int score;

    public III_DScore(@NonNull final Context context, final int score) {
        super(context);
        setContentView(R.layout.dialog_iii_score);
        this.context=context;
        this.score=score;
        tvShowD301=this.findViewById(R.id.tvShowD301);
        btnBackD301=this.findViewById(R.id.btnBackD301);
        btnPlayD301=this.findViewById(R.id.btnPlayD301);

        tvShowD301.setText("Chúc mừng, bạn được "+score+" điểm");

        btnPlayD301.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameMode="e";
                if(username.length()!=0){
                    String url= IP+ "?name="+username+"&score="+score;
                    new checkScore().execute(url);
                }
                Intent intentD302=new Intent(context, V_EndlessMode.class);
                context.startActivity(intentD302);
            }
        });

        btnBackD301.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.length()!=0){
                    String url= IP+ "?name="+username+"&score="+score;
                    new checkScore().execute(url);
                }
                Intent intentD031=new Intent(context, II_Menu.class);
                context.startActivity(intentD031);
            }
        });
    }

     private class checkScore extends AsyncTask<String, Void, String> {
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
                httpURLConnection.setRequestMethod("POST");
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
               Toast.makeText(context,"True",Toast.LENGTH_SHORT).show();
            }
            else {
                String url2=IP+"?username="+username+"&score="+score;
                new modifyScore().execute(url2);
            }
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }

    private class modifyScore extends AsyncTask<String, Void, String> {
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
                httpURLConnection.setRequestMethod("PUT");
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
                Toast.makeText(context,"True",Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(context,"false", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }

}
