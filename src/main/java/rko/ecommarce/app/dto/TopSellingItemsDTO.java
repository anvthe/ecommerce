package rko.ecommarce.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopSellingItemsDTO {
    private List<ItemDTO> topSellingItems;
}
