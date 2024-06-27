package rko.ecommarce.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TotalSaleAmountDTO {
    private BigDecimal totalSaleAmount;

    public static TotalSaleAmountDTO from(BigDecimal totalSaleAmount) {
        return new TotalSaleAmountDTO(totalSaleAmount);
    }
}
