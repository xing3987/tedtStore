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
/****************************�ı��û���Ϣ**********************/
	public void changePassword(Integer id,String oldPwd,String newPwd);//�ı��û�����
	public void update(Integer id,String username,Integer gender,String phone,String email);//�ı��û�������Ϣ
	public void updateImageById(String image,Integer id);

}
