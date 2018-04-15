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
	//实现返回所有省份的方法
	public List<Province> getProvince() {
		List<Province> provinces=dectMapper.selectProvince();
		return provinces;
	}

}
