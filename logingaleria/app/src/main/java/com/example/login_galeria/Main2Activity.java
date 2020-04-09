package com.example.login_galeria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    ImageView imageViewMain;
    TextView textViewTitle,textViewIndex;

    Imagem i,x,j;
    int[] array = {R.drawable.pikachu1, R.drawable.pikachu2, R.drawable.pikachu3};
    ArrayList<Imagem> imagem;
    int cont = 0;
    int tamanho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageViewMain = findViewById(R.id.imageViewMain);
        textViewTitle = (TextView) findViewById(R.id.textViewTitle);
        textViewIndex = (TextView) findViewById(R.id.textViewIndex);
        i = new Imagem();
        x = new Imagem();
        j = new Imagem();
        i.setNome_imagem("Pikachu A");
        i.setImagemId(R.drawable.pikachu1);
        SingletonImagem.getInstance().setImagem(i);
        x.setNome_imagem("Pikachu B");
        x.setImagemId(R.drawable.pikachu2);
        SingletonImagem.getInstance().setImagem(x);
        j.setNome_imagem("Pikachu C");
        j.setImagemId(R.drawable.pikachu3);
        SingletonImagem.getInstance().setImagem(j);

        i = SingletonImagem.getInstance().getImagem(cont);
        imageViewMain.setImageResource(i.getImagemId());
        textViewTitle.setText(i.getNome_imagem());
        tamanho = cont + 1;
        textViewIndex.setText(tamanho + " | " + SingletonImagem.getInstance().tamanho());




    }


    public void proximo(View v) {
        cont = cont +1;
        if(cont  > 2){
            cont = 2;
        }
        tamanho = cont+1;
        i = SingletonImagem.getInstance().getImagem(cont);

        imageViewMain.setImageResource(i.getImagemId());


        textViewTitle.setText(i.getNome_imagem());
        textViewIndex.setText(tamanho + " | " + SingletonImagem.getInstance().tamanho());


    }

    public void anterior(View v ) {
        cont = cont -1;
        if(cont < 0)   {
            cont = 0;
        }
        tamanho = cont +1;
        i = SingletonImagem.getInstance().getImagem(cont);
        imageViewMain.setImageResource(i.getImagemId());

        textViewTitle.setText(i.getNome_imagem());
        textViewIndex.setText(tamanho + " | " + SingletonImagem.getInstance().tamanho());
    }


}
