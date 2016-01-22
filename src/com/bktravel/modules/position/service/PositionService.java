package com.bktravel.modules.position.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bkweb.modules.position.entity.City;
import com.bkweb.modules.position.entity.Continent;
import com.bkweb.modules.position.entity.Country;
import com.bkweb.modules.position.entity.Nation;
import com.bkweb.modules.position.entity.Province;
import com.bkweb.modules.position.service.CCityService;
import com.bkweb.modules.position.service.CContinentService;
import com.bkweb.modules.position.service.CCountryService;
import com.bkweb.modules.position.service.CNationService;
import com.bkweb.modules.position.service.CProvinceService;

@Service
@Transactional
public class PositionService {
	@Autowired
	private CNationService nationService;

	@Autowired
	private CContinentService continentService;

	@Autowired
	CProvinceService provinceService;

	@Autowired
	private CCityService cityService;

	@Autowired
	private CCountryService countryService;

	public List<Continent> findContinentList(Continent continent, boolean b) {
		List<Continent> list = continentService.findList(continent, b);
		return list;
	}

	public List<Nation> findNationList(Nation nation, boolean b, String... string) {
		List<Nation> list = nationService.findList(nation, b, string);
		return list;
	}

	public List<Province> findProvinceList(Province province, boolean b, String... string) {
		List<Province> list = provinceService.findList(province, b, string);
		return list;
	}

	public List<City> findCityList(City city, boolean b, String... string) {
		List<City> list = cityService.findList(city, b, string);
		return list;
	}

	public List<Country> findCountryList(Country country, boolean b, String... string) {
		List<Country> list = countryService.findList(country, b, string);
		return list;
	}

	public Continent getContinent(Continent continent, String... batchTable) {
		return continentService.get(continent, batchTable);
	}

	public Nation getNation(Nation nation, String... batchTable) {
		return nationService.get(nation, batchTable);
	}

	public Province getProvince(Province province, String... batchTable) {
		return provinceService.get(province, batchTable);
	}

	public City getCity(City city, String... batchTable) {
		return cityService.get(city, batchTable);
	}

	public Country getCountry(Country country, String... batchTable) {
		return countryService.get(country, batchTable);
	}
}
