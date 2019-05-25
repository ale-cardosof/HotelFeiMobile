package com.example.alexandrecardoso.projetohotelfei.Telas;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.alexandrecardoso.projetohotelfei.Adapters.ReservaAdapter;
import com.example.alexandrecardoso.projetohotelfei.Classes.Estruturas;
import com.example.alexandrecardoso.projetohotelfei.Classes.Quarto;
import com.example.alexandrecardoso.projetohotelfei.Classes.Usuario;
import com.example.alexandrecardoso.projetohotelfei.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.example.alexandrecardoso.projetohotelfei.Telas.cadastroUser.usuario_cad;
import static com.example.alexandrecardoso.projetohotelfei.Telas.cadastroUser.usuarios;
import static com.example.alexandrecardoso.projetohotelfei.Telas.menuEstruturaHotel.quartosref;
//import com.example.alexandrecardoso.projetohotelfei.Adapters.ReservaAdapter;

public class UsuarioReservas extends AppCompatActivity {
    private List<Quarto> quartosU = new ArrayList<>();
    ArrayAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_reservas);
        ListView listView = findViewById(R.id.lvUsuarioReserva);
        getSupportActionBar().hide();
        adapter = new ReservaAdapter(this, quartosU);

        listView.setAdapter(adapter);
        pesquisaQuartos(usuario_cad.getUid());

       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(UsuarioReservas.this, UsuarioAvaliacao.class);
                int i = 0;
                Quarto ptrQuarto = quartosU.get(i);
                int quartoNum = ptrQuarto.getNumPorta();
                Log.d("RESERVA", "UsuarioReserva");
                while (ptrQuarto != null && ptrQuarto.getNumPorta()!= quartoNum) {
                    i++;
                    ptrQuarto = quartosU.get(i);
                }
                if (ptrQuarto != null) {
                    UsuarioAvaliacao.quartoStatic = ptrQuarto;
                    startActivity(intent);
                }
            }
        });
    }

    public void pesquisaQuartos(String texto){
        Query query = usuarios.orderByChild("codPessoa").startAt(texto).endAt(texto + "\uf8ff");

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    quartosU.add(ds.getValue(Quarto.class));
                }
                adapter.notifyDataSetChanged();
                int total = quartosU.size();
                Log.i("totalQuartos", "total " + total);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}