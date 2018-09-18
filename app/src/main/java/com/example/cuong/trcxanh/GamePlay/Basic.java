package com.example.cuong.trcxanh.GamePlay;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.cuong.trcxanh.Activities.III_Test;
import com.example.cuong.trcxanh.Activities.II_Menu;
import com.example.cuong.trcxanh.DataModels.ImageObject;
import com.example.cuong.trcxanh.R;


import java.util.Random;

import static com.example.cuong.trcxanh.Activities.II_Menu.gameMode;
import static com.example.cuong.trcxanh.Activities.IV_WorldMap.keyword401;

/**
 * Created by Cuong on 7/24/2018.
 */

public class Basic {

    private LinearLayout linearLayout;

    private EditText edKeyword;

    private Button btnOk;

    private Context context;

    private TextView textView;

    private ImageView image301,image302,image303,image304,image305,image306,image307,
            image311, image312,image313,image315,image316,image317,
            image321,image322,image323,image324,image325,image326,image327;

    private ProgressBar progressBar301;

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

    private boolean flag=false;

    private int currentQua=10;

    private int currentStage=0;

    private final String[] listWonder={"CHICHENITZA","MACHUPICCHU","CHRISTTHEREDEEMER ","COLOSSEUM","PETRA","TAJMAHAL","THEGREATWALL"};

    private final int[] wonders={R.drawable.chichen,R.drawable.machu,R.drawable.riode,R.drawable.colo,R.drawable.petraa,R.drawable.tajmahal,R.drawable.thegreatwall};
    //chichen, coloss, petra

    CountDownTimer countDownTimer;

    int total=50000;

    public Basic(LinearLayout linearLayout,EditText edKeyword,Button btnOk,TextView textView,Context context, ImageView image301, ImageView image302, ImageView image303, ImageView image304, ImageView image305, ImageView image306, ImageView image307, ImageView image311, ImageView image312, ImageView image313, ImageView image315, ImageView image316, ImageView image317, ImageView image321, ImageView image322, ImageView image323, ImageView image324, ImageView image325, ImageView image326, ImageView image327, ProgressBar progressBar301, Animation fadeOut, Animation fadeIn) {
        this.linearLayout=linearLayout;
        this.edKeyword=edKeyword;
        this.btnOk=btnOk;
        this.textView=textView;
        this.context = context;
        this.image301 = image301;
        this.image302 = image302;
        this.image303 = image303;
        this.image304 = image304;
        this.image305 = image305;
        this.image306 = image306;
        this.image307 = image307;
        this.image311 = image311;
        this.image312 = image312;
        this.image313 = image313;
        this.image315 = image315;
        this.image316 = image316;
        this.image317 = image317;
        this.image321 = image321;
        this.image322 = image322;
        this.image323 = image323;
        this.image324 = image324;
        this.image325 = image325;
        this.image326 = image326;
        this.image327 = image327;
        this.progressBar301 = progressBar301;
        this.fadeOut = fadeOut;
        this.fadeIn = fadeIn;

        creat();

        listImage= new ImageView[]{image301, image302, image303, image304, image305, image306, image307,
                image311, image312, image313, image315, image316, image317,
                image321, image322, image323, image324, image325, image326, image327};

        listObject=new ImageObject[]{object301,object302,object303,object304,object305,object306,object307,
                object311,object312,object313,object315,object316,object317,
                object321,object322,object323,object324,object325,object326,object327};


    }

    public void creat(){
        object301=new ImageObject(image301);
        object302=new ImageObject(image302);
        object303=new ImageObject(image303);
        object304=new ImageObject(image304);
        object305=new ImageObject(image305);
        object306=new ImageObject(image306);
        object307=new ImageObject(image307);
        object311=new ImageObject(image311);
        object312=new ImageObject(image312);
        object313=new ImageObject(image313);
        object315=new ImageObject(image315);
        object316=new ImageObject(image316);
        object317=new ImageObject(image317);
        object321=new ImageObject(image321);
        object322=new ImageObject(image322);
        object323=new ImageObject(image323);
        object324=new ImageObject(image324);
        object325=new ImageObject(image325);
        object326=new ImageObject(image326);
        object327=new ImageObject(image327);
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
            // imageObjects[i].getImageView().setImageResource(imageSource[randomInt]);
            listObject[i].setKeyword(imageSource[randomInt]);
            imageQuantity[randomInt]=imageQuantity[randomInt]-1;
        }
    }

    public void updateProgress(){
        countDownTimer=new CountDownTimer(total,1000) {
             @Override
             public void onTick(long l) {
                 int current = progressBar301.getProgress();
                 int a = 1000*100/total;
                 progressBar301.setProgress(current + a);
             }

             @Override
             public void onFinish() {
                 progressBar301.setProgress(100);
                 if (currentQua != 0) {
                     flag = true;
                     isOver();
                 }
             }
         }.start();
    }

    public  void stopProgress(){
        countDownTimer.cancel();
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
                        if(gameMode.equals("b")){
                            isOver();
                        }
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

    public void newGame(){
        currentStage=currentStage+1;
        progressBar301.setProgress(0);
        if(gameMode.equals("b")){
            flag=false;
            edKeyword.setVisibility(View.GONE);
            btnOk.setVisibility(View.GONE);
            int color= Color.parseColor("#00ffffff");
            linearLayout.setBackgroundColor(color);
            textView.setText("Màn "+currentStage+"");
            updateProgress();
        }
        if(gameMode.equals("q")){
            progressBar301.setVisibility(View.GONE);
            for(int i=0;i<listWonder.length;i++){
                if(keyword401.equals(listWonder[i])){
                    linearLayout.setBackgroundResource(wonders[i]);
                    i=10;
                }
            }
        //    linearLayout.setBackgroundResource(R.drawable.thegreatwall);
        }
        currentQua=10;
        for(int i=0;i<listObject.length;i++){
            listObject[i].getImageView().setImageResource(R.drawable.woodbackground);
            listObject[i].getImageView().setClickable(true);
            listObject[i].getImageView().startAnimation(fadeIn);
        }
        init();
    }

    public void setCurrentStage(){
        currentStage=0;
    }

    public void isOver(){
        if(currentQua==0){
            countDownTimer.cancel();
            if(currentStage==5){
                AlertDialog.Builder builder2=new AlertDialog.Builder(context);
                builder2.setTitle("Trúc Xanh");
                builder2.setMessage("Bạn đã phá đảo game, bạn có muốn chơi lại không?");
                builder2.setCancelable(false);
                builder2.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        setCurrentStage();
                        newGame();                }
                });

                builder2.setNegativeButton("Không đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent302=new Intent(context,II_Menu.class);
                        context.startActivity(intent302);
                    }
                });
                builder2.show();
            }
            else {
                newGame();
            }
        }
        if(flag==true){
            AlertDialog.Builder builder=new AlertDialog.Builder(context);
            builder.setTitle("Trúc Xanh");
            builder.setMessage("Bạn đã thua, bạn có muốn chơi lại không?");
            builder.setCancelable(false);
            builder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                        countDownTimer.cancel();
                        setCurrentStage();
                        newGame();                }
            });

            builder.setNegativeButton("Không đồng ý", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent301=new Intent(context,II_Menu.class);
                    context.startActivity(intent301);
                }
            });
            builder.show();
        }
    }

    public boolean checkKeyword(String keyword){
        String newKeyword=keyword.toUpperCase();
        newKeyword=newKeyword.replace(" ","");
        if(newKeyword.equals(keyword401)){
            return true;
        }
        else return false;
    }
}
