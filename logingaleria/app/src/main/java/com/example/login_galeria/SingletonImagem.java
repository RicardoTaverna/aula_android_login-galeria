package com.example.login_galeria;

import java.util.ArrayList;

public class SingletonImagem {
    private static SingletonImagem instance = null;
    private ArrayList<Imagem> lista;

    private SingletonImagem (){

        lista = new ArrayList<Imagem>();
    }

    public static SingletonImagem getInstance(){
        if (instance == null){
            instance = new SingletonImagem();
        }

        return instance;
    }

    public Imagem  getImagem(int i) {

        return this.lista.get(i);
    }
    public void setImagem(Imagem i) {

        this.lista.add(i);
    }

    public int tamanho(){
        return this.lista.size();
    }

}
