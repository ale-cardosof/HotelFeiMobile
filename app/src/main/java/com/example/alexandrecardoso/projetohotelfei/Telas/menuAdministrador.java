package com.example.alexandrecardoso.projetohotelfei.Telas;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.alexandrecardoso.projetohotelfei.Classes.Estruturas;
import com.example.alexandrecardoso.projetohotelfei.R;

import static com.example.alexandrecardoso.projetohotelfei.Classes.Estruturas.tela;

public class menuAdministrador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_administrador);
        getSupportActionBar().hide();
    }

    public void checkincheckout(View view){
        Intent intent = new Intent(menuAdministrador.this, CheckInAdm.class);
        startActivity(intent);
    }

    public void cadastrarFunc(View view){
        Intent intent = new Intent(menuAdministrador.this, menuCadastroNovoFuncionario.class);
        startActivity(intent);
    }

    public void estruturaHotel(View view){
        Intent intent = new Intent(menuAdministrador.this, menuEstruturaHotel.class);
        startActivity(intent);
    }

    public void deslogar(View view){
        //Estruturas.logado.desloga();
        /* Logado com Sucesso */
        tela.exibir(getApplicationContext(),"Administrador deslogado com sucesso!");
        /* Voltando para o login do Adm */
        Intent intent = new Intent(menuAdministrador.this, loginAdm.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed(){
        boolean deslogar = true;
        new AlertDialog.Builder(this)
                .setTitle("Você esta prestes a deslogar.")
                .setMessage("Tem certeza que deseja deslogar?")
                .setPositiveButton("Sim",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Estruturas.logado.desloga();
                                /* Logado com Sucesso */
                                tela.exibir(getApplicationContext(),"Administrador deslogado com sucesso!");
                                /* Voltando para o login do Adm */
                                Intent intent = new Intent(menuAdministrador.this, loginAdm.class);
                                startActivity(intent);
                            }
                        })
                .setNegativeButton("Não", null)
                .show();
    }

}
