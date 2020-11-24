package com.travel.nana.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.nana.exception.RecordNotFoundException;
import com.travel.nana.model.City;
import com.travel.nana.repository.CityRepository;

@Service
public class CityService {

	@Autowired
	private CityRepository cityRepository;

	public List<City> getAllCities() {
		List<City> cityList = cityRepository.findAll();
		if (cityList.size() > 0) {
			return cityList;
		} else {
			return new ArrayList<City>();
		}
	}

	public City getCityById(String cityId) throws RecordNotFoundException {
		Optional<City> city = cityRepository.findById(cityId);
		if (city.isPresent()) {
			return city.get();
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

	public City createOrUpdateCity(City city) throws RecordNotFoundException {
		if (city.getCityId() != null) {
			Optional<City> cities = cityRepository.findById(city.getCityId());
			City newCity = cities.get();
			newCity.setCityName(city.getCityName());
			newCity = cityRepository.save(newCity);
			return newCity;
		} else {
			city = cityRepository.save(city);
			return city;
		}
	}

	public void deleteCityById(String cityId) throws RecordNotFoundException {
		Optional<City> city = cityRepository.findById(cityId);
		if (city.isPresent()) {
			cityRepository.deleteById(cityId);
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}
}
