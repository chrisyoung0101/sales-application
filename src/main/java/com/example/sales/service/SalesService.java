package com.example.sales.service;

import com.example.sales.model.Sale;
import com.example.sales.repository.SalesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {

    private final SalesRepository salesRepository;

    public SalesService(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }


    public List<Sale> getAllSales() {
        List<Sale> sales = salesRepository.findAll();
        System.out.println("Retrieved sales: " + sales);
        return sales;
    }

    public Sale getSaleById(Long id) {
        Sale sale = salesRepository.findById(id).orElseThrow();
        System.out.println("Retrieved sale: " + sale);
        return sale;
    }
}
