package com.company.examples;

import com.company.connection.ConnectionHelper;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDuplicateExample {

    public static void main( String[] args ) {
        try ( Connection con = ConnectionHelper.getConnection( "" ) ) {
            if ( con != null ) {
                try ( Statement stmt = con.createStatement() ) {
                    // This should produce an exception as the ID value should already be existing.
                    stmt.executeUpdate( "INSERT INTO city (ID, Name, CountryCode) VALUES(1000, 'Karlsruhe', 'DEU');" );
                }
            }
        } catch ( SQLException e ) {
            System.err.println( "Error during the Insert Duplicate Example!" );
            e.printStackTrace();
        }
    }

}
