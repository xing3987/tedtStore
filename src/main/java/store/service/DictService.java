package store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import store.bean.Area;
import store.bean.City;
import store.bean.Province;
import store.mapper.DictMapper;
@Service
public class DictService implements IDictService{

	@Resource
	DictMapper dictMapper;
	//实现返回所有省份的方法
	public List<Province> getProvince() {
		List<Province> provinces=dictMapper.selectProvince();
		return provinces;
	}
	
	//实现通过省份编号查询返回城市的方法
	public List<City> getCity(String provinceCode) {
		List<City> citys=dictMapper.selectCitysByProvince(provinceCode);
		return citys;
	}
	
	//实现通过城市编号查询返回区域的方法
	public List<Area> getArea(String cityCode) {
		List<Area> areas=dictMapper.selectAreaByCity(cityCode);
		return areas;
	}

}
