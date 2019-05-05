package com.example.alexandrecardoso.projetohotelfei;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CheckInAdm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in_adm);
        getSupportActionBar().hide();
    }

    public void buscarUser(View view){
        Intent intent = new Intent(this, CheckInAdm_BuscarUser.class);
        startActivity(intent);
    }
    public void listarReservas(View view){
        Intent intent = new Intent(this, CheckInAdm_listar.class);
        startActivity(intent);
    }
}