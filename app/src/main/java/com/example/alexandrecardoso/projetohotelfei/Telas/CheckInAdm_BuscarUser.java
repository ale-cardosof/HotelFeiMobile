package com.example.alexandrecardoso.projetohotelfei.Telas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

//import com.example.alexandrecardoso.projetohotelfei.Adapters.AdapterReservaAdm;
import com.example.alexandrecardoso.projetohotelfei.Classes.Estruturas;
import com.example.alexandrecardoso.projetohotelfei.Classes.Usuario;
import com.example.alexandrecardoso.projetohotelfei.R;

public class CheckInAdm_BuscarUser extends AppCompatActivity {
    TextView userCliente;
    ListView listView;
    ArrayAdapter adapter;
    Usuario userBuscado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in_adm__buscar_user);
        getSupportActionBar().hide();
        userCliente = findViewById(R.id.userCliente);
        listView = findViewById(R.id.lvReservaUsuario);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CheckInAdm_BuscarUser.this, CheckAdmRealiza.class);
                //Estruturas.reserva_clicada = userBuscado.getMinhasReservas(position);
                startActivity(intent);
            }
        });
    }
/*
    public void buscarCliente(View view){
        String usernameBuscado = userCliente.getText().toString();
        userBuscado = Estruturas.usuariosCadastrados.busca(usernameBuscado);
        if (userBuscado == null){
            // Usuário não existe
            Estruturas.tela.exibir(getApplicationContext(),"Usuário não existe.");
        }else{
            if(userBuscado.getQntReservas() == 0){
                // Usuário existe, porém não tem nenhuma reserva
                adapter = new AdapterReservaAdm(this, userBuscado.getMinhasReservas());
                listView.setAdapter(adapter);
                Estruturas.tela.exibir(getApplicationContext(),"O usuário " + userBuscado.getNome() + " não possui nenhuma reserva pendente.");
            }else{
                // Usuário existe e possui alguma reserva
                adapter = new AdapterReservaAdm(this, userBuscado.getMinhasReservas());
                listView.setAdapter(adapter);
                Estruturas.tela.exibir(getApplicationContext(),"Estas são as reservas de " + userBuscado.getNome() + ".");
            }
        }
    } */

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(CheckInAdm_BuscarUser.this, CheckInAdm.class);
        startActivity(intent);
    }

}
