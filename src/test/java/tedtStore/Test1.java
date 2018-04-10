package tedtStore;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import store.bean.User;
import store.mapper.UserMapper;
import store.service.IUserService;
import store.service.UserService;
import store.service.exception.UserNameAlreadyExistException;

public class Test1 {
		ApplicationContext ac=new ClassPathXmlApplicationContext(
				"spring-dao.xml","spring-mvc.xml","spring-service.xml");
		UserMapper dao=ac.getBean("userMapper",UserMapper.class);
		IUserService userService=ac.getBean("userService",IUserService.class);
		
	@Test
	//测试插入语句
	public void insert(){
		User user=new User(1,"16","12","16","12","12",1,null,null,null,null);
		dao.insert(user);		
	}
	
	@Test
	//测试查询语句，通过用户名查询
	public void selectByUsername(){
		User user=dao.selectByUsername("13");
		System.out.println(user);
	}
	
	@Test
	//测试服务层
	public void userService(){		
		User user=new User(1,"17","12","16","12","12",1,null,null,null,null);
		try {
			userService.register(user);
		} catch (Exception e) {
			if(e instanceof UserNameAlreadyExistException){
				System.out.println("用户名已经存在");
			}
		}
	}
	
	@Test
	//测试邮箱查询语句，通过邮箱查询是否存在，返回存在数量
	public void selectByEmail(){
		int num=dao.selectByEmail("16");
		System.out.println(num);
	}
	
	@Test
	//测试邮箱服务层
	public void userEmail(){		
		boolean flag=userService.checkEmail("16");
		System.out.println(flag);
	}
	
	@Test
	//测试电话查询语句，通过邮箱查询是否存在，返回存在数量
	public void selectByPhone(){
		int num=dao.selectByPhone("12");
		System.out.println(num);
	}
	@Test
	//测试电话服务层
	public void userPhone(){		
		boolean flag=userService.checkPhone("12");
		System.out.println(flag);
	}
}
