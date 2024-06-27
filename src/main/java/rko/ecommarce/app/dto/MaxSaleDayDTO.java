package rko.ecommarce.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaxSaleDayDTO {
    private String maxSaleDay;

    public static MaxSaleDayDTO from(String maxSaleDay) {
        return new MaxSaleDayDTO(maxSaleDay);
    }
}
