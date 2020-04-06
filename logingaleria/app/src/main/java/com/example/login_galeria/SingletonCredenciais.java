package com.example.login_galeria;

public class SingletonCredenciais {

    private static final SingletonCredenciais instance = new SingletonCredenciais();

    private SingletonCredenciais (){}

    static public SingletonCredenciais getInstance(){
        return instance;
    }

}
