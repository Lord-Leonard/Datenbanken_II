package com.company.blatt_2.aufgabe_8.model;

public class Artikel {

    private Integer artikelnummer;
    private String bezeichnung;
    private Float netto;
    private Float steuer;
    private Float preis;
    private String farbe;
    private String mass;
    private String einheit;
    private String typ;

    public Integer getArtikelnummer() {
        return artikelnummer;
    }

    public void setArtikelnummer(Integer artikelnummer) {
        this.artikelnummer = artikelnummer;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung( String bezeichnung ) {
        this.bezeichnung = bezeichnung;
    }


    public Float getNetto() {
        return netto;
    }

    public void setNetto(Float netto) {
        this.netto = netto;
    }


    public Float getSteuer() {
        return steuer;
    }

    public void setSteuer(Float steuer) {
        this.steuer = steuer;
    }

    public Float getPreis() {
        return preis;
    }

    public void setPreis(Float preis) {
        this.preis = preis;
    }

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getEinheit() {
        return einheit;
    }

    public void setEinheit(String einheit) {
        this.einheit = einheit;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    @Override
    public String toString() {
        return "-------------------- Artikel --------------------" + "\n" +
                "Artikelnummer: " + artikelnummer + "\n" +
                "Bezeichnung: " + bezeichnung + "\n" +
                "Netto: " + netto + "\n" +
                "Steuer: " + steuer + "\n" +
                "Preis: " + preis + "\n" +
                "Farbe: " + farbe + "\n" +
                "Mass: " + mass + "\n" +
                "Einheit: " + einheit + "\n" +
                "Typ: " + typ + "\n" +
                "-------------------------------------------------";
    }
}
