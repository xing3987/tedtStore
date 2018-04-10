package store.service;

import store.bean.User;

public interface IUserService {
	public void register(User user);//注册用户
	public boolean checkEmail(String email);//验证邮箱
	public boolean checkPhone(String phone);//验证电话
}
