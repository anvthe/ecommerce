package rko.ecommarce.app.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import rko.ecommarce.app.dto.ItemDTO;
import rko.ecommarce.app.dto.WishlistDTO;
import rko.ecommarce.app.entity.Item;
import rko.ecommarce.app.repository.WishlistRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class WishlistService {
    private final WishlistRepository wishlistRepository;

    public WishlistDTO getWishlistByCustomerId(Long customerId) {
        log.info("Fetching wishlist for customer with ID: {}", customerId);
        List<Item> items = wishlistRepository.findByCustomerId(customerId);
        List<ItemDTO> itemDTOs = items.stream()
                .map(ItemDTO::from)
                .collect(Collectors.toList());
        return new WishlistDTO(itemDTOs);
    }
}