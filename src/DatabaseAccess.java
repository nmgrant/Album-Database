//STEP 1. Import required packages

import java.sql.*;
import java.util.ArrayList;

public class DatabaseAccess { // JDBC driver name and database URL

    static final String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";
    static final String DB_URL = "jdbc:derby://localhost:1527/testdb";

    //  Database credentials
    static final String USER = "newuser";
    static final String PASS = "newpass";

    private Connection conn;

    public DatabaseAccess() throws Exception {
        Class.forName(JDBC_DRIVER);

        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);

    }
    
    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
    
    public ArrayList<String> listAlbumTitles() {
        Statement stmt = null;
        ArrayList<String> albumTitles = new ArrayList<String>();
        try {
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT album_title FROM album";
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                albumTitles.add(rs.getString("album_title"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        if (!albumTitles.isEmpty()) {
            return albumTitles;
        }
        else {
            return null;
        }
    }
}
    /*public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM recording_group";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                String group_name = rs.getString("group_name");
                String lead_singer = rs.getString("lead_singer");
                String year_formed = rs.getString("year_formed");
                String genre = rs.getString("genre");

                //Display values
                System.out.print("group_name: " + group_name);
                System.out.print(", lead_singer: " + lead_singer);
                System.out.print(", year_formed: " + year_formed);
                System.out.println(", genre: " + genre);
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }//end main
}//end FirstExample*/
