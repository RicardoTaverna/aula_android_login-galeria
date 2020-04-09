package com.example.login_galeria;

public class Imagem {

    private String nome_imagem;
    private int imagemId;

    public Imagem(){}

    public Imagem(String nome_imagem, int imagemId) {

        this.nome_imagem = nome_imagem;
        this.imagemId = imagemId;

    }



    public String getNome_imagem() {

        return nome_imagem;
    }

    public void setNome_imagem(String nome_imagem) {
        this.nome_imagem = nome_imagem;
    }

    public int getImagemId() {
        return imagemId;
    }

    public void setImagemId(int imagemId) {
        this.imagemId = imagemId;
    }
}
