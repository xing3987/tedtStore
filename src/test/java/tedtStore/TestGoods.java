package tedtStore;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import store.bean.Goods;
import store.bean.GoodsCategory;
import store.mapper.GoodsCategoryMapper;
import store.mapper.GoodsMapper;
import store.service.GoodsCategoryService;
import store.service.GoodsService;
import store.service.IGoodsService;

public class TestGoods {
	
	ApplicationContext ac=new ClassPathXmlApplicationContext(
			"spring-dao.xml","spring-mvc.xml","spring-service.xml");
	GoodsMapper goodsMapper=ac.getBean("goodsMapper",GoodsMapper.class);
	IGoodsService goodsService=ac.getBean("goodsService",GoodsService.class);
/*****************�־ò�**************************/	
	@Test
	//���Գ־ò�
	public void MapperSelect(){
		List<Goods> goods=goodsMapper.select(163, 0, 3);
		System.out.println(goods);
	}
	@Test
	//���Գ־ò�,ͨ��categoryId��ѯ��Ʒ����
	public void MapperSelectCount(){
		Integer count=goodsMapper.selectCount(163);
		System.out.println(count);
	}
	
	
/*******************ҵ���*************************/	
	@Test
	//����ҵ���
	public void ServiceSelect(){
		List<Goods> goods=goodsService.getGoodsByCategoryId(163, 0, 3);
		System.out.println(goods);
	}
	
	@Test
	//����ҵ���,ͨ��categoryId��ѯ��Ʒ����
	public void ServiceSelectCount(){
		Integer count=goodsService.getCount(163);
		System.out.println(count);
	}
}
