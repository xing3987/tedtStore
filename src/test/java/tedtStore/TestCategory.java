package tedtStore;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import store.bean.Goods;
import store.bean.GoodsCategory;
import store.mapper.GoodsCategoryMapper;
import store.service.GoodsCategoryService;
import store.service.GoodsService;
import store.service.IGoodsService;

public class TestCategory {
	
	ApplicationContext ac=new ClassPathXmlApplicationContext(
			"spring-dao.xml","spring-mvc.xml","spring-service.xml");
	GoodsCategoryMapper categoryMapper=ac.getBean("goodsCategoryMapper",GoodsCategoryMapper.class);
	GoodsCategoryService categoryService=ac.getBean("goodsCategoryService",GoodsCategoryService.class);
	IGoodsService goodsService=ac.getBean("goodsService",GoodsService.class);
/*****************�־ò�**************************/	
	@Test
	//���Գ־ò�
	public void MapperSelectCategoryByParentId(){
		List<GoodsCategory> categorys=categoryMapper.selectCategoryByParentId(162, null, null);
		System.out.println(categorys);
	}
	
	
/*******************ҵ���*************************/	
	@Test
	//����ҵ���
	public void ServiceSelectCategoryByParentId(){
		List<GoodsCategory> categorys=categoryService.getCategoryByParentId(162, null, null);
		System.out.println(categorys);
	}
	@Test
	//���Գ־ò�ѡȡ��Ʒ
	public void MapperselectGoods(){
		List<Goods> goodsList=goodsService.getGoodsByCategoryId(238, 0, 12);
		System.out.println(goodsList);
	}
	
}
