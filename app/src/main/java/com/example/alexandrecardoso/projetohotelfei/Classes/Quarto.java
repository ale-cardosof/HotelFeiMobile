package com.example.alexandrecardoso.projetohotelfei.Classes;

import android.graphics.Bitmap;


public class Quarto {
    private int numPorta; // Chave
    private double valorDiaria;
    private float mediaAvaliacao = -1;
    private int qntdCamas;
    private int qntdChuveiros;
    private boolean possuiTv;


    /*
    private LDE<Avaliacao> ldeAvaliacoes = new LDE<>();
    private LES<Bitmap> lesImagens = new LES<>();

    public Quarto(){
        this.numPorta = 0;
    }

    public Quarto(int numeroPorta, double valorDiaria, int qntdCamas, int qntdChuveiro, boolean possuiTv) {
        this.numPorta = numeroPorta;
        this.valorDiaria = valorDiaria;
        this.qntdCamas = qntdCamas;
        this.qntdChuveiros = qntdChuveiro;
        this.possuiTv = possuiTv;
    }

    private float calculaMedia(){
        float media = 0;
        int nAval = ldeAvaliacoes.getSize();
        for(int i = 0; i < nAval; i++ ){
            media += ldeAvaliacoes.getByIndex(i).getNota();
        }
        return media/nAval;
    }

    public LDE<Avaliacao> getAvaliacoes() {
        return ldeAvaliacoes;
    }

    public void setAvaliacoes(Avaliacao avaliacao) {
        this.ldeAvaliacoes.insere(avaliacao);
        mediaAvaliacao = calculaMedia();
    }

    public int getNumPorta() {
        return numPorta;
    }

    public void setNumPorta(int numPorta) {
        this.numPorta = numPorta;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public int getQntdCamas() {
        return qntdCamas;
    }

    public void setQntdCamas(int qntdCamas) {
        this.qntdCamas = qntdCamas;
    }

    public int getQntdChuveiros() {
        return qntdChuveiros;
    }

    public void setQntdChuveiros(int qntdChuveiros) {
        this.qntdChuveiros = qntdChuveiros;
    }

    public boolean isPossuiTv() {
        return possuiTv;
    }

    public void setPossuiTv(boolean possuiTv) {
        this.possuiTv = possuiTv;
    }

    public void adicionaImagem(Bitmap foto, int position) {
        this.lesImagens.insere(foto,position);
    }

    public Bitmap retornaImagem(int position){
        return lesImagens.busca(position);
    }

    public LES<Bitmap> getLesImagens() {
        return lesImagens;
    } */
}
