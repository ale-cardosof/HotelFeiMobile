package com.example.alexandrecardoso.projetohotelfei.Telas;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

//import com.example.alexandrecardoso.projetohotelfei.Adapters.AdapterQuartos;
import com.example.alexandrecardoso.projetohotelfei.Adapters.AdapterQuartos;
import com.example.alexandrecardoso.projetohotelfei.Classes.Estruturas;
import com.example.alexandrecardoso.projetohotelfei.Classes.Quarto;
import com.example.alexandrecardoso.projetohotelfei.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.example.alexandrecardoso.projetohotelfei.Telas.menuEstruturaHotel.quartosref;

public class UsuarioBuscarQuarto extends AppCompatActivity {
    private ViewPager vpBuscaQuarto;
    private List<Quarto> quartosL = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_buscar_quartos);
        getSupportActionBar().hide();
        vpBuscaQuarto = findViewById(R.id.vpBuscaQuarto);
        Button btnVisuQuarto = findViewById(R.id.btnVisuQuarto);
        vpBuscaQuarto.setAdapter(new AdapterQuartos(UsuarioBuscarQuarto.this,quartosL ));
        pesquisaQuartos("Disponivel");



        btnVisuQuarto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UsuarioBuscarQuarto.this, UsuarioExibirQuarto.class);
                UsuarioExibirQuarto.quartoAtual = quartosL.get(vpBuscaQuarto.getCurrentItem());
                startActivity(intent);
            }
        });
    }

    public void pesquisaQuartos(String texto){
        Query query = quartosref.orderByChild("status").startAt(texto).endAt(texto + "\uf8ff");

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    quartosL.add(ds.getValue(Quarto.class));
                }
            //vpBuscaQuarto.notify();
                int total = quartosL.size();
                Log.i("totalQuartos", "total " + total);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
