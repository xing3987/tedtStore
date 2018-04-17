package store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import store.bean.Address;
import store.mapper.AddressMapper;
import store.mapper.DictMapper;

@Service
//��ַ��������
public class AddressService implements IAddressService{
	@Resource
	private AddressMapper addressMapper;
	@Resource
	private DictMapper dictMapper;
	//����ջ���ַ
	public void addAddress(Address address) {
		//ͨ����ַ��ʡ�������룬�õ������ʡ�������֣�Ȼ������ַ��������뵽address��
		String provinceName=dictMapper.selectProvinceNameByCode(address.getRecvProvince());
		String cityName=dictMapper.selectCityNameByCode(address.getRecvCity());
		String areaName=dictMapper.selectAreaNameByCode(address.getRecvArea());
		String District=provinceName+cityName+areaName;
		address.setRecvDistrict(District);
		
		//��isDefault���õ�ַĬ��ֵ
		List<Address> addresses=addressMapper.selectByUid(address.getUid());
		if(addresses.size()>0){
			address.setDefaultAddress(0);
		}else{
			address.setDefaultAddress(1);
		}
		
		addressMapper.insert(address);
	}

	//��ѯ�ջ���ַ
	public List<Address> getAddress(Integer uid) {
		
		return addressMapper.selectByUid(uid);
	}

	//����Ĭ�ϵ�ַ
	public void setDefault(Integer uid, Integer id) {
		int n1=addressMapper.setCancel(uid);
		if(n1>0){
			throw new RuntimeException("ȡ��Ĭ�ϵ�ַʧ��");
		}
		int n2=addressMapper.setDefault(id);
		if(n2>0){
			throw new RuntimeException("����Ĭ�ϵ�ַʧ��");
		}
	}

}
