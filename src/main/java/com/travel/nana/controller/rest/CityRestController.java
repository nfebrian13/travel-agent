package com.travel.nana.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.nana.exception.RecordNotFoundException;
import com.travel.nana.model.City;
import com.travel.nana.service.CityService;

@RestController
@RequestMapping("/api/v1/city")
public class CityRestController {

	@Autowired
	private CityService cityService;

	@GetMapping
	public ResponseEntity<List<City>> getAllCities() {
		List<City> list = cityService.getAllCities();
		return new ResponseEntity<List<City>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<City> getCityById(@PathVariable("id") String cityId) throws RecordNotFoundException {
		City entity = cityService.getCityById(cityId);
		return new ResponseEntity<City>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<City> createOrUpdateCity(@RequestBody City city) throws RecordNotFoundException {
		City updated = cityService.createOrUpdateCity(city);
		return new ResponseEntity<City>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteCityById(@PathVariable("id") String cityId) throws RecordNotFoundException {
		cityService.deleteCityById(cityId);
		return HttpStatus.FORBIDDEN;
	}
}
