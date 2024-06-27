package rko.ecommarce.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import rko.ecommarce.app.repository.SaleRepository;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class SaleService {
    private final SaleRepository saleRepository;

    public BigDecimal getTotalSaleAmountToday() {
        return saleRepository.findTotalSaleAmountByDate(LocalDate.now());
    }
    public LocalDate getMaxSaleDay(LocalDate start, LocalDate end) {
        Pageable pageable = PageRequest.of(0, 10);
        return saleRepository.findMaxSaleDayBetween(start, end, pageable);
    }
}
