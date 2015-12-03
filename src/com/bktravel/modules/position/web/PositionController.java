package com.bktravel.modules.position.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bktravel.common.web.BaseController;
import com.bktravel.modules.position.entity.City;
import com.bktravel.modules.position.entity.Continent;
import com.bktravel.modules.position.entity.Country;
import com.bktravel.modules.position.entity.Nation;
import com.bktravel.modules.position.entity.Province;
import com.bktravel.modules.position.service.PositionService;

@Controller
@RequestMapping("${adminPath}/position")
public class PositionController extends BaseController {

	@Autowired
	private PositionService positionService;

	@RequestMapping("continentSelections")
	@ResponseBody
	public Object continentSelections() {
		List<Continent> list = positionService.findContinentList(new Continent(), true);
		return list;
	}

	@RequestMapping("nationSelections")
	@ResponseBody
	public Object nationSelections(Continent continent) {
		Nation nation = new Nation();
		nation.setContinent(continent);
		List<Nation> list = positionService.findNationList(nation, true, "continent");
		return list;
	}

	@RequestMapping("provinceSelections")
	@ResponseBody
	public Object provinceSelections(Nation nation) {
		Province province = new Province();
		province.setNation(nation);
		List<Province> list = positionService.findProvinceList(province, true, "nation");
		return list;
	}

	@RequestMapping("citySelections")
	@ResponseBody
	public Object citySelections(Province province) {
		City city = new City();
		city.setProvince(province);
		List<City> list = positionService.findCityList(city, true, "province");
		return list;
	}

	@RequestMapping("countrySelections")
	@ResponseBody
	public Object countrySelections(City city) {
		Country country = new Country();
		country.setCity(city);
		List<Country> list = positionService.findCountryList(country, true, "city");
		return list;
	}
}
