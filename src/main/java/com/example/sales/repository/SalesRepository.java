package com.example.sales.repository;


import com.example.sales.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesRepository extends JpaRepository<Sale, Long> {

    List<Sale> findAll();

}
