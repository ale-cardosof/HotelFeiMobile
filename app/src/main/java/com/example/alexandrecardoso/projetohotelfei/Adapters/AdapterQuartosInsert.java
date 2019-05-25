package com.example.alexandrecardoso.projetohotelfei.Adapters;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.alexandrecardoso.projetohotelfei.Classes.Quarto;
import com.example.alexandrecardoso.projetohotelfei.Estruturas_.LDE;
import com.example.alexandrecardoso.projetohotelfei.R;
import com.example.alexandrecardoso.projetohotelfei.Classes.Estruturas;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.File;
import java.net.URL;
import java.util.List;

import static com.example.alexandrecardoso.projetohotelfei.Telas.cadastroUser.referencia;


public class AdapterQuartosInsert extends RecyclerView.Adapter<AdapterQuartosInsert.MyViewHolder> {
    private List<Quarto> listaQuartos;
    private Context context;

    public  AdapterQuartosInsert(){}
    public AdapterQuartosInsert(List<Quarto> listaQuartos, Context context) {
        this.listaQuartos = listaQuartos;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemLista = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_lista, viewGroup, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Quarto quarto = listaQuartos.get(i);
        myViewHolder.numeroPorta.setText("Numero da porta: " +quarto.getNumPorta());
        myViewHolder.valorDiaria.setText("Valor da diária: R$"+quarto.getValorDiaria());
        myViewHolder.quantidadeCama.setText("Quantidade de cama:" + quarto.getQntdCamas());
        myViewHolder.quantidadeChuveiro.setText("Numero de chuveiro:" + quarto.getQntdChuveiros());
        if(quarto.isPossuiTv())
            myViewHolder.possuiTV.setText("Possui TV");
        else
            myViewHolder.possuiTV.setText("Não possui TV");
        //Uri uri1 = Uri.parse(quarto.getFotoUrl1());
//        Uri uri2 = Uri.parse(quarto.getFotoUrl2());
  //      Uri uri3 = Uri.parse(quarto.getFotoUrl3());
    //    Uri uri4 = Uri.parse(quarto.getFotoUrl4());
      //  Uri uri5 = Uri.parse(quarto.getFotoUrl5());
        //Glide.with(context).load(quarto.getFotoUrl1()).into(myViewHolder.imgQuartos1);
        //Glide.with(context).load(uri2).into(myViewHolder.imgQuartos2);
        //Glide.with(context).load(uri3).into(myViewHolder.imgQuartos3);
        //Glide.with(context).load(uri4).into(myViewHolder.imgQuartos4);
        //Glide.with(context).load(uri5).into(myViewHolder.imgQuartos5);
//        Log.i("Imagem 1", quarto.getFotoUrl1());
        /*myViewHolder.imgQuartos1.setImageBitmap(quarto.retornaImagem(0));
        myViewHolder.imgQuartos2.setImageBitmap(quarto.retornaImagem(1));
        myViewHolder.imgQuartos3.setImageBitmap(quarto.retornaImagem(2));
        myViewHolder.imgQuartos4.setImageBitmap(quarto.retornaImagem(3));
        myViewHolder.imgQuartos5.setImageBitmap(quarto.retornaImagem(4)); */
    }

    @Override
    public int getItemCount() {

        return listaQuartos.size();
    }

    //Inner Class  - classe para armazenar os dados dentro de cada elemento de lista
    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView numeroPorta;
        TextView valorDiaria;
        TextView quantidadeCama;
        TextView quantidadeChuveiro;
        TextView possuiTV;
        ImageView imgQuartos1,imgQuartos2,imgQuartos3,imgQuartos4,imgQuartos5;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            numeroPorta = itemView.findViewById(R.id.txtPorta);
            valorDiaria = itemView.findViewById(R.id.txtDiaria);
            quantidadeCama = itemView.findViewById(R.id.txtCama);
            quantidadeChuveiro = itemView.findViewById(R.id.txtChuveiro);
            possuiTV = itemView.findViewById(R.id.txtTV);
            imgQuartos1 = itemView.findViewById(R.id.imgQuartos1);
            imgQuartos2 = itemView.findViewById(R.id.imgQuartos2);
            imgQuartos3 = itemView.findViewById(R.id.imgQuartos3);
            imgQuartos4 = itemView.findViewById(R.id.imgQuartos4);
            imgQuartos5 = itemView.findViewById(R.id.imgQuartos5);
        }
    }
}
