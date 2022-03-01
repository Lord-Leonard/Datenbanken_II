package com.company.blatt_2;

import com.company.connection.ConnectionHelper;

import java.sql.*;

public class Aufgabe_6 {

    public static void main( String[] args) {
        String deleteString = "DELETE FROM Lager\n" +
                "WHERE Bestand = 0;";

        String selectString = "SELECT COUNT(L.Bestand)\n" +
                "FROM Lager L\n" +
                "WHERE L.Bestand = 0";

        try (Connection con = ConnectionHelper.getConnection("")) {
            if (con != null) {
                try (Statement stmt = con.createStatement()) {
                    try (PreparedStatement selectBestand = con.prepareStatement(selectString);
                         PreparedStatement deleteArtikel = con.prepareStatement(deleteString)) {

                        con.setAutoCommit(false);

                        ResultSet rs = selectBestand.executeQuery();
                        while(rs.next()) {
                            System.out.printf("Bestand: %s%n", rs.getInt(1));
                        }

                        deleteArtikel.executeUpdate();
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
