package com.example.alexandrecardoso.projetohotelfei.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alexandrecardoso.projetohotelfei.Classes.Quarto;
import com.example.alexandrecardoso.projetohotelfei.Classes.Reserva;
import com.example.alexandrecardoso.projetohotelfei.Classes.Usuario;
import com.example.alexandrecardoso.projetohotelfei.Estruturas_.LDE;
import com.example.alexandrecardoso.projetohotelfei.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import static com.example.alexandrecardoso.projetohotelfei.Telas.cadastroUser.usuario_cad;
import static com.example.alexandrecardoso.projetohotelfei.Telas.cadastroUser.usuarios;
import static com.example.alexandrecardoso.projetohotelfei.Telas.menuEstruturaHotel.quartosref;

public class ReservaAdapter extends ArrayAdapter<Quarto> {
    ArrayAdapter adapter;
    private final Context context;
    //private final LDE<Reserva> ldeReserva;
    private List<Quarto> quartosU = new ArrayList<>();
    private List<Usuario> usuariosU = new ArrayList<>();
    private Quarto quartoAtual;
    private Usuario usuarioAtual;

    public ReservaAdapter(Context context, List<Quarto> listaQuarto){
        super(context, R.layout.layout_usuario_reservas_item);
        this.context = context;
        this.quartosU = listaQuarto;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.layout_usuario_reservas_item, parent, false);

        if (position % 2 == 0) {
            rowView.setBackgroundColor(Color.parseColor("#4D808080"));
        }
        else
            rowView.setBackgroundColor(Color.parseColor("#BFF0E68C"));

        DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(context.getApplicationContext());
        quartoAtual = quartosU.get(position);


        //((ImageView)rowView.findViewById(R.id.imvQuarto)).setImageBitmap(
               // quartoAtual.getQuartoReserva().retornaImagem(0));
        ((TextView)rowView.findViewById(R.id.nomeDoUsuario)).setText(String.valueOf(
                quartoAtual.getNumPorta()));
       /*((TextView)rowView.findViewById(R.id.boolCheckIN)).setText(String.valueOf(
               quartoAtual.getMinhasReservas().get(position).isCheckin()));
        ((TextView)rowView.findViewById(R.id.idQuarto)).setText(dateFormat.format(
                quartoAtual.getMinhasReservas().get(position).getDtEntrada()));
        ((TextView)rowView.findViewById(R.id.dtEntrada)).setText(dateFormat.format(
                quartoAtual.getMinhasReservas().get(position).getDtSaida()));*/

        return rowView;
    }


    @Override
    public int getCount() {
        return quartosU.size();
    }
}
