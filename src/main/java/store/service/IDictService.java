package store.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import store.bean.Area;
import store.bean.City;
import store.bean.Province;
@Transactional
public interface IDictService {
	public List<Province> getProvince();//创建得到所有省份的方法
	public List<City> getCity(String provinceCode);//创建得到城市的方法
	public List<Area> getArea(String cityCode);//创建得到区域的方法
}
