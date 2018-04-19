package store.service;

import java.util.List;

import store.bean.Address;

public interface IAddressService {
	public void addAddress(Address address);//��ӵ�ַ
	public List<Address> getAddress(Integer uid);//ͨ��uid��ѯ�ջ���ַ
	public void setDefault(Integer uid,Integer id);//�ı��ֵַ
	public Address getAddressById(Integer id);//ͨ��id��ѯ��ַ
	public void updateAddressById(Address address);//����ͨ��id���ҵ�������
	public void deletById(Integer id);//ͨ��idɾ����ַ
}
