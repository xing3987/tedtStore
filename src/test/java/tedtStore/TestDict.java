package tedtStore;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import store.bean.Address;
import store.bean.Area;
import store.bean.City;
import store.bean.Province;
import store.mapper.AddressMapper;
import store.mapper.DictMapper;
import store.service.AddressService;

public class TestDict {
	ApplicationContext ac=new ClassPathXmlApplicationContext(
			"spring-dao.xml","spring-mvc.xml","spring-service.xml");
	DictMapper dictdao=ac.getBean("dictMapper",DictMapper.class);
	AddressMapper addressdao=ac.getBean("addressMapper",AddressMapper.class);
	AddressService addressService=ac.getBean("addressService",AddressService.class);
	/*-----------------------��ַ����addressAdmin.jsp----------------------------*/
	
	
	@Test
	//���Բ�ѯʡ
	public void dectSelectProvinces(){
		List<Province> provinces=dictdao.selectProvince();
		System.out.println(provinces);
	}
	
	@Test
	//���Բ�ѯ����
	public void dectSelectCitysByProvince(){
		List<City> citys=dictdao.selectCitysByProvince("120000");
		System.out.println(citys);		
	}
	
	@Test
	//���Բ�ѯ����
	public void dectSelectAreaByCity(){
		List<Area> areas=dictdao.selectAreaByCity("110100");
		System.out.println(areas);
	}
	
	@Test
	//����ͨ����Ų�ѯ����
	public void dectSelectAreaByCode(){
		String area=dictdao.selectAreaNameByCode("110101");
		System.out.println(area);
	}
	
	@Test
	//����ͨ����Ų�ѯ����
	public void dectSelectCityByCode(){
		String city=dictdao.selectCityNameByCode("110100");
		System.out.println(city);
	}
	
	@Test
	//����ͨ����Ų�ѯ����
	public void dectSelectProvinceByCode(){
		String province=dictdao.selectProvinceNameByCode("110000");
		System.out.println(province);
	}
	
	@Test
	//���Բ����ַ����
	public void addressInsert(){
		
		Address address=new Address();
		address.setUid(2);
		address.setRecvName("y");
		address.setRecvArea("110101");
		address.setRecvCity("110100");
		address.setRecvProvince("110000");
		address.setRecvPhone("y");
		address.setRecvAddress("y");
		address.setRecvDistrict("y");
		addressService.addAddress(address);;
	}
	
	@Test
	//���Բ����ַ����
	public void AddressServerInsert(){
//		Address address=new Address(null,1,"x","x","x",
//				"x","x","x","x","x",
//				"x","x","x",null,"x",
//				null,1);
		Address address=new Address();
		address.setUid(1);
		address.setRecvName("y");
		address.setRecvArea("110101");
		address.setRecvCity("110100");
		address.setRecvProvince("110000");
		address.setRecvPhone("y");
		address.setRecvAddress("y");
		address.setRecvDistrict("y");
		addressdao.insert(address);
		
	}
	
	
	@Test
	//����ͨ����Ų�ѯ����
	public void addressSelectByUid(){
		List<Address> address=addressdao.selectByUid(11);
		System.out.println(address);
	}
	
	@Test
	//����ɾ����ַ
	public void deleteByUid(){
		addressdao.deleteById(13);
	}
	
}
