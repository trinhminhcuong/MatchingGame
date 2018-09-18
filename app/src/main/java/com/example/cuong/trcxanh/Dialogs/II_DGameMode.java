package com.example.cuong.trcxanh.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import static com.example.cuong.trcxanh.Activities.II_Menu.gameMode;

import com.example.cuong.trcxanh.Activities.III_Test;
import com.example.cuong.trcxanh.Activities.IV_WorldMap;
import com.example.cuong.trcxanh.Activities.V_EndlessMode;
import com.example.cuong.trcxanh.R;

import java.io.BufferedReader;

/**
 * Created by Cuong on 7/6/2018.
 */

public class II_DGameMode extends Dialog {

    private Button btnBasicD20;
    private Button btnEndlessD20;
    private Button btnWorldD20;

    public II_DGameMode(@NonNull final Context context) {
        super(context);
        setContentView(R.layout.dialog_ii_game_mode);

        final Intent intentD201=new Intent(context, III_Test.class);


        btnBasicD20=this.findViewById(R.id.btnBasicD20);
        btnEndlessD20=this.findViewById(R.id.btnEndlessD20);
        btnWorldD20=this.findViewById(R.id.btnWorldD20);

        btnBasicD20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameMode="b";
                context.startActivity(intentD201);
            }
        });

        btnWorldD20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameMode="q";
                Intent intentD202=new Intent(context, IV_WorldMap.class);
                context.startActivity(intentD202);
            }
        });

        btnEndlessD20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameMode="e";
                Intent intentD203=new Intent(context, V_EndlessMode.class);
                context.startActivity(intentD203);
            }
        });
    }
}
