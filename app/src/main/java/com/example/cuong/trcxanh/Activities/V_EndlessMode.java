package com.example.cuong.trcxanh.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.cuong.trcxanh.GamePlay.Endless;
import com.example.cuong.trcxanh.R;

public class V_EndlessMode extends AppCompatActivity {

    private TextView tvRound501, tvTime501;

    private ProgressBar progressBar501;

    private ImageView image501,image502,image503,image504,image505,image506,image507,
                image511,image512,image513,image515,image516,image517,
                image521,image522,image523,image524,image525,image526,image527;

    private Animation fadeIn, fadeOut;

    private Endless endless;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v__endless_mode);
        vmapping();
        endless=new Endless(tvTime501,this,fadeIn,fadeOut,tvRound501,progressBar501,image501,image502,image503,image504,image505,image506,image507,
                image511,image512,image513,image515,image516,image517,
                image521,image522,image523,image524,image525,image526,image527);
        endless.newGame();

        image501.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endless.check(image501);
            }
        });

        image502.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endless.check(image502);
            }
        });

        image503.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endless.check(image503);
            }
        });

        image504.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endless.check(image504);
            }
        });

        image505.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endless.check(image505);
            }
        });

        image506.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endless.check(image506);
            }
        });

        image507.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endless.check(image507);
            }
        });

        image511.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endless.check(image511);;
            }
        });

        image512.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endless.check(image512);
            }
        });

        image513.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endless.check(image513);
            }
        });

        image515.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endless.check(image515);
            }
        });

        image516.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endless.check(image516);
            }
        });

        image517.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endless.check(image517);
            }
        });

        image521.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endless.check(image521);
            }
        });

        image522.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endless.check(image522);
            }
        });

        image523.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endless.check(image523);
            }
        });

        image524.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endless.check(image524);
            }
        });

        image525.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endless.check(image525);
            }
        });

        image526.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endless.check(image526);
            }
        });

        image527.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endless.check(image527);
            }
        });

    }

    public void vmapping(){
        fadeIn= AnimationUtils.loadAnimation(this,R.anim.fade_in);
        fadeOut=AnimationUtils.loadAnimation(this,R.anim.fade_out);
        tvRound501=findViewById(R.id.tvRound501);
        tvTime501=findViewById(R.id.tvTime501);
        image501=findViewById(R.id.image501);
        image502=findViewById(R.id.image502);
        image503=findViewById(R.id.image503);
        image504=findViewById(R.id.image504);
        image505=findViewById(R.id.image505);
        image506=findViewById(R.id.image506);
        image507=findViewById(R.id.image507);
        image511=findViewById(R.id.image511);
        image512=findViewById(R.id.image512);
        image513=findViewById(R.id.image513);
        image515=findViewById(R.id.image515);
        image516=findViewById(R.id.image516);
        image517=findViewById(R.id.image517);
        image521=findViewById(R.id.image521);
        image522=findViewById(R.id.image522);
        image523=findViewById(R.id.image523);
        image524=findViewById(R.id.image524);
        image525=findViewById(R.id.image525);
        image526=findViewById(R.id.image526);
        image527=findViewById(R.id.image527);
        progressBar501=findViewById(R.id.progressBar501);

    }
}
