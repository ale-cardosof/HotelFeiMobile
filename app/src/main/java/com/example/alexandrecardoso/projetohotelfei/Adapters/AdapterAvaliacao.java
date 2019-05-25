package com.example.alexandrecardoso.projetohotelfei.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.alexandrecardoso.projetohotelfei.Classes.Avaliacao;
import com.example.alexandrecardoso.projetohotelfei.Estruturas_.LDE;
import com.example.alexandrecardoso.projetohotelfei.R;

// Classe que ira gerar itens da list View de Avaliação a partir da LDE
public class AdapterAvaliacao extends ArrayAdapter<Avaliacao> {
    // Variaveis globais
    private final Context context;
    private final LDE<Avaliacao> alAvaliacoes;

    // Construtor do Adapter de Avaliacao
    public AdapterAvaliacao(Context context, LDE<Avaliacao> alAvaliacoes) {
        super(context, R.layout.layout_usuario_reservas_item);
        this.context = context;
        this.alAvaliacoes = alAvaliacoes;
    }

    // Metodo que busca a Avaliação apatir da position recebida e retorna uma nova linha para a listView
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.layout_usuario_avaliacao_item, parent, false);


        Avaliacao avalAtual = alAvaliacoes.getByIndex(position);

        ((RatingBar)rowView.findViewById(R.id.ratingBar)).setRating(avalAtual.getNota());
        ((TextView)rowView.findViewById(R.id.lblNotaAvaliacao)).setText(String.valueOf(avalAtual.getNota()));
        ((TextView)rowView.findViewById(R.id.lblTituloAvaliacao)).setText(avalAtual.getTitulo());
        ((TextView)rowView.findViewById(R.id.lblMensagemAvaliacao)).setText(avalAtual.getMensagem());

        return rowView;
    }

    // Metodo que retorna o tamanho da LDE
    // Essencial para a atividade do getView
    @Override
    public int getCount() {
        return alAvaliacoes.getSize();
    }
}
