import java.sql.*;

public class DBUtil {
    private Connection con;
    private Statement stmt;
    public DBUtil(){
        try {
            Class.forName("org.postgresql,Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost/hit","postgres","liusiqi");
            stmt = con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        try {
            if(!stmt.isClosed())
            stmt.close();
            if(!con.isClosed())
                con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public  void executeUpdat(String sql){
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public ResultSet executeQuery(String sql){
        try {
            ResultSet rs = stmt.executeQuery(sql);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
