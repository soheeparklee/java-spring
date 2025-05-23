package com.example.spring_basic.singleton;

public class SingletonService {
    private static final SingletonService instance = new SingletonService();

    private SingletonService(){} //private constructor, cannot create from outside

    public static SingletonService getInstance(){ //only accessible through getter
        return instance;
    }

    public void logic(){
        System.out.println("print singleton object");
    }
}
