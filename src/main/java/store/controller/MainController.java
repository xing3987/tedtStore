package store.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import store.bean.Goods;
import store.bean.GoodsCategory;
import store.service.IGoodsCategoryService;
import store.service.IGoodsService;

@Controller
@RequestMapping("/main")
public class MainController {
	@Resource
	IGoodsCategoryService categoryService;
	@Resource
	IGoodsService goodsService;
	
/********************首页index.jsp***********************/	
	
	@RequestMapping("/showIndex.do")
	//跳转到首页,实现商品的分页显示
	public String showIndex(ModelMap map){
		//显示办公电脑1F信息
		List<GoodsCategory> computerList=categoryService.getCategoryByParentId(161, 0, 3);
		List<List<GoodsCategory>> category161List=new ArrayList<List<GoodsCategory>>();
		for(int i=0;i<computerList.size();i++){
			List<GoodsCategory> categorys=
					categoryService.getCategoryByParentId(computerList.get(i).getId(),null,null);
			category161List.add(categorys);
		}
		map.addAttribute("category161List",category161List);
		map.addAttribute("computerList",computerList);
		
		//显示电脑热门商品信息
		List<Goods> goodses=goodsService.getGoodsByCategoryId(163, 0, 3);
		map.addAttribute("goodses",goodses);
		
		//显示办公文件2F信息
		List<GoodsCategory> computerList2=categoryService.getCategoryByParentId(161, 3, 3);
		List<List<GoodsCategory>> category161List2=new ArrayList<List<GoodsCategory>>();
		for(int i=0;i<computerList2.size();i++){
			List<GoodsCategory> categorys2=
					categoryService.getCategoryByParentId(computerList2.get(i).getId(),null,null);
			category161List2.add(categorys2);
		}
		map.addAttribute("category161List2",category161List2);
		map.addAttribute("computerList2",computerList2);
		
		//显示文件热门商品信息
		List<Goods> goodses2=goodsService.getGoodsByCategoryId(238, 0, 3);
		map.addAttribute("goodses2",goodses2);
		
		return "index";
	}
	
	@RequestMapping("/showPersonal.do")
	//点击用户，显示修改密码页面
	public String showPersonal(){
		return "personal_password";
	}
	
	@RequestMapping("/showPersonInfo.do")
	//跳转到首页
	public String showPersonInfo(){
		return "personInfo";
	}
	
}
