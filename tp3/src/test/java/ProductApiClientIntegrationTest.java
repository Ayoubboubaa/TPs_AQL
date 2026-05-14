import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;
import static org.junit.jupiter.api.Assertions.*;

import com.github.tomakehurst.wiremock.client.WireMock;
import static com.github.tomakehurst.wiremock.client.WireMock.*;

@Testcontainers
public class ProductApiClientIntegrationTest {

    @Container
    public static GenericContainer<?> wiremockContainer = new GenericContainer<>(DockerImageName.parse("wiremock/wiremock:2.35.0"))
            .withExposedPorts(8080);

    private ProductApiClientImpl apiClient;

    @BeforeEach
    public void setUp() {
        String host = wiremockContainer.getHost();
        int port = wiremockContainer.getMappedPort(8080);
        String baseUrl = "http://" + host + ":" + port;
        
        apiClient = new ProductApiClientImpl(baseUrl);
        
        // Configure WireMock client to point to the container
        WireMock.configureFor(host, port);
    }

    @Test
    public void testGetProduct() {
        // Stubbing the API
        stubFor(get(urlEqualTo("/products/123"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"id\":\"123\", \"name\":\"Laptop\", \"price\":999.99}")));

        Product product = apiClient.getProduct("123");

        assertNotNull(product);
        assertEquals("Laptop", product.getName());
        assertEquals(999.99, product.getPrice());
    }
}
