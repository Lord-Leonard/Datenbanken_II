package com.company.blatt_2;

import com.company.connection.ConnectionHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Aufgabe_3 {

    public static void main( String[] args) {
        try ( Connection con = ConnectionHelper.getConnection("")) {
            if (con != null ) {
                try (Statement stmt = con.createStatement()) {
                    try (ResultSet rs = stmt.executeQuery("SELECT Bezeichnung, Preis, Farbe FROM Artikel") ) { // WHERE Farbe IS NOT NULL
                        while (rs.next()) {
                            String bezeichnung = rs.getString(1);
                            Integer preis = rs.getInt(2);

                            String farbe = rs.getString(3);
                            if (!rs.wasNull()) {
                                System.out.printf("%s %s%n \n", bezeichnung, preis);
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
