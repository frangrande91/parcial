package com.parcialLabV.parcial.repository;

import com.parcialLabV.parcial.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Integer>, JpaSpecificationExecutor<Currency> {

}
