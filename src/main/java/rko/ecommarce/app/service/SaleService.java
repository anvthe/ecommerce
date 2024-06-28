package rko.ecommarce.app.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import rko.ecommarce.app.dto.ItemDTO;
import rko.ecommarce.app.dto.ItemDetailsDTO;
import rko.ecommarce.app.repository.SaleRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SaleService {
    private final SaleRepository saleRepository;

    public BigDecimal getTotalSaleAmountToday() {
        log.info("Getting total sale amount for today");
        BigDecimal totalSaleAmount = saleRepository.findTotalSaleAmountByDate(LocalDate.now());
        log.debug("Total sale amount for today: {}", totalSaleAmount);
        return totalSaleAmount;
    }

    public LocalDate getMaxSaleDay(LocalDate start, LocalDate end) {
        log.info("Getting max sale day between {} and {}", start, end);
        Pageable pageable = PageRequest.of(0, 1);
        List<LocalDate> maxSaleDay = saleRepository.findMaxSaleDayBetween(start, end, pageable);

        if (maxSaleDay.isEmpty()) {
            log.debug("No sales found in the given date range");
            return null;
        }
        LocalDate maxSaleDate = maxSaleDay.get(0);
        log.debug("Max sale day: {}", maxSaleDate);
        return maxSaleDate;
    }

    public List<ItemDTO> getTop5SellingItemsAllTime() {
        log.info("Getting top 5 selling items of all time");
        List<ItemDTO> topSellingItems = saleRepository.findTop5SellingItemsAllTime(PageRequest.of(0, 5));
        log.debug("Top 5 selling items: {}", topSellingItems);
        return topSellingItems;
    }

    public List<ItemDetailsDTO> getTop5SellingItemsLastMonth() {
        log.info("Getting top 5 selling items of the last month");
        LocalDate lastMonthStart = LocalDate.now().minusMonths(1).withDayOfMonth(1);
        LocalDate lastMonthEnd = lastMonthStart.withDayOfMonth(lastMonthStart.lengthOfMonth());
        List<ItemDetailsDTO> topSellingItems = saleRepository.findTop5SellingItemsByMonth(lastMonthStart, lastMonthEnd, PageRequest.of(0, 5));
        log.debug("Top 5 selling items of the last month: {}", topSellingItems);
        return topSellingItems;
    }
}
