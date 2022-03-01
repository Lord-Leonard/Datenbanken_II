package com.company.blatt_2.aufgabe_8;

import com.company.blatt_2.aufgabe_8.model.Artikel;
import com.company.blatt_2.aufgabe_8.model.ArtikelFactory;
import com.company.connection.ConnectionHelper;
import com.company.modelclassexample.Customer;

import java.sql.*;

public class Aufgabe_8 {

    public static void main( String[] args ) {
        try ( Connection con = ConnectionHelper.getConnection( "bike" ) ) {
            if ( con != null ) {
                try ( Statement stmt = con.createStatement() ) {
                    try ( ResultSet rs = stmt.executeQuery( "SELECT * FROM Artikel;" ) ) {
                        while ( rs.next() ) {
                            Artikel artikel = ArtikelFactory.getArtikel( rs );
                            System.out.println( artikel );

//                            System.out.println( "-------------------- artikel --------------------" );
//                            System.out.println( "Nummer: " + artikel.getArtikelnummer() );
//                            System.out.println( "Name: " + artikel.getBezeichnung() );
//                            System.out.println( "Straße: " + artikel.getNetto() );
//                            System.out.println( "PLZ: " + artikel.getSteuer() );
//                            System.out.println( "Ort: " + artikel.getPreis() );
//                            System.out.println( "Ort: " + artikel.getFarbe() );
//                            System.out.println( "Ort: " + artikel.getMass() );
//                            System.out.println( "Ort: " + artikel.getEinheit() );
//                            System.out.println( "Ort: " + artikel.getTyp() );
//                            System.out.println( "-----------------------------------------------" );
                        }
                    }
                }
            }
        } catch ( SQLException e ) {
            System.err.println( "Error during ExerciseA!" );
            e.printStackTrace();
        }
    }

}
