package rko.ecommarce.app;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class TopSellingItemsLastMonthControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnTop5SellingItemsLastMonth() throws Exception {
        mockMvc.perform(get("/api/sales/top/lastmonth"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.topSellingItems").isArray())
                .andExpect(jsonPath("$.topSellingItems.length()").value(5));
    }
}
