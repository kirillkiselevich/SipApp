package by.epolsoft.utils;


import java.sql.*;

public class Database {
    private static final String url = "jdbc:mysql://localhost:3306/sipusers?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String user = "dev";
    private static final String password = "dev";


    private static Connection con;
    private static PreparedStatement stmt;
    private static ResultSet rs;

    public Database(String u) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

            stmt = con.prepareStatement("SELECT id,name,email FROM user");
            rs = stmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString(2);
                if (name.equals(u)) {
                    int id = rs.getInt(1);
                    String email = rs.getString(3);
                    System.out.printf("id: %d, name: %s, email: %s %n", id, name, email);
                }
            }


        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se) {
            }
            try {
                stmt.close();
            } catch (SQLException se) {
            }
            try {
                rs.close();
            } catch (SQLException se) {
            }

        }
    }

}
