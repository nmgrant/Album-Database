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
   private Statement stmt;

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
      } finally {
         try {
            if (stmt != null) {
               stmt.close();
            }
         } catch (SQLException se2) {
         }
         try {
            if (conn != null) {
               conn.close();
            }
         } catch (SQLException se) {
            se.printStackTrace();
         }
         System.out.println("Goodbye!");
      }
   }

   public ArrayList<String> listAlbumTitles() {
      stmt = null;
      ArrayList<String> albumTitles = new ArrayList<String>();
      try {
         stmt = conn.createStatement();
         String sql;
         sql = "SELECT album_title FROM albums";
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
      } else {
         return null;
      }
   }
   
   public ArrayList<String> listStudioTitles() {
      stmt = null;
      ArrayList<String> studioTitles = new ArrayList<String>();
      try {
         stmt = conn.createStatement();
         String sql;
         sql = "SELECT studio_name FROM recording_studios";
         ResultSet rs = stmt.executeQuery(sql);

         while (rs.next()) {
            studioTitles.add(rs.getString("studio_name"));
         }
         rs.close();
         stmt.close();
      } catch (SQLException se) {
         se.printStackTrace();
      }
      if (!studioTitles.isEmpty()) {
         return studioTitles;
      } else {
         return null;
      }
   }

   public ArrayList<String> listAlbumData(String album) {
      Statement stmt = null;
      ArrayList<String> data = new ArrayList<String>();
      try {
         stmt = conn.createStatement();
         String sql;
         sql = "SELECT * FROM albums WHERE album_title = '" + album + "'";
         ResultSet rs = stmt.executeQuery(sql);

         while (rs.next()) {
            String albumTitle = rs.getString("album_title");
            String groupName = rs.getString("group_name");
            String studioName = rs.getString("studio_name");
            String dateRecorded = rs.getString("date_recorded");
            String length = rs.getString("length");
            String numberOfSongs = rs.getString("number_of_songs");

            data.add(albumTitle);
            data.add(groupName);
            data.add(studioName);
            data.add(dateRecorded);
            data.add(length);
            data.add(numberOfSongs);
         }
         rs.close();
         stmt.close();
      } catch (SQLException se) {
         se.printStackTrace();
      }
      if (!data.isEmpty()) {
         return data;
      } else {
         return null;
      }
   }

   public String insertAlbum(ArrayList<String> albumData) {
      stmt = null;
      try {
         stmt = conn.createStatement();
         String sql;
         String title = albumData.get(0);
         String group = albumData.get(1);
         String studio = albumData.get(2);
         String date = albumData.get(3);
         String length = albumData.get(4);
         String numberOfSongs = albumData.get(5);
         sql = "INSERT INTO albums"
         + " VALUES ('" + title + "','" + group + "','" + studio
         + "','" + date + "','" + length + "'," + numberOfSongs + ")";
         stmt.executeUpdate(sql);

         stmt.close();
      } catch (SQLException se) {
         return se.getMessage();
      }
      return "Insert album successful!";
   }

   public String removeAlbum(String albumTitle) {
      stmt = null;
      try {
         stmt = conn.createStatement();
         String sql;
         String title = albumTitle;
         sql = "DELETE FROM albums WHERE album_title = '" + title + "'";
         stmt.executeUpdate(sql);

         stmt.close();
      } catch (SQLException se) {
         return se.getMessage();
      }
      return "Remove successful!";
   }

   public String insertStudio(ArrayList<String> studioData, String replacedStudio) {
      stmt = null;
      try {
         stmt = conn.createStatement();
         String sql;
         String studioName = studioData.get(0);
         String studioAddress = studioData.get(1);
         String studioOwner = studioData.get(2);
         String studioPhone = studioData.get(3);
         sql = "INSERT INTO recording_studios"
         + " VALUES ('" +studioName +"','" +studioAddress +"','" +studioOwner 
         +"','" +studioPhone +"')";
         stmt.executeUpdate(sql);

         sql = "UPDATE albums SET studio_name = '" +studioName 
         +"' WHERE studio_name = '" +replacedStudio +"'";
         stmt.executeUpdate(sql);
         
         stmt.close();
      } catch (SQLException se) {
         return se.getMessage();
      }
      return "Insert studio successful!";
   }
}
