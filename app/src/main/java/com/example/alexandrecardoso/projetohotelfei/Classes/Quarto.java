package com.example.alexandrecardoso.projetohotelfei.Classes;

import android.graphics.Bitmap;

import com.example.alexandrecardoso.projetohotelfei.Estruturas_.LDE;
import com.example.alexandrecardoso.projetohotelfei.Estruturas_.LES;

import java.util.ArrayList;
import java.util.List;

public class Quarto {
    private String codUserReserva;
    private String idQuarto;
    private int numPorta; // Chave
    private double valorDiaria;
    private float mediaAvaliacao = -1;
    private int qntdCamas;
    private int qntdChuveiros;
    private boolean possuiTv;
    private String fotoUrl1;
    private String fotoUrl2;
    private String fotoUrl3;
    private String fotoUrl4;
    private String fotoUrl5;
    private String status;
    private List<Reserva> minhasReservas = new ArrayList<Reserva>();
    //private LDE<Avaliacao> ldeAvaliacoes = new LDE<>();
    //private LES<Bitmap> lesImagens = new LES<>();

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

   /* private float calculaMedia(){
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
*/
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
    public String getFotoUrl1() {
        return fotoUrl1;
    }

    public void setFotoUrl1(String fotoUrl1) {
        this.fotoUrl1 = fotoUrl1;
    }

    public String getFotoUrl2() {
        return fotoUrl2;
    }

    public void setFotoUrl2(String fotoUrl2) {
        this.fotoUrl2 = fotoUrl2;
    }

    public String getFotoUrl3() {
        return fotoUrl3;
    }

    public void setFotoUrl3(String fotoUrl3) {
        this.fotoUrl3 = fotoUrl3;
    }

    public String getFotoUrl4() {
        return fotoUrl4;
    }

    public void setFotoUrl4(String fotoUrl4) {
        this.fotoUrl4 = fotoUrl4;
    }

    public String getFotoUrl5() {
        return fotoUrl5;
    }

    public void setFotoUrl5(String fotoUrl5) {
        this.fotoUrl5 = fotoUrl5;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(String idQuarto) {
        this.idQuarto = idQuarto;
    }

    public String getCodUserReserva() {
        return codUserReserva;
    }

    public void setCodUserReserva(String codUserReserva) {
        this.codUserReserva = codUserReserva;
    }

    public List<Reserva> getMinhasReservas() {
        return minhasReservas;
    }

    public void setMinhasReservas(Reserva minhasReservas) {
        this.minhasReservas.add(minhasReservas);
    }


    /*
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
