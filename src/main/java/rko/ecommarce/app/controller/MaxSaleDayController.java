package rko.ecommarce.app.controller;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
@RequestMapping("/api/sales")
public class MaxSaleDayController {
    private static final Logger log = LogManager.getLogger(MaxSaleDayController.class);
    private final SaleService saleService;

    @GetMapping("/max")
    public ResponseEntity<MaxSaleDayDTO> getMaxSaleDay(@RequestParam String start,
                                                       @RequestParam String end) {
        log.info("Received request to get max sale day between {} and {}", start, end);
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);
        LocalDate maxSaleDay = saleService.getMaxSaleDay(startDate, endDate);
        log.debug("Max sale day between {} and {} is {}", start, end, maxSaleDay);
        return ResponseEntity.ok(new MaxSaleDayDTO(maxSaleDay.toString()));
    }
}
