package com.travel.nana.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.nana.exception.RecordNotFoundException;
import com.travel.nana.model.District;
import com.travel.nana.repository.DistrictRepository;

@Service
public class DistrictService {

	@Autowired
	private DistrictRepository districtRepository;

	public List<District> getAllDistricts() {
		List<District> districtList = districtRepository.findAll();
		if (districtList.size() > 0) {
			return districtList;
		} else {
			return new ArrayList<District>();
		}
	}

	public District getDistrictById(String districtId) throws RecordNotFoundException {
		Optional<District> district = districtRepository.findById(districtId);
		if (district.isPresent()) {
			return district.get();
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

	public District createOrUpdateDistrict(District district) throws RecordNotFoundException {
		if (district.getDistrictId() != null) {
			Optional<District> districts = districtRepository.findById(district.getDistrictId());
			District newDistrict = districts.get();
			newDistrict.setDistrictName(district.getDistrictName());
			newDistrict = districtRepository.save(newDistrict);
			return newDistrict;
		} else {
			district = districtRepository.save(district);
			return district;
		}
	}

	public void deleteDistrictById(String districtId) throws RecordNotFoundException {
		Optional<District> district = districtRepository.findById(districtId);
		if (district.isPresent()) {
			districtRepository.deleteById(districtId);
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}
}
