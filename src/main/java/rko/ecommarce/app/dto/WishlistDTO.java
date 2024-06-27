package rko.ecommarce.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rko.ecommarce.app.entity.Item;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WishlistDTO {
    private List<ItemDTO> items;
}
