package com.example.alexandrecardoso.projetohotelfei.Telas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.alexandrecardoso.projetohotelfei.R;
import com.example.alexandrecardoso.projetohotelfei.Classes.Estruturas;

public class CheckAdmRealiza extends AppCompatActivity {
    TextView nomeDoUsuario, idReserva, statusReserva, alteracao;
    String reserva,alteracaoT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_adm_realiza);
        getSupportActionBar().hide();
        nomeDoUsuario = findViewById(R.id.nomeDoUsuario);
        idReserva = findViewById(R.id.idReserva);
        statusReserva = findViewById(R.id.statusReserva);
        alteracao = findViewById(R.id.alteracao);
        /*
        // Pega as informações da Reserva Clicada e troca
        nomeDoUsuario.setText(Estruturas.reserva_clicada.getUsuario());
        idReserva.setText(Integer.toString(Estruturas.reserva_clicada.getIdReserva()));
        // Verifica qual o status atual
        if((!(Estruturas.reserva_clicada.isCheckin())) && (!(Estruturas.reserva_clicada.isCheckout()))){
            // Nesse caso, é apenas reserva
            reserva = "Reservado.";
            statusReserva.setText(reserva);
            alteracaoT = "De: Reserva Para: Check-IN";
            alteracao.setText(alteracaoT);
        }else if(((Estruturas.reserva_clicada.isCheckin())) && (!(Estruturas.reserva_clicada.isCheckout()))){
            // Nesse caso já foi feito checkIn
            reserva = "Check-in já realizado.";
            statusReserva.setText(reserva);
            alteracaoT = "De: Check-IN Para: Check-OUT";
            alteracao.setText(alteracaoT);
        }else if(((Estruturas.reserva_clicada.isCheckout()))){
            // Nesse caso já foi feito checkOut
            reserva = "Check-Out já realizado.";
            statusReserva.setText(reserva);
            alteracaoT = "Nenhuma.";
            alteracao.setText(alteracaoT);
        } */
    }

    /*public void mudaStatus(View view){
        if((!(Estruturas.reserva_clicada.isCheckin())) && (!(Estruturas.reserva_clicada.isCheckout()))){
            // Nesse caso, é apenas reserva, fazendo check-in
            Estruturas.reserva_clicada.setCheckin(true);
            Estruturas.tela.exibir(getApplicationContext(),"Check-In realizado com sucesso!");
        }else if(((Estruturas.reserva_clicada.isCheckin())) && (!(Estruturas.reserva_clicada.isCheckout()))){
            // Nesse caso já foi feito checkIn, fazendo check-out
            Estruturas.reserva_clicada.setCheckout(true);
            Estruturas.tela.exibir(getApplicationContext(),"Check-Out realizado com sucesso!");
        }else if(((Estruturas.reserva_clicada.isCheckout()))){
            // Nesse caso já foi feito checkOut, fechando o pedido
            Estruturas.tela.exibir(getApplicationContext(),"Esta reserva já foi finalizada!");
        }
    } */

    public void onBackPressed(){
        Intent intent = new Intent(CheckAdmRealiza.this, CheckInAdm.class);
        startActivity(intent);
    }
}
