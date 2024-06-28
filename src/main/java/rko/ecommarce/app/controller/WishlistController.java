package rko.ecommarce.app.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rko.ecommarce.app.dto.WishlistDTO;
import rko.ecommarce.app.service.WishlistService;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/wishlist")
public class WishlistController {
    private final WishlistService wishlistService;

    @GetMapping("/{customerId}")
    public ResponseEntity<?> getCustomerWishlist(@PathVariable Long customerId) {
        log.info("Get Customer Wishlist by customerId: {}", customerId);
        WishlistDTO wishlist = wishlistService.getWishlistByCustomerId(customerId);
        return ResponseEntity.ok(wishlist);
    }
}
