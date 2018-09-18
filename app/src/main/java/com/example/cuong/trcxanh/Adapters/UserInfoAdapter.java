package com.example.cuong.trcxanh.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cuong.trcxanh.DataModels.UserInfo;
import com.example.cuong.trcxanh.R;

import java.util.List;

/**
 * Created by Cuong on 8/1/2018.
 */

public class UserInfoAdapter extends ArrayAdapter<UserInfo> {
    private Context context;
    private int resource;
    private List<UserInfo> userInfos;

    public UserInfoAdapter(@NonNull Context context, int resource, List<UserInfo> userInfos) {
        super(context, resource,userInfos);
        this.context=context;
        this.resource=resource;
        this.userInfos=userInfos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null){
            LayoutInflater layoutInflater=LayoutInflater.from(context);
            convertView=layoutInflater.inflate(resource,null);
        }
        ImageView imageRank=convertView.findViewById(R.id.imageRank);
        TextView tvUsername=convertView.findViewById(R.id.tvUsername);
        TextView tvHighScore=convertView.findViewById(R.id.tvHighScore);

        if(position==0){
            imageRank.setImageResource(R.drawable.first);
        }
        if(position==1){
            imageRank.setImageResource(R.drawable.second);
        }
        if(position==2){
            imageRank.setImageResource(R.drawable.third);
        }

        tvUsername.setText(userInfos.get(position).getUsername());
        tvHighScore.setText("Round: "+userInfos.get(position).getHighscore());

        return convertView;
    }
}
