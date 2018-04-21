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

public class TestGoods {
	
	ApplicationContext ac=new ClassPathXmlApplicationContext(
			"spring-dao.xml","spring-mvc.xml","spring-service.xml");
	GoodsMapper goodsMapper=ac.getBean("goodsMapper",GoodsMapper.class);
/*****************≥÷æ√≤„**************************/	
	@Test
	//≤‚ ‘≥÷æ√≤„
	public void MapperSelect(){
		List<Goods> goods=goodsMapper.select(163, 0, 3);
		System.out.println(goods);
	}
	
	
/*******************“µŒÒ≤„*************************/	
	@Test
	//≤‚ ‘“µŒÒ≤„
	public void ServiceSelect(){
		List<Goods> goods=goodsMapper.select(163, 0, 3);
		System.out.println(goods);
	}
}
