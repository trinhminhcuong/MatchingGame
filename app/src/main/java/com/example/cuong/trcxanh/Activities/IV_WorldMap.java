package com.example.cuong.trcxanh.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.cuong.trcxanh.R;

public class IV_WorldMap extends AppCompatActivity {

    private ImageView imageView401,imageView402, imageView403, imageView404, imageView405,
                        imageView406, imageView407;


    public static String keyword401="";

    private final String[] listWonder={"CHICHENITZA","MACHUPICCHU","CHRISTTHEREDEEMER ","COLOSSEUM","PETRA","TAJMAHAL","THEGREATWALL"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iv__world_map);
        mappingiv();

        final Intent intent401=new Intent(IV_WorldMap.this,III_Test.class);

        imageView401.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keyword401=listWonder[0];
                startActivity(intent401);
            }
        });

        imageView402.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keyword401=listWonder[1];
                startActivity(intent401);
            }
        });

        imageView403.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keyword401=listWonder[2];
                startActivity(intent401);
            }
        });

        imageView404.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keyword401=listWonder[3];
                startActivity(intent401);
            }
        });

        imageView405.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keyword401=listWonder[4];
                startActivity(intent401);
            }
        });

        imageView406.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keyword401=listWonder[5];
                startActivity(intent401);
            }
        });

        imageView407.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keyword401=listWonder[6];
                startActivity(intent401);
            }
        });
    }

    public void mappingiv(){
        imageView401=findViewById(R.id.imageView401);
        imageView402=findViewById(R.id.imageView402);
        imageView403=findViewById(R.id.imageView403);
        imageView404=findViewById(R.id.imageView404);
        imageView405=findViewById(R.id.imageView405);
        imageView406=findViewById(R.id.imageView406);
        imageView407=findViewById(R.id.imageView407);
    }

}
