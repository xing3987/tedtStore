package store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import store.bean.Goods;
import store.service.IGoodsService;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController extends BaseController{
	@Resource
	private IGoodsService goodsService;
	
	
	@RequestMapping("/showSearch.do")
	//ͨ��categoryId�õ���Ʒ��Ϣ�����ݸ�ҳ��
	public String showSearch(ModelMap map,Integer page,Integer categoryId){
		//�����ҳ����ת��pageû�д���ֵ��������ֵΪ1
		if(page==null||page<=0){
			page=1;
		}
		int start=(page-1)*12;
		List<Goods> goodsList=goodsService.getGoodsByCategoryId(categoryId, start, 12);
		map.addAttribute("goodsList",goodsList);
		
		//�õ���Ʒ������
		int count=goodsService.getCount(categoryId);
		int pages=count%12==0?count/12:count/12+1;//���㹲����ҳ
		map.addAttribute("count",count);
		map.addAttribute("pages",pages);
		map.addAttribute("categoryId",categoryId);
		return "search";
	}
	
	@RequestMapping("/showProduct.do")
	public String showProduct(Integer id,Integer categoryId,ModelMap map){
		//ͨ��id�õ���Ʒ
		Goods goods=goodsService.getGoodsById(id);
		map.addAttribute("goods",goods);
		
		//��ѯ������Ʒ
		List<Goods> goodsList=goodsService.getGoodsByCategoryId(categoryId, 0, 4);
		map.addAttribute("goodsList",goodsList);
		return "product_details";
	}
}
