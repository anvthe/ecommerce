package rko.ecommarce.app.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rko.ecommarce.app.dto.TotalSaleAmountDTO;
import rko.ecommarce.app.service.SaleService;
import java.math.BigDecimal;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/sales")
public class TotalSaleAmountCurrentDayController {
  private final SaleService saleService;

    @GetMapping("/today")
    public ResponseEntity<?> getTotalSaleAmountToday() {
        log.info("Total sale amount current day");
        BigDecimal totalSaleAmount = saleService.getTotalSaleAmountToday();
        return ResponseEntity.ok(new TotalSaleAmountDTO(totalSaleAmount));
    }
}