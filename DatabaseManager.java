import java.sql.*;

public class DatabaseManager {
    static final String URL = "jdbc:mysql://localhost:3306/trading_system";
    static final String USER = "root";
    static final String PASS = "password";

    public static void insertOrder(Order o) {
        try (Connection c = DriverManager.getConnection(URL, USER, PASS)) {
            PreparedStatement ps = c.prepareStatement(
                "INSERT INTO orders VALUES (?, ?, ?, ?, ?, ?)"
            );

            ps.setString(1, o.getClOrdID());
            ps.setString(2, o.getSymbol());
            ps.setString(3, String.valueOf(o.getSide()));
            ps.setDouble(4, o.getPrice());
            ps.setDouble(5, o.getQuantity());
            ps.setString(6, "NEW");

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}