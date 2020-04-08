package com.example.login_galeria;

import java.util.ArrayList;

public class SingletonCredenciais {

    private static SingletonCredenciais instance = null;
    private ArrayList<Usuario> lista;

    private SingletonCredenciais (){
        lista = new ArrayList<Usuario>();
    }

    public static SingletonCredenciais getInstance(){
        if (instance == null){
            instance = new SingletonCredenciais();
        }

        return instance;
    }

    public ArrayList<Usuario> getUsuario() {
        return this.lista;
    }

    public void setUsuario(Usuario u) {
        this.lista.add(u);
    }

    public boolean checkAutenticado(Usuario u){
        for (int i = 0; i < lista.size(); i++){
            if(lista.get(i).getNome().equals(u.getNome()) && lista.get(i).getSenha().equals(u.getSenha())){
                return true;
            }
        }

        return false;

    }
}
