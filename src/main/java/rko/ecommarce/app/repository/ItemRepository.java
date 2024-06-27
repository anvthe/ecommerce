package rko.ecommarce.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rko.ecommarce.app.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
