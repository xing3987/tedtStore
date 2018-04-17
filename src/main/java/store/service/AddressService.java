package store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import store.bean.Address;
import store.mapper.AddressMapper;
import store.mapper.DictMapper;

@Service
//地址管理服务层
public class AddressService implements IAddressService{
	@Resource
	private AddressMapper addressMapper;
	@Resource
	private DictMapper dictMapper;
	//添加收货地址
	public void addAddress(Address address) {
		//通过地址的省市区编码，得到具体的省市区名字，然后组成字符串并插入到address中
		String provinceName=dictMapper.selectProvinceNameByCode(address.getRecvProvince());
		String cityName=dictMapper.selectCityNameByCode(address.getRecvCity());
		String areaName=dictMapper.selectAreaNameByCode(address.getRecvArea());
		String District=provinceName+cityName+areaName;
		address.setRecvDistrict(District);
		
		//给isDefault设置地址默认值
		List<Address> addresses=addressMapper.selectByUid(address.getUid());
		if(addresses.size()>0){
			address.setDefaultAddress(0);
		}else{
			address.setDefaultAddress(1);
		}
		
		addressMapper.insert(address);
	}

	//查询收货地址
	public List<Address> getAddress(Integer uid) {
		
		return addressMapper.selectByUid(uid);
	}

	//设置默认地址
	public void setDefault(Integer uid, Integer id) {
		int n1=addressMapper.setCancel(uid);
		if(n1>0){
			throw new RuntimeException("取消默认地址失败");
		}
		int n2=addressMapper.setDefault(id);
		if(n2>0){
			throw new RuntimeException("设置默认地址失败");
		}
	}

}
