package com.example.alexandrecardoso.projetohotelfei.Estruturas_;

import android.util.Log;

// Estrutura de dados LDE
public class LDE<T> {

    private NoLDE<T> noPrim; // Primeiro No da LDE
    private int tam; // Tamanho da LDE

    /* 1 - Construtor que define e inicia as variaveis da LDE */
    public LDE() {
        noPrim = null;
        tam = 0;
    }

    /* 2 - Insere um No à LDE a partir do Objeto recebido */
    public void insere(T valor) {
        NoLDE<T> noAtual = new NoLDE<>();
        noAtual.setValor(valor);

        NoLDE<T> noProx = noPrim;
        NoLDE<T> noAnt = null;

        while (noPrim != null && noProx != null) {
            noAnt = noProx;
            noProx = noProx.getProx();
        }

        if (noAnt != null) {
            noAnt.setProx(noAtual);
        } else {
            noPrim = noAtual;
        }
        noAtual.setProx(noProx);

        tam++;
    }

    /* 3 - Retorna um objeto pelo indice */
    public T getByIndex(int i) {
        NoLDE<T> noAtual = noPrim;
        int iAtual = 0;
        while (noAtual != null) {
            if (i == iAtual)
                return noAtual.getValor();
            else if (iAtual > i)
                return null;
            noAtual = noAtual.getProx();
            iAtual++;
        }
        return null;
    }

    /* 4 - Imprime no LogCat (Para testes) */
    public void imprime() {
        NoLDE<T> noAtual = noPrim;

        while (noAtual != null) {
            Log.d("NOLDE", "Valor" + noAtual.getValor());
            noAtual = noAtual.getProx();
        }
    }

    /* 5 - Remove um No pelo indice */
    public boolean removeByIndex(int i) {
        if (i >= tam || i < 0)
            return false;

        NoLDE<T> noAtual = noPrim;
        NoLDE<T> noAnt = null;
        int iAtual = 0;
        while (noAtual != null) {
            if (i == iAtual) {
                if (noAnt != null)
                    noAnt.setProx(noAtual.getProx());
                else
                    noPrim = noAtual.getProx();
                noAtual = null;
                tam--;
                return true;
            }
            noAnt = noAtual;
            noAtual = noAtual.getProx();
            iAtual++;
        }
        return false;
    }

    /* 6 - Retorna o primeiro no No da LDE */
    NoLDE<T> getPrimeiroNo(){
        return noPrim;
    }

    /* 7 - Retorna o tamanho da funcao */
    public int getSize(){
        return tam;
    }
}

// No auxiliar usado na LDE
class No<T>{
    T valor;
    No<T> proximo;
    No<T> anterior;

    /* 1 - Construtor */
    No(T valorNo){
        valor = valorNo;
        proximo = anterior = null;
    }

    /* 2 - Getter's e Setter's */
    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public No<T> getProximo() {
        return proximo;
    }

    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }


}
