package com.example.cuong.trcxanh.DataModels;

/**
 * Created by Cuong on 8/1/2018.
 */

public class UserInfo {


    private String username;
    private String highscore;

    public UserInfo(String username, String highscore) {
        this.username = username;
        this.highscore = highscore;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHighscore() {
        return highscore;
    }

    public void setHighscore(String highscore) {
        this.highscore = highscore;
    }
}
