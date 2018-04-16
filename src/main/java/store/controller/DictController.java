package store.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import store.bean.Area;
import store.bean.City;
import store.bean.Province;
import store.bean.ResponseResult;
import store.service.DictService;

@Controller
@RequestMapping("/dict")
public class DictController {

	@Resource
	DictService dictService;
	
	@RequestMapping("/showProvince.do")
	@ResponseBody
	//����ʡ���б�
	public ResponseResult<List<Province>> showProvince(){
		ResponseResult<List<Province>> rr=new ResponseResult<List<Province>>();
		List<Province> provinces=dictService.getProvince();
		rr.setState(1);
		rr.setData(provinces);
		return rr;
	}
	
	@RequestMapping("/showCity.do")
	@ResponseBody
	//���س����б�
	public ResponseResult<List<City>> showCity(String provinceCode){
		ResponseResult<List<City>> rr=new ResponseResult<List<City>>();
		List<City> citys=dictService.getCity(provinceCode);
		rr.setState(1);
		rr.setData(citys);
		return rr;
	}
	
	@RequestMapping("/showArea.do")
	@ResponseBody
	//���������б�
	public ResponseResult<List<Area>> showArea(String cityCode){
		ResponseResult<List<Area>> rr=new ResponseResult<List<Area>>();
		List<Area> areas=dictService.getArea(cityCode);
		rr.setState(1);
		rr.setData(areas);
		return rr;
	}
}
