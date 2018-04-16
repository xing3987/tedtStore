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
	//ʵ�ַ�������ʡ�ݵķ���
	public List<Province> getProvince() {
		List<Province> provinces=dictMapper.selectProvince();
		return provinces;
	}
	
	//ʵ��ͨ��ʡ�ݱ�Ų�ѯ���س��еķ���
	public List<City> getCity(String provinceCode) {
		List<City> citys=dictMapper.selectCitysByProvince(provinceCode);
		return citys;
	}
	
	//ʵ��ͨ�����б�Ų�ѯ��������ķ���
	public List<Area> getArea(String cityCode) {
		List<Area> areas=dictMapper.selectAreaByCity(cityCode);
		return areas;
	}

}
