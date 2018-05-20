package store.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import store.bean.Address;
@Transactional
public interface IAddressService {
	public void addAddress(Address address);//添加地址
	public List<Address> getAddress(Integer uid);//通过uid查询收货地址
	public void setDefault(Integer uid,Integer id);//改变地址值
	public Address getAddressById(Integer id);//通过id查询地址
	public void updateAddressById(Address address);//更新通过id查找到的数据
	public void deletById(Integer id);//通过id删除地址
}
