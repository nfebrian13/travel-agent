package com.travel.nana.controller.view;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.travel.nana.model.City;
import com.travel.nana.service.CityService;

@Controller
public class CityController {

	private static final Logger logger = LoggerFactory.getLogger(CityController.class);

	@Autowired
	private CityService cityService;;

	@RequestMapping("/city")
	public String viewHomePage(Model model) {
		List<City> listcities = cityService.getAllCities();
		model.addAttribute("listCities", listcities);
		return "city";
	}

}
