package com.company.blatt_2;

import com.company.connection.ConnectionHelper;

import java.sql.*;

public class Aufgabe_7 {

    public static void main( String[] args) throws SQLException {
        String updateString = "UPDATE Personal\n" +
                "SET Gehalt = Gehalt + 100, Beurteilung = 2\n" +
                "WHERE Beurteilung = 1";

        String selectString = "SELECT Name FROM Personal\n" +
                "WHERE Beurteilung = 2";


        try (Connection con = ConnectionHelper.getConnection("")) {
            try (PreparedStatement updatePersonal = con.prepareStatement(updateString);
                 PreparedStatement selectPersonal = con.prepareStatement(selectString)) {

                con.setAutoCommit(false);

                ResultSet rs = selectPersonal.executeQuery();
                while(rs.next())
                    System.out.printf("Query 1: %s%n", rs.getString(1));

                updatePersonal.executeUpdate();
                con.commit();

                rs = selectPersonal.executeQuery();
                while(rs.next())
                    System.out.printf("Query 2: %s%n", rs.getString(1));

            } catch (SQLException e) {
                e.printStackTrace();
                if (con != null) {
                    try {
                        System.err.print("Transaction is being rolled back");
                        con.rollback();
                    } catch (SQLException excep) {
                        System.err.println(excep.getMessage());
                    }
                }
            }
        }
    }

}
