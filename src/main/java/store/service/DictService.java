package store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import store.bean.Province;
import store.mapper.DectMapper;
@Service
public class DictService implements IDictService{

	@Resource
	DectMapper dectMapper;
	//ʵ�ַ�������ʡ�ݵķ���
	public List<Province> getProvince() {
		List<Province> provinces=dectMapper.selectProvince();
		return provinces;
	}

}
