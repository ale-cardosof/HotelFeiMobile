package com.example.alexandrecardoso.projetohotelfei.Classes;

import java.util.Date;

public class Reserva {

    private Date dtEntrada, dtSaida;
    private double valor;
    private Quarto quartoReserva;
    private boolean avaliada;
    private static int IDRESERVA = 0;
    private int idReserva = 0;
    private String usuario;
    private String quartoId;
    private boolean checkin = false;
    private boolean checkout = false;

    public Reserva(){

    }

    public Reserva(String usuario, Date dtEntrada,Date dtSaida, Quarto quartoReserva, double valor, String quartoId){
        this.dtEntrada = dtEntrada;
        this.dtSaida = dtSaida;
        this.quartoReserva = quartoReserva;
        this.valor = valor;
        this.usuario = usuario;
        this.idReserva = IDRESERVA++;
        this.quartoId = quartoId;

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getDtEntrada() {
        return dtEntrada;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public Date getDtSaida() {
        return dtSaida;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Quarto getQuartoReserva() {
        return quartoReserva;
    }

    public boolean isCheckin() {
        return checkin;
    }

    public void setCheckin(boolean checkin) {
        this.checkin = checkin;
    }

    public boolean isCheckout() {
        return checkout;
    }

    public void setCheckout(boolean checkout) {
        this.checkout = checkout;
    }

    public String getQuartoId() {
        return quartoId;
    }

    public void setQuartoId(String quartoId) {
        this.quartoId = quartoId;
    }
}
