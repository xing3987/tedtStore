package store.service;

import store.bean.User;

public interface IUserService {
	public void register(User user);//ע���û�
	public boolean checkEmail(String email);//��֤����
	public boolean checkPhone(String phone);//��֤�绰
}
