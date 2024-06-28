package rko.ecommarce.app.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rko.ecommarce.app.dto.ItemDetailsDTO;
import rko.ecommarce.app.dto.TopSellingItemsLastMonthDTO;
import rko.ecommarce.app.service.SaleService;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/sales")
public class TopSellingItemsLastMonthController {
    private final SaleService saleService;

    @GetMapping("/top/lastmonth")
    public ResponseEntity<TopSellingItemsLastMonthDTO> getTop5SellingItemsLastMonth() {
        log.info("Get Top 5 Selling Items Last Month");
        List<ItemDetailsDTO> topSellingItems = saleService.getTop5SellingItemsLastMonth();
        return ResponseEntity.ok(new TopSellingItemsLastMonthDTO(topSellingItems));
    }
}
