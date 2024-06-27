package rko.ecommarce.app.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import rko.ecommarce.app.entity.Sale;

import java.math.BigDecimal;
import java.time.LocalDate;


public interface SaleRepository extends CrudRepository<Sale, Long> {

    @Query("SELECT SUM(s.amount) FROM Sale s WHERE s.date = :date")
    BigDecimal findTotalSaleAmountByDate(@Param("date") LocalDate date);

}
