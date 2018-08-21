package main.java.ignite0820;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class App 
{
    public static void main( String[] args ) throws Exception {
     // Register JDBC driver.
        Class.forName("org.apache.ignite.IgniteJdbcThinDriver");
        // Open JDBC connection.
        Connection conn = DriverManager.getConnection("jdbc:ignite:thin://127.0.0.1/");
        // Create database tables.
        try (Statement stmt = conn.createStatement()) {
            // Create table based on REPLICATED template.
            stmt.executeUpdate("CREATE TABLE City (" + 
            " id LONG PRIMARY KEY, name VARCHAR) " +
            " WITH \"template=replicated\"");
            // Create table based on PARTITIONED template with one backup.
            stmt.executeUpdate("CREATE TABLE Person (" +
            " id LONG, name VARCHAR, city_id LONG, " +
            " PRIMARY KEY (id, city_id)) " +
            " WITH \"backups=1, affinityKey=city_id\"");
            // Create an index on the City table.
            stmt.executeUpdate("CREATE INDEX idx_city_name ON City (name)");
            // Create an index on the Person table.
            stmt.executeUpdate("CREATE INDEX idx_person_name ON Person (name)");
        }
        
    }

   
}
