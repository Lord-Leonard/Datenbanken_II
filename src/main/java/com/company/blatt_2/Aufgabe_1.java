package com.company.blatt_2;

import com.company.connection.ConnectionHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Aufgabe_1 {

    public static void main( String[] args) {
        try ( Connection con = ConnectionHelper.getConnection("")) {
            if (con != null ) {
                try (Statement stmt = con.createStatement()) {
                    try (ResultSet rs = stmt.executeQuery("SELECT * FROM Personal WHERE Gehalt > 3000") ) {
                        while (rs.next()) {
                            System.out.printf("%s \n", rs.getString(2));
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
