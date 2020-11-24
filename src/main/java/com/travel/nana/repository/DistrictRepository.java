package com.travel.nana.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.nana.model.District;

@Repository
public interface DistrictRepository extends JpaRepository<District, String> {

}
