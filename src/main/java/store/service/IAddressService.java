package store.service;

import java.util.List;

import store.bean.Address;

public interface IAddressService {
	public void addAddress(Address address);//添加地址
	public List<Address> getAddress(Integer uid);//通过uid查询收货地址
	public void setDefault(Integer uid,Integer id);//改变地址值
	
}
