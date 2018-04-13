package store.service;

import store.bean.User;

public interface IUserService {
	
/************************�û�ע��*********************/	
	public void register(User user);//ע���û�
	public boolean checkEmail(String email);//��֤����
	public boolean checkPhone(String phone);//��֤�绰
	public boolean checkUsername(String username);//��֤�û���
/****************************�û���½**********************/
	public User login(String username,String password);
	public void changePassword(Integer id,String oldPwd,String newPwd);//�ı��û���Ϣ
	
}
