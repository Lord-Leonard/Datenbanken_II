package com.company.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {

    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String DEFAULTSCHEMA = "bike";
    // Specify specific parameters for German timezone as there is an SQLException with MySQL otherwise
    // See e.g. https://stackoverflow.com/questions/26515700/mysql-jdbc-driver-5-1-33-time-zone-issue
    private static final String TIMEZONEPROPERTY = "?useUnicode=true&useJDBCCompliantTimezoneShift=true" +
            "&useLegacyDatetimeCode=false&serverTimezone=UTC";

    // Loading of Driver was necessary in older Java versions. Driver classes now just need to be on the class path.
    //private static String DRIVER = "com.mysql.cj.jdbc.Driver";


    private ConnectionHelper() throws IllegalAccessException {
        throw new IllegalAccessException();
    }


    /**
     * Get a connection to the locally installed MySQL database.
     *
     * @param schema The schema name you want to connect to. If the schema is blank or null,
     *               a connection to the world schema is established by default
     * @return a {@link Connection} to the MySQL database.
     */
    public static Connection getConnection( String schema ) {
        // Again, old way to define driver class
        /*try {
            Class.forName( DRIVER );
        } catch ( ClassNotFoundException e ) {
            System.err.println( "No driver class found!" );
            e.printStackTrace();
            return null;
        }*/

        Connection con = null;
        try {
            if ( schema == null || schema.isBlank() ) {
                con = DriverManager.getConnection( URL + DEFAULTSCHEMA + TIMEZONEPROPERTY, LOGIN, PASSWORD );
            } else {
                con = DriverManager.getConnection( URL + schema + TIMEZONEPROPERTY, LOGIN, PASSWORD );
            }
        } catch ( SQLException e ) {
            System.err.println( "Error during connection to database!" );
            e.printStackTrace();
        }

        return con;
    }
}
