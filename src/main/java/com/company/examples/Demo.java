package com.company.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {

    private static String LOGIN = "dhbw";
    private static String PASSWORD = "dhbw";
    private static String URL = "jdbc:mysql://localhost:3306/world";
    private static String TIMEZONEPROPERTY = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public static void main( String[] args ) {
        try ( Connection con = DriverManager.getConnection( URL + TIMEZONEPROPERTY, LOGIN, PASSWORD ) ) {
            if ( con != null ) {
                try ( Statement stmt = con.createStatement() ) {
                    try ( ResultSet rs = stmt.executeQuery( "SELECT * FROM city" ) ) {
                        while ( rs.next() ) {
                            System.out.printf( "Name: %s, ID: %s%n", rs.getString( 2 ), rs.getInt( 1 ) );
                        }
                    }
                }
            }
        } catch ( SQLException e ) {
            System.err.println( "Error during Demo!" );
            e.printStackTrace();
        }
    }

}
