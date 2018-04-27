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
	
	@Test
	//���Գ־ò�,ͨ��Id��ѯ��Ʒ
	public void MapperselectGoodsById(){
		Goods good=goodsMapper.selectGoodsById(10000003);
		System.out.println(good);
	}
	
	@Test
	public void MapperUpdateNumById(){
		goodsMapper.updateNumById("10000001", 999);
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
	
	@Test
	//����ҵ���,ͨ��Id��ѯ��Ʒ
	public void MappergetGoodsById(){
		Goods good=goodsService.getGoodsById(10000003);
		System.out.println(good);
	}
	
	@Test
	public void ServiceUpdateNumById(){
		goodsService.setGoodsNumById("10000001", 998);
	}
	
}
