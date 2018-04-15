package store.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public ResponseResult<List<Province>> showProvince(){
		ResponseResult<List<Province>> rr=new ResponseResult<List<Province>>();
		List<Province> provinces=dictService.getProvince();
		rr.setState(1);
		rr.setData(provinces);
		return rr;
	}
}
