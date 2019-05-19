package com.example.alexandrecardoso.projetohotelfei.Telas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

//import com.example.alexandrecardoso.projetohotelfei.Adapters.AdapterReservaAdm;
import com.example.alexandrecardoso.projetohotelfei.Classes.Estruturas;
import com.example.alexandrecardoso.projetohotelfei.R;

public class CheckInAdm_listar extends AppCompatActivity {
    ListView listView;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in_adm_listar);
        getSupportActionBar().hide();
        listView = findViewById(R.id.lvReservaUsuario);
        /*
        adapter = new AdapterReservaAdm(this, Estruturas.hash_reservas.getTodasReservas());
        listView.setAdapter(adapter);
        Estruturas.tela.exibir(getApplicationContext(),"Exibindo todas as reservas realizadas. ");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CheckInAdm_listar.this, CheckAdmRealiza.class);
                Estruturas.reserva_clicada = Estruturas.hash_reservas.getReservaAtual(position);
                startActivity(intent);
            }
        }); */
    }

    public void onBackPressed(){
        Intent intent = new Intent(CheckInAdm_listar.this, CheckInAdm.class);
        startActivity(intent);
    }
}
