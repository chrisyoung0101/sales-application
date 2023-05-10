package com.example.sales.controller;

import com.example.sales.model.Sale;
import com.example.sales.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SalesController {

    private final SalesService salesService;

    @Autowired
    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @GetMapping("/")
    public String index() {
        return "Welcome to the Sales application!";
    }

    @GetMapping("/sales")
    public List<Sale> getAllSales() {
        return salesService.getAllSales();
    }

    @GetMapping("/sales/{id}")
    public Sale getSaleById(@PathVariable(value = "id") Long id) {
        return salesService.getSaleById(id);
    }

}
