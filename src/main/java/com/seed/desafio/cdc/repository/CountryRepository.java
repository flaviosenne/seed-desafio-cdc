package com.seed.desafio.cdc.repository;

import com.seed.desafio.cdc.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CountryRepository extends JpaRepository<Country, String> {
}
