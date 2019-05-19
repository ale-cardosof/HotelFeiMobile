package com.example.alexandrecardoso.projetohotelfei.Telas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

//import com.example.alexandrecardoso.projetohotelfei.Adapters.AdapterAvaliacao;
//import com.example.alexandrecardoso.projetohotelfei.Adapters.AdapterQuartos;
import com.example.alexandrecardoso.projetohotelfei.Classes.Quarto;
import com.example.alexandrecardoso.projetohotelfei.R;

public class UsuarioExibirQuarto extends AppCompatActivity {

    public static Quarto quartoAtual;
    public static Quarto quartoExibido;
    private Button btnReservar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_exibir_quarto);

        getSupportActionBar().hide();

        btnReservar = findViewById(R.id.btnReservar);

        quartoExibido = quartoAtual;
        quartoAtual = null;
/*
        ((TextView)findViewById(R.id.lblNumCamas)).setText(String.valueOf(quartoExibido.getQntdCamas()));
        ((TextView)findViewById(R.id.lblDetalhes)).setText("Detalhes - Quarto : " +quartoExibido.getNumPorta());
        ((TextView)findViewById(R.id.lblPossuiTV)).setText(quartoExibido.isPossuiTv() ? "Sim" : "Não");
        ((TextView)findViewById(R.id.lblNumChuveiros)).setText(String.valueOf(quartoExibido.getQntdChuveiros()));
        ((TextView)findViewById(R.id.lblValorDiaria)).setText(String.valueOf(quartoExibido.getValorDiaria()));

        ViewPager vpExibeQuarto = findViewById(R.id.vpExibeQuarto);
        vpExibeQuarto.setAdapter(new AdapterQuartos(UsuarioExibirQuarto.this, quartoExibido));

        ListView lvAvaliacoes = findViewById(R.id.lvAvaliacoes);
        ArrayAdapter adapter = new AdapterAvaliacao(this, quartoExibido.getAvaliacoes());
        lvAvaliacoes.setAdapter(adapter);

        // Seta o tamanho da ListView de acordo com o tamanho da lista

        ViewGroup.LayoutParams params = lvAvaliacoes.getLayoutParams();
        ((ViewGroup.LayoutParams) params).height = 750 * lvAvaliacoes.getCount();
        lvAvaliacoes.setLayoutParams(params);
        lvAvaliacoes.requestLayout();
*/
        btnReservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UsuarioExibirQuarto.this, UsuarioNovaReserva.class);
                UsuarioNovaReserva.quarto = quartoExibido;
                startActivity(intent);
            }
        });
    }
}
