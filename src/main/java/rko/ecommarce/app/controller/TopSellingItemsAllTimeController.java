package rko.ecommarce.app.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rko.ecommarce.app.dto.ItemDTO;
import rko.ecommarce.app.dto.TopSellingItemsAllTimeDTO;
import rko.ecommarce.app.service.SaleService;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/sales")
public class TopSellingItemsAllTimeController {
    private final SaleService saleService;

    @GetMapping("/top/alltime")
    public ResponseEntity<?> getTop5SellingItemsAllTime() {
        log.info("Get Top 5 Selling Items All Time");
        List<ItemDTO> topSellingItems = saleService.getTop5SellingItemsAllTime();
        return ResponseEntity.ok(new TopSellingItemsAllTimeDTO(topSellingItems));
    }
}
