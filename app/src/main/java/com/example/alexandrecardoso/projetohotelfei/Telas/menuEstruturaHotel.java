package com.example.alexandrecardoso.projetohotelfei.Telas;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

//import com.example.alexandrecardoso.projetohotelfei.Utilizardps.AdapterQuartosInsert;
import com.example.alexandrecardoso.projetohotelfei.Adapters.AdapterQuartosInsert;
import com.example.alexandrecardoso.projetohotelfei.Classes.Estruturas;
import com.example.alexandrecardoso.projetohotelfei.Classes.Quarto;
import com.example.alexandrecardoso.projetohotelfei.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.example.alexandrecardoso.projetohotelfei.Telas.cadastroUser.referencia;
//import com.example.alexandrecardoso.projetohotelfei.Adapters.RecyclerItemClickListener;

public class menuEstruturaHotel extends AppCompatActivity {
    public static DatabaseReference quartosref = referencia.child("quartos");
    public static int numeroQuarto;

    private RecyclerView listHoteis;
    private List<Quarto> quartos = new ArrayList<>();
    private AdapterQuartosInsert adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_estrutura_hotel);
        getSupportActionBar().hide();
        pesquisaQuartos("Disponivel");
        listHoteis = findViewById(R.id.recyclerHotel);

        //Configuraando adapter
        adapter = new AdapterQuartosInsert(quartos,getApplicationContext());
        //Configurar recyclerview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        listHoteis.setLayoutManager(layoutManager);
        listHoteis.setHasFixedSize(true);
        listHoteis.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        listHoteis.setAdapter(adapter);


        /*/Eventos de click
        listHoteis.addOnItemTouchListener(
            new RecyclerItemClickListener(
                    getApplicationContext(),
                    listHoteis,
                    new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            menuOpcoes(position);
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

                        }

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        }
                    }
            )
        ); */

    }

    public void menuInsercao(View view){
        Intent intent = new Intent(menuEstruturaHotel.this, menuInsercaoQuarto.class);
        startActivity(intent);
    }

    public void pesquisaQuartos(String texto){
        Query query = quartosref.orderByChild("status").startAt(texto).endAt(texto + "\uf8ff");

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    quartos.add(ds.getValue(Quarto.class));
                }
                adapter.notifyDataSetChanged();
                int total = quartos.size();
                Log.i("totalQuartos", "total " + total);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void menuOpcoes(final int position){
        //Alert Dialog
        AlertDialog.Builder dialog = new  AlertDialog.Builder(this);

        //Configurar titulo e msg
        dialog.setTitle("Menu de opções");
        dialog.setMessage("O que deseja fazer?");

        //Configura acoes para botão sim ou nao
        dialog.setPositiveButton("Alterar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //numeroQuarto = Estruturas.ldeQuartos.getByIndex(position).getNumPorta();
                Log.d("Valor", ""+numeroQuarto);
                Intent intent = new Intent(menuEstruturaHotel.this, menuAlterarQuarto.class);
                startActivity(intent);

            }
        });
        dialog.setNegativeButton("Excluir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"O quarto foi excluido.",
                        Toast.LENGTH_SHORT).show();
                //Estruturas.ldeQuartos.removeByIndex(position);
                Intent intent = new Intent(menuEstruturaHotel.this, menuEstruturaHotel.class);
                startActivity(intent);
            }
        });

        //Configura cancelamento
        dialog.setCancelable(true);

        //configurar icone

        dialog.setIcon(android.R.drawable.ic_dialog_alert);
        dialog.create();
        dialog.show();
    }

    public void atualizaAc(View v){
        finish();

        startActivity(getIntent());
    }

    public void onBackPressed(){
        Intent intent = new Intent(menuEstruturaHotel.this, menuAdministrador.class);
        startActivity(intent);
    }
}
