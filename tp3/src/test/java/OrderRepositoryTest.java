import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
public class OrderRepositoryTest {

    @Container
    private static final MySQLContainer<?> mysql = new MySQLContainer<>("mysql:8.0")
            .withDatabaseName("testdb")
            .withUsername("root")
            .withPassword("");

    private OrderRepository orderRepository;

    @BeforeEach
    public void setUp() {
        orderRepository = new OrderRepository(
                mysql.getJdbcUrl(),
                mysql.getUsername(),
                mysql.getPassword()
        );
        orderRepository.createTable();
    }

    @Test
    public void testSaveAndFindOrder() {
        Order order = new Order(1L, "iPhone", 2);
        orderRepository.saveOrder(order);

        Order retrievedOrder = orderRepository.findById(1L);
        assertNotNull(retrievedOrder);
        assertEquals("iPhone", retrievedOrder.getProductName());
        assertEquals(2, retrievedOrder.getQuantity());
    }
}
