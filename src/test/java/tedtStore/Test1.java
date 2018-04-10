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
	//���Բ������
	public void insert(){
		User user=new User(1,"16","12","16","12","12",1,null,null,null,null);
		dao.insert(user);		
	}
	
	@Test
	//���Բ�ѯ��䣬ͨ���û�����ѯ
	public void selectByUsername(){
		User user=dao.selectByUsername("13");
		System.out.println(user);
	}
	
	@Test
	//���Է����
	public void userService(){		
		User user=new User(1,"17","12","16","12","12",1,null,null,null,null);
		try {
			userService.register(user);
		} catch (Exception e) {
			if(e instanceof UserNameAlreadyExistException){
				System.out.println("�û����Ѿ�����");
			}
		}
	}
	
	@Test
	//���������ѯ��䣬ͨ�������ѯ�Ƿ���ڣ����ش�������
	public void selectByEmail(){
		int num=dao.selectByEmail("16");
		System.out.println(num);
	}
	
	@Test
	//������������
	public void userEmail(){		
		boolean flag=userService.checkEmail("16");
		System.out.println(flag);
	}
	
	@Test
	//���Ե绰��ѯ��䣬ͨ�������ѯ�Ƿ���ڣ����ش�������
	public void selectByPhone(){
		int num=dao.selectByPhone("12");
		System.out.println(num);
	}
	@Test
	//���Ե绰�����
	public void userPhone(){		
		boolean flag=userService.checkPhone("12");
		System.out.println(flag);
	}
}
