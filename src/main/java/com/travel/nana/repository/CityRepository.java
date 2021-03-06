package com.travel.nana.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.nana.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, String> {

}
