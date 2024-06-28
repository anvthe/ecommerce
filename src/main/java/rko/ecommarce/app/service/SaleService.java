package rko.ecommarce.app.service;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private static final Logger log = LogManager.getLogger(SaleService.class);
    private final SaleRepository saleRepository;

    public BigDecimal getTotalSaleAmountToday() {
        log.info("Getting total sale amount for today");
        BigDecimal totalSaleAmount = saleRepository.findTotalSaleAmountByDate(LocalDate.now());
        log.debug("Total sale amount for today: {}", totalSaleAmount);
        return totalSaleAmount;
    }

    public LocalDate getMaxSaleDay(LocalDate start, LocalDate end) {
        log.info("Getting max sale day between {} and {}", start, end);
        Pageable pageable = PageRequest.of(0, 10);
        LocalDate maxSaleDay = saleRepository.findMaxSaleDayBetween(start, end, pageable);
        log.debug("Max sale day: {}", maxSaleDay);
        return maxSaleDay;
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
