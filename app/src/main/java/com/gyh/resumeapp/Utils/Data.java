package com.gyh.resumeapp.Utils;

import android.app.Application;

public class Data extends Application {
    private String ipPort;

    public String getIpPortData(){

        return this.ipPort;

    }

    public void setIpPortData(String ipPort){

        this.ipPort = ipPort;

    }

    @Override

    public void onCreate(){

        ipPort = "1.1.1.1:1111";

        super.onCreate();

    }

}
