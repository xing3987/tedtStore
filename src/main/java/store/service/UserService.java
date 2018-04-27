package store.service;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
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
	@Value("#{dbConfig.salt}")
	private String salt;//�������ܵ��Σ�ʹ�������ļ�����salt,��ͨ��spingע�⵼��
	
/**********ע��ҳ��*****************/

	//ע���û�
	public void register(User user) {
		User u=userMapper.selectByUsername(user.getUsername());
		if(u==null){
			//�������ת����ϢժҪ,���ü��ܷ���			
			String newp=this.DigestUtilsSalt(user.getPassword());
			user.setPassword(newp);
			
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
		}else if(!user.getPassword().equals(this.DigestUtilsSalt(password))){//���ü��ܷ����õ����ܺ�������ԭ����ȶ�
			throw new PasswordNotMatchException("���벻��ȷ");
		}else{
			return user;
		}
	}

	/*
	 *�ı��û�����
	 */
	public void changePassword(Integer id,String oldPwd,String newPwd){
		User user=userMapper.selectById(id);
		if(user!=null){
			if(user.getPassword().equals(this.DigestUtilsSalt(oldPwd))){
				User u=new User();
				u.setId(id);
				u.setPassword(this.DigestUtilsSalt(newPwd));
				userMapper.update(u);
			}else{
				throw new PasswordNotMatchException("���벻��ȷ");
			}
		}
	
	}

	/*
	 *�ı��û���Ϣ
	 */	
	public void update(Integer id, String username, Integer gender, String phone, String email) {
		User user=new User();
		//User u1=userMapper.selectById(id);
		User u1=userMapper.selectByUsername(username);
		if(u1==null||id.equals(u1.getId())){
			user.setUsername(username);
			user.setGender(gender);
			user.setPhone(phone);
			user.setEmail(email);
			user.setId(id);
			Date date=new Date();
			user.setModifiedTime(date);			
			userMapper.update(user);
		}else{
			throw new UserNameAlreadyExistException("�û����Ѿ�����");
		}
	}
	
	//MD5���ܴ���
	public String DigestUtilsSalt(String pwd){
		//salt="��ϲ�������?";
		//System.out.println(salt);
		//ʹ�������ļ�����salt,��ͨ��spingע�⵼��
		String newpwd=DigestUtils.md5Hex(pwd+salt);
		return newpwd;
	}

}
