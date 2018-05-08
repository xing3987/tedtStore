package store.mapper;



import org.apache.ibatis.annotations.Param;

import store.bean.User;


public interface UserMapper {
	public void insert(User user);//�����ݿ��������
	public User selectByUsername(String username);//ͨ���û�����ѯ�������û�
	public User selectById(Integer id);//ͨ��id�����û�
	public Integer selectByEmail(String email);//��ѯ�����ѯ��������
	public Integer selectByPhone(String phone);//��ѯ�绰��������
	
	public void update(User user);//�����û���Ϣ
	public void updateImageById(@Param("image") String image,@Param("id") Integer id);
	
}
