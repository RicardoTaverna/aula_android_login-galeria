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
    Boolean logar = true, cadastrar = false;
    EditText inputNome, inputSenha;
    Switch switchCadastro;
    String nome, senha;
    Usuario u;


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
                    logar = false;
                } else {
                    logar = true;
                    cadastrar = false;
                }
            }
        });

    }

    public void clickButtonGo(View v){
        u = new Usuario();
        nome = inputNome.getText().toString();
        senha = inputSenha.getText().toString();

        if (logar){
            if (senha.matches("") || senha.matches("")){
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Atenção");
                alert.setMessage("Usuário ou senha incorretos");
                AlertDialog dialog = alert.create();
                dialog.show();
            }
            u.setNome(nome);
            u.setSenha(senha);

            if (SingletonCredenciais.getInstance().checkAutenticado(u)){
                //direciona para segunda tela
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Deu boa");
                alert.setMessage("Usuário autenticado");
                AlertDialog dialog = alert.create();
                dialog.show();
            } else {
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Atenção");
                alert.setMessage("Usuário ou senha incorretos");
                AlertDialog dialog = alert.create();
                dialog.show();
            }

        } else if (cadastrar) {
            u.setNome(nome);
            u.setSenha(senha);
            SingletonCredenciais.getInstance().setUsuario(u);

            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Cadastro Realizado");
            alert.setMessage("Mude o switch para logar agora!");
            AlertDialog dialog = alert.create();
            dialog.show();

        }

    }
}
