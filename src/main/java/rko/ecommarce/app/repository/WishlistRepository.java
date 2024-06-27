package rko.ecommarce.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import rko.ecommarce.app.entity.Item;
import rko.ecommarce.app.entity.Wishlist;

import java.util.List;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {

    @Query("SELECT w.items FROM Wishlist w WHERE w.customer.id = :customerId")
    List<Item> findByCustomerId(@Param("customerId") Long customerId);
}
