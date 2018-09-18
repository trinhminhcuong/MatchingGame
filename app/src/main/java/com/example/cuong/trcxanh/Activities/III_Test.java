package com.example.cuong.trcxanh.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cuong.trcxanh.DataModels.ImageObject;
import com.example.cuong.trcxanh.GamePlay.Basic;
import com.example.cuong.trcxanh.R;

import org.w3c.dom.Text;

import java.util.Random;

public class III_Test extends AppCompatActivity {

    private ImageView  image301,image302,image303,image304,image305,image306,image307,
                        image311, image312,image313,image315,image316,image317,
                        image321,image322,image323,image324,image325,image326,image327;

    private ProgressBar progressBar301;

    private TextView tvRound301;

    private Button btnOk301;

    private EditText edKeyword301;

    private ImageObject object301,object302,object303,object304,object305,object306,object307,
            object311,object312,object313,object315,object316,object317,
            object321,object322,object323,object324,object325,object326,object327;

    private final  int[] imageSource={R.drawable.apple,R.drawable.grape,R.drawable.watermelon,R.drawable.pineapple,R.drawable.tomato};

    private ImageView[] listImage;

    private ImageObject[] listObject;

    private Animation fadeOut, fadeIn;

    private int count=0;

    private int id1,id2;

    private ImageView imageView1, imageView2;


    private int currentQua=10;

    private int currentStage=0;

    private Basic basicMode;

    private LinearLayout linearLayout301;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iii__test);
        mapping();
        fadeOut=AnimationUtils.loadAnimation(this,R.anim.fade_out);
        fadeIn=AnimationUtils.loadAnimation(this,R.anim.fade_in);

        listImage= new ImageView[]{image301, image302, image303, image304, image305, image306, image307,
                 image311, image312, image313, image315, image316, image317,
                 image321, image322, image323, image324, image325, image326, image327};

        basicMode=new Basic(linearLayout301,edKeyword301,btnOk301,tvRound301,III_Test.this,image301,image302,image303,image304,image305,image306,image307,
                image311, image312,image313,image315,image316,image317,
                image321,image322,image323,image324,image325,image326,image327,progressBar301,fadeOut, fadeIn);

        basicMode.newGame();

        btnOk301.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edKeyword301.length()==0){
                    Toast.makeText(III_Test.this,"Xin mời nhập đáp án",Toast.LENGTH_SHORT).show();
                }
                else {
                    boolean result=basicMode.checkKeyword(edKeyword301.getText().toString().trim());
                    if(result==true){
                        Toast.makeText(III_Test.this,"Bạn đã đoán đúng",Toast.LENGTH_SHORT).show();
                        Intent intent301=new Intent(III_Test.this,II_Menu.class);
                        startActivity(intent301);
                    }
                    else {
                        Toast.makeText(III_Test.this,"Đây không phải đáp án đúng",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        image301.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                basicMode.check(image301);
            }
        });

        image302.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                basicMode.check(image302);
            }
        });


        image303.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                basicMode.check(image303);
            }
        });

        image304.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                basicMode.check(image304);
            }
        });

        image305.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                basicMode.check(image305);
            }
        });

        image306.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                basicMode.check(image306);
            }
        });

        image307.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                basicMode.check(image307);
            }
        });

        image311.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                basicMode.check(image311);;
            }
        });

        image312.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                basicMode.check(image312);
            }
        });

        image313.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               basicMode.check(image313);
            }
        });

        image315.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                basicMode.check(image315);
            }
        });

        image316.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                basicMode.check(image316);
            }
        });

        image317.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                basicMode.check(image317);
            }
        });

        image321.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                basicMode.check(image321);
            }
        });

        image322.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                basicMode.check(image322);
            }
        });

        image323.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                basicMode.check(image323);
            }
        });

        image324.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                basicMode.check(image324);
            }
        });

        image325.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                basicMode.check(image325);
            }
        });

        image326.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                basicMode.check(image326);
            }
        });

        image327.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                basicMode.check(image327);
            }
        });
    }


    public void mapping(){
        tvRound301=findViewById(R.id.tvRound301);
        image301=findViewById(R.id.image301);
        image302=findViewById(R.id.image302);
        image303=findViewById(R.id.image303);
        image304=findViewById(R.id.image304);
        image305=findViewById(R.id.image305);
        image306=findViewById(R.id.image306);
        image307=findViewById(R.id.image307);
        image311=findViewById(R.id.image311);
        image312=findViewById(R.id.image312);
        image313=findViewById(R.id.image313);
        image315=findViewById(R.id.image315);
        image316=findViewById(R.id.image316);
        image317=findViewById(R.id.image317);
        image321=findViewById(R.id.image321);
        image322=findViewById(R.id.image322);
        image323=findViewById(R.id.image323);
        image324=findViewById(R.id.image324);
        image325=findViewById(R.id.image325);
        image326=findViewById(R.id.image326);
        image327=findViewById(R.id.image327);
        progressBar301=findViewById(R.id.progressBar301);
        edKeyword301=findViewById(R.id.edKeyword301);
        btnOk301=findViewById(R.id.btnOk301);
        linearLayout301=findViewById(R.id.linearLayout301);
    }


}
