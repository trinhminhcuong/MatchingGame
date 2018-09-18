package com.example.cuong.trcxanh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.cuong.trcxanh.Activities.I_Sign;

public class MainActivity extends AppCompatActivity {

    private TextView tvStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvStart=findViewById(R.id.tvStart);

        tvStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,I_Sign.class);
                startActivity(intent);
            }
        });
    }


}
