package com.example.alexandrecardoso.projetohotelfei.Estruturas_;

import com.example.alexandrecardoso.projetohotelfei.Classes.Reserva;

public class NoLDE_Reserva {

    private Reserva valor;
    private No<Reserva>  noPrim;
    private int tam;

    /* 0 - Construtor */
    public NoLDE_Reserva() {
        this.valor = null;
        this.noPrim = null;
    }

    /* 1 - Getter's e Setter's */
    public Reserva getValor() {
        return valor;
    }

    public void setValor(Reserva valor) {
        this.valor = valor;
    }

    /* 2 - Insere um No à LDE a partir do Objeto recebido */
    void insereNo(Reserva valor) {
        No<Reserva>  noAtual = new No<>(valor);
        noAtual.setValor(valor);

        No<Reserva>  noProx = noPrim;
        No<Reserva>  noAnt = null;

        while (noProx != null) {
            noAnt = noProx;
            noProx = noProx.getProximo();
        }
        if (noAnt != null) {
            noAnt.setProximo(noAtual);
        } else {
            noPrim = noAtual;
        }
        tam++;
    }

    /* 3 - Retorna um objeto pelo indice */
    No<Reserva> getByIndex(int i) { ;
        No<Reserva> noAtual = noPrim;
        int iAtual = 0;
        while (noAtual != null) {
            if (i == iAtual) {
                return noAtual;
            }
            else if (iAtual > i) {
                return null;
            }
            noAtual = noAtual.getProximo();
            iAtual++;
        }
        return null;
    }

    /* 4 - Retorna uma Reserva */
    Reserva getByValor(Reserva noBusca) {
        No<Reserva> noAtual = noPrim;
        while (noAtual != null) {
            if (noBusca == noAtual.getValor())
                return noAtual.getValor();
            noAtual = noAtual.getProximo();
        }
        return null;
    }

    /* 5 - Remove uma Reserva */
    boolean removeByNo(Reserva noRemove) {

        No<Reserva> noAtual = noPrim;
        No<Reserva> noAnt = null;

        while (noAtual != null) {
            if (noRemove == noAtual.getValor()) {
                if (noAnt != null)
                    noAnt.setProximo(noAtual.getProximo());
                else
                    noPrim = noAtual.getProximo();
                noAtual = null;
                tam--;
                return true;
            }
            noAnt = noAtual;
            noAtual = noAtual.getProximo();
        }
        return false;
    }

}
