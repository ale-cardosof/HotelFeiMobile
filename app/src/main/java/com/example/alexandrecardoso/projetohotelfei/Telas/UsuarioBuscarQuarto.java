package com.example.alexandrecardoso.projetohotelfei.Telas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

//import com.example.alexandrecardoso.projetohotelfei.Adapters.AdapterQuartos;
import com.example.alexandrecardoso.projetohotelfei.Classes.Estruturas;
import com.example.alexandrecardoso.projetohotelfei.R;

public class UsuarioBuscarQuarto extends AppCompatActivity {
    private ViewPager vpBuscaQuarto;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_buscar_quartos);
        getSupportActionBar().hide();
        vpBuscaQuarto = findViewById(R.id.vpBuscaQuarto);
        Button btnVisuQuarto = findViewById(R.id.btnVisuQuarto);
        //vpBuscaQuarto.setAdapter(new AdapterQuartos(UsuarioBuscarQuarto.this, Estruturas.ldeQuartos));

        btnVisuQuarto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UsuarioBuscarQuarto.this, UsuarioExibirQuarto.class);
                //UsuarioExibirQuarto.quartoAtual = Estruturas.ldeQuartos.getByIndex(vpBuscaQuarto.getCurrentItem());
                startActivity(intent);
            }
        });
    }
}
