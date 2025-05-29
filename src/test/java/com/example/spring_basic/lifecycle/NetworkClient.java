package com.example.spring_basic.lifecycle;

import org.apache.catalina.util.ToStringUtil;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient implements InitializingBean, DisposableBean {
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

    @Override
    public void afterPropertiesSet() throws Exception { //의존관계 주입이 끝나면
        System.out.println("afterPropertiesSet ");
        connect();
        call("initialization mesage");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
        disconnect();
    }
}
