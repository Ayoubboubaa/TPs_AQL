import java.sql.*;

public class OrderRepository implements OrderDao {
    private String url;
    private String username;
    private String password;

    public OrderRepository(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    public void saveOrder(Order order) {
        String sql = "INSERT INTO orders (id, product_name, quantity) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, order.getId());
            pstmt.setString(2, order.getProductName());
            pstmt.setInt(3, order.getQuantity());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Order findById(long id) {
        String sql = "SELECT * FROM orders WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Order(rs.getLong("id"), rs.getString("product_name"), rs.getInt("quantity"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS orders (id BIGINT PRIMARY KEY, product_name VARCHAR(255), quantity INT)";
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
