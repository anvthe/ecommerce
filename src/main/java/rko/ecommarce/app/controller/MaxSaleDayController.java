package rko.ecommarce.app.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rko.ecommarce.app.dto.MaxSaleDayDTO;
import rko.ecommarce.app.service.SaleService;

import java.time.LocalDate;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/api/sales")
public class MaxSaleDayController {
    private final SaleService saleService;

    @GetMapping("/max")
    public ResponseEntity<MaxSaleDayDTO> getMaxSaleDay(@RequestParam String start,
                                                       @RequestParam String end) {
        log.info("Received request to get max sale day between {} and {}", start, end);
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);
        LocalDate maxSaleDay = saleService.getMaxSaleDay(startDate, endDate);
        return ResponseEntity.ok(new MaxSaleDayDTO(maxSaleDay.toString()));
    }
}
