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
//********************���Գ־ò�************************
	@Test
	//���Բ������
	public void insert(){
		User user=new User(1,"16","12","16","12","12",1,null,null,null,null);
		userdao.insert(user);		
	}
	
	@Test
	//���Բ�ѯ��䣬ͨ���û�����ѯ
	public void selectByUsername(){
		User user=userdao.selectByUsername("13");
		System.out.println(user);
	}
	
	@Test
	//���������ѯ��䣬ͨ�������ѯ�Ƿ���ڣ����ش�������
	public void selectByEmail(){
		int num=userdao.selectByEmail("16");
		System.out.println(num);
	}
	
	@Test
	//���Ե绰��ѯ��䣬ͨ�������ѯ�Ƿ���ڣ����ش�������
	public void selectByPhone(){
		int num=userdao.selectByPhone("12");
		System.out.println(num);
	}
	
	

//****************************���Է����********************************
	
	/*--------------------ע��ҳ��------------------------------*/
	@Test
	//�����ж��û���
	public void checkusername(){		
		boolean flag=userService.checkUsername("18");
		System.out.println(flag);
	}
	
	@Test
	//���Ե绰�����
	public void userPhone(){		
		boolean flag=userService.checkPhone("12");
		System.out.println(flag);
	}
	
	@Test
	//������������
	public void userEmail(){		
		boolean flag=userService.checkEmail("16");
		System.out.println(flag);
	}
	
	@Test
	//����ע������
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
	/*----------------------��½ҳ��-----------------------*/
	@Test
	//�����û���½
	public void userlogin(){		
		try {
			userService.login("123456", "12356");
			System.out.println("��½�ɹ�");
		} catch (Exception e) {
			if(e instanceof UserNotFoundException){
				System.out.println(e.getMessage());
			}else if(e instanceof PasswordNotMatchException){
				System.out.println(e.getMessage());
			}
		}
	}
	
	
//****************************���Կ��Ʋ�********************************
	
	/*---------------------ע��ҳ��---------------------------*/
	@Test
	//���Կ��Ʋ��ж��û���
	public void controllerCheckusername(){		
		ResponseResult<Void> rr=userController.checkUsername("17");
		System.out.println(rr);
	}
	/*-----------------------��½ҳ��----------------------------------*/
	@Test
	//���Ե�½
	public void controllerLogin(){		
		ResponseResult<Void> rr=userController.login("123456", "123456", null);
		System.out.println(rr);
	}
	/*-----------------------��ҳindex.jsp----------------------------------*/
	/*-----------------------�޸�����personal.jsp----------------------------*/
	
	@Test
	//�����޸���Ϣ
	public void update(){
		User user=new User(1,"adadf", "dfassadf", "132154@123","13212564646", null, null, null, null, null, null);
		userdao.update(user);
	}
	
	@Test
	//����ͨ��id��ѯ�û�
	public void selectById(){
		User user=userdao.selectById(1);
		System.out.println(user);
		
	}
	
	@Test
	//�����޸�����
	public void changePassword(){
		try {
			userService.changePassword(1, "dfassadf", "123131");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}	
	
	@Test
	//�����޸��û���Ϣ
	public void changePersonalInfo(){
		try {
			userService.update(1, "132461", 2, "1254646465", "161616@qq");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}

	@Test
	//����ͨ��id�޸��û�image����
	public void changeImage(){
		userService.updateImageById("13246579", 1);
	}
	
	
	
	
}
