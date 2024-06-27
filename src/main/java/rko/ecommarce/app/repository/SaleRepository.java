package rko.ecommarce.app.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import rko.ecommarce.app.entity.Sale;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.time.LocalDate;


public interface SaleRepository extends CrudRepository<Sale, Long> {

    @Query("SELECT SUM(s.amount) FROM Sale s WHERE s.date = :date")
    BigDecimal findTotalSaleAmountByDate(@Param("date") LocalDate date);

    @Query("SELECT s.date, SUM(s.amount) AS total FROM Sale s WHERE s.date BETWEEN :start AND :end GROUP BY s.date ORDER BY total DESC LIMIT 1")
    LocalDate findMaxSaleDayBetween(@Param("start") LocalDate start, @Param("end") LocalDate end, Pageable pageable);
}
