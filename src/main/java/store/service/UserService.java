package store.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import store.bean.User;
import store.mapper.UserMapper;
import store.service.exception.UserNameAlreadyExistException;

@Service
public class UserService implements IUserService{

	@Resource
	private UserMapper userMapper;
	
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

}
