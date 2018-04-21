package store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/goods")
public class GoodsController extends BaseController{
	
	@RequestMapping("showSearch.do")
	public String showSearch(){
		return "search";
	}
}
