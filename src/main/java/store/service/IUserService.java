package store.service;

import store.bean.User;

public interface IUserService {
	
/************************用户注册*********************/	
	public void register(User user);//注册用户
	public boolean checkEmail(String email);//验证邮箱
	public boolean checkPhone(String phone);//验证电话
	public boolean checkUsername(String username);//验证用户名
/****************************用户登陆**********************/
	public User login(String username,String password);
	public void changePassword(Integer id,String oldPwd,String newPwd);//改变用户信息
	
}
