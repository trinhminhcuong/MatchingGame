package com.example.cuong.trcxanh.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cuong.trcxanh.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static com.example.cuong.trcxanh.DataModels.Networks.IP;

/**
 * Created by Cuong on 6/17/2018.
 */

public class I_DSignUp extends Dialog {

    private EditText edUserNameD10;
    private EditText edPasswordD10;
    private EditText edPasswordD11;
    private Button btnSignUpD10;
    private boolean running=false;
    private Context context;




    public I_DSignUp(@NonNull final Context context) {
        super(context);
         this.context=context;
        setContentView(R.layout.dialog_i_sign_up);

        edUserNameD10=this.findViewById(R.id.edUserNameD10);
        edPasswordD10=this.findViewById(R.id.edPasswordD10);
        edPasswordD11=this.findViewById(R.id.edPasswordD11);
        btnSignUpD10=this.findViewById(R.id.btnSignUp10);

        btnSignUpD10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edUserNameD10.length()==0||edPasswordD10.length()==0||edPasswordD11.length()==0){
                    Toast.makeText(context,"Xin mời nhập đầy đủ thông tin",Toast.LENGTH_SHORT).show();
                }
                else if(edPasswordD10.getText().toString().equals(edPasswordD11.getText().toString())==false){
                    Toast.makeText(context,"Mật khẩu không trùng khớp",Toast.LENGTH_SHORT).show();
                }
                else {
                    if(isConnected()==false){
                        Toast.makeText(context,"Không có kết nối mạng",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        String url=IP+"?username="+edUserNameD10.getText().toString().trim()
                                +"&password="+edPasswordD10.getText().toString().trim();
                        new AsyncSignUp().execute(url);
                        cancel();
                    }
                }
            }
        });
    }

    public boolean isConnected() {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }

    private class AsyncSignUp extends AsyncTask<String, Void, String> {
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
            String a=s.charAt(0)+"";

            if(a.equals("t")==true)
            {
                edUserNameD10.setText("");
                edPasswordD10.setText("");
                edPasswordD11.setText("");
                running=true;
                Toast.makeText(context,"Đăng ký thành công", Toast.LENGTH_SHORT).show();

            }
            else {
                running=true;
                Toast.makeText(context,"Tài khoản đã tồn tại", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

    }

}
