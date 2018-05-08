package store.mapper;



import org.apache.ibatis.annotations.Param;

import store.bean.User;


public interface UserMapper {
	public void insert(User user);//向数据库插入数据
	public User selectByUsername(String username);//通过用户名查询，返回用户
	public User selectById(Integer id);//通过id查找用户
	public Integer selectByEmail(String email);//查询邮箱查询存在数量
	public Integer selectByPhone(String phone);//查询电话存在数量
	
	public void update(User user);//更改用户信息
	public void updateImageById(@Param("image") String image,@Param("id") Integer id);
	
}
