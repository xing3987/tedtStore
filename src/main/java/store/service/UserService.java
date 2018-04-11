package store.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import store.bean.User;
import store.mapper.UserMapper;
import store.service.exception.PasswordNotMatchException;
import store.service.exception.UserNameAlreadyExistException;
import store.service.exception.UserNotFoundException;

@Service
public class UserService implements IUserService{

	@Resource
	private UserMapper userMapper;
	
/**********ע��ҳ��*****************/

	//ע���û�
	public void register(User user) {
		User u=userMapper.selectByUsername(user.getUsername());
		if(u==null){
			userMapper.insert(user);
			System.out.println("����ɹ�");
		}else{
			throw new UserNameAlreadyExistException("�û����Ѿ�����");
		}
	}

	//��֤����
	public boolean checkEmail(String email) {
		int a=userMapper.selectByEmail(email);
		if(a>0){
			return true;
		}
		return false;
	}

	//��֤�绰
	public boolean checkPhone(String phone) {
		
		return userMapper.selectByPhone(phone)>0;
	}

	//��֤�û���,���ڷ���true�������ڷ���false
	public boolean checkUsername(String username) {
		User u=userMapper.selectByUsername(username);
		return u!=null;
	}

/****************��½ҳ��*****************/
	/*
	 * ��½��֤
	 */
	public User login(String username,String password){
		User user=userMapper.selectByUsername(username);
		if(user==null){
			throw new UserNotFoundException("�û�������");
		}else if(!user.getPassword().equals(password)){
			throw new PasswordNotMatchException("���벻����");
		}else{
			return user;
		}
	}

}
