package com.company.blatt_2;

import com.company.connection.ConnectionHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Aufgabe_4 {

    public static void main( String[] args) {
        try ( Connection con = ConnectionHelper.getConnection("")) {
            if (con != null ) {
                try (Statement stmt = con.createStatement()) {
                    try (ResultSet rs = stmt.executeQuery("SELECT Artnr, Anzahl, Bezeichnung\n" +
                            "FROM Auftragsposten AP\n" +
                            "         INNER JOIN Artikel A on AP.Artnr = A.Anr\n" +
                            "WHERE AuftrNr = 2") ) {
                        while (rs.next()) {
                            System.out.printf("Artikelnummer: %s, Bezeichnung: %s, Anzahl: %s%n", rs.getInt(2), rs.getString(3), rs.getInt(2));
                        }
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
