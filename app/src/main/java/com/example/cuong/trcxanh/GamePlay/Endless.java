package com.example.cuong.trcxanh.GamePlay;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cuong.trcxanh.Activities.II_Menu;
import com.example.cuong.trcxanh.Activities.I_Sign;
import com.example.cuong.trcxanh.DataModels.ImageObject;
import com.example.cuong.trcxanh.Dialogs.III_DScore;
import com.example.cuong.trcxanh.R;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import static android.content.Context.SHORTCUT_SERVICE;
import static com.example.cuong.trcxanh.Activities.II_Menu.gameMode;
import static com.example.cuong.trcxanh.Activities.IV_WorldMap.keyword401;
import static com.example.cuong.trcxanh.DataModels.Account.password;
import static com.example.cuong.trcxanh.DataModels.Account.username;
import static com.example.cuong.trcxanh.DataModels.Networks.IP;

/**
 * Created by Cuong on 7/27/2018.
 */

public class Endless {

    private Context context;

    private Animation fadeIn, fadeOut;

    private TextView tvRound501,tvTime501;

    private ProgressBar progressBar501;

    private ImageView image501,image502,image503,image504,image505,image506,image507,
            image511,image512,image513,image515,image516,image517,
            image521,image522,image523,image524,image525,image526,image527;

    private ImageObject object501,object502,object503,object504,object505,object506,object507,
            object511,object512,object513,object515,object516,object517,
            object521,object522,object523,object524,object525,object526,object527;

    private ImageView[] listImage;

    private ImageObject[] listObject;

    private CountDownTimer countDownTimer;

    private int id1,id2;

    private ImageView imageView1, imageView2;

    private int currentQua=10;

    private int currentStage=0;

    private int total=50000;

    private int count=0;

    private int curentProgress=0;

    private long second;

    private boolean flag=false;

    private final  int[] imageSource={R.drawable.apple,R.drawable.grape,R.drawable.watermelon,R.drawable.pineapple,R.drawable.tomato};

    public Endless(TextView tvTime501,Context context, Animation fadeIn, Animation fadeOut, TextView tvRound501,ProgressBar progressBar, ImageView image501, ImageView image502, ImageView image503, ImageView image504, ImageView image505, ImageView image506, ImageView image507, ImageView image511, ImageView image512, ImageView image513, ImageView image515, ImageView image516, ImageView image517, ImageView image521, ImageView image522, ImageView image523, ImageView image524, ImageView image525, ImageView image526, ImageView image527) {
        this.tvTime501=tvTime501;
        this.context=context;
        this.fadeIn=fadeIn;
        this.fadeOut=fadeOut;
        this.tvRound501=tvRound501;
        this.progressBar501 = progressBar;
        this.image501 = image501;
        this.image502 = image502;
        this.image503 = image503;
        this.image504 = image504;
        this.image505 = image505;
        this.image506 = image506;
        this.image507 = image507;
        this.image511 = image511;
        this.image512 = image512;
        this.image513 = image513;
        this.image515 = image515;
        this.image516 = image516;
        this.image517 = image517;
        this.image521 = image521;
        this.image522 = image522;
        this.image523 = image523;
        this.image524 = image524;
        this.image525 = image525;
        this.image526 = image526;
        this.image527 = image527;

        creat();



        listImage=new ImageView[]{image501,image502,image503,image504,image505,image506,image507,
                image511,image512,image513,image515,image516,image517,
                image521,image522,image523,image524,image525,image526,image527};

        listObject=new ImageObject[]{object501,object502,object503,object504,object505,object506,object507,
                object511,object512,object513,object515,object516,object517,
                object521,object522,object523,object524,object525,object526,object527};
    }

