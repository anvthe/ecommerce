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
public class MaxSaleDayControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnMaxSaleDay() throws Exception {
        mockMvc.perform(get("/api/sales/max?start=2024-01-01&end=2024-06-30"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.maxSaleDay").isString());
    }
}
