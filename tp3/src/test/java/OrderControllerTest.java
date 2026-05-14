import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class OrderControllerTest {

    @Mock
    private OrderDao orderDao;

    private OrderService orderService;
    private OrderController orderController;

    @Test
    public void testCreateOrder() {
        // Initialize with real service and mock dao
        orderService = spy(new OrderService(orderDao));
        orderController = new OrderController(orderService);

        // Create an order
        Order order = new Order(1L, "Laptop", 1);

        // When orderController.createOrder is called
        orderController.createOrder(order);

        // Verify OrderService.createOrder was called with the correct argument
        verify(orderService).createOrder(order);
        
        // Verify OrderDao.saveOrder was called with the correct argument
        verify(orderDao).saveOrder(order);
    }
}
