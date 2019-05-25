package com.example.alexandrecardoso.projetohotelfei.Estruturas_;
import android.text.format.DateFormat;
import com.example.alexandrecardoso.projetohotelfei.Classes.Reserva;

import java.util.Calendar;
import java.util.Date;

public class HASH{
    // Vetor em que cada posição é uma LDE diferente e referencia um dia no mês
    private int MAX = 31;
    public NoLDE_Reserva vetorHash[] = new NoLDE_Reserva[MAX];

    /* 0 - Construtor */
    public HASH(){
    }

    /* 1 - Insere */
    public boolean insereHash(Reserva x){
        // Função Hash
        int posicao = this.hash(x);
        // Inserção
        if (vetorHash[posicao] == null)
            vetorHash[posicao] = new NoLDE_Reserva();
        vetorHash[posicao].insereNo(x);
        return true;
    }

    /* 2 - Método Hash */
    public int hash(Reserva x){
        int dia  = Integer.parseInt((String)DateFormat.format("dd", x.getDtEntrada()));
        return ( dia % MAX);
    }

    /* 3 - Método Busca (por Reserva) */
    public Reserva busca(Reserva x){
        int posicaoHash = this.hash(x);
        return (vetorHash[posicaoHash].getByValor(x)); // Busca pelo valor e traz No
    }

    /* 4 - Método Remove (por reserva) */
    public boolean remove(Reserva x){
        int posicaoHash = this.hash(x);
        return (vetorHash[posicaoHash].removeByNo(x)); // Remove pelo valor e retorna int
    }

    /* 5 - Método que retorna as reservas do ano inteiro */
    public LDE<Reserva> getTodasReservas(){
        LDE<Reserva> listaReserva = new LDE<>();
        for(int i = 0; i < MAX; i++){
            if(vetorHash[i] != null) {
                No<Reserva> reserAux = vetorHash[i].getByIndex(0);
                while (reserAux != null) {
                    if (reserAux.getValor() != null)
                        listaReserva.insere(reserAux.getValor());
                    reserAux = reserAux.getProximo();
                }
            }
        }
        return listaReserva; // Busca pelo valor e traz No
    }

    /* 6 - Método que captura a reserva "clicada" na tela de check-in */
    public Reserva getReservaAtual(int posicao){
        return getTodasReservas().getByIndex(posicao); // Busca pelo valor e traz No
    }

    /* 7 - Método que verifica a disponibilidade de um quarto especifico em um intervalo de datas */
    public boolean verificaDisponibilidade(Date dtEntrada, Date dtSaida, int numQuarto){
        LDE<Reserva> ldeTodasReservas = getTodasReservas();
        NoLDE<Reserva> resAtual = ldeTodasReservas.getPrimeiroNo();
        Calendar cDtEntradaNovaReserva = Calendar.getInstance();
        Calendar cDtSaidaNovaReserva = Calendar.getInstance();
        Calendar cDtEntradaReservaAtual = Calendar.getInstance();
        Calendar cDtSaidaReservaAtual = Calendar.getInstance();
        while (resAtual != null){
            if (resAtual.getValor().getQuartoReserva().getNumPorta() == numQuarto) {
                cDtEntradaNovaReserva.setTime(dtEntrada);
                cDtSaidaNovaReserva.setTime(dtSaida);
                cDtEntradaReservaAtual.setTime(resAtual.getValor().getDtEntrada());
                cDtSaidaReservaAtual.setTime(resAtual.getValor().getDtSaida());

                if (cDtEntradaNovaReserva.equals(cDtEntradaReservaAtual)
                || cDtSaidaNovaReserva.equals(cDtSaidaReservaAtual))
                    return false;

                else if ((resAtual.getValor().getDtEntrada().before(dtEntrada)
                && resAtual.getValor().getDtSaida().after(dtEntrada))
                || (resAtual.getValor().getDtEntrada().before(dtSaida)
                        && resAtual.getValor().getDtSaida().after(dtSaida)))
                    return false;

                else if ((dtEntrada.before(resAtual.getValor().getDtEntrada())
                        && dtSaida.after(resAtual.getValor().getDtEntrada()))
                        || (dtEntrada.before(resAtual.getValor().getDtSaida())
                        && dtSaida.after(resAtual.getValor().getDtSaida())))
                    return false;
            }
            resAtual = resAtual.getProx();
        }
        return true;
    }
}