    public void creat(){
        object501=new ImageObject(image501);
        object502=new ImageObject(image502);
        object503=new ImageObject(image503);
        object504=new ImageObject(image504);
        object505=new ImageObject(image505);
        object506=new ImageObject(image506);
        object507=new ImageObject(image507);
        object511=new ImageObject(image511);
        object512=new ImageObject(image512);
        object513=new ImageObject(image513);
        object515=new ImageObject(image515);
        object516=new ImageObject(image516);
        object517=new ImageObject(image517);
        object521=new ImageObject(image521);
        object522=new ImageObject(image522);
        object523=new ImageObject(image523);
        object524=new ImageObject(image524);
        object525=new ImageObject(image525);
        object526=new ImageObject(image526);
        object527=new ImageObject(image527);
    }

    public void init(){
        int[] imageQuantity={4,4,4,4,4};
        Random random=new Random();
        int randomInt;
        for (int i=0; i<listObject.length;i++){
            do{
                randomInt=random.nextInt(imageSource.length);
            }
            while (imageQuantity[randomInt]==0);
            listObject[i].setKeyword(imageSource[randomInt]);
            imageQuantity[randomInt]=imageQuantity[randomInt]-1;
        }
    }

    public void check(ImageView imageView){
        count=count+1;
        if(count==1){
            imageView1=imageView;
            for(int i=0;i<listImage.length;i++){
                if(listImage[i]==imageView){
                    id1=listObject[i].getKeyword();
                    imageView.setImageResource(id1);
                    imageView.setClickable(false);
                    i=21;
                }
            }
        }
        if(count==2){
            imageView2=imageView;
            for(int i=0;i<listImage.length;i++){
                if(listImage[i]==imageView){
                    id2=listObject[i].getKeyword();
                    imageView.setImageResource(id2);
                    i=21;
                    if(id1==id2){
                        imageView1.startAnimation(fadeOut);
                        imageView.startAnimation(fadeOut);
                        imageView.setClickable(false);
                        currentQua=currentQua-1;
                        isOver();
                    }
                    else {
                        imageView1.setClickable(true);
                        CountDownTimer countDownTimer2=new CountDownTimer(600,200) {
                            @Override
                            public void onTick(long l) {
                            }
                            @Override
                            public void onFinish() {
                                imageView1.setImageResource(R.drawable.woodbackground);
                                imageView2.setImageResource(R.drawable.woodbackground);
                            }
                        }.start();
                    }
                    count=0;
                }
            }
        }
    }

    public void updateProgress(){

        countDownTimer=new CountDownTimer(total,1000) {
            @Override
            public void onTick(long l) {
                int a = 1000*(100-curentProgress)/total;
                progressBar501.setProgress(progressBar501.getProgress()+a);
                tvTime501.setText(exchange(l));
            }
            @Override
            public void onFinish() {
                progressBar501.setProgress(100);
                tvTime501.setText("00:00");
                if (currentQua != 0) {
                    flag = true;
                    isOver();
                }
            }
        }.start();
    }

    public void newGame(){
        currentStage=currentStage+1;
        progressBar501.setProgress(curentProgress);
        flag=false;
        tvRound501.setText("Màn "+currentStage+"");
        updateProgress();
        currentQua=10;
        tvTime501.setText(exchange(total));
        for(int i=0;i<listObject.length;i++){
            listObject[i].getImageView().setImageResource(R.drawable.woodbackground);
            listObject[i].getImageView().setClickable(true);
            listObject[i].getImageView().startAnimation(fadeIn);
        }
        init();
    }

    public void isOver(){
        if(currentQua==0){
            curentProgress=progressBar501.getProgress();
            total=total-progressBar501.getProgress()*total/100;
            total=total+5000;
            countDownTimer.cancel();
            newGame();
        }
        if(flag==true){
            int score=currentStage-1;
            Dialog dialog=new III_DScore(context,score);
            dialog.show();
        }
    }

    public String exchange(long milisecond){
        long time=milisecond/1000;
        long second=time%60;
        long minute=time/60;
        String result=minute+":"+second;
        return result;
    }



}
