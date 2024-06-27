package rko.ecommarce.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rko.ecommarce.app.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
