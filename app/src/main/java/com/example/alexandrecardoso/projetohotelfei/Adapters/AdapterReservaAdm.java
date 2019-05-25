package com.example.alexandrecardoso.projetohotelfei.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alexandrecardoso.projetohotelfei.Classes.Reserva;
import com.example.alexandrecardoso.projetohotelfei.Estruturas_.LDE;
import com.example.alexandrecardoso.projetohotelfei.R;

import java.text.DateFormat;

public class AdapterReservaAdm extends ArrayAdapter<Reserva> {

    private final Context context;
    private final LDE<Reserva> ldeReserva;
    private Reserva reservaAtual;

    public AdapterReservaAdm(Context context, LDE<Reserva>  ldeReserva){
        super(context, R.layout.activity_check_in_adm__buscar_user);
        this.context = context;
        this.ldeReserva = ldeReserva;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(ldeReserva.getSize() == 0){
            return null;
        }else{
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.layout_checkin, parent, false);

            if (position % 2 == 0) {
                rowView.setBackgroundColor(Color.parseColor("#4D808080"));
            }
            else
                rowView.setBackgroundColor(Color.parseColor("#BFF0E68C"));

            DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(context.getApplicationContext());
            reservaAtual = ldeReserva.getByIndex(position);

           /* ((ImageView)rowView.findViewById(R.id.imvQuarto)).setImageBitmap(
                    reservaAtual.getQuartoReserva();


            ((TextView)rowView.findViewById(R.id.username3)).setText(String.valueOf(
                    reservaAtual.getUsuario()));

            ((TextView)rowView.findViewById(R.id.alteracao)).setText(String.valueOf(
                    reservaAtual.getIdReserva()));

            ((TextView)rowView.findViewById(R.id.idQuarto)).setText(String.valueOf(
                    reservaAtual.getQuartoReserva().getNumPorta()));

            ((TextView)rowView.findViewById(R.id.dtEntrada)).setText(dateFormat.format(
                    reservaAtual.getDtEntrada()));

            ((TextView)rowView.findViewById(R.id.dtSaida)).setText(dateFormat.format(
                    reservaAtual.getDtSaida())); */

            ((TextView)rowView.findViewById(R.id.dtCheckIn)).setText(reservaAtual.isCheckin() ? "Sim" : "Não");

            ((TextView)rowView.findViewById(R.id.dtCheckout)).setText(reservaAtual.isCheckout() ? "Sim" : "Não");

            ((TextView)rowView.findViewById(R.id.vlrTotal)).setText(String.valueOf(reservaAtual.getValor()));

            return rowView;
        }
    }

    @Override
    public int getCount() {
        return ldeReserva.getSize();
    }

}
