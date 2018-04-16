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
	//返回省份列表
	public ResponseResult<List<Province>> showProvince(){
		ResponseResult<List<Province>> rr=new ResponseResult<List<Province>>();
		List<Province> provinces=dictService.getProvince();
		rr.setState(1);
		rr.setData(provinces);
		return rr;
	}
	
	@RequestMapping("/showCity.do")
	@ResponseBody
	//返回城市列表
	public ResponseResult<List<City>> showCity(String provinceCode){
		ResponseResult<List<City>> rr=new ResponseResult<List<City>>();
		List<City> citys=dictService.getCity(provinceCode);
		rr.setState(1);
		rr.setData(citys);
		return rr;
	}
	
	@RequestMapping("/showArea.do")
	@ResponseBody
	//返回区域列表
	public ResponseResult<List<Area>> showArea(String cityCode){
		ResponseResult<List<Area>> rr=new ResponseResult<List<Area>>();
		List<Area> areas=dictService.getArea(cityCode);
		rr.setState(1);
		rr.setData(areas);
		return rr;
	}
}
