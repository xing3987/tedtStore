package store.mapper;

import store.bean.Area;
import store.bean.City;
import store.bean.Province;

import java.util.List;
//ʡ������ѯ�ȷ�������ӿ�
public interface DictMapper {
	public List<Province> selectProvince();//��ѯ����ʡ������
	public List<City> selectCitysByProvince(String provinceCode);//ͨ��ʡ��code��ѯ������ 
	public List<Area> selectAreaByCity(String cityCode);//ͨ������code��ѯ������
	public String selectProvinceNameByCode(String provinceCode);//ͨ�������ѯʡ��
	public String selectCityNameByCode(String cityCode);//ͨ�������ѯ����
	public String selectAreaNameByCode(String areaCode);//ͨ�������ѯ����
}
