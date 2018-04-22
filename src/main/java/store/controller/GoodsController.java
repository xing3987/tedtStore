package store.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import store.bean.Goods;
import store.service.IGoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController extends BaseController{
	@Resource
	private IGoodsService goodsService;
	
	
	@RequestMapping("showSearch.do")
	//通过categoryId得到商品信息，传递给页面
	public String showSearch(ModelMap map,Integer page,Integer categoryId){
		//如果从页面跳转，page没有传递值，给它赋值为1
		if(page==null||page<=0){
			page=1;
		}
		int start=(page-1)*12;
		List<Goods> goodsList=goodsService.getGoodsByCategoryId(categoryId, start, 12);
		map.addAttribute("goodsList",goodsList);
		
		//得到商品的总数
		int count=goodsService.getCount(categoryId);
		int pages=count%12==0?count/12:count/12+1;//计算共多少页
		map.addAttribute("count",count);
		map.addAttribute("pages",pages);
		map.addAttribute("categoryId",categoryId);
		return "search";
	}
}
