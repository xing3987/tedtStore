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
	private String salt;//声明加密的盐，使用配置文件配置salt,并通过sping注解导入
	
/**********注册页面*****************/

	//注册用户
	public void register(User user) {
		User u=userMapper.selectByUsername(user.getUsername());
		if(u==null){
			//密码加密转成消息摘要,调用加密方法			
			String newp=this.DigestUtilsSalt(user.getPassword());
			user.setPassword(newp);
			
			userMapper.insert(user);
			System.out.println("导入成功");
		}else{
			throw new UserNameAlreadyExistException("用户名已经存在");
		}
	}

	//验证邮箱
	public boolean checkEmail(String email) {
		int a=userMapper.selectByEmail(email);
		if(a>0){
			return true;
		}
		return false;
	}

	//验证电话
	public boolean checkPhone(String phone) {
		
		return userMapper.selectByPhone(phone)>0;
	}

	//验证用户名,存在返回true，不存在返回false
	public boolean checkUsername(String username) {
		User u=userMapper.selectByUsername(username);
		return u!=null;
	}

/****************登陆页面*****************/
	/*
	 * 登陆验证
	 */
	public User login(String username,String password){
		User user=userMapper.selectByUsername(username);
		if(user==null){
			throw new UserNotFoundException("用户不存在");
		}else if(!user.getPassword().equals(this.DigestUtilsSalt(password))){//调用加密方法得到加密后的密码和原密码比对
			throw new PasswordNotMatchException("密码不正确");
		}else{
			return user;
		}
	}

	/*
	 *改变用户密码
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
				throw new PasswordNotMatchException("密码不正确");
			}
		}
	
	}

	/*
	 *改变用户信息
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
			throw new UserNameAlreadyExistException("用户名已经存在");
		}
	}
	
	//MD5加密处理
	public String DigestUtilsSalt(String pwd){
		//salt="你喜欢编程吗?";
		//System.out.println(salt);
		//使用配置文件配置salt,并通过sping注解导入
		String newpwd=DigestUtils.md5Hex(pwd+salt);
		return newpwd;
	}

}
