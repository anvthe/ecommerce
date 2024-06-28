package rko.ecommarce.app.service;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import rko.ecommarce.app.dto.ItemDTO;
import rko.ecommarce.app.dto.WishlistDTO;
import rko.ecommarce.app.entity.Item;
import rko.ecommarce.app.repository.WishlistRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WishlistService {
    private static final Logger log = LogManager.getLogger(WishlistService.class);
    private final WishlistRepository wishlistRepository;

    public WishlistDTO getWishlistByCustomerId(Long customerId) {
        log.info("Fetching wishlist for customer with ID: {}", customerId);
        List<Item> items = wishlistRepository.findByCustomerId(customerId);
        List<ItemDTO> itemDTOs = items.stream()
                .map(ItemDTO::from)
                .collect(Collectors.toList());
        log.debug("Wishlist items for customer {}: {}", customerId, itemDTOs);
        return new WishlistDTO(itemDTOs);
    }
}