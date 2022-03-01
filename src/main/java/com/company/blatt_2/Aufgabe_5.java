package com.company.blatt_2;

import com.company.connection.ConnectionHelper;

import java.sql.*;

public class Aufgabe_5 {

    public static void main( String[] args) {
        String selectString = "SELECT L.Bestand\n" +
                "From Lager L\n" +
                "INNER JOIN Artikel A on L.Artnr = A.Anr\n" +
                "WHERE A.Bezeichnung = ?";

        String updateString = "UPDATE\n" +
                "    Lager L\n" +
                "    INNER JOIN Artikel A on L.Artnr = A.Anr\n" +
                "SET\n" +
                "    L.Bestand = ?\n" +
                "WHERE\n" +
                "    A.Bezeichnung = ?";

        int bestand;
        int newBestand = 0;

        try (Connection con = ConnectionHelper.getConnection("")) {
            if (con != null) {
                try (Statement stmt = con.createStatement()) {
                    try (PreparedStatement selectBestand = con.prepareStatement(selectString);
                         PreparedStatement updateBestand = con.prepareStatement(updateString)) {

                        con.setAutoCommit(false);
                        selectBestand.setString(1, "Sattel");

                        ResultSet rs = selectBestand.executeQuery();
                        while(rs.next()) {
                            bestand = rs.getInt(1);
                            newBestand = bestand + 7;

                            System.out.printf("Bestand: %s%n", bestand);
                        }

                        updateBestand.setString(1, Integer.toString(newBestand));
                        updateBestand.setString(2, "Sattel");
                        updateBestand.executeUpdate();
                        con.commit();

                        rs = selectBestand.executeQuery();
                        while(rs.next()) {
                            System.out.printf("Neuer Bestand: %s%n", rs.getInt(1));
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
