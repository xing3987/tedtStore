package tedtStore;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import store.bean.Province;
import store.mapper.DectMapper;

public class TestDict {
	ApplicationContext ac=new ClassPathXmlApplicationContext(
			"spring-dao.xml","spring-mvc.xml","spring-service.xml");
	DectMapper dectdao=ac.getBean("dectMapper",DectMapper.class);
	
	/*-----------------------地址管理addressAdmin.jsp----------------------------*/
	
	
	@Test
	//测试查询省
	public void dectSelectProvinces(){
		List<Province> provinces=dectdao.selectProvince();
		System.out.println(provinces);
	}
	
	
}
