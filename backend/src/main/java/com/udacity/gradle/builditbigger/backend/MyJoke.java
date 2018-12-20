package com.udacity.gradle.builditbigger.backend;

import com.jokeme.thejoker.TheJoker;

public class MyJoke {

    private String myJoke;

    public interface  instantiate{
        TheJoker theJoker = new TheJoker();
    }

    public String getMyJoke() {
        return myJoke;
    }

    public void setMyJoke(String data) {
        myJoke = data;
    }
}
