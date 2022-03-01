package com.company.modelclassexample;

import com.company.connection.ConnectionHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CustomerObjectGenerator {


    public static void main( String[] args ) {
        try ( Connection con = ConnectionHelper.getConnection( "bike" ) ) {
            if ( con != null ) {
                try ( Statement stmt = con.createStatement() ) {
                    try ( ResultSet rs = stmt.executeQuery( "SELECT * FROM kunde;" ) ) {
                        while ( rs.next() ) {
                            Customer customer = generateCustomer( rs );

                            System.out.println( "-------------------- Kunde --------------------" );
                            System.out.println( "Nummer: " + customer.getNumber() );
                            System.out.println( "Name: " + customer.getName() );
                            System.out.println( "Straße: " + customer.getStreet() );
                            System.out.println( "PLZ: " + customer.getPlz() );
                            System.out.println( "Ort: " + customer.getCity() );
                            System.out.println( "-----------------------------------------------" );
                        }
                    }
                }
            }
        } catch ( SQLException e ) {
            System.err.println( "Error during ExerciseA!" );
            e.printStackTrace();
        }
    }


    private static Customer generateCustomer( ResultSet rs ) throws SQLException {
        Customer customer = new Customer();
        customer.setNumber( rs.getInt( "Nr" ) );
        customer.setName( rs.getString( "Name" ) );
        customer.setCity( rs.getString( "Ort" ) );
        customer.setPlz( rs.getInt( "PLZ" ) );
        customer.setStreet( rs.getString( "Strasse" ) );

        return customer;
    }

}
