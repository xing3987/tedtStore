package store.mapper;

import java.util.List;

import store.bean.Address;

public interface AddressMapper {
	public void insert(Address address);//���������ַ�ķ���
	public List<Address> selectByUid(Integer uid);//ͨ��uid��ѯ��ַ
	public Integer setCancel(Integer uid);//�ѵ�½�û����е�default_address����Ϊ0
	public Integer setDefault(Integer id);//��ѡ�е��û���default_address����Ϊ1
}
