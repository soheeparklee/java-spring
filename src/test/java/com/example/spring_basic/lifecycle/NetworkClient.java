package com.example.spring_basic.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class NetworkClient {
    private String url;
    public NetworkClient(){
        System.out.println("call constructor, url: " + url);
        connect();
        call("initiation message");
    }

    public void setUrl(String url){
        this.url = url;
    }

    public void connect(){
        System.out.println("connect: " + url);
    }

    public void call(String message){
        System.out.println("call: " + url + " message: " + message);
    }

    public void disconnect(){
        System.out.println("close: " + url);
    }


}
