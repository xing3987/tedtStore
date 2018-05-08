package tedtStore;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import store.bean.Province;
import store.bean.ResponseResult;
import store.bean.User;
import store.controller.MainController;
import store.controller.UserController;
import store.mapper.DictMapper;
import store.mapper.UserMapper;
import store.service.IUserService;
import store.service.UserService;
import store.service.exception.PasswordNotMatchException;
import store.service.exception.UserNameAlreadyExistException;
import store.service.exception.UserNotFoundException;

public class TestUser {
		ApplicationContext ac=new ClassPathXmlApplicationContext(
				"spring-dao.xml","spring-mvc.xml","spring-service.xml");
		UserMapper userdao=ac.getBean("userMapper",UserMapper.class);
		DictMapper dictMapper=ac.getBean("dictMapper",DictMapper.class);
		IUserService userService=ac.getBean("userService",IUserService.class);
		UserController userController=ac.getBean("userController",UserController.class);
		MainController mainController=ac.getBean("mainController",MainController.class);
//********************测试持久层************************
	@Test
	//测试插入语句
	public void insert(){
		User user=new User(1,"16","12","16","12","12",1,null,null,null,null);
		userdao.insert(user);		
	}
	
	@Test
	//测试查询语句，通过用户名查询
	public void selectByUsername(){
		User user=userdao.selectByUsername("13");
		System.out.println(user);
	}
	
	@Test
	//测试邮箱查询语句，通过邮箱查询是否存在，返回存在数量
	public void selectByEmail(){
		int num=userdao.selectByEmail("16");
		System.out.println(num);
	}
	
	@Test
	//测试电话查询语句，通过邮箱查询是否存在，返回存在数量
	public void selectByPhone(){
		int num=userdao.selectByPhone("12");
		System.out.println(num);
	}
	
	

//****************************测试服务层********************************
	
	/*--------------------注册页面------------------------------*/
	@Test
	//测试判断用户名
	public void checkusername(){		
		boolean flag=userService.checkUsername("18");
		System.out.println(flag);
	}
	
	@Test
	//测试电话服务层
	public void userPhone(){		
		boolean flag=userService.checkPhone("12");
		System.out.println(flag);
	}
	
	@Test
	//测试邮箱服务层
	public void userEmail(){		
		boolean flag=userService.checkEmail("16");
		System.out.println(flag);
	}
	
	@Test
	//测试注册服务层
	public void userService(){		
		User user=new User(1,"17","12","16","12","12",1,null,null,null,null);
		try {
			userService.register(user);
		} catch (Exception e) {
			if(e instanceof UserNameAlreadyExistException){
				System.out.println(e.getMessage());
			}
		}
	}
	/*----------------------登陆页面-----------------------*/
	@Test
	//测试用户登陆
	public void userlogin(){		
		try {
			userService.login("123456", "12356");
			System.out.println("登陆成功");
		} catch (Exception e) {
			if(e instanceof UserNotFoundException){
				System.out.println(e.getMessage());
			}else if(e instanceof PasswordNotMatchException){
				System.out.println(e.getMessage());
			}
		}
	}
	
	
//****************************测试控制层********************************
	
	/*---------------------注册页面---------------------------*/
	@Test
	//测试控制层判断用户名
	public void controllerCheckusername(){		
		ResponseResult<Void> rr=userController.checkUsername("17");
		System.out.println(rr);
	}
	/*-----------------------登陆页面----------------------------------*/
	@Test
	//测试登陆
	public void controllerLogin(){		
		ResponseResult<Void> rr=userController.login("123456", "123456", null);
		System.out.println(rr);
	}
	/*-----------------------主页index.jsp----------------------------------*/
	/*-----------------------修改密码personal.jsp----------------------------*/
	
	@Test
	//测试修改信息
	public void update(){
		User user=new User(1,"adadf", "dfassadf", "132154@123","13212564646", null, null, null, null, null, null);
		userdao.update(user);
	}
	
	@Test
	//测试通过id查询用户
	public void selectById(){
		User user=userdao.selectById(1);
		System.out.println(user);
		
	}
	
	@Test
	//测试修改密码
	public void changePassword(){
		try {
			userService.changePassword(1, "dfassadf", "123131");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}	
	
	@Test
	//测试修改用户信息
	public void changePersonalInfo(){
		try {
			userService.update(1, "132461", 2, "1254646465", "161616@qq");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}

	@Test
	//测试通过id修改用户image属性
	public void changeImage(){
		userService.updateImageById("13246579", 1);
	}
	
	
	
	
}
