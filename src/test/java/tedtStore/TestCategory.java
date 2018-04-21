package tedtStore;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import store.bean.GoodsCategory;
import store.mapper.GoodsCategoryMapper;
import store.service.GoodsCategoryService;

public class TestCategory {
	
	ApplicationContext ac=new ClassPathXmlApplicationContext(
			"spring-dao.xml","spring-mvc.xml","spring-service.xml");
	GoodsCategoryMapper categoryMapper=ac.getBean("goodsCategoryMapper",GoodsCategoryMapper.class);
	GoodsCategoryService categoryService=ac.getBean("goodsCategoryService",GoodsCategoryService.class);
	
/*****************≥÷æ√≤„**************************/	
	@Test
	//≤‚ ‘≥÷æ√≤„
	public void MapperSelectCategoryByParentId(){
		List<GoodsCategory> categorys=categoryMapper.selectCategoryByParentId(162, null, null);
		System.out.println(categorys);
	}
	
	
/*******************“µŒÒ≤„*************************/	
	@Test
	//≤‚ ‘“µŒÒ≤„
	public void ServiceSelectCategoryByParentId(){
		List<GoodsCategory> categorys=categoryService.getCategoryByParentId(162, null, null);
		System.out.println(categorys);
	}
}
