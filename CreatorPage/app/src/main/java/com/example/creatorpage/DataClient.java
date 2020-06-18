package com.example.creatorpage;

import android.database.ContentObservable;

public class DataClient {

    private String NomeSite;
    private String ContatoSite;
    private String EmailSite;
    private String TelefoneSite;
    private String DescricaoSite;
    private String EmailVinculo;

    public  DataClient(String NomeSite, String ContatoSite, String EmailSite, String TelefoneSite, String DescricaoSite, String EmailVinculo){
        this.NomeSite = NomeSite;
        this.ContatoSite = ContatoSite;
        this.EmailSite = EmailSite;
        this.TelefoneSite = TelefoneSite;
        this.DescricaoSite = DescricaoSite;
        this.EmailVinculo = EmailVinculo;
    }

    public String getNomeSite() {
        return NomeSite;
    }

    public void setNomeSite(String nomeSite) {
        NomeSite = nomeSite;
    }

    public String getContatoSite() {
        return ContatoSite;
    }

    public void setContatoSite(String contatoSite) {
        ContatoSite = contatoSite;
    }

    public String getEmailSite() {
        return EmailSite;
    }

    public void setEmailSite(String emailSite) {
        EmailSite = emailSite;
    }

    public String getTelefoneSite() {
        return TelefoneSite;
    }

    public void setTelefoneSite(String telefoneSite) {
        TelefoneSite = telefoneSite;
    }

    public String getDescricaoSite() {
        return DescricaoSite;
    }

    public void setDescricaoSite(String descricaoSite) {
        DescricaoSite = descricaoSite;
    }

    public String getEmailVinculo() {
        return EmailVinculo;
    }

    public void setPageSelected(String emailVinculo) { EmailVinculo = emailVinculo; }
}
