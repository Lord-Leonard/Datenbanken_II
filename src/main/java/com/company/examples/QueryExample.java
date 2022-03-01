package com.company.examples;

import com.company.connection.ConnectionHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryExample {

    public static void main( String[] args ) {
        try ( Connection con = ConnectionHelper.getConnection( "" ) ) {
            if ( con != null ) {
                try ( Statement stmt = con.createStatement() ) {
                    try ( ResultSet rs = stmt.executeQuery( "SELECT * FROM city" ) ) {
                        while ( rs.next() ) {
                            System.out.printf( "%s, %s%n", rs.getString( 2 ), rs.getInt( 5 ) );
                        }
                    }
                }
            }
        } catch ( SQLException e ) {
            System.err.println( "Error during Query Example!" );
            e.printStackTrace();
        }
    }
}
