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

	public List<City> getAllEmployees() {
		List<City> employeeList = cityRepository.findAll();
		if (employeeList.size() > 0) {
			return employeeList;
		} else {
			return new ArrayList<City>();
		}
	}

	public City getEmployeeById(String city_id) throws RecordNotFoundException {
		Optional<City> employee = cityRepository.findById(city_id);
		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

	public City createOrUpdateEmployee(City entity) throws RecordNotFoundException {
		if (entity.getCityId() != null) {
			Optional<City> employee = cityRepository.findById(entity.getCityId());
			City newEntity = employee.get();
			newEntity.setCityName(entity.getCityName());
			newEntity = cityRepository.save(newEntity);
			return newEntity;
		} else {
			entity = cityRepository.save(entity);
			return entity;
		}
	}

	public void deleteEmployeeById(String city_id) throws RecordNotFoundException {
		Optional<City> employee = cityRepository.findById(city_id);
		if (employee.isPresent()) {
			cityRepository.deleteById(city_id);
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}
}
