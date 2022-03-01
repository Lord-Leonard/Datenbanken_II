package com.company.blatt_2;

import com.company.connection.ConnectionHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Aufgabe_2 {

    public static void main( String[] args) {
        try ( Connection con = ConnectionHelper.getConnection("")) {
            if (con != null ) {
                try (Statement stmt = con.createStatement()) {
                    try (ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM Reservierung") ) {
                        while (rs.next()) {
                            System.out.printf("Es sind %s Artikel reserviert", rs.getInt(1));
                        }
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
