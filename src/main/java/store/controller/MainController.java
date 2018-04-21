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
	
/********************��ҳindex.jsp***********************/	
	
	@RequestMapping("/showIndex.do")
	//��ת����ҳ,ʵ����Ʒ�ķ�ҳ��ʾ
	public String showIndex(ModelMap map){
		//��ʾ�칫����1F��Ϣ
		List<GoodsCategory> computerList=categoryService.getCategoryByParentId(161, 0, 3);
		List<List<GoodsCategory>> category161List=new ArrayList<List<GoodsCategory>>();
		for(int i=0;i<computerList.size();i++){
			List<GoodsCategory> categorys=
					categoryService.getCategoryByParentId(computerList.get(i).getId(),null,null);
			category161List.add(categorys);
		}
		map.addAttribute("category161List",category161List);
		map.addAttribute("computerList",computerList);
		
		//��ʾ����������Ʒ��Ϣ
		List<Goods> goodses=goodsService.getGoodsByCategoryId(163, 0, 3);
		map.addAttribute("goodses",goodses);
		
		//��ʾ�칫�ļ�2F��Ϣ
		List<GoodsCategory> computerList2=categoryService.getCategoryByParentId(161, 3, 3);
		List<List<GoodsCategory>> category161List2=new ArrayList<List<GoodsCategory>>();
		for(int i=0;i<computerList2.size();i++){
			List<GoodsCategory> categorys2=
					categoryService.getCategoryByParentId(computerList2.get(i).getId(),null,null);
			category161List2.add(categorys2);
		}
		map.addAttribute("category161List2",category161List2);
		map.addAttribute("computerList2",computerList2);
		
		//��ʾ�ļ�������Ʒ��Ϣ
		List<Goods> goodses2=goodsService.getGoodsByCategoryId(238, 0, 3);
		map.addAttribute("goodses2",goodses2);
		
		return "index";
	}
	
	@RequestMapping("/showPersonal.do")
	//����û�����ʾ�޸�����ҳ��
	public String showPersonal(){
		return "personal_password";
	}
	
	@RequestMapping("/showPersonInfo.do")
	//��ת����ҳ
	public String showPersonInfo(){
		return "personInfo";
	}
	
}
