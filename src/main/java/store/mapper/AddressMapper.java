package store.mapper;

import java.util.List;

import store.bean.Address;

public interface AddressMapper {
	public void insert(Address address);//创建导入地址的方法
	public List<Address> selectByUid(Integer uid);//通过uid查询地址
	public Integer setCancel(Integer uid);//把登陆用户所有的default_address设置为0
	public Integer setDefault(Integer id);//把选中的用户的default_address设置为1
	public Address selectAddressById(Integer id);//通过id得到地址
	public void updateById(Address address);//跟新通过id得到的地址
	public void deleteById(Integer id);//根据id删除数据
}
