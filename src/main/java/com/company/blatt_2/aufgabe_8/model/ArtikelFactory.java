package com.company.blatt_2.aufgabe_8.model;

import com.company.modelclassexample.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtikelFactory {

    public static Artikel getArtikel(ResultSet rs) throws SQLException {
        Artikel artikel = new Artikel();
        artikel.setArtikelnummer( rs.getInt( "Anr" ) );
        artikel.setBezeichnung( rs.getString( "Bezeichnung" ) );
        artikel.setNetto( rs.getFloat( "Netto" ) );
        artikel.setSteuer( rs.getFloat( "Steuer" ) );
        artikel.setPreis( rs.getFloat( "Preis" ) );
        artikel.setFarbe( rs.getString("Farbe"));
        artikel.setMass( rs.getString("Mass"));
        artikel.setEinheit( rs.getString("Einheit"));
        artikel.setTyp( rs.getString("Typ"));

        return artikel;
    }

}
