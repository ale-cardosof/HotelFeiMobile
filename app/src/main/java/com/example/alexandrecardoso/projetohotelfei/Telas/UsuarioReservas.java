package com.example.alexandrecardoso.projetohotelfei.Telas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.alexandrecardoso.projetohotelfei.Classes.Estruturas;
import com.example.alexandrecardoso.projetohotelfei.Classes.Quarto;
import com.example.alexandrecardoso.projetohotelfei.Classes.Usuario;
import com.example.alexandrecardoso.projetohotelfei.R;
//import com.example.alexandrecardoso.projetohotelfei.Adapters.ReservaAdapter;

public class UsuarioReservas extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_reservas);
        ListView listView = findViewById(R.id.lvUsuarioReserva);
        getSupportActionBar().hide();
        //ArrayAdapter adapter = new ReservaAdapter(this, ((Usuario) Estruturas.logado.user).getMinhasReservas());
       // listView.setAdapter(adapter);

      /*  listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(UsuarioReservas.this, UsuarioAvaliacao.class);
                int i = 0;
                Quarto ptrQuarto = Estruturas.ldeQuartos.getByIndex(i);
                int quartoNum = ((Usuario)(Estruturas.logado.user)).getMinhasReservas(position).getQuartoReserva().getNumPorta();
                Log.d("RESERVA", "UsuarioReserva");
                while (ptrQuarto != null && ptrQuarto.getNumPorta()!= quartoNum) {
                    i++;
                    ptrQuarto = Estruturas.ldeQuartos.getByIndex(i);
                }
                if (ptrQuarto != null) {
                    UsuarioAvaliacao.quartoStatic = ptrQuarto;
                    startActivity(intent);
                }
            }
        }); */
    }
}