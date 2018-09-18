package com.example.cuong.trcxanh.Activities;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cuong.trcxanh.Adapters.UserInfoAdapter;
import com.example.cuong.trcxanh.DataModels.UserInfo;
import com.example.cuong.trcxanh.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static com.example.cuong.trcxanh.DataModels.Account.username;
import static com.example.cuong.trcxanh.DataModels.Networks.IP;

public class VI_HighScore extends AppCompatActivity {

    private TextView tvMyRank601;
    private ListView lvRank601;
    private ArrayAdapter<UserInfo> userInfoAdapter;
    private List<UserInfo> userInfoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vi__high_score);
        tvMyRank601=findViewById(R.id.tvMyRank601);
        lvRank601=findViewById(R.id.lvRank601);
        userInfoList=new ArrayList<>();
        String url=IP+"?list=abc";
        if(isConnected()==true){
            new getListRank().execute(url);
        }
        else {
            Toast.makeText(VI_HighScore.this,"Không có kết nối mạng",Toast.LENGTH_SHORT).show();
        }
    }

    public boolean isConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }


    private class getListRank extends AsyncTask<String, Void, String> {
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
            if(s.length()>5) {
                try {
                    JSONArray array=new JSONArray(s) ;
                    for(int i=0;i<=array.length();i++){
                        JSONObject activity=array.getJSONObject(i);
                        String name=activity.getString("name");
                        String score=activity.getString("score");
                        if(i<3){
                            userInfoList.add(new UserInfo(name,score));
                        }
                        if (username.length() != 0) {
                            if(name.equals(username)==true){
                                int newrank=i+1;
                                tvMyRank601.setText("Hạng của bạn: "+newrank+" - Điểm: "+score);
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            userInfoAdapter=new UserInfoAdapter(VI_HighScore.this,R.layout.adapter_user_info,userInfoList);
            lvRank601.setAdapter(userInfoAdapter);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

    }

}
