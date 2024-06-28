package rko.ecommarce.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import rko.ecommarce.app.dto.ItemDTO;
import rko.ecommarce.app.dto.ItemDetailsDTO;
import rko.ecommarce.app.repository.SaleRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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
    public List<ItemDTO> getTop5SellingItemsAllTime() {;
        return saleRepository.findTop5SellingItemsAllTime(PageRequest.of(0, 5));
    }
    public List<ItemDetailsDTO> getTop5SellingItemsLastMonth() {
        LocalDate lastMonthStart = LocalDate.now().minusMonths(1).withDayOfMonth(1);
        LocalDate lastMonthEnd = lastMonthStart.withDayOfMonth(lastMonthStart.lengthOfMonth());
        return saleRepository.findTop5SellingItemsByMonth(lastMonthStart, lastMonthEnd, PageRequest.of(0, 5));
    }
}
