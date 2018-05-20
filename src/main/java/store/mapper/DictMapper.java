package store.mapper;

import store.bean.Area;
import store.bean.City;
import store.bean.Province;

import java.util.List;
//省市区查询等方法管理接口
public interface DictMapper {
	public List<Province> selectProvince();//查询返回省份数据
	public List<City> selectCitysByProvince(String provinceCode);//通过省分code查询出城市 
	public List<Area> selectAreaByCity(String cityCode);//通过城市code查询出区域
	public String selectProvinceNameByCode(String provinceCode);//通过编码查询省份
	public String selectCityNameByCode(String cityCode);//通过编码查询城市
	public String selectAreaNameByCode(String areaCode);//通过编码查询区域
}
