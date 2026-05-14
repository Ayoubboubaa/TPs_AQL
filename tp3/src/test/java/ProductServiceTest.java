import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductApiClient apiClient;

    @InjectMocks
    private ProductService productService;

    @Test
    public void testGetProductSuccessful() {
        String productId = "123";
        Product expectedProduct = new Product(productId, "Phone", 500.0);
        
        when(apiClient.getProduct(productId)).thenReturn(expectedProduct);

        Product result = productService.getProduct(productId);

        assertNotNull(result);
        assertEquals("Phone", result.getName());
        verify(apiClient).getProduct(productId);
    }

    @Test
    public void testGetProductApiFailure() {
        String productId = "123";
        
        when(apiClient.getProduct(productId)).thenThrow(new RuntimeException("API error"));

        assertThrows(RuntimeException.class, () -> {
            productService.getProduct(productId);
        });
        
        verify(apiClient).getProduct(productId);
    }

    @Test
    public void testGetProductIncompatibleData() {
        String productId = "123";
        
        // Simulating incompatible data by returning null or an object with missing fields
        // In a real scenario, this might be a custom exception or a parsing error
        when(apiClient.getProduct(productId)).thenReturn(null);

        Product result = productService.getProduct(productId);

        assertNull(result);
        verify(apiClient).getProduct(productId);
    }
}
