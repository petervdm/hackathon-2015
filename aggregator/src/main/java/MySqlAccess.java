import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;

/**
 * Created by Paul Kisbee on 19/08/2015.
 */
public class MySqlAccess {

//    private String dbUrl = "jdbc:mysql://localhost/socialdb";
    private String dbUrl = "jdbc:mysql://173.194.226.150/socialdb";
    private String dbClass = "com.mysql.jdbc.Driver";
    private String username = "root";
//    private String password = "mysqlroot";
    private String password = "s0cial";

    private Connection connection;

    public void init() throws Exception {

        System.out.println("- Connecting To Database");
        try {
            Class.forName(dbClass);
            connection = DriverManager.getConnection(dbUrl, username, password);
        } catch (Exception e) {
            throw e;
        }
    }

    public ResultSet getTweets() throws Exception {

        String query = "SELECT tweettime, tweet, sent from tweets ORDER BY tweettime";

        System.out.println("- - Getting Tweets");
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            return rs;
        } catch (Exception e) {
            throw e;
        }
    }

    public void writeTotals(String date, int hour, int pos, int neu, int neg, String imgLoc) throws Exception {

        System.out.println("- - Writing Totals");

        try {
            PreparedStatement s = connection.prepareStatement(
                    "INSERT INTO displaydata " +
                            "(infodate, hour, positive, neutral, negative, image_loc, created_at, updated_at) " +
                            "VALUES (?,?,?,?,?,?,?,?)");
            s.setString(1, date);
            s.setInt(2, hour);
            s.setInt(3, pos);
            s.setInt(4, neu);
            s.setInt(5, neg);
            s.setString(6, imgLoc);
            s.setString(7, "2015-08-19 12:30:00");
            s.setString(8, "2015-08-19 12:30:00");
            s.executeUpdate();

        } catch (Exception e) {
            throw e;
        }
    }

    public void end() {

        System.out.println("- Closing Database Connection");
        try {
            /*
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            } */

            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {

        }
    }
}
