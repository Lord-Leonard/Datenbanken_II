package com.company.examples;

import com.company.connection.ConnectionHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertExample {

    public static void main( String[] args ) {
        try ( Connection con = ConnectionHelper.getConnection( "" ) ) {
            if ( con != null ) {
                try ( Statement stmt = con.createStatement() ) {
                    stmt.executeUpdate( "INSERT INTO city (ID, Name, CountryCode, District) " +
                            "VALUES(5001, 'Karlsruhe', 'DEU', 'Baden-Württemberg');" );

                    try ( ResultSet rs = stmt.executeQuery( "SELECT * FROM city" ) ) {

                        System.out.println( "----------------\r\nTeste auf NULL-Wert" );
                        while ( rs.next() ) {
                            Integer population = rs.getInt( 5 );
                            if ( rs.wasNull() ) {
                                System.out.println( rs.getInt( 1 ) + ", " + rs.getString( 2 ) + ", " + population );
                            }
                        }
                    }
                }
            }
        } catch ( SQLException e ) {
            System.err.println( "Error during the Insert Example!" );
            e.printStackTrace();
        }
    }

}
