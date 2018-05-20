package store.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import store.bean.Area;
import store.bean.City;
import store.bean.Province;
@Transactional
public interface IDictService {
	public List<Province> getProvince();//�����õ�����ʡ�ݵķ���
	public List<City> getCity(String provinceCode);//�����õ����еķ���
	public List<Area> getArea(String cityCode);//�����õ�����ķ���
}
