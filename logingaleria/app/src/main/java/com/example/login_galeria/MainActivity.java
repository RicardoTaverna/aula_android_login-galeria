package com.example.login_galeria;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    Button buttonGo;
    Boolean logar = false, cadastrar = false;
    EditText inputNome, inputSenha;
    Switch switchCadastro;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchCadastro = findViewById(R.id.switchCadastro);
        inputNome = findViewById(R.id.inputNome);
        inputSenha = findViewById(R.id.inputSenha);

        switchCadastro.setChecked(false);
        switchCadastro.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    cadastrar = true;
                } else {
                    logar = true;
                }
            }
        });

    }

    public void clickButtonGo(View v){
        if (logar){
            // get singleton para logar
            // direcionar para outra tela
            if (inputNome.equals("") || inputSenha.equals("")){
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Atenção");
                alert.setMessage("Usuário ou senha incorretos");
                AlertDialog dialog = alert.create();
                dialog.show();
            }

        } else if (cadastrar) {
            // set singleton para cadastrar
        }

    }
}
