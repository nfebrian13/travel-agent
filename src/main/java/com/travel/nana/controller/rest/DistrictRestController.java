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
import com.travel.nana.model.District;
import com.travel.nana.service.DistrictService;

@RestController
@RequestMapping("/api/v1/district")
public class DistrictRestController {

	@Autowired
	private DistrictService districtService;

	@GetMapping
	public ResponseEntity<List<District>> getAllDistricts() {
		List<District> list = districtService.getAllDistricts();
		return new ResponseEntity<List<District>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<District> getDistrictById(@PathVariable("id") String districtId) throws RecordNotFoundException {
		District entity = districtService.getDistrictById(districtId);
		return new ResponseEntity<District>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<District> createOrUpdateDistrict(@RequestBody District district) throws RecordNotFoundException {
		District updated = districtService.createOrUpdateDistrict(district);
		return new ResponseEntity<District>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteDistrictById(@PathVariable("id") String districtId) throws RecordNotFoundException {
		districtService.deleteDistrictById(districtId);
		return HttpStatus.FORBIDDEN;
	}
}
