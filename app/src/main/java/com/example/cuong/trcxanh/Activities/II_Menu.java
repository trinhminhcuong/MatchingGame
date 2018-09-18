package com.example.cuong.trcxanh.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cuong.trcxanh.Dialogs.II_DGameMode;
import com.example.cuong.trcxanh.R;

public class II_Menu extends AppCompatActivity {

    private Button btnPlay20;
    private Button btnRank20;
    private Button btnQuit20;
    private Dialog dialogGameMode;
    public static String gameMode="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ii__menu);

        btnPlay20=findViewById(R.id.btnPlay20);
        btnRank20=findViewById(R.id.btnRank20);
        btnQuit20=findViewById(R.id.btnQuit20);
        dialogGameMode=new II_DGameMode(this);

        btnPlay20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogGameMode.show();
            }
        });

        btnRank20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent201=new Intent(II_Menu.this,VI_HighScore.class);
                startActivity(intent201);
            }
        });

        btnQuit20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
