package rko.ecommarce.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopSellingItemsLastMonthDTO {
    private List<ItemDetailsDTO> topSellingItems;
}
