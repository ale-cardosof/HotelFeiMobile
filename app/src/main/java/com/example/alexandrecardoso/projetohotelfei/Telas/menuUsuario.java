package com.example.alexandrecardoso.projetohotelfei.Telas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.alexandrecardoso.projetohotelfei.Classes.Estruturas;
import com.example.alexandrecardoso.projetohotelfei.R;

public class menuUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Inicia o Programa na Tela de seleção de Usuário
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_usuario);
        // Retira barra superior com o nome do app
        getSupportActionBar().hide();
        // Cria Estruturas Iniciais do programa
        /*if(!Estruturas.criado){
            Estruturas.criaEstru();
        }*/

    }

    public void abrirTelaADM(View view){
        Intent intent = new Intent(menuUsuario.this, loginAdm.class);
        startActivity(intent);

    }

    public void abrirTelaCliente(View view){
        Intent intent = new Intent(menuUsuario.this, loginUser.class);
        startActivity(intent);
    }

}